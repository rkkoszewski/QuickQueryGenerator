package com.robertkoszewski.quickquery.builder;

import com.robertkoszewski.quickquery.model.Compare;
import com.robertkoszewski.quickquery.model.HavingClause;
import com.robertkoszewski.quickquery.model.Order;
import com.robertkoszewski.quickquery.model.QueryElement;
import com.robertkoszewski.quickquery.statement.Having;
import com.robertkoszewski.quickquery.statement.OrderBy;

/**
 * Having State
 * @author Robert Koszewski
 */
// TODO: Having AND/OR
public class HavingState extends BuilderHost implements Having, OrderBy{

	HavingState(BuilderContainer builder, QueryElement model) {
		super(builder, model);
	}
	
	static HavingState havingFactory(BuilderContainer builder, QueryElement model, String column, Compare compare, Object value) {
		HavingClause having = new HavingClause(column, compare, value);
		model.addNextElement(having);
		return new HavingState(builder, having);
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

	// HAVING
	public HavingState having(String column, Compare compare, Object value){
		return HavingState.havingFactory(builder, model, column, compare, value);
	}
	
	public HavingState HAVING(String column, Compare compare, Object value){
		return having(column, compare, value);
	}

}
