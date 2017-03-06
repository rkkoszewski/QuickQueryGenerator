package com.robertkoszewski.quickquery.model;

/**
 * Having Clause
 * @author Robert Koszewski
 *
 */
public class HavingClause extends QueryModel{
	
	private ComparableStatement having;

	public HavingClause(String column, Compare compare, Object value) {
		this.having = new ComparableStatement(column, compare, value);
	}

	public ComparableStatement getFilter(){
		return having;
	}
}
