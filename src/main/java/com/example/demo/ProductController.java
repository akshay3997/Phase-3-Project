package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	@Autowired
	ProductRepo repo;
	@Autowired
	ProductDAO dao;
	@RequestMapping("/ManageProduct")
	public ModelAndView Update(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Update.jsp");
		return mv;
	}
//insert
	@RequestMapping("/AddDetails")
	public ModelAndView AddDetails(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();	
String Category = req.getParameter("Category");
String ProductName = req.getParameter("ProductName");
String PurchaseDate = req.getParameter("PurchaseDate");

Product product = new Product();

product.setCategory(Category);
product.setProductName(ProductName);
product.setDate(PurchaseDate);
Product p = repo.save(product);
if(p!=null) {
	mv.setViewName("AddSuccess.jsp");
}
else {
	mv.setViewName("Fail.jsp");
}
return mv;
	}
	
	@RequestMapping("/ShowProduct")
	public ModelAndView ShowProduct(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
			List<Product> list = dao.ShowProduct();
			mv.setViewName("DisplayPrpduct.jsp");
			mv.addObject("list", list);
			return mv;
		}
		
		@RequestMapping("/buy")
		public ModelAndView buy(HttpServletRequest req, HttpServletResponse resp) {
			ModelAndView mv = new ModelAndView();	
	String Category = req.getParameter("Category");
	String ProductName = req.getParameter("ProductName");
	String PurchaseDate = req.getParameter("PurchaseDate");

	Product product = new Product();

	product.setCategory(Category);
	product.setProductName(ProductName);
	product.setDate(PurchaseDate);
	Product p = repo.save(product);
	if(p!=null) {
		mv.setViewName("AddSuccess.jsp");
	}
	else {
		mv.setViewName("Fail.jsp");
	}
	return mv;
		}
}