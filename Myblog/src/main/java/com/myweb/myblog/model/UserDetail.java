package com.myweb.myblog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class UserDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userDetailId;
	private String username;
	private String status;
	private String profession;
	@Transient
    private MultipartFile userImage;
	public MultipartFile getUserImage() {
		return userImage;
	}
	public void setUserImage(MultipartFile userImage) {
		this.userImage = userImage;
	}
	public int getUserDetailId() {
		return userDetailId;
	}
	public void setUserDetailId(int userDetailId) {
		this.userDetailId = userDetailId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	

}
