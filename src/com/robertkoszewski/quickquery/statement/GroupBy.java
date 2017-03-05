package com.robertkoszewski.quickquery.statement;

import com.robertkoszewski.quickquery.builder.GroupByState;

/**
 * Group By
 * @author Robert Koszewski
 *
 */
public interface GroupBy {
	public GroupByState groupby(String... column_names);
	public GroupByState GROUPBY(String... column_names);
}
