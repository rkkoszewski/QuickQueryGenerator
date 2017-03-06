package com.robertkoszewski.quickquery.builder;

import com.robertkoszewski.quickquery.model.QueryElement;

/**
 * Builder Host
 * @author Robert Koszewski
 */
public class BuilderHost {

	BuilderContainer builder;
	QueryElement model;
	
	BuilderHost(BuilderContainer builder, QueryElement model) {
		this.builder = builder;
		this.model = model;
	}
	
	public String toString(){
		return builder.getQuery();
	}
}
