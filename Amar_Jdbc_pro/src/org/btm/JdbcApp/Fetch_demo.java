package org.btm.JdbcApp;

import java.sql.*;

public class Fetch_demo
{
	public static void main(String[] args)
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry1="select * from btm.ClgStudent where name='amar'";
	     try
	     {
	    	 Class.forName("com.mysql.jdbc.Driver");
	    	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=aman.123");
		     pstmt=con.prepareStatement(qry1);
		     
		     rs=pstmt.executeQuery();
		     while(rs.next())
		     {
		    	 int id=rs.getInt(1);
		    	 String name=rs.getString(2);
		    	 double cgpa=rs.getDouble(3);
		    	 double per=rs.getDouble(4);
		    	 System.out.println(id+"   "+name+"    "+cgpa+"   "+per) ;
		     }
	    
	     }
	     catch (ClassNotFoundException|SQLException e) 
	     {
		  e.printStackTrace();
		}
	     finally 
	     {
	    	 if (rs!=null|con!=null|pstmt!=null)
	    	 {
	    		 try 
	    		 {
				rs.close();
				con.close();
				pstmt.close();
	    		 }
	    		 catch (SQLException e) 
	    		 {
			       e.printStackTrace();
				}
			}
	    	 System.out.println("closed all coastly resoures");
			
		}
		
	}

}
