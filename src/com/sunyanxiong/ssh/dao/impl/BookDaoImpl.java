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

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public int findPriceByIsbn(String isbn) {
		String sql = "SELECT b.price FROM Book b WHERE b.isbn = ?";
		Query query = getSession().createQuery(sql).setString(0, isbn);

		int rs_price = 0;

		if (query.uniqueResult() == null) {
			rs_price = 0;
		} else {
			rs_price = (int) query.uniqueResult();
		}

		return rs_price;
	}

	@Override
	public void updateBookStock(String isbn) {
		String query_sql = "SELECT b.stock FROM Book b WHERE b.isbn = ?";
		String update_sql = "UPDATE Book b SET b.stock = b.stock - 1 WHERE b.isbn = ?";

		int stock = (int) getSession().createQuery(query_sql).setString(0, isbn).uniqueResult();
		if (stock == 0) {
			System.out.println("库存不足");
		} else {
			getSession().createQuery(update_sql).setString(0, isbn).executeUpdate();
		}

	}

	@Override
	public void updateUserAccount(String username, int price) {
		
		String query_sql = "SELECT a.balance FROM Account a WHERE a.username = ?";
		String update_sql = "UPDATE Account a SET a.balance = a.balance - ? WHERE a.username = ?";
		
		int balance = (int) getSession().createQuery(query_sql).setString(0, username).uniqueResult();
		if(balance < price){
			System.out.println("余额不足");
		}else{
			getSession().createQuery(update_sql).setInteger(0, price).setString(1, username).executeUpdate();
		}
	}

}
