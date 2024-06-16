package com.report;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.incomeexpenses.DBConnect;
import com.incomeexpenses.Incomeexpenses;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePDF1 {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static boolean validate(String category) {
		
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from payment where category='"+category+"'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static List<Incomeexpenses> getInstance(String Category)  {
		
		ArrayList<Incomeexpenses> doc = new ArrayList<>();
		
			try
			{
				Document document = new Document();
				
				PdfWriter.getInstance(document, new FileOutputStream ("D://Income_Expenses.pdf"));
				
				document.open();
				
				Paragraph p = new Paragraph();
				
				p.add("Income & Expenses Report");
				
				p.setAlignment(Element.ALIGN_CENTER);
				
				document.add(p);
				
				document.add(Chunk.NEWLINE);
				document.add(Chunk.NEWLINE);
				
				PdfPTable table = new PdfPTable(new float[] {5,15,15,15,15,15});
				
				table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
				
				table.addCell("No");
				table.addCell("Billid");
				table.addCell("Category");
				table.addCell("Date");
				table.addCell("Phone");
				table.addCell("Amount");
				
				table.setHeaderRows(1);
				
				PdfPCell[] cells = table.getRow(0).getCells();
				
				for (int j=0;j<cells.length;j++) {
					
					cells[j].setBackgroundColor(BaseColor.GRAY);
				}
				
				Connection con = DBConnect.getConnection();
				String sql = "select * from payment where category='"+Category+"'";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
					while(rs.next())
					{
						table.addCell(String.valueOf(rs.getInt(1)));
						table.addCell(rs.getString(2));
						table.addCell(rs.getString(3));
						table.addCell(rs.getString(4));
						table.addCell(rs.getString(5));
						table.addCell(rs.getString(6));
						
					}
					
			   document.add(table);
			   
			   document.close();
			   
			   System.out.println("Done");
			   
			   con.close();
			}
			
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return doc;
			
	}


}
