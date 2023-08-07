package com.digit.javaTraining.mvcApp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.mvcApp.model.BankApp;

@WebServlet("/ChangePin")
public class ChangePinController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int acc_no = (int) session.getAttribute("acc_no");
		int old_pin = Integer.parseInt(req.getParameter("old_pin"));
		int new_pin = Integer.parseInt(req.getParameter("new_pin"));
		int confirm_pin= Integer.parseInt(req.getParameter("confirm_pin"));
		try {
			BankApp bankApp=new BankApp();
			bankApp.setAcc_no(acc_no);
			bankApp.setNpin(new_pin);
			bankApp.setPin(old_pin);
			bankApp.setCpin(confirm_pin);
			if (bankApp.changePin() == true) {
				resp.sendRedirect("/BankingApplication2_MVC/PinChangeSuccess.html");
			} else {
				resp.sendRedirect("/BankingApplication2_MVC/PinChangeFail.html");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
