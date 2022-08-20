package com.example.demo;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
Logger log= Logger.getAnonymousLogger();
	@Autowired
	AdminRepo repo;
	@ResponseBody
@RequestMapping("/Admin")
public ModelAndView Admin(HttpServletRequest req, HttpServletResponse resp) {
	ModelAndView mv = new ModelAndView();
	mv.setViewName("AdminLogin.jsp");

return mv;

}
	
	@RequestMapping("/AdminReg")
	public ModelAndView AdminReg(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("AdminRegister.jsp");

	return mv;

	}
	
@RequestMapping("/AdminRegister")
public ModelAndView AdminRegister(HttpServletRequest req, HttpServletResponse resp) {
	ModelAndView mv = new ModelAndView();

String adminID = req.getParameter("adminID");

String password = req.getParameter("password");
String email = req.getParameter("email");

Admin a = new Admin();
a.setAdminID(adminID);
a.setPassword(password);
a.setEmail(email);
Admin aa = repo.save(a);
if(aa!=null) {
	mv.setViewName("index.jsp");
}
else {
	mv.setViewName("Fail.jsp");
}
return mv;
}
@ResponseBody
@RequestMapping("/AdminLogin")
public ModelAndView AdminLogin(HttpServletRequest req, HttpServletResponse resp) {
	ModelAndView mv = new ModelAndView();
	
	String adminID = req.getParameter("adminID");
	
	String password = req.getParameter("password");
	repo.findByadmin(adminID);
	repo.findByPwd(password);
	
	if(repo.findByadmin(adminID).equals(repo.findByPwd(password))){
		HttpSession session = req.getSession();
				session.setAttribute("adminID", adminID);
				
	mv.setViewName("WelcomeAdmin.jsp");
	}
	else{
	mv.setViewName("Fail.jsp");	
	}
	

return mv;

}

@ResponseBody
@RequestMapping("/logout")
public  ModelAndView logout(HttpServletRequest req, HttpServletResponse resp) {
	 ModelAndView mv = new ModelAndView();
	 
	HttpSession session = req.getSession();
	 session.invalidate();
mv.setViewName("index.jsp");
return mv;
}

//TO change admin Password
@RequestMapping("/ChangePassword")
public  ModelAndView ChangePassword(HttpServletRequest req, HttpServletResponse resp) {
	 ModelAndView mv = new ModelAndView();
	 mv.setViewName("ChangePassword.jsp");
	 return mv;
}


//new password
@RequestMapping("/NewPassword")
public  ModelAndView NewPassword(HttpServletRequest req, HttpServletResponse resp) {
	 ModelAndView mv = new ModelAndView();
	 String adminID = req.getParameter("adminID");
	 String Oldpassword = req.getParameter("Oldpassword");
	 String Newpassword = req.getParameter("Newpassword");
	 repo.findByadmin(adminID);
	 repo.findByPwd(Oldpassword);
	 if(repo.findByadmin(adminID).equals( repo.findByPwd(Oldpassword))){
		 Admin a = new Admin();
		 a.setPassword(Newpassword);
	Admin save = repo.save(a);
		 mv.setViewName("WelcomeAdmin.jsp");
	 }
	 else {
		 mv.setViewName("Fail.jsp");
	 }
return mv;
}
}
