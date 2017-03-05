package com.robertkoszewski.quickquery.builder;

import com.robertkoszewski.quickquery.model.*;
import com.robertkoszewski.quickquery.statement.GroupBy;
import com.robertkoszewski.quickquery.statement.Having;
import com.robertkoszewski.quickquery.statement.OrderBy;
import com.robertkoszewski.quickquery.statement.Where;

/**
 * From State
 * @author Robert Koszewski
 */
public class FromState extends BuilderHost implements Where, Having, OrderBy, GroupBy{

	public FromState(SQLBuilder builder) {
		super(builder);
	}
	
	// WHERE
	public WhereState where(String column, Compare compare, Object value){
		return WhereState.whereFactory(builder, null, column, compare, value);
	}
	
	public WhereState WHERE(String column, Compare compare, Object value){
		return where(column, compare, value);
	}
	
	// ORDER BY
	public OrderByState orderby(String column_name){
		return OrderByState.orderByFactory(builder, column_name, null);
	}
	
	public OrderByState ORDERBY(String column_name){
		return orderby(column_name);
	}
	
	public OrderByState orderby(String column_name, Order order){
		return OrderByState.orderByFactory(builder, column_name, order);
	}
	
	public OrderByState ORDERBY(String column_name, Order order){
		return orderby(column_name, order);
	}
	
	// GROUP BY
	public GroupByState groupby(String... column_names){
		return GroupByState.groupByFactory(builder, column_names);
	}
	
	public GroupByState GROUPBY(String... column_names){
		return groupby(column_names);
	}
	
	// HAVING
	public HavingState having(String column, Compare compare, Object value){
		return HavingState.havingFactory(builder, column, compare, value);
	}
	
	public HavingState HAVING(String column, Compare compare, Object value){
		return having(column, compare, value);
	}
}
