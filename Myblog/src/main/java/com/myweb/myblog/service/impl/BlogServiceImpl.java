package com.myweb.myblog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myweb.myblog.dao.impl.BlogDAOImpl;
import com.myweb.myblog.model.Blog;
@Service
public class BlogServiceImpl {
	
	@Autowired
	private BlogDAOImpl bdi;
	
	@Transactional
    public void addBlog(Blog b) {
        this.bdi.addBlog(b);
    }
	
	@Transactional
    public List<Blog> listBlogs() {
        return this.bdi.listBlogs();
    }
	
	@Transactional
    public Blog getBlogById(int blogId) {
        return this.bdi.getBlogById(blogId);
    }
	
	@Transactional
    public void removeBlog(int blogId) {
        this.bdi.removeBlog(blogId);
    }
}
