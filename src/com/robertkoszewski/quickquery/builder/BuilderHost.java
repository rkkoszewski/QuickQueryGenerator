package com.robertkoszewski.quickquery.builder;

import com.robertkoszewski.quickquery.model.SQLBuilder;

/**
 * Builder Host
 * @author Robert Koszewski
 */
public class BuilderHost {

	SQLBuilder builder;
	
	BuilderHost(SQLBuilder builder) {
		this.builder = builder;
	}
	
	public String toString(){
		return builder.getQuery();
	}
}
