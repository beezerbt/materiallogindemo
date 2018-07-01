package com.sourcey.materiallogindemo.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValuesItem{

	@JsonProperty("owner")
	private Owner owner;

	@JsonProperty("updated_on")
	private String updatedOn;

	@JsonProperty("is_private")
	private boolean isPrivate;

	@JsonProperty("website")
	private String website;

	@JsonProperty("fork_policy")
	private String forkPolicy;

	@JsonProperty("description")
	private String description;

	@JsonProperty("language")
	private String language;

	@JsonProperty("type")
	private String type;

	@JsonProperty("uuid")
	private String uuid;

	@JsonProperty("has_issues")
	private boolean hasIssues;

	@JsonProperty("mainbranch")
	private Mainbranch mainbranch;

	@JsonProperty("has_wiki")
	private boolean hasWiki;

	@JsonProperty("full_name")
	private String fullName;

	@JsonProperty("size")
	private int size;

	@JsonProperty("created_on")
	private String createdOn;

	@JsonProperty("name")
	private String name;

	@JsonProperty("links")
	private Links links;

	@JsonProperty("scm")
	private String scm;

	@JsonProperty("slug")
	private String slug;

	public void setOwner(Owner owner){
		this.owner = owner;
	}

	public Owner getOwner(){
		return owner;
	}

	public void setUpdatedOn(String updatedOn){
		this.updatedOn = updatedOn;
	}

	public String getUpdatedOn(){
		return updatedOn;
	}

	public void setIsPrivate(boolean isPrivate){
		this.isPrivate = isPrivate;
	}

	public boolean isIsPrivate(){
		return isPrivate;
	}

	public void setWebsite(String website){
		this.website = website;
	}

	public String getWebsite(){
		return website;
	}

	public void setForkPolicy(String forkPolicy){
		this.forkPolicy = forkPolicy;
	}

	public String getForkPolicy(){
		return forkPolicy;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setLanguage(String language){
		this.language = language;
	}

	public String getLanguage(){
		return language;
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

	public void setHasIssues(boolean hasIssues){
		this.hasIssues = hasIssues;
	}

	public boolean isHasIssues(){
		return hasIssues;
	}

	public void setMainbranch(Mainbranch mainbranch){
		this.mainbranch = mainbranch;
	}

	public Mainbranch getMainbranch(){
		return mainbranch;
	}

	public void setHasWiki(boolean hasWiki){
		this.hasWiki = hasWiki;
	}

	public boolean isHasWiki(){
		return hasWiki;
	}

	public void setFullName(String fullName){
		this.fullName = fullName;
	}

	public String getFullName(){
		return fullName;
	}

	public void setSize(int size){
		this.size = size;
	}

	public int getSize(){
		return size;
	}

	public void setCreatedOn(String createdOn){
		this.createdOn = createdOn;
	}

	public String getCreatedOn(){
		return createdOn;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLinks(Links links){
		this.links = links;
	}

	public Links getLinks(){
		return links;
	}

	public void setScm(String scm){
		this.scm = scm;
	}

	public String getScm(){
		return scm;
	}

	public void setSlug(String slug){
		this.slug = slug;
	}

	public String getSlug(){
		return slug;
	}

	@Override
 	public String toString(){
		return 
			"ValuesItem{" + 
			"owner = '" + owner + '\'' + 
			",updated_on = '" + updatedOn + '\'' + 
			",is_private = '" + isPrivate + '\'' + 
			",website = '" + website + '\'' + 
			",fork_policy = '" + forkPolicy + '\'' + 
			",description = '" + description + '\'' + 
			",language = '" + language + '\'' + 
			",type = '" + type + '\'' + 
			",uuid = '" + uuid + '\'' + 
			",has_issues = '" + hasIssues + '\'' + 
			",mainbranch = '" + mainbranch + '\'' + 
			",has_wiki = '" + hasWiki + '\'' + 
			",full_name = '" + fullName + '\'' + 
			",size = '" + size + '\'' + 
			",created_on = '" + createdOn + '\'' + 
			",name = '" + name + '\'' + 
			",links = '" + links + '\'' + 
			",scm = '" + scm + '\'' + 
			",slug = '" + slug + '\'' + 
			"}";
		}
}