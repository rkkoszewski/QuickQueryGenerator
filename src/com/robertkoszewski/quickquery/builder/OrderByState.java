package com.robertkoszewski.quickquery.builder;

import com.robertkoszewski.quickquery.model.Order;
import com.robertkoszewski.quickquery.model.OrderByClause;
import com.robertkoszewski.quickquery.model.QueryElement;
import com.robertkoszewski.quickquery.statement.OrderBy;

/**
 * Order By State
 * @author Robert Koszewski
 */
public class OrderByState extends BuilderHost implements OrderBy{

	OrderByState(BuilderContainer builder, QueryElement model) {
		super(builder, model);
	}
	
	static OrderByState orderByFactory(BuilderContainer builder, QueryElement model, String column_name, Order order){
		OrderByClause orderby;
		if(model instanceof OrderByClause){
			orderby = (OrderByClause) model;
		}else{
			orderby = new OrderByClause();
			model.addNextElement(orderby);
		}
		orderby.addOrderBy(column_name, order);
		return new OrderByState(builder, orderby);
	}

	// ORDER BY
	public OrderByState orderby(String column_name){
		return OrderByState.orderByFactory(builder, model, column_name, null);
	}
	
	public OrderByState ORDERBY(String column_name){
		return orderby(column_name);
	}
	
	public OrderByState orderby(String column_name, Order order){
		return OrderByState.orderByFactory(builder, model, column_name, order);
	}
	
	public OrderByState ORDERBY(String column_name, Order order){
		return orderby(column_name, order);
	}
}
