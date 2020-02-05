package org.btm.JdbcApp;
import java.sql.*;

public class Batch_pstmt
{
	public static void main(String[] args)
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		
		String inqry="insert into btm.clgstudent values(9,'joya',8.9,89.00)";
		String upqry="update  btm.user set password='cde' where name='soumen'";
		String delqry="delete from btm.user where password='j456'";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=aman.123");
			pstmt=con.prepareStatement(inqry);
			pstmt.addBatch();
			int arr[]=pstmt.executeBatch();			
			for (int i : arr) 
			{
				System.out.println(i);
				
			}
			pstmt1=con.prepareStatement(upqry);
			pstmt1.addBatch();
			int arr1[]=pstmt1.executeBatch();			
			for (int i : arr1) 
			{
				System.out.println(i);
				
			}
			pstmt2=con.prepareStatement(delqry);
			pstmt2.addBatch();
			int arr2[]=pstmt2.executeBatch();			
			for (int i : arr2) 
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
			if(con!=null||pstmt!=null)
				try {
					pstmt.close();
					con.close();
				} catch (SQLException e)
			{
			e.printStackTrace();		
				}
		}
		
	}

}
