package com.robertkoszewski.quickquery.model;

import com.robertkoszewski.quickquery.translator.ModelDriver;

public class SQLBuilder {

	private SQLModel model;
	private ModelDriver driver;
	
	public SQLBuilder(ModelDriver driver){
		this.model = new SQLModel();
		this.driver = driver;
	}
	
	public SQLModel getModel(){
		return model;
	}
	
	public String getQuery(){
		return driver.toString(model);
	}
}
