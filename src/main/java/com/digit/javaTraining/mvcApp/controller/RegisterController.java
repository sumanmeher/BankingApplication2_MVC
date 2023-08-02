package com.digit.javaTraining.mvcApp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.javaTraining.mvcApp.model.BankApp;

public class RegisterController extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bank_id = Integer.parseInt(req.getParameter("bank_id"));
		String bank_name = req.getParameter("bank_name");
		String ifsc_code = req.getParameter("ifsc_code");
		int acc_no = Integer.parseInt(req.getParameter("acc_no"));
		int pin = Integer.parseInt(req.getParameter("pin"));
		int cust_id = Integer.parseInt(req.getParameter("cust_id"));
		String cust_name = req.getParameter("cust_name");
		int balance = Integer.parseInt(req.getParameter("balance"));
		String email = req.getParameter("email");
		long phone = Long.parseLong(req.getParameter("phone"));
		
		BankApp bankApp=new BankApp();
		bankApp.setAcc_no(acc_no);  //OR bankApp.setAcc_no(Integer.parseInt(req.getParameter("acc_no")));
		bankApp.setBalance(balance);
		bankApp.setBank_id(bank_id);
		bankApp.setBank_name(bank_name);
		bankApp.setCust_id(cust_id);
		bankApp.setCust_name(cust_name);
		bankApp.setEmail(email);
		bankApp.setIfsc_code(ifsc_code);
		bankApp.setPhone(phone);
		bankApp.setPin(pin);
	}
}
