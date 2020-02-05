package org.btm.JdbcApp;
import java.sql.*;

public class InsertDemo 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		String qry="insert into btm.user values(?,?,?)";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=aman.123");
			System.out.println("connection established");
			pstmt=con.prepareStatement(qry);
			System.out.println("platform created");
			/*pstmt.setInt(1,52);
			pstmt.setString(2,"soumen");
			pstmt.setDouble(3,6.62);
			pstmt.setDouble(4,66.2);
			pstmt.executeUpdate();
			
			pstmt.setInt(1,53);
			pstmt.setString(2,"amar");
			pstmt.setDouble(3,8.62);
			pstmt.setDouble(4,86.2);
			pstmt.executeUpdate();
			
			pstmt.setInt(1,54);
			pstmt.setString(2,"rohit");
			pstmt.setDouble(3,7.62);
			pstmt.setDouble(4,76.2);
			pstmt.executeUpdate();*/
			/*pstmt.setString(1, "modi");
			pstmt.setString(2, "m123");
			pstmt.setString(3, "modi@mail");
			pstmt.executeUpdate();
			pstmt.setString(1, "soumen");
			pstmt.setString(2, "s123");
			pstmt.setString(3, "somumenghosh");
			pstmt.executeUpdate();*/
			pstmt.setString(1, "amar");
			pstmt.setString(2, "amargeu");
			pstmt.setString(3, "amar@gmail");
			pstmt.executeUpdate();
			
			
			/*pstmt.setString(1, "kaushik");
			pstmt.setString(2, "k456");
			pstmt.setString(3, "kaushik1223");
			pstmt.executeUpdate();
			
			pstmt.setString(1, "rohit");
			pstmt.setString(2, "r123");
			pstmt.setString(3, "rohit@gmail");
			pstmt.executeUpdate();
			System.out.println("data inserted");*/
			
			
		}
		catch(SQLException|ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(pstmt!=null||con!=null)
			{
				try {
					pstmt.close();
					con.close();
				   }
				catch(SQLException e)
				{
				e.printStackTrace();
				}
			}
				/*if(con!=null)
				{
					try {
						con.close();
					   }
					catch(SQLException e)
					{
					e.printStackTrace();
					}
			}*/
			System.out.println("closed  all coastly resources");
		}
		
	}

	private static PreparedStatement setString() {
		// TODO Auto-generated method stub
		return null;
	}

}
