package com.robertkoszewski.quickquery.translator;

import java.util.*;
import java.util.Map.Entry;
import com.robertkoszewski.quickquery.model.*;
import com.robertkoszewski.quickquery.model.ComparableStatement.dataType;

/**
 * MySQL Query Generator
 * @author Robert Koszewski
 */
public class MySQLDriver implements ModelDriver{

	@Override
	public String toString(QueryElement model) {
		if(model instanceof SelectClause)
			try {
				return processSelect((SelectClause) model);
			} catch (Exception e) {
				//e.printStackTrace();
				return "ERROR: "+e.getMessage();
			}
		else
			return "ERROR: Unsupported Statement (Only SELECT is supported so far)";
	}
	
	// ##############################################################
	// SELECT Statement
	// ##############################################################
	private String processSelect(SelectClause model) throws Exception{
		String query = "SELECT ";

		ArrayList<ItemAlias> select_column = model.getColumns();
		
		if(select_column.size() == 0){
			query += "* ";
		}else{
			query += "(";
			
			Iterator<ItemAlias> it = select_column.iterator();
			while(it.hasNext()){
				ItemAlias column = it.next();
				
				// Add Column
				query += column.getItemName();
				
				// Process Alias
				if(column.hasAlias())
					query += "AS " + column.getItemAlias();
				
				if(it.hasNext())
					query += ", ";
				
			}
			
			query += ") ";
		}
		
		// Process Next
		QueryElement next = model.getNextElement();
		
		if(next instanceof FromClause)
			return query + processFrom((FromClause) next);
		else
			throw new Exception("Error: Wrong state. After SELECT only FROM is supported but is "+next.getClass().getName());
	}
	
	// ##############################################################
	// FROM Statement
	// ##############################################################
	private String processFrom(FromClause model) throws Exception{
		String query = "";
		ArrayList<ItemAlias> from = model.getTables();
		
		query += "FROM ";
		
		Iterator<ItemAlias> it = from.iterator();
		while(it.hasNext()){
			ItemAlias table = it.next();
			query += table.getItemName();
			
			// Process Alias
			if(table.hasAlias())
				query += " " + table.getItemAlias();
			
			if(it.hasNext())
				query += ", ";
		}
		
		// Process Next
		QueryElement next = model.getNextElement();
		
		if(next instanceof WhereClause)
			return query + processWhere((WhereClause) next);
		if(next instanceof OrderByClause)
			return query + processOrderBy((OrderByClause) next);
		if(next instanceof GroupByClause)
			return query + processGroupBy((GroupByClause) next);
		if(next instanceof HavingClause)
			return query + processHaving((HavingClause) next);
		if(model.getNextElement() != null)
			throw new Exception("ERROR: Unknown state after From");

		return query + ";";
	}
	
	// ##############################################################
	// WHERE Statement
	// ##############################################################
	private String processWhere(WhereClause model) throws Exception{
		String query = "";
		ArrayList<ComparableStatementCollection> where_collection = model.getFilter();
		
		if(where_collection.size() > 0){
			query += " WHERE ";
			
			Iterator<ComparableStatementCollection> wsit = where_collection.iterator();
			while(wsit.hasNext()){

				ComparableStatementCollection where_statement = wsit.next();
				
				Iterator<ComparableStatement> wit = where_statement.getWhereStatementCollection().iterator();
				
				while(wit.hasNext()){
					ComparableStatement where = wit.next();
					
					query += where.getColumn() + " ";
					query += comparatorToString(where.getComparator()) + " ";
					
					// TODO: Escape String
					if(where.getValueDataType() == dataType.STRING)
						query += "'" + where.getValue() + "'";
					else
						query +=  where.getValue();
					
					if(wit.hasNext())
						query +=  " AND ";
				}
				
				
				if(wsit.hasNext())
					query +=  " OR ";
			}
		}

		// Process Next
		QueryElement next = model.getNextElement();

		if(next instanceof OrderByClause)
			return query + processOrderBy((OrderByClause) next);
		if(next instanceof GroupByClause)
			return query + processGroupBy((GroupByClause) next);
		if(next instanceof HavingClause)
			return query + processHaving((HavingClause) next);
		if(model.getNextElement() != null)
			throw new Exception("ERROR: Unknown state after Where");

		return query + ";";
	}
	
	// ##############################################################
	// ORDER BY Statement
	// ##############################################################
	private String processOrderBy(OrderByClause model) throws Exception{
		String query = "";
		Iterator<Entry<String, Order>> osit = model.getOrderBy().entrySet().iterator();
		if(osit.hasNext())
			query += " ORDER BY ";
		
		while(osit.hasNext()){
			Entry<String, Order> order = osit.next();
			query +=  order.getKey();
			
			if(order.getValue() != null)
				query += " " + order.getValue().name();
			
			if(osit.hasNext())
				query +=  ", ";
		}
		
		if(model.getNextElement() != null)
			throw new Exception("ERROR: ORDER BY should be final state");
		
		return query + ";";
	}
	
	// ##############################################################
	// GROUP BY Statement
	// ##############################################################
	private String processGroupBy(GroupByClause model) throws Exception{
		String query = "";
		Iterator<String> gbit = model.getGroupBy().iterator();
		if(gbit.hasNext())
			query += " GROUP BY ";
		
		while(gbit.hasNext()){
			 query +=  gbit.next();
			 
			 if(gbit.hasNext())
					query +=  ", ";
		}
		
		// Process Next
		QueryElement next = model.getNextElement();

		if(next instanceof OrderByClause)
			return query + processOrderBy((OrderByClause) next);
		if(next instanceof HavingClause)
			return query + processHaving((HavingClause) next);
		if(model.getNextElement() != null)
			throw new Exception("ERROR: Unknown state after GroupBy");

		return query + ";";
	}
	
	// ##############################################################
	// HAVING Statement
	// ##############################################################
	private String processHaving(HavingClause model) throws Exception{
		String query = "";
		ComparableStatement having = model.getFilter();
		if(having != null){
			query += " HAVING " + having.getColumn() + " " + 
					comparatorToString(having.getComparator()) + " ";
			
			// TODO: Escape String
			if(having.getValueDataType() == dataType.STRING)
				query += "'" + having.getValue() + "'";
			else
				query +=  having.getValue();
		}

		// Process Next
		QueryElement next = model.getNextElement();

		if(next instanceof OrderByClause)
			return query + processOrderBy((OrderByClause) next);
		if(model.getNextElement() != null)
			throw new Exception("ERROR: Unknown state after Having");

		return query + ";";
	}
	
	// Convert Compare ENUM to String
	private String comparatorToString(Compare compare){
		switch(compare){
		case NOTEQUALS:
			return "<>"; // TODO: Check if it's not != 
		case EQUALS:
			return "=";
		case GREATERTHAN:
			return "> ";
		case GREATEROREQUALTHAN:
			return ">=";
		case SMALLERTHAN:
			return "<";
		case SMALLEROREQUALTHAN:
			return "<=";
		case LIKE:
			return "LIKE";
		case BETWEEN:
			return "BETWEEN";
		case IN:
			return "IN";
		}
		return null;
	}
}
