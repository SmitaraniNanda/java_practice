public class JdbcConnection {
	
	    public static void main(String[] args) {
	        try {
	            // Load the PostgreSQL JDBC Driver
	        	//In JDBC, Class.forName() is a method that loads JDBC drivers into memory. It's used to connect to a database by registering the driver for that database. 
	            Class.forName("org.postgresql.Driver");
	            System.out.println("PostgreSQL JDBC Driver Registered!");
	        } catch (ClassNotFoundException e) {
	            System.out.println("Driver not found! " + e.getMessage());
	        }
	    }
	}

