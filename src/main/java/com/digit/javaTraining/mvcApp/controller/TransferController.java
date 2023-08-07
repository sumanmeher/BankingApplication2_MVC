package com.digit.javaTraining.mvcApp.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.javaTraining.mvcApp.model.BankApp;

@WebServlet("/Transfer")
public class TransferController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cust_id = Integer.parseInt(req.getParameter("cust_id"));
		;
		String s_ifsc = req.getParameter("sender_ifsc");
		int s_accno = Integer.parseInt(req.getParameter("sender_accno"));
		int pin = Integer.parseInt(req.getParameter("pin"));
		String r_ifsc = req.getParameter("receiver_ifsc");
		int r_accno = Integer.parseInt(req.getParameter("receiver_accno"));
		int amount = Integer.parseInt(req.getParameter("amount"));
		String bank_name = req.getParameter("bank_name");

		BankApp bankApp = new BankApp();
		bankApp.setCust_id(cust_id);
		bankApp.setIfsc_code(s_ifsc);
		bankApp.setAcc_no(s_accno);
		bankApp.setPin(pin);

		bankApp.transfer(r_ifsc, r_accno, amount);
		if (bankApp.transfer(r_ifsc, r_accno, amount) == true) {
			resp.sendRedirect("/BankingApplication2_MVC/TransferSuccess.html");
		} else {
			resp.sendRedirect("/BankingApplication2_MVC/TransferFail.jsp");
		}

	}
}
