package com.sunyanxiong.ssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunyanxiong.ssh.dao.BookDao;
import com.sunyanxiong.ssh.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	@Override
	public void purchase(String username, String isbn) {
		int price = bookDao.findPriceByIsbn(isbn);
		bookDao.updateBookStock(isbn);
		bookDao.updateUserAccount(username, price);
	}

}
