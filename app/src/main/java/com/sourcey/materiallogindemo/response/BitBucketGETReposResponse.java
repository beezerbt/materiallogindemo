package com.sourcey.materiallogindemo.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BitBucketGETReposResponse {

	@JsonProperty("size")
	private int size;

	@JsonProperty("values")
	private List<ValuesItem> values;

	@JsonProperty("page")
	private int page;

	@JsonProperty("pagelen")
	private int pagelen;

	public void setSize(int size){
		this.size = size;
	}

	public int getSize(){
		return size;
	}

	public void setValues(List<ValuesItem> values){
		this.values = values;
	}

	public List<ValuesItem> getValues(){
		return values;
	}

	public void setPage(int page){
		this.page = page;
	}

	public int getPage(){
		return page;
	}

	public void setPagelen(int pagelen){
		this.pagelen = pagelen;
	}

	public int getPagelen(){
		return pagelen;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"size = '" + size + '\'' + 
			",values = '" + values + '\'' + 
			",page = '" + page + '\'' + 
			",pagelen = '" + pagelen + '\'' + 
			"}";
		}
}