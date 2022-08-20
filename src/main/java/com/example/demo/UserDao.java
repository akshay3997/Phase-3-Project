package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDao {
	@Autowired
	UserRepo userepo;

	public List<User> getall() {

		return userepo.findAll();
	}
	
	public User findByUser(String userID) {
		return userepo.findByUser(userID);
	 }

	
}
