package org.btm.JdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Jdbc_Transaction
{
	public static void main(String[] args) 
	{
	Connection con=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	String stded="insert into btm.studentedu values(?,?,?,?)";
	String stdper="insert into btm.studentper values(?,?,?)";
	Scanner sc=new Scanner(System.in);
	System.out.println("enter id");
	int id=sc.nextInt();
	System.out.println("enter Name");
	String name=sc.next();
	System.out.println("enter dept");
     String dept=sc.next();
	System.out.println("enter percentage");
	double perc=sc.nextDouble();
	
	System.out.println("enter place");
	String place=sc.next();
	sc.close();
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=aman.123");
		con.setAutoCommit(false);
		 pstmt=con.prepareStatement(stded);
		 
		 pstmt.setInt(1, id);
		 pstmt.setString(2, name);
		 pstmt.setString(3, dept);
		 pstmt.setDouble(4, perc);
		 pstmt.executeUpdate();
		 
		 System.out.println("Student educational detail executed.....");
		 
        pstmt1=con.prepareStatement(stdper);
		 
		 pstmt1.setInt(1, id);
		 pstmt1.setString(2, name);
		 pstmt1.setString(3, place);
		
		 pstmt1.executeUpdate();
		 
		 System.out.println("Student personal detail executed.....");
		 con.commit();
		 
	} 
	catch (ClassNotFoundException | SQLException e) 
	{
		
		try {
			con.rollback();
			System.out.println("operation rolled back");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		e.printStackTrace();
	}
	
	finally
	{
		if (con!=null)
   	 {
   		 try 
   		 {
			con.close();
   		 }
   		 catch (SQLException e) 
   		 {
		       e.printStackTrace();
			}
   	 }
   		 if (pstmt!=null)
	    	 {
	    		 try 
	    		 {
				pstmt.close();
	    		 }
	    		 catch (SQLException e) 
	    		 {
			       e.printStackTrace();
				   }
	    	 }
   		 if (pstmt1!=null)
    	 {
    		 try 
    		 {
			pstmt1.close();
    		 }
    		 catch (SQLException e) 
    		 {
		       e.printStackTrace();
			   }
    	 }
	}
	
	
	
		
	}

}
