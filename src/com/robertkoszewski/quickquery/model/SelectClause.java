package com.robertkoszewski.quickquery.model;

import java.util.ArrayList;

/**
 * Select Clause
 * @author Robert Koszewski
 *
 */
public class SelectClause extends QueryModel{
	
	private ArrayList<ItemAlias> columns;

	public SelectClause(){
		columns = new ArrayList<ItemAlias>();
	}
	
	public void addColumn(ItemAlias column){
		columns.add(column);
	}
	
	public ArrayList<ItemAlias> getColumns(){
		return this.columns;
	}
}
