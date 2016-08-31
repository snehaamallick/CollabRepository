package com.myweb.myblog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myweb.myblog.dao.impl.ForumDAOImpl;
import com.myweb.myblog.model.Forum;

@Service
public class ForumServiceImpl {
	@Autowired
	private ForumDAOImpl fdi;
	
	@Transactional
    public void addForum(Forum b) {
        this.fdi.addForum(b);
    }
	
	@Transactional
    public List<Forum> listForums() {
        return this.fdi.listForums();
    }
	
	@Transactional
    public Forum getForumById(int fId) {
        return this.fdi.getForumById(fId);
    }
	
	@Transactional
    public void removeForum(int fId) {
        this.fdi.removeForum(fId);
    }
}
