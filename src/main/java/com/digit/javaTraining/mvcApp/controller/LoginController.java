package com.digit.javaTraining.mvcApp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.mvcApp.model.BankApp;

@WebServlet("/Login")
public class LoginController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BankApp bankApp = new BankApp();
		HttpSession session = req.getSession();
		bankApp.setCust_id(Integer.parseInt(req.getParameter("cust_id")));
		bankApp.setPin(Integer.parseInt(req.getParameter("pin")));

		boolean b = bankApp.login();
		if (b == true) {
			session.setAttribute("acc_no", bankApp.getAcc_no());
			session.setAttribute("cust_name", bankApp.getCust_name());
			resp.sendRedirect("/BankingApplication2_MVC/HomePage.jsp");
		} else {
			resp.sendRedirect("/BankingApplication2_MVC/LoginFail.html");
		}
	}
}
