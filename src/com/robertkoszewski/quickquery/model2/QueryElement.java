package com.robertkoszewski.quickquery.model2;

/**
 * Query Element
 * @author Robert Koszewski
 *
 */
public abstract class QueryElement {
	
	private QueryElement nextElement;
	
	public void addNextElement(QueryElement element){
		this.nextElement = element;
	}
	
	public QueryElement getNextElement(){
		return this.nextElement;
	}
}
