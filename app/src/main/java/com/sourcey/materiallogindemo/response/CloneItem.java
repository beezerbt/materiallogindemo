package com.sourcey.materiallogindemo.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CloneItem{

	@JsonProperty("name")
	private String name;

	@JsonProperty("href")
	private String href;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setHref(String href){
		this.href = href;
	}

	public String getHref(){
		return href;
	}

	@Override
 	public String toString(){
		return 
			"CloneItem{" + 
			"name = '" + name + '\'' + 
			",href = '" + href + '\'' + 
			"}";
		}
}