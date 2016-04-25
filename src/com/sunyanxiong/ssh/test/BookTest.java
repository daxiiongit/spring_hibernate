package com.sunyanxiong.ssh.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sunyanxiong.ssh.service.BookService;

public class BookTest {
	
	private ApplicationContext ctx = null;
	private BookService bookService = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		bookService = ctx.getBean(BookService.class);
	}
	
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}
	
	@Test
	public void testBookService(){
		bookService.purchase("sunyanxiong", "2020");
	}
	

}
