package com.sunyanxiong.ssh.dao;

public interface BookDao {

	// 通过书的编号查找书的价格
	public String findPriceByIsbn(String isbn);
	
}
