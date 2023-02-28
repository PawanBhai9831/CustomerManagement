package com.techpalle.dao;

import java.sql.*;

import com.techpalle.model.Customer;

public class DataAccess {
	
	private static final String dburl="jdbc:mysql://localhost:3306/palle";
	
	private static final String dbusername="root";
	private static final String dbpassword="Pawan123";
	
	private static Connection con=null;
	private static Statement stm=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	
	private static final String insertQry="insert into "+"customer(name,email,mobile,password,state) values(?,?,?,?,?)";
	
	private static final String validateQry="select email,password from customer where email=? and password=?";
	
	public static boolean validateCustomer(String email,String password) {
		
		 boolean b=false;
		try 
		  {	
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(dburl, dbusername, dbpassword);
			ps=con.prepareStatement(validateQry);
			ps.setString(1, email);
			ps.setString(2, password);
			
			rs=ps.executeQuery();
			
			b=rs.next();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			     if(rs != null)
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
			
			try {
				if(ps != null) {
				ps.close();
				}
				if( con != null) {
				con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return b;

	}
	public static void insertCustomer(Customer cus) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(dburl, dbusername, dbpassword);
			ps=con.prepareStatement(insertQry);
			ps.setString(1, cus.getName());
			ps.setString(2, cus.getEmail());
			ps.setLong(3, cus.getMobile());
			ps.setString(4, cus.getPassword());
			ps.setString(5, cus.getState());
			
			ps.executeUpdate();
			
		} 
		catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		finally {
			try {
				if(ps != null) {
				ps.close();
				}
				if( con != null) {
				con.close();
				}
			} catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
		}
	} 
}
