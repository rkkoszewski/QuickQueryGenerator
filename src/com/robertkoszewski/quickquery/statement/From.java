package com.robertkoszewski.quickquery.statement;

import com.robertkoszewski.quickquery.builder.FromState;

/**
 * From
 * @author Robert Koszewski
 *
 */
public interface From {
	public FromState from(String table);
	public FromState FROM(String table);
}
