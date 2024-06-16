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

/**
 * Servlet implementation class UpdateIncomeexpensesServlet
 */
@WebServlet("/UpdateIncomeexpensesServlet")
public class UpdateIncomeexpensesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("ineid");
		String billid = request.getParameter("billid");
		String category = request.getParameter("category");
		String date = request.getParameter("date");
		String phone = request.getParameter("phone");
		String amount = request.getParameter("amount");
		
		boolean isTrue;
		
		isTrue = IncomeexpensesDBUtil.updateincomeexpenses(id,billid,category,date,phone,amount);
		
		if(isTrue == true) {
			
			List<Incomeexpenses> ineDetails = IncomeexpensesDBUtil.getIncomeexpensesDetails(id);
			request.setAttribute("ineDetails", ineDetails);
			
			JOptionPane.showMessageDialog(null,"Successfully Updated","Update",JOptionPane.WARNING_MESSAGE);
			RequestDispatcher dis = request.getRequestDispatcher("search.jsp");
			dis.forward(request, response);
		}
		else {

			List<Incomeexpenses> ineDetails = IncomeexpensesDBUtil.getIncomeexpensesDetails(id);
			request.setAttribute("ineDetails", ineDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("list.jsp");
			dis.forward(request, response);
		}
	}

}
