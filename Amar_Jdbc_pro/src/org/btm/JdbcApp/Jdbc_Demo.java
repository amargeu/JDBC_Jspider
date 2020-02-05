package org.btm.JdbcApp;
import java.sql.*;
public class Jdbc_Demo 
{
	public static void main(String[] args)
	{
		Connection con=null;
		Statement stmt=null;
		String insqry="delete from btm.ClgStudent where id";
		//String insqry1="insert into btm.ClgStudent values(6,'rohit',7.47,cgpa*10)";
		//String insqry2="insert into btm.ClgStudent values(7,'modi',9.47,cgpa*10)";
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded succesfully");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=aman.123");
			System.out.println("connection established");
			stmt=con.createStatement();
			System.out.println("platform created");
			stmt.executeUpdate(insqry);
			//stmt.executeUpdate(insqry1);
			//stmt.executeUpdate(insqry2);
			System.out.println("data update in table");
		}
		catch (ClassNotFoundException e) 
		{
		   e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try
				{
					con.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(stmt!=null)
			{
				try
				{
					stmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			System.out.println("close all coastly resources");
			
		}
		
	}

}
