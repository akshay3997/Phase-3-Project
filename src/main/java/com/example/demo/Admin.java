package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String adminID;
private String password;
private String email;
//hello
}
