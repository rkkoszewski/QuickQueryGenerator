package com.robertkoszewski.quickquery.model;

import java.util.*;

public class SQLModel {

	private ArrayList<ItemAlias> select_columns; // SELECT Item (Columns)
	private ArrayList<ItemAlias> tables;
	private ArrayList<ComparableStatementCollection> where;
	private Map<String, Order> orderby;
	private ArrayList<String> groupby;
	private ComparableStatement having;
	
	public SQLModel(){
		select_columns = new ArrayList<ItemAlias>();
		tables = new ArrayList<ItemAlias>();
		where = new ArrayList<ComparableStatementCollection>();
		orderby = new HashMap<String, Order>();
		groupby = new ArrayList<String>();
	}
	
	public void addSelectColumn(ItemAlias column_item){
		select_columns.add(column_item);
	}
	
	public ArrayList<ItemAlias> getSelectColumn(){
		return select_columns;
	}
	
	public void addTables(ItemAlias table_item){
		tables.add(table_item);
	}
	
	public ArrayList<ItemAlias> getTables(){
		return tables;
	}
	
	public void addWhereStatement(ComparableStatementCollection where){
		this.where.add(where);
	}
	
	public ArrayList<ComparableStatementCollection> getWhereStatement(){
		return where;
	}
	
	public void addOrderByStatement(String column_name, Order order){
		this.orderby.put(column_name, order);
	}
	
	public Map<String, Order> getOrderByStatement(){
		return this.orderby;
	}
	
	public void addGroupByColumns(String[] columns){
		for(String column: columns)
			if(!groupby.contains(column)) // Filter Duplicates
				groupby.add(column);
	}
	
	public ArrayList<String> getGroupByColumns(){
		return groupby;
	}
	
	public void addHavingStatement(String column, Compare compare, Object value){
		having = new ComparableStatement(column, compare, value);
	}
	
	public ComparableStatement getHavingStatement(){
		return having;
	}
	
	/*
	enum verbs{
		SELECT,
		UPDATE,
		DELETE,
		INSERT,
		CREATE,
		ALTER,
		TABLE,
		DATABASE,
		INDEX
	}
	*/
}
