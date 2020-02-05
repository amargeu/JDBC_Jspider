package org.btm.JdbcApp;
import java.sql.*;
import java.util.Scanner;

public class Fetch_demo1
{
	public static void main(String[] args)
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select * from btm.ClgStudent where name=?";
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the name ??:");
		String name=sc.next();
		sc.close();
	     try
	     {
	    	 Class.forName("com.mysql.jdbc.Driver");
	    	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=aman.123");
		     pstmt=con.prepareStatement(qry);
		     pstmt.setString(1,name);
		     rs=pstmt.executeQuery();
		    if(rs.next())
		     {
		         int id=rs.getInt(1);
		    	 double cgpa=rs.getDouble(3);
		    	 double per=rs.getDouble(4);
		    	 System.out.println(id+" "+cgpa+"   "+per) ;
		     }
		    System.out.println("no data found for name "+name);
		    /* else
		     {
		    	 System.out.println("no data found for name "+name);
		     }*/
	    
	     }
	     catch (ClassNotFoundException|SQLException e) 
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
	   
			
		}
		
	}

}
