package com.robertkoszewski.quickquery.model;

/**
 * Comparable Statement
 * @author Robert Koszewski
 */
public class ComparableStatement {
	
	private String column;
	private Compare compare;
	private Object value;
	
	public ComparableStatement(String column, Compare compare, Object value){
		this.column = column;
		this.compare = compare;
		this.value = value;
	}
	
	public String getColumn(){
		return column;
	}
	
	public Compare getComparator(){
		return compare;
	}
	
	public Object getValue(){
		return value;
	}
	
	public dataType getValueDataType(){
		if(value instanceof Integer)
			return dataType.INTEGER;
		if(value instanceof Boolean)
			return dataType.BOOLEAN;
		else
			return dataType.STRING;
	}
	
	public enum dataType{
		STRING,
		BOOLEAN,
		INTEGER
	}
}
