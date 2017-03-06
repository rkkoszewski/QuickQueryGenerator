package com.robertkoszewski.quickquery.translator;

import com.robertkoszewski.quickquery.model.QueryElement;

/**
 * Model Driver Interface
 * @author Robert Koszewski
 *
 */
public interface ModelDriver {

	String toString(QueryElement model);

}
