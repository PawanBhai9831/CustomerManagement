package com.techServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.DataAccess;
import com.techpalle.model.Customer;
import com.techpalle.util.SuccessPage;


@WebServlet("/")  //default
public class Myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();
		switch(path)
		{
		case"/logCustomer":
			validateCustomer(request,response);
			break;
		case"/regCustomer":
		    insertCustomer(request,response);
		    break;
		    
		case"/reg":
			getRegistrationPage(request,response);
			break;
		case"/log":
			getLoginPage(request,response);
			break;
		
		  default:
			      getStartUpPage(request,response);//Every default case having switch case
			      break;
		
		
		}
		
	}

	
	private void validateCustomer(HttpServletRequest request, HttpServletResponse response) {
		
		String e=request.getParameter("tbEmail");
		String p=request.getParameter("tbPass");
		
		boolean res=DataAccess.validateCustomer(e, p);
		
		if(res) {
			try {
				RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
				
				SuccessPage sp = new SuccessPage();
				request.setAttribute("successDetails", sp);
				
				rd.forward(request, response);
			} catch (ServletException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
			else {
				getLoginPage(request,response);
			}
			
		
		
	}


	private void getLoginPage(HttpServletRequest request, HttpServletResponse response) {
	
		
		try {
			RequestDispatcher rd=request.getRequestDispatcher("customer_login.jsp");
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void getRegistrationPage(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		try {
			RequestDispatcher rd=request.getRequestDispatcher("customer_registration.jsp");
			rd.forward(request, response);
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}


	private void insertCustomer(HttpServletRequest request, HttpServletResponse response) {
		//Read the data from jsp
		String n=request.getParameter("tbName");
		String e=request.getParameter("tbEmail");
		
		long m=Long.parseLong(request.getParameter("tbMob"));
		String p=request.getParameter("tbPass");
		String s=request.getParameter("ddlStates");
      
		//store the data in customer object
		Customer c=new Customer(n,e,m,p,s);
		
		//
		DataAccess.insertCustomer(c);
		//Redirect user to login page with email and password
		
		
		try {
			RequestDispatcher rd=request.getRequestDispatcher("customer_login.jsp");
			
			rd.forward(request, response);
		} catch (ServletException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}


	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) {
	   
				
		try {
			
			RequestDispatcher rd=request.getRequestDispatcher("customer_management.jsp");
			
			rd.forward(request, response);
			
			
			
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
