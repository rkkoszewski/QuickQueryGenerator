package com.robertkoszewski.quickquery.builder;

import com.robertkoszewski.quickquery.model.*;
import com.robertkoszewski.quickquery.statement.OrderBy;

/**
 * Order By State
 * @author Robert Koszewski
 */
public class OrderByState extends BuilderHost implements OrderBy{

	OrderByState(SQLBuilder builder) {
		super(builder);
	}
	
	static OrderByState orderByFactory(SQLBuilder builder, String column_name, Order order){
		builder.getModel().addOrderByStatement(column_name, order);
		return new OrderByState(builder);
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
