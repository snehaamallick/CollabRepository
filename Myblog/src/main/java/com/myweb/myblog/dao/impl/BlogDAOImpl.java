package com.myweb.myblog.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myweb.myblog.model.Blog;
import com.myweb.myblog.model.User;

@Repository
public class BlogDAOImpl {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addBlog(Blog b) {
        Session session = this.sessionFactory.getCurrentSession();
        
     //  b.getUser().setBlog(b);
     //  session.save(b.getUser());
        //Blog newBlog = new Blog();
        //newBlog.setUsername(b.getUsername());
       
       // b.getUser();

        session.save(b);
       // session.save(b.getUser());
        //session.save(b);
        session.flush();
    }
	
	
	public List<Blog> listBlogs() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Blog> blogList = session.createQuery("from Blog").list();
        return blogList;
    }
    
    public Blog getBlogById(int blogId) {
        Session session = this.sessionFactory.getCurrentSession();      
        Blog b = (Blog) session.load(Blog.class, new Integer(blogId));
        
        return b;
    }
    
    @Transactional
    public void removeBlog(int blogId) {
        Session session = this.sessionFactory.getCurrentSession();
        Blog b = (Blog) session.load(Blog.class, new Integer(blogId));
        if(null != b){
            session.delete(b);
            session.flush();
        }
}
}
