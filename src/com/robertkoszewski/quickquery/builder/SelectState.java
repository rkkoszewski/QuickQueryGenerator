package com.robertkoszewski.quickquery.builder;

import com.robertkoszewski.quickquery.model.ItemAlias;
import com.robertkoszewski.quickquery.model.SQLBuilder;
import com.robertkoszewski.quickquery.statement.From;

/**
 * Select State
 * @author Robert Koszewski
 */
public class SelectState extends BuilderHost implements From {
	
	public SelectState(SQLBuilder builder, String... columns) {
		super(builder);
		
		for(String column: columns){
			// TODO: Parse alias 
			builder.getModel().addSelectColumn(new ItemAlias(column));
		}
	}
	
	public FromState from(String table){
		// TODO: Implement ALIAS and Multiple Tables
		builder.getModel().addTables(new ItemAlias(table));
		return new FromState(builder);
	}
	
	public FromState FROM(String table){
		return from(table);
	}
}
