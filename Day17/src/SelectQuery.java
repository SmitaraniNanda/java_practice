import java.sql.*;

public class SelectQuery {

	
	    public static void main(String[] args) {
	        String url = "jdbc:postgresql://localhost:5432/QUESTK2";
	        String user = "postgres";
	        String password = "root";
	        
	        String query = "SELECT id, name FROM EMPLOYE";
	        
	        try (Connection conn = DriverManager.getConnection(url, user, password);
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(query)) {
	            
	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                System.out.println("ID: " + id + ", Name: " + name );
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    
	}

}
