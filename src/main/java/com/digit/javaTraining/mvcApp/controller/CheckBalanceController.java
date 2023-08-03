package com.digit.javaTraining.mvcApp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.mvcApp.model.BankApp;

@WebServlet("/CheckBalance")
public class CheckBalanceController extends HttpServlet {

	public Connection con;
	public PreparedStatement pstmt;
	public ResultSet resultSet;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int acc_no = (int) session.getAttribute("acc_no");
		try {
			BankApp bankApp=new BankApp();
			bankApp.setAcc_no(acc_no);
			if (bankApp.checkBalance() == true) {
				session.setAttribute("balance", bankApp.getBalance());
				resp.sendRedirect("/BankingApplication2_MVC/Balance.jsp");
			} else {
				resp.sendRedirect("/BankingApplication2_MVC/BalanceFail.html");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
