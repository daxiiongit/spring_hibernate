package com.sunyanxiong.ssh.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sunyanxiong.ssh.dao.BookDao;

// @Repository:标识Dao 组件
@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public String findPriceByIsbn(String isbn) {
		String sql = "SELECT b.price FROM Book b WHERE b.isbn = ?";
		Query query = getSession().createQuery(sql).setString(0, isbn);
		
		String rs_price = query.uniqueResult().toString();
		
		return rs_price;
	}

}
