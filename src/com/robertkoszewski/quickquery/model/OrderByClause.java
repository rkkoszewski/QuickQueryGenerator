package com.robertkoszewski.quickquery.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Order By Clause
 * @author Robert Koszewski
 *
 */
public class OrderByClause extends QueryModel{

	private Map<String, Order> orderby;
	
	public OrderByClause(){
		orderby = new HashMap<String, Order>();
	}
	
	public void addOrderBy(String column, Order order){
		orderby.put(column, order);
	}
	
	public Map<String, Order> getOrderBy(){
		return orderby;
	}
}
