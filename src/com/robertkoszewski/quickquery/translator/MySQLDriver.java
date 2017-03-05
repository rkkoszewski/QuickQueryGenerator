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
	public String toString(SQLModel model) {
		String query = "SELECT ";
		
		// ##############################################################
		// SELECT Statement
		// ##############################################################
		ArrayList<ItemAlias> select_column = model.getSelectColumn();
		
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
		
		// ##############################################################
		// FROM Statement
		// ##############################################################
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
		
		// ##############################################################
		// WHERE Statement
		// ##############################################################
		ArrayList<ComparableStatementCollection> where_collection = model.getWhereStatement();
		
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
		
		// ##############################################################
		// GROUP BY Statement
		// ##############################################################
		Iterator<String> gbit = model.getGroupByColumns().iterator();
		if(gbit.hasNext())
			query += " GROUP BY ";
		
		while(gbit.hasNext()){
			 query +=  gbit.next();
			 
			 if(gbit.hasNext())
					query +=  ", ";
		}
		
		// ##############################################################
		// HAVING Statement
		// ##############################################################
		ComparableStatement having = model.getHavingStatement();
		if(having != null){
			query += " HAVING " + having.getColumn() + " " + 
					comparatorToString(having.getComparator()) + " ";
			
			// TODO: Escape String
			if(having.getValueDataType() == dataType.STRING)
				query += "'" + having.getValue() + "'";
			else
				query +=  having.getValue();
		}

		/*
		if(column_names == null || column_names.length == 0)
			throw new Exception("Invalid column names for Group By Statement. Values cannot be empty");
		*/
		
		// ##############################################################
		// ORDER BY Statement
		// ##############################################################
		Iterator<Entry<String, Order>> osit = model.getOrderByStatement().entrySet().iterator();
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
