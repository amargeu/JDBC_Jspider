package org.btm.JdbcApp;
import java.sql.*;
import java.util.Scanner;
public class LoginVlidation 
{
	public static void main(String[] args)
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select username from btm.user where name=? and password=?";
		Scanner sc=new Scanner(System.in);
		System.out.println("pls enter name");
		String name=sc.next();
		System.out.println("pls enter password");
		String pwd=sc.next();
		sc.close();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=aman.123");
			System.out.println("connection established");
			pstmt=con.prepareStatement(qry);
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			rs=pstmt.executeQuery();
			System.out.println("query executed");
			if(rs.next())
			{
	   
				System.out.println("welcome "+rs.getString(1));
			}
			else
				System.out.println("invalid username and password");
            			
		}
		catch( ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (rs!=null)
	    	 {
	    		 try 
	    		 {
				rs.close();
	    		 }
	    		 catch (SQLException e) 
	    		 {
			       e.printStackTrace();
				}
	    	 }
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
		    		 sc.close();
	   
	
		}
		
	}

}
