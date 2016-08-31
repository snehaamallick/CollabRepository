package com.myweb.myblog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.myblog.dao.impl.UserDetailDAOImp;
import com.myweb.myblog.model.UserDetail;

@Service
public class UserDetailServiceImpl {
	

    @Autowired
    private UserDetailDAOImp userDetailDao;

    public UserDetail getUserDetailById(int userDetailId){
        return userDetailDao.getUserDetailById(userDetailId);
    }

    public List<UserDetail> getUserDetailList(){
        return userDetailDao.getUserDetailList();
    }

    public void addUserDetail(UserDetail userdetail){
        userDetailDao.addUserDetail(userdetail);
    }
    public void editUserDetail(UserDetail userdetail){
        userDetailDao.editUserDetail(userdetail);
    }

    public void deleteUserDetail(UserDetail userdetail){
        userDetailDao.deleteUserDetail(userdetail);
    }


} // The End of Class;
