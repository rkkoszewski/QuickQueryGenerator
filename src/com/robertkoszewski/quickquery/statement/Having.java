package com.robertkoszewski.quickquery.statement;

import com.robertkoszewski.quickquery.builder.HavingState;
import com.robertkoszewski.quickquery.model.Compare;

/**
 * Having
 * @author Robert Koszewski
 *
 */
public interface Having {
	public HavingState having(String column, Compare compare, Object value);
	public HavingState HAVING(String column, Compare compare, Object value);
}
