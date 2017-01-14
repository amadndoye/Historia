package fr.univ.upem.localHistory.database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnectionDerbyDB {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		
		// Load JDBC pilot org.apache.derby.jdbc.ClientDriver
		Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();

		// Connect to the jdbc database
		Connection con = 
		DriverManager.getConnection("jdbc:derby://localhost:4848/historiadb","admin","admin");

		//   DriverManager.getConnection("jdbc:derby://localhost:4848/historiadb; "
		  // 		+ "create=true;");
		System.out.println("hello ?");
		System.out.println("connection ? " + con);

		Statement smt = con.createStatement() ;		
		con.close();


	}
	
}
