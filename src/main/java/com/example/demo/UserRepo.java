package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Integer>{
	@Query("select user from User user where user.userID=?1")
	public User findByUser(String userID);
	@Query("select user from User user where user.password=?1")
public User  findByPwd(String password);
	
		
	
}

