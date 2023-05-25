package com.cdac.MyJdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cdac.MyJdbc.dao.StudentDao;

@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner 
{
	@Autowired
	StudentDao studentDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		studentDao.createTable();
				
	}

}
