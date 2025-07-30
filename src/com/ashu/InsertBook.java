 package com.ashu;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement; 

public class InsertBook {
	private static final String INSERT_SQL = "INSERT INTO BOOKS VALUE(103,'Devops',1400)";
	public static void main(String[] args) throws Exception {
		
// Step-1 Load Drivers	
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Class Found!");
		
//	Step-2 Get DB Connection	
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjdb","root","@Dune274");
		System.out.println("Connection Established!");
		
//	Step-3 Create A Statement
		Statement stmt = con.createStatement();
		System.out.println("Statement created.");
		
//	Step-4 Execute the query
		int rowsEffected = stmt.executeUpdate(INSERT_SQL);     //this is used for DML operations
		
//	Step-5 Process the result
		System.out.println("Record Inserted count : "+rowsEffected);
		
//	Step-6 Close Connection
		con.close();
		System.out.println("Connection Closed.");
	}
}
