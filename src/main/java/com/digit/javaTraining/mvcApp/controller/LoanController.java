package com.digit.javaTraining.mvcApp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.mvcApp.model.BankApp;

@WebServlet("/Loan")
public class LoanController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int l_id = Integer.parseInt(req.getParameter("choice"));
		try {
			BankApp bankApp = new BankApp();
			bankApp.setLid(l_id);
			if (bankApp.loan() == true) {
				session.setAttribute("choice", bankApp.getLid());
				session.setAttribute("l_type", bankApp.getLtype());
				session.setAttribute("interest", bankApp.getInterest());
				session.setAttribute("tenure", bankApp.getTenure());
				session.setAttribute("description", bankApp.getDesc());
				resp.sendRedirect("/BankingApplication2_MVC/LoanDetails.jsp");
			} else {
				resp.sendRedirect("/BankingApplication/LoanDetailsFail.html");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
