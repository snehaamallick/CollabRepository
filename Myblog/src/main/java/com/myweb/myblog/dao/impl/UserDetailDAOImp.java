package com.myweb.myblog.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myweb.myblog.model.UserDetail;

@Repository
@Transactional
public class UserDetailDAOImp {
	@Autowired
    private SessionFactory sessionFactory;

    public UserDetail getUserDetailById (int userDetailId){
        Session session = sessionFactory.getCurrentSession();
        UserDetail userdetail = (UserDetail) session.get(UserDetail.class, userDetailId);
        session.flush();

        return userdetail;
    }

    public List<UserDetail> getUserDetailList(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from UserDetail");
        List<UserDetail> userdetailList = query.list();
        session.flush();

        return userdetailList;
    }

    public void addUserDetail (UserDetail userdetail){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(userdetail);
        session.flush();
    }

    public void editUserDetail(UserDetail userdetail){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(userdetail);
        session.flush();
    }

    public void deleteUserDetail (UserDetail userdetail){
        Session session = sessionFactory.getCurrentSession();
        session.delete(userdetail);
        session.flush();
    }

} // The End of Class;