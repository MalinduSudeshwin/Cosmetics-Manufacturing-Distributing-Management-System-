package com.report;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.incomeexpenses.Incomeexpenses;

/**
 * Servlet implementation class GeneratePDFServlet
 */
@WebServlet("/GeneratePDFServlet")
public class GeneratePDFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public GeneratePDFServlet() {
        super();
        // TODO Auto-generated constructor stub
    }



	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		

		
		String Category = request.getParameter("cate");
		
		boolean isTrue;
		
		isTrue = GeneratePDF1.validate(Category);
		if (isTrue == true) {
		
	
			
			List<Incomeexpenses> docDetails = GeneratePDF1.getInstance(Category);
			request.setAttribute("docDetails", docDetails);
			
			
			RequestDispatcher rd =request.getRequestDispatcher("incomeexpenses.jsp");
			rd.forward(request, response);
		}
		else
		{
		
			pw.print("<script>alert('PDF Genarated....')</script>");
		}
		
		
			RequestDispatcher rd = request.getRequestDispatcher("Incomeexpenses");
			rd.forward(request, response);
		}
	

}
