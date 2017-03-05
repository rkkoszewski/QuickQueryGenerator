package com.robertkoszewski.quickquery.builder;

import com.robertkoszewski.quickquery.model.*;
import com.robertkoszewski.quickquery.statement.Having;
import com.robertkoszewski.quickquery.statement.OrderBy;

/**
 * Order By State
 * @author Robert Koszewski
 */
public class GroupByState extends BuilderHost implements Having, OrderBy{

	GroupByState(SQLBuilder builder) {
		super(builder);
	}
	
	static GroupByState groupByFactory(SQLBuilder builder, String... column_names){		
		builder.getModel().addGroupByColumns(column_names);
		return new GroupByState(builder);
	}

	// HAVING
	public HavingState having(String column, Compare compare, Object value){
		return HavingState.havingFactory(builder, column, compare, value);
	}
	
	public HavingState HAVING(String column, Compare compare, Object value){
		return having(column, compare, value);
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
}
