package com.niit.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.blog.dao.impl.UserDAOImpl;
import com.niit.blog.model.User;

@Service
public class UserServiceImpl {
	@Autowired
	private UserDAOImpl udi;
	
	@Transactional
    public void addUser(User u) {
        this.udi.addUser(u);
    }
	
	@Transactional
    public void updateUser(User u) {
        this.udi.updateUser(u);
    }
	
	@Transactional
    public List<User> listUsers() {
        return this.udi.listUsers();
    }
	
	@Transactional
    public User getPersonById(int userid) {
        return this.udi.getUserById(userid);
    }
	
	@Transactional
    public void removeUser(int userid) {
        this.udi.removeUser(userid);
    }
}