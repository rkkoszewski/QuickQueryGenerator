package com.robertkoszewski.quickquery.builder;

import com.robertkoszewski.quickquery.model.FromClause;
import com.robertkoszewski.quickquery.model.ItemAlias;
import com.robertkoszewski.quickquery.model.SelectClause;
import com.robertkoszewski.quickquery.statement.From;

/**
 * Select State
 * @author Robert Koszewski
 */
public class SelectState extends BuilderHost implements From {
	
	public SelectState(BuilderContainer builder, String... columns) {
		super(builder, null);

		model = new SelectClause();
		
		builder.setRootModel(model);

		for(String column: columns){
			// TODO: Parse alias 
			((SelectClause) model).addColumn(new ItemAlias(column));
		}
	}
	
	public FromState from(String table){
		// TODO: Implement ALIAS and Multiple Tables
		FromClause from = new FromClause(new ItemAlias(table));
		model.addNextElement(from);
		return new FromState(builder, from);
	}
	
	public FromState FROM(String table){
		return from(table);
	}
}
