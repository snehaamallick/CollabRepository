package com.myweb.myblog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


import java.util.Date;

@Entity
public class Blog {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int blogId;
	
private	String blogTitle;

private String blogcontent;
private String u_name;

public String getU_name() {
	return u_name;
}

public void setU_name(String u_name) {
	this.u_name = u_name;
}

private Date time;
/*@ManyToOne
@JoinColumn(name="u_name", nullable = false, updatable = false, insertable = false )
private User user;

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}*/


public int getBlogId() {
	return blogId;
}

public void setBlogId(int blogId) {
	this.blogId = blogId;
}

public String getBlogTitle() {
	return blogTitle;
}

public void setBlogTitle(String blogTitle) {
	this.blogTitle = blogTitle;
}



public String getBlogcontent() {
	return blogcontent;
}

public void setBlogcontent(String blogcontent) {
	this.blogcontent = blogcontent;
}

public Date getTime() {
	return time;
}

public void setTime(Date time) {
	this.time = time;
}

}
