package com.sourcey.materiallogindemo.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Mainbranch{

	@JsonProperty("name")
	private String name;

	@JsonProperty("type")
	private String type;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"Mainbranch{" + 
			"name = '" + name + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}