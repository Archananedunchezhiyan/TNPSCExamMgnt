package com.vast.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.vast.Dao.DbExaminerDao;
import com.vast.Dao.IExaminerDao;
import com.vast.Exceptions.InvalidLoginException;
import com.vast.Exceptions.InvalidRegisterException;
import com.vast.vo.Event;
import com.vast.vo.Login;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Logger logger=Logger.getLogger("vast");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
    	    IExaminerDao dao = new DbExaminerDao();
    	    String name = request.getParameter("txtname");
    	    String email = request.getParameter("txtemail");
    	    String pwd = request.getParameter("txtpass");
    	    String confrmpwd = request.getParameter("txtconfrmpass");

    	    try {
    	        
    	        if (name != null && pwd != null && dao.getLoginDetails(name, pwd) != null) {
    	          
    	            request.setAttribute("name", name);
    	            request.setAttribute("pass", pwd);
    	            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
    	            rd.forward(request, response);
    	        } 
    	        
    	        else if (pwd != null && confrmpwd != null && pwd.equals(confrmpwd)) {   
    	            if (dao.getRegisterDetails(name, email, pwd, confrmpwd) != null) {
    	                request.setAttribute("name", name);
    	                request.setAttribute("email", email);
    	                request.setAttribute("pwd", pwd);
    	                request.setAttribute("cfmpwd", confrmpwd);

    	                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
    	                rd.forward(request, response);
    	            } else {
    	                throw new InvalidRegisterException("Registration failed. Please try again.");
    	            }
    	        } else {
    	           
    	            if (!pwd.equals(confrmpwd)) {
    	                throw new InvalidRegisterException("Passwords do not match.");
    	            } else {
    	                throw new InvalidLoginException("Invalid credentials! Please try again or register.");
    	            }
    	        }
    	    } catch (InvalidLoginException e) {
    	       
    	        request.setAttribute("errorMessage", e.getMessage());
    	        RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
    	        rd.forward(request, response);
    	    } catch (InvalidRegisterException e) {
    	       
    	        request.setAttribute("errorMessage", e.getMessage());
    	        RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
    	        rd.forward(request, response);
    	    } 
    	}


			
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	


}
