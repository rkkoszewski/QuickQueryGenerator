package com.robertkoszewski.quickquery.model;

import java.util.ArrayList;

public class GroupByClause extends QueryModel{

	private ArrayList<String> groupby;
	
	public GroupByClause(){
		groupby = new ArrayList<String>();
	}
	
	public void addGroupBy(String column){
		if(!groupby.contains(column))
			groupby.add(column);
	}
	
	public ArrayList<String> getGroupBy(){
		return groupby;
	}
}
