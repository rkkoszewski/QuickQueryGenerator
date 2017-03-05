package com.robertkoszewski.quickquery.model;

import java.util.ArrayList;

/**
 * Comparable Statement Collection
 * @author Robert Koszewski
 */
public class ComparableStatementCollection {
	
	private ArrayList<ComparableStatement> comparable_list;
	
	public ComparableStatementCollection(){
		this.comparable_list = new ArrayList<ComparableStatement>();
	}
	
	public void addWhereStatement(ComparableStatement where_stmnt){
		comparable_list.add(where_stmnt);
	}
	
	public ArrayList<ComparableStatement> getWhereStatementCollection(){
		return comparable_list;
	}
}
