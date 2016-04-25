package com.sunyanxiong.ssh.service;

public interface BookService {
	// 通过书的编号查找书的价格
	public String findPriceByIsbn(String isbn);
}
