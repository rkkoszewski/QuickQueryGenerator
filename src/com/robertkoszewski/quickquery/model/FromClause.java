package com.robertkoszewski.quickquery.model;

import java.util.ArrayList;

/**
 * From Clause
 * @author Robert Koszewski
 *
 */
public class FromClause extends QueryModel{

	private ArrayList<ItemAlias> tables;
	
	public FromClause(){
		tables = new ArrayList<ItemAlias>();
	}
	
	public FromClause(ItemAlias table){
		this();
		tables.add(table);
	}
	
	public ArrayList<ItemAlias> getTables(){
		return tables;
	}
}
