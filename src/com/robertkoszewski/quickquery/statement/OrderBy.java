package com.robertkoszewski.quickquery.statement;

import com.robertkoszewski.quickquery.builder.OrderByState;
import com.robertkoszewski.quickquery.model.Order;

/**
 * Order By
 * @author Robert Koszewski
 *
 */
public interface OrderBy {
	public OrderByState orderby(String column_name);
	public OrderByState ORDERBY(String column_name);
	public OrderByState orderby(String column_name, Order order);
	public OrderByState ORDERBY(String column_name, Order order);
}
