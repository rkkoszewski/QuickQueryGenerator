package com.robertkoszewski.quickquery.builder;

import com.robertkoszewski.quickquery.model.*;
import com.robertkoszewski.quickquery.statement.GroupBy;
import com.robertkoszewski.quickquery.statement.Having;
import com.robertkoszewski.quickquery.statement.OrderBy;
import com.robertkoszewski.quickquery.statement.WhereAndOr;

/**
 * Where State
 * @author Robert Koszewski
 */
public class WhereState extends BuilderHost implements WhereAndOr, GroupBy, Having, OrderBy{
	
	private ComparableStatementCollection collection;
	
	WhereState(SQLBuilder builder, ComparableStatementCollection collection) {
		super(builder);
		this.collection = collection;
	}
	
	static WhereState whereFactory(SQLBuilder builder, ComparableStatementCollection collection, String column, Compare compare, Object value){
		if(collection == null){
			collection = new ComparableStatementCollection();
			builder.getModel().addWhereStatement(collection);
		}
		collection.addWhereStatement(new ComparableStatement(column, compare, value));
		return new WhereState(builder, collection);
	}

	// WHERE (AND)
	public WhereState and(String column, Compare compare, Object value){
		return WhereState.whereFactory(builder, collection, column, compare, value);
	}
	
	public WhereState AND(String column, Compare compare, Object value){
		return and(column, compare, value);
	}

	// WHERE (OR)
	public WhereState or(String column, Compare compare, Object value){
		return WhereState.whereFactory(builder, null, column, compare, value);
	}
	
	public WhereState OR(String column, Compare compare, Object value){
		return or(column, compare, value);
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

	// GROUP BY
	public GroupByState groupby(String... column_names){
		return GroupByState.groupByFactory(builder, column_names);
	}
	
	public GroupByState GROUPBY(String... column_names){
		return groupby(column_names);
	}
}
