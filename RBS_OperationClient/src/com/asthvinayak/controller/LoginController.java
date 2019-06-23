package com.asthvinayak.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asthvinayak.dao.LogingDAO;

/**
 * Servlet implementation class LoginControllere
 */
// @WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		System.out.println("LoginController");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		System.out.println(request.getLocalAddr());
		System.out.println(request.getQueryString());

		String userName = request.getParameter("uname");
		String password = request.getParameter("psw");

		// call service layer
		LogingDAO ld = LogingDAO.getInstance();
		boolean b = ld.getLogin(userName, password);
		if (b) {

			RequestDispatcher rd = request.getRequestDispatcher("/resources/html/home.html");
			rd.forward(request, response);

		}

		System.out.println(userName + "  " + password);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
