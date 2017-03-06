package com.robertkoszewski.quickquery.model;

/**
 * Query Model
 * @author Robert Koszewski
 *
 */
public abstract class QueryModel implements QueryElement{
	
	private QueryElement nextElement;
	
	public void addNextElement(QueryElement element){
		this.nextElement = element;
	}
	
	public QueryElement getNextElement(){
		return this.nextElement;
	}
}
