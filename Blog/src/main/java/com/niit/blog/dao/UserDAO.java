package com.niit.blog.dao;

import java.util.List;

import com.niit.blog.model.User;

public interface UserDAO {
void addUser(User user);
	
	void updateUser(User user);
	
    User getUserById(int userid);

    List<User> listUsers();

    User getUserByname(String name);
    
    void removeUser(int userid);
}
