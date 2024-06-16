package com.incomeexpenses;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


@WebServlet("/IncomeexpensesInsert")
public class IncomeexpensesInsert extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String billid = request.getParameter("bid");
		String category = request.getParameter("category");
		String date = request.getParameter("date");
		String phone = request.getParameter("phone");
		String amount = request.getParameter("amount");
		
		boolean isTrue;
		
		isTrue = IncomeexpensesDBUtil.insertincomeexpenses(billid,category, date, phone, amount);
		
		if(isTrue == true) {
			
			String billID = request.getParameter("bid");
			
			
			isTrue = IncomeexpensesDBUtil.validate(billID);
			
			if (isTrue == true) {
				List<Incomeexpenses> ineDetails = IncomeexpensesDBUtil.getIncomeexpenses(billID);
				request.setAttribute("ineDetails", ineDetails);
				
				JOptionPane.showMessageDialog(null,"Successfully","Alert",JOptionPane.WARNING_MESSAGE);
				RequestDispatcher dis2 = request.getRequestDispatcher("incomeexpenses.jsp");
				dis2.forward(request, response);
			} else {
				RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
				dis2.forward(request, response);
			}
		} else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
		
		
	}
}
