package com.robertkoszewski.quickquery.statement;

import com.robertkoszewski.quickquery.builder.WhereState;
import com.robertkoszewski.quickquery.model.Compare;

/**
 * Where
 * @author Robert Koszewski
 *
 */
public interface Where {
		public WhereState where(String column, Compare compare, Object value);
		public WhereState WHERE(String column, Compare compare, Object value);
}
