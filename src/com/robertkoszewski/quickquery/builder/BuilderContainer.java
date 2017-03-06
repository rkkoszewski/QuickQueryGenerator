package com.robertkoszewski.quickquery.builder;

import com.robertkoszewski.quickquery.model.QueryElement;
import com.robertkoszewski.quickquery.translator.ModelDriver;

/**
 * Builder Container
 * @author Robert Koszewski
 *
 */
public class BuilderContainer {

	private QueryElement model_root;
	private ModelDriver driver;
	
	public BuilderContainer(ModelDriver driver){
		this.driver = driver;
		
	}
	
	void setRootModel(QueryElement model_root){
		this.model_root = model_root;
	}
	
	public QueryElement getRootModel(){
		return model_root;
	}
	
	public String getQuery(){
		return driver.toString(model_root);
	}
}
