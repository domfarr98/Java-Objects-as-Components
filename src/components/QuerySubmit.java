package components;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QuerySubmit {
	
	public void interfaceMethod(Object args) {
		
		String user = "interface";
		String password = "password";
		String url = "jdbc:mysql://localhost/";
		String schema = "test";
		
		String temp = (String) args;
		String[] temp1 = temp.split(" ");
		String operative = temp1[0];
		
		if (operative.contains("INSERT") || operative.contains("UPDATE") || operative.contains("DELETE")) {
		
			try {
				Connection myConn = DriverManager.getConnection(url + schema, user, password);
	
				Statement myStmt = myConn.createStatement();
	
				String sql = (String) args;
	
				myStmt.executeUpdate(sql);
				
				switch (operative) {
					case("INSERT"):
						System.out.println("Insert Complete");
						break;
					case("UPDATE"):
						System.out.println("Update Complete");
						break;
					case("DELETE"):
						System.out.println("Delete Complete");
						break;
				}
	
			} catch (Exception exc) {
				exc.printStackTrace();
				System.out.println("Something has gone wrong, please try again.");
				System.out.println(" ");
			}
		
		}
		
		else if (operative.contains("SELECT")) {
			
			try {
				Connection myConn = DriverManager.getConnection(url + schema, user, password);
	
				Statement myStmt = myConn.createStatement();
	
				String sql = (String) args;
	
				ResultSet results = myStmt.executeQuery(sql);
				
				while(results.next()) {
					System.out.println(results.getString("index"));
					System.out.println(results.getString("string_list"));
					System.out.println(" ");
				}

	
			} catch (Exception exc) {
				exc.printStackTrace();
				System.out.println("Something has gone wrong, please try again.");
			}
			
		}
		
		else {
			
			try {
				
				Connection myConn = DriverManager.getConnection(url + schema, user, password);
	
				Statement myStmt = myConn.createStatement();
	
				String sql = (String) args;
	
				myStmt.executeUpdate(sql);
	
			} catch (Exception exc) {
				exc.printStackTrace();
				System.out.println("Something has gone wrong, please try again.");
			}
			
		}
		
		System.out.println(" ");
		
	}

}
