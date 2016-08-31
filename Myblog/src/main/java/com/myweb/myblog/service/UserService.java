package com.myweb.myblog.service;
import java.util.List;

import com.myweb.myblog.model.*;
public interface UserService {
	
	void addUser(User user);
	
	void updateUser(User user);
	
    User getUserById(int userid);

    List<User> listUsers();

    User getUserByusername(String username);
    
    void removeUser(int userid);
}

