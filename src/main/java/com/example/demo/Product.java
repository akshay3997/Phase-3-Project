package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Product {
@Id
@GeneratedValue(strategy =GenerationType.AUTO)
private int id;
private String category;
private String ProductName;
private String date;

}
