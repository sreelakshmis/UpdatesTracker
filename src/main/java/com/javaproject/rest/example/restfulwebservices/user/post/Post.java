package com.javaproject.rest.example.restfulwebservices.user.post;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javaproject.rest.example.restfulwebservices.user.User;

@Entity
public class Post{
	@Id
	@GeneratedValue
	private Integer postId;
	
	private String postMessage;
	private Date postDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private User user;
	
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postMessage=" + postMessage + ", postDate=" + postDate + "]";
	}

	protected Post() {

	}
	
	public Post(Integer postId, String postMessage, Date postDate, User user) {
		super();
		this.postId = postId;
		this.postMessage = postMessage;
		this.postDate = postDate;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getPostMessage() {
		return postMessage;
	}
	public void setPostMessage(String postMessage) {
		this.postMessage = postMessage;
	}
	

}
