package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	@Autowired
	UserRepo repo;
	@Autowired
	UserDao userDao;

	@ResponseBody
	@RequestMapping("/Register")
	public ModelAndView RegisterUser(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("RegisterUser.jsp");
		return mv;

	}

	@ResponseBody
	@RequestMapping("/UserRegister")
	public ModelAndView UserRegister(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
		String UserID = req.getParameter("UserID");
		String Password = req.getParameter("Password");
		String Email = req.getParameter("Email");
		User u = new User();
		u.setUserID(UserID);
		u.setPassword(Password);
		u.setEmail(Email);
		User U = repo.save(u);
		if (U != null) {

			mv.setViewName("Display.jsp");
		} else {

			mv.setViewName("Fail.jsp");
		}

		return mv;

	}

	@ResponseBody
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
		String userID = req.getParameter("userID");
		String password = req.getParameter("password");
		repo.findByUser(userID);
		repo.findByPwd(password);

		if (repo.findByUser(userID).equals(repo.findByPwd(password))) {
			HttpSession session = req.getSession();
			session.setAttribute("userID", userID);
			mv.setViewName("User.jsp");

		} else {
			mv.setViewName("Fail.jsp");
		}
		return mv;
	}

	@ResponseBody
	@RequestMapping("/LoginPage")
	public ModelAndView LoginPage(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		return mv;
	}

	@ResponseBody
	@RequestMapping("/logoutUser")
	public ModelAndView logoutUser(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = req.getSession();
		session.invalidate();
		mv.setViewName("index.jsp");
		return mv;

	}

	@ResponseBody
	@RequestMapping("/BrowseUser")
	public ModelAndView BrowseUser(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("BrowseUser.jsp");
		return mv;
	}

	
//	Display one user
//	@ResponseBody
//	@RequestMapping("/findByUser")
//	public ModelAndView finduser(HttpServletRequest req, HttpServletResponse resp) {
//		ModelAndView mv = new ModelAndView();
//		String UserID = req.getParameter("UserID");
//		List<User> list =userDao.findByUser();
//		
//		mv.setViewName("DisplayOneUser.jsp");
//		mv.addObject("list", list);
//		return mv;
//
//}
//	
	

	@ResponseBody
	@RequestMapping("/getall")
	public ModelAndView getall(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		List<User> list = userDao.getall();
		mv.setViewName("DisplayUser.jsp");
		mv.addObject("list", list);
		return mv;
	}
}