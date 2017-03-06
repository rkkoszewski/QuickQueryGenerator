package com.robertkoszewski.quickquery.model;

import java.util.ArrayList;

/**
 * Where Clause
 * @author Robert Koszewski
 *
 */
public class WhereClause extends QueryModel{

	private ArrayList<ComparableStatementCollection> where;
	
	public WhereClause(){
		where = new ArrayList<ComparableStatementCollection>();
	}
	
	public void addFilter(ComparableStatementCollection filter){
		where.add(filter);
	}
	
	public ArrayList<ComparableStatementCollection> getFilter(){
		return where;
	}
}
