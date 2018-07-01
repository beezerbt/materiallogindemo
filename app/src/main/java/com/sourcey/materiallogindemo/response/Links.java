package com.sourcey.materiallogindemo.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Links{

	@JsonProperty("forks")
	private Forks forks;

	@JsonProperty("watchers")
	private Watchers watchers;

	@JsonProperty("source")
	private Source source;

	@JsonProperty("avatar")
	private Avatar avatar;

	@JsonProperty("branches")
	private Branches branches;

	@JsonProperty("issues")
	private Issues issues;

	@JsonProperty("pullrequests")
	private Pullrequests pullrequests;

	@JsonProperty("tags")
	private Tags tags;

	@JsonProperty("downloads")
	private Downloads downloads;

	@JsonProperty("clone")
	private List<CloneItem> clone;

	@JsonProperty("commits")
	private Commits commits;

	@JsonProperty("self")
	private Self self;

	@JsonProperty("html")
	private Html html;

	@JsonProperty("hooks")
	private Hooks hooks;

	public void setForks(Forks forks){
		this.forks = forks;
	}

	public Forks getForks(){
		return forks;
	}

	public void setWatchers(Watchers watchers){
		this.watchers = watchers;
	}

	public Watchers getWatchers(){
		return watchers;
	}

	public void setSource(Source source){
		this.source = source;
	}

	public Source getSource(){
		return source;
	}

	public void setAvatar(Avatar avatar){
		this.avatar = avatar;
	}

	public Avatar getAvatar(){
		return avatar;
	}

	public void setBranches(Branches branches){
		this.branches = branches;
	}

	public Branches getBranches(){
		return branches;
	}

	public void setIssues(Issues issues){
		this.issues = issues;
	}

	public Issues getIssues(){
		return issues;
	}

	public void setPullrequests(Pullrequests pullrequests){
		this.pullrequests = pullrequests;
	}

	public Pullrequests getPullrequests(){
		return pullrequests;
	}

	public void setTags(Tags tags){
		this.tags = tags;
	}

	public Tags getTags(){
		return tags;
	}

	public void setDownloads(Downloads downloads){
		this.downloads = downloads;
	}

	public Downloads getDownloads(){
		return downloads;
	}

	public void setClone(List<CloneItem> clone){
		this.clone = clone;
	}

	public List<CloneItem> getClone(){
		return clone;
	}

	public void setCommits(Commits commits){
		this.commits = commits;
	}

	public Commits getCommits(){
		return commits;
	}

	public void setSelf(Self self){
		this.self = self;
	}

	public Self getSelf(){
		return self;
	}

	public void setHtml(Html html){
		this.html = html;
	}

	public Html getHtml(){
		return html;
	}

	public void setHooks(Hooks hooks){
		this.hooks = hooks;
	}

	public Hooks getHooks(){
		return hooks;
	}

	@Override
 	public String toString(){
		return 
			"Links{" + 
			"forks = '" + forks + '\'' + 
			",watchers = '" + watchers + '\'' + 
			",source = '" + source + '\'' + 
			",avatar = '" + avatar + '\'' + 
			",branches = '" + branches + '\'' + 
			",issues = '" + issues + '\'' + 
			",pullrequests = '" + pullrequests + '\'' + 
			",tags = '" + tags + '\'' + 
			",downloads = '" + downloads + '\'' + 
			",clone = '" + clone + '\'' + 
			",commits = '" + commits + '\'' + 
			",self = '" + self + '\'' + 
			",html = '" + html + '\'' + 
			",hooks = '" + hooks + '\'' + 
			"}";
		}
}