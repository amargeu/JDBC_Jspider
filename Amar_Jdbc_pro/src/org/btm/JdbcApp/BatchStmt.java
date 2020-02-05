package org.btm.JdbcApp;

import java.sql.*;

public class BatchStmt 
{
	public static void main(String[] args)
	{
		Connection con=null;
		Statement stmt=null;
		String inqry="insert into btm.clgstudent values(8,'soumen',7.4,70.66)";
		String upqry="update  btm.user set password='s459' where name='soumen'";
		String delqry="delete from btm.user where name='modi'";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=aman.123");
			stmt=con.createStatement();
			stmt.addBatch(inqry);
			stmt.addBatch(upqry);
			stmt.addBatch(delqry);
			int arr[]=stmt.executeBatch();			
			for (int i : arr) 
			{
				System.out.print(i);
				
			}
		}
		catch (ClassNotFoundException |SQLException e) 
		{
		   e.printStackTrace();
		}
		finally
		{
			if(con!=null||stmt!=null)
				try {
					stmt.close();
					con.close();
				} catch (SQLException e)
			{
			e.printStackTrace();		
				}
		}
		
	}

}

