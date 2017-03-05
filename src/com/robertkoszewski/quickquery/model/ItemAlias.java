package com.robertkoszewski.quickquery.model;

/**
 * Column Item
 * @author Robert Koszewski
 */
public class ItemAlias {
	
	private final String item_name;
	private final String item_alias;
	
	public ItemAlias(String column_name){
		this(column_name, null);
	}
	
	public ItemAlias(String column_name, String column_alias){
		this.item_name = column_name;
		this.item_alias = column_alias;
	}
	
	/**
	 * Get Column Name
	 * @return Column Name
	 */
	public String getItemName(){
		return this.item_name;
	}
	
	/**
	 * Get Column Alias
	 * @return Column Alias
	 */
	public String getItemAlias(){
		return item_alias;
	}
	
	/**
	 * Has Column Alias?
	 * @return true/false
	 */
	public boolean hasAlias(){
		return item_alias != null;
	}
}
