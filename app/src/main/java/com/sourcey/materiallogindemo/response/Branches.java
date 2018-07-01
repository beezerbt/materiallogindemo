package com.sourcey.materiallogindemo.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Branches{

	@JsonProperty("href")
	private String href;

	public void setHref(String href){
		this.href = href;
	}

	public String getHref(){
		return href;
	}

	@Override
 	public String toString(){
		return 
			"Branches{" + 
			"href = '" + href + '\'' + 
			"}";
		}
}