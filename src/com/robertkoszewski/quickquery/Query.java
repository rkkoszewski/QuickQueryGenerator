package com.robertkoszewski.quickquery;

import com.robertkoszewski.quickquery.builder.BuilderContainer;
import com.robertkoszewski.quickquery.builder.SelectState;
import com.robertkoszewski.quickquery.translator.ModelDriver;
import com.robertkoszewski.quickquery.translator.MySQLDriver;

/**
 * Quick Query Generator
 * @author Robert Koszewski
 */
public class Query {
	
	private static ModelDriver driver;

	public static SelectState select(String... columns){
		if(driver == null)
			driver = new MySQLDriver();
		
		BuilderContainer builder = new BuilderContainer(driver);

		return new SelectState(builder, columns);
	}
	
	public static SelectState SELECT(String... columns){
		return select(columns);
	}
	
	public static void setModelDriver(ModelDriver driver){
		Query.driver = driver;
	}
}
