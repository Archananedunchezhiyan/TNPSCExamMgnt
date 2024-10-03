package com.vast.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vast.Dao.DbExaminerDao;
import com.vast.Dao.IExaminerDao;
import com.vast.vo.Examinor;

/**
 * Servlet implementation class G2AExamServlet
 */
//@WebServlet("/G2AExamServlet")
public class G2AExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public G2AExamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IExaminerDao dao=new DbExaminerDao();
		String name=request.getParameter("txtname");
		int age=Integer.parseInt(request.getParameter("txtage"));
		String degree=request.getParameter("txtdegree");
		String loc=request.getParameter("txtloc");
		Examinor exam=new Examinor(name,age,degree,loc);
		if(dao.g2aaddExaminer(exam)) {
			request.setAttribute("exam", exam);
			RequestDispatcher rd=request.getRequestDispatcher("AddResult.jsp");
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
