import java.sql.*;

public class InsertUpdate {
	
	
	    public static void main(String[] args) {
	        String url = "jdbc:postgresql://localhost:5432/QUESTK2";
	        String user = "postgres";
	        String password = "root";

	        Connection conn = null;
	        PreparedStatement insertStmt = null;
	        PreparedStatement updateStmt = null;

	        try {
	            conn = DriverManager.getConnection(url, user, password);
	            
	            // INSERT example
	            String insertQuery = "INSERT INTO EMPLOYE (name, id) VALUES (?, ?)";
	            insertStmt = conn.prepareStatement(insertQuery);
	            insertStmt.setString(1, "RAJA");
	            insertStmt.setInt(2, 106);
	            int insertRows = insertStmt.executeUpdate();
	            System.out.println("Inserted Rows: " + insertRows);
	            
	            // UPDATE example
	            String updateQuery = "UPDATE EMPLOYE SET id = ? WHERE name = ?";
	            updateStmt = conn.prepareStatement(updateQuery);
	            updateStmt.setInt(1, 105);
	            updateStmt.setString(2, "RAJA");
	            int updateRows = updateStmt.executeUpdate();
	            System.out.println("Updated Rows: " + updateRows);
	            
	        } catch (SQLException e) {
	            System.err.println("Database error: " + e.getMessage());
	            e.printStackTrace();
	        } finally {
	            try {
	                if (insertStmt != null) insertStmt.close();
	                if (updateStmt != null) updateStmt.close();
	                if (conn != null) conn.close();
	            } catch (SQLException e) {
	                System.err.println("Error closing resources: " + e.getMessage());
	                e.printStackTrace();
	            }
	        }
	    }
	

}
