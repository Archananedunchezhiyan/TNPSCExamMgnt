package com.vast.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vast.Dao.DbExaminerDao;
import com.vast.Dao.IExaminerDao;
import com.vast.Exceptions.InvalidLoginException;
import com.vast.vo.Login;

public class ExamController {
	IExaminerDao dao=new DbExaminerDao().getDaoInstance() ;

	public String doLogin(HttpServletRequest request ,HttpServletResponse response) throws InvalidLoginException {
	  String viewname="Login.jsp";
	  String uname=request.getParameter("txtname");
	  String pwd=request.getParameter("txtpass");
	  Login login=dao.getLoginDetails(uname,pwd);
	  HttpSession session=request.getSession();
	  if(null!=login) {
		  session.setAttribute("login", login);
		  session.setMaxInactiveInterval(10*60);
		  viewname="index.jsp";
	  }else {
		  request.setAttribute("msg","you are not authenticated,check your credentials");
	  }
	return viewname;
}
}
