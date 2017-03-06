package com.robertkoszewski.quickquery.model;

/**
 * Query Element
 * @author Robert Koszewski
 *
 */
public interface QueryElement {
	public void addNextElement(QueryElement element);
	public QueryElement getNextElement();
}
