package com.robertkoszewski.quickquery.builder;

import com.robertkoszewski.quickquery.model.*;
import com.robertkoszewski.quickquery.statement.Having;
import com.robertkoszewski.quickquery.statement.OrderBy;

/**
 * Having State
 * @author Robert Koszewski
 */
// TODO: Having AND/OR
public class HavingState extends BuilderHost implements Having, OrderBy{

	HavingState(SQLBuilder builder) {
		super(builder);
	}
	
	static HavingState havingFactory(SQLBuilder builder, String column, Compare compare, Object value) {
		builder.getModel().addHavingStatement(column, compare, value);
		return new HavingState(builder);
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

	// HAVING
	public HavingState having(String column, Compare compare, Object value){
		return HavingState.havingFactory(builder, column, compare, value);
	}
	
	public HavingState HAVING(String column, Compare compare, Object value){
		return having(column, compare, value);
	}

}
