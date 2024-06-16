package com.incomeexpenses;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IncomeexpensesDBUtil {
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	public static boolean validate(String billid) {
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from payment where billid='"+billid+"'";
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
	
	public static List<Incomeexpenses> getIncomeexpenses(String billID) {
		
		ArrayList<Incomeexpenses> ine = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from payment where billid='"+billID+"'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String billid = rs.getString(2);
				String category = rs.getString(3);
				String date = rs.getString(4);
				String phone = rs.getString(5);
				String amount = rs.getString(6);
				
				Incomeexpenses i = new Incomeexpenses(id,billid,category,date,phone,amount);
				ine.add(i);
			}
			
		} catch (Exception e) {
			
		}
		
		return ine;	
	}
	
	public static boolean insertincomeexpenses(String billid, String category, String date, String phone, String amount) {
    	
    	boolean isSuccess = false;
    	
    	try {
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    	    String sql = "insert into payment values (0,'"+billid+"','"+category+"','"+date+"','"+phone+"','"+amount+"')";
    		int rs = stmt.executeUpdate(sql);
    		
    		if(rs > 0) {
    			isSuccess = true;
    		} else {
    			isSuccess = false;
    		}
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
 	
    	return isSuccess;
    }
	  
	public static boolean updateincomeexpenses(String id, String billid, String category, String date, String phone, String amount) {
	    	
	    	try {
	    		
	    		con = DBConnect.getConnection();
	    		stmt = con.createStatement();
	    		String sql = "update payment set billid='"+billid+"',category='"+category+"',date='"+date+"',phone='"+phone+"',amount='"+amount+"'" 
	    				+ "where id='"+id+"'";
	    		int rs = stmt.executeUpdate(sql);
	    		
	    		if(rs > 0) {
	    			isSuccess = true;
	    		}
	    		else {
	    			isSuccess = false;
	    		}
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    	return isSuccess;
	    }
	
	  public static List<Incomeexpenses> getIncomeexpensesDetails(String Id) {
			
			int convertedID = Integer.parseInt(Id);
			
			ArrayList<Incomeexpenses> ine = new ArrayList<>();
			
			try {
				
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				String sql = "select * from payment where id='"+convertedID+"'";
				rs = stmt.executeQuery(sql);
				
	    		while(rs.next()) {
	    			int id = rs.getInt(1);
					String billid = rs.getString(2);
					String category = rs.getString(3);
					String date = rs.getString(4);
					String phone = rs.getString(5);
					String amount = rs.getString(6);
	    			
	    			Incomeexpenses i = new Incomeexpenses(id,billid,category,date,phone,amount);
	    			ine.add(i);
	    		}
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}	
	    	return ine;	
	    }
	    
	    public static boolean deleteincomeexpenses(String id) {
	    	
	    	int convId = Integer.parseInt(id);
	    	
	    	try {
	    		
	    		con = DBConnect.getConnection();
	    		stmt = con.createStatement();
	    		String sql = "delete from payment where id='"+convId+"'";
	    		int r = stmt.executeUpdate(sql);
	    		
	    		if (r > 0) {
	    			isSuccess = true;
	    		}
	    		else {
	    			isSuccess = false;
	    		}
	    		
	    	}
	    	catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    	return isSuccess;
	    }
}
