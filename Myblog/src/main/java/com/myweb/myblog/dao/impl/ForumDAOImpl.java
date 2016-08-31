package com.myweb.myblog.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myweb.myblog.model.Blog;
import com.myweb.myblog.model.Forum;

@Repository
public class ForumDAOImpl {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addForum(Forum f) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(f);
       // session.save(b.getUser());
        //session.save(b);
        session.flush();
    }
	
	
	public List<Forum> listForums() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Forum> forumList = session.createQuery("from Forum").list();
        return forumList;
    }
    
    public Forum getForumById(int fId) {
        Session session = this.sessionFactory.getCurrentSession();      
        Forum f = (Forum) session.load(Forum.class, new Integer(fId));
        
        return f;
    }
    
    @Transactional
    public void removeForum(int fId) {
        Session session = this.sessionFactory.getCurrentSession();
        Forum f = (Forum) session.load(Blog.class, new Integer(fId));
        if(null != f){
            session.delete(f);
            session.flush();
        }
}
}
