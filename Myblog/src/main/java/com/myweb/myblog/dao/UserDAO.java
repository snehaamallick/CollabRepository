package com.myweb.myblog.dao;
import java.util.List;

import com.myweb.myblog.model.*;

public interface UserDAO {
void addUser(User user);
	
	void updateUser(User user);
	
    User getUserById(int userid);

    List<User> listUsers();

    User getUserByusername(String username);
    
    void removeUser(int userid);
}
