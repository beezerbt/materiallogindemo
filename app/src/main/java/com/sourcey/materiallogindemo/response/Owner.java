package com.sourcey.materiallogindemo.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Owner{

	@JsonProperty("account_id")
	private String accountId;

	@JsonProperty("links")
	private Links links;

	@JsonProperty("display_name")
	private String displayName;

	@JsonProperty("type")
	private String type;

	@JsonProperty("uuid")
	private String uuid;

	@JsonProperty("username")
	private String username;

	public void setAccountId(String accountId){
		this.accountId = accountId;
	}

	public String getAccountId(){
		return accountId;
	}

	public void setLinks(Links links){
		this.links = links;
	}

	public Links getLinks(){
		return links;
	}

	public void setDisplayName(String displayName){
		this.displayName = displayName;
	}

	public String getDisplayName(){
		return displayName;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setUuid(String uuid){
		this.uuid = uuid;
	}

	public String getUuid(){
		return uuid;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"Owner{" + 
			"account_id = '" + accountId + '\'' + 
			",links = '" + links + '\'' + 
			",display_name = '" + displayName + '\'' + 
			",type = '" + type + '\'' + 
			",uuid = '" + uuid + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}