/**
 * 
 */
package com.ss.lms.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * This is a class which talks to the database and retrives information on Author table.
 * @author ppradhan
 *
 */
public class AuthorJDBC_Edit {
	
	public static final String driver= "com.mysql.cj.jdbc.Driver";
	public static final String url= "jdbc:mysql://localhost:3306/library?useSSL=false";
	public static final String username= "root";
	public static final String password= "root";

	/**
	 * Test method to demo JDBC Connection.
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1> Register the driver.
		Class.forName(driver);
		
		//2> Creating a connection.
		Connection conn = DriverManager.getConnection(url, username, password);
		
		//3> Create a statement
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Authorname you want to update");
		String authorName = scan.nextLine();
		System.out.println("Enter the AuthorID you want to update");
		Integer authorId = scan.nextInt();
		
		PreparedStatement pstmt = conn.prepareStatement("UPDATE tbl_author set authorName = ? where authorId = ?");
		pstmt.setString(1, authorName);
		pstmt.setInt(2, authorId);
		pstmt.executeUpdate();
		
	}

}
