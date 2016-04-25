package com.sunyanxiong.ssh.dao;

public interface BookDao {

	// 通过书的编号查找书的价格
	public int findPriceByIsbn(String isbn);
	
	// 更新用户购买书的库存
	public void updateBookStock(String isbn);
	
	// 更新账户余额
	public void updateUserAccount(String username,int price);
}
