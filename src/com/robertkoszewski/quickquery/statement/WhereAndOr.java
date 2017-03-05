package com.robertkoszewski.quickquery.statement;

import com.robertkoszewski.quickquery.builder.WhereState;
import com.robertkoszewski.quickquery.model.Compare;

/**
 * Where (AND and OR statement)
 * @author Robert Koszewski
 *
 */
public interface WhereAndOr {
		// WHERE (AND)
		public WhereState and(String column, Compare compare, Object value);
		public WhereState AND(String column, Compare compare, Object value);

		// WHERE (OR)
		public WhereState or(String column, Compare compare, Object value);
		public WhereState OR(String column, Compare compare, Object value);
}
