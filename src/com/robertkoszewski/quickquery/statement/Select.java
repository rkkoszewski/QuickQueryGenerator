package com.robertkoszewski.quickquery.statement;

/**
 * Select
 * @author Robert Koszewski
 *
 */
public interface Select {
	public Select SELECT(String... columns);
	public Select select(String... columns);
}
