package com.example.demo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
	@Query("select admin from Admin admin where admin.adminID=?1")
	public Admin findByadmin(String adminID);
	@Query("select admin from Admin admin where admin.password=?1")
public Admin  findByPwd(String password);
}
