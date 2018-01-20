package util;

import java.sql.*;

public class dbUtil {
	
	private static Connection conn;
	
	public static Connection getConnection(){
	
	if(conn!=null){
	return conn;
	}
	
	
	  String URL="jdbc:postgresql://horton.elephantsql.com:5432/durgojpk";
	  String USERNAME="durgojpk";
	  String PASSW="LuMV7w0a2bIGIAbPGOjAKp8e6W50N3m_";
	  
	  try 
	         {
	             Class.forName("org.postgresql.Driver");
	             conn = DriverManager.getConnection(URL, USERNAME, PASSW);
	         }
	           
	    	 catch (ClassNotFoundException | java.sql.SQLException e) 
	         {
	 	            System.out.println(e.getMessage());
	 	     }
	return conn;
	 
	}  
	  
	  public static void closeConnection( Connection toBeClosed ) {
	        if( toBeClosed == null )
	            return;
	        
	        
	        try {
	            toBeClosed.close();
	        } catch (SQLException e) {
	        	System.out.println(e.getMessage());
	        }
	    
	    }
 
	
	}
