package com.robertkoszewski.quickquery.builder;

import com.robertkoszewski.quickquery.model.Compare;
import com.robertkoszewski.quickquery.model.GroupByClause;
import com.robertkoszewski.quickquery.model.Order;
import com.robertkoszewski.quickquery.model.QueryElement;
import com.robertkoszewski.quickquery.statement.Having;
import com.robertkoszewski.quickquery.statement.OrderBy;

/**
 * Order By State
 * @author Robert Koszewski
 */
public class GroupByState extends BuilderHost implements Having, OrderBy{

	GroupByState(BuilderContainer builder, QueryElement model) {
		super(builder, model);
	}
	
	static GroupByState groupByFactory(BuilderContainer builder, QueryElement model, String... column_names){	
		GroupByClause groupby = new GroupByClause();
		for(String column: column_names)
			groupby.addGroupBy(column);
		model.addNextElement(groupby);
		return new GroupByState(builder, groupby);
	}

	// HAVING
	public HavingState having(String column, Compare compare, Object value){
		return HavingState.havingFactory(builder, model, column, compare, value);
	}
	
	public HavingState HAVING(String column, Compare compare, Object value){
		return having(column, compare, value);
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
