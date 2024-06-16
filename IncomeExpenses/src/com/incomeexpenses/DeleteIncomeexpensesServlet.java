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


@WebServlet("/DeleteIncomeexpensesServlet")
public class DeleteIncomeexpensesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("ineid");
		boolean isTrue;
		
		isTrue = IncomeexpensesDBUtil.deleteincomeexpenses(id);
		
		if (isTrue == true) {
			List<Incomeexpenses> ineDetails = IncomeexpensesDBUtil.getIncomeexpensesDetails(id);
			request.setAttribute("ineDetails", ineDetails);
			
		    JOptionPane.showMessageDialog(null,"Are You sure to Delete","Delete",JOptionPane.YES_NO_OPTION);
			RequestDispatcher dispatcher = request.getRequestDispatcher("incomeexpenses.jsp");
			dispatcher.forward(request, response);
		}
		else {
			
			List<Incomeexpenses> ineDetails = IncomeexpensesDBUtil.getIncomeexpensesDetails(id);
			request.setAttribute("ineDetails", ineDetails);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("deleteincomeexpenses.jsp");
			dispatcher.forward(request, response);
		}
		
	}	
}
