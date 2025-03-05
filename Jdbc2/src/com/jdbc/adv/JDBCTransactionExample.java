package com.jdbc.adv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTransactionExample {

    public static void transferFunds(int fromAccountId, int toAccountId, double amount) {
        Connection conn = null;
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;

        try {
            // Step 1: Connect to the database (PostgreSQL in this case)
            String dbURL = "jdbc:postgresql://localhost:5432/QUESTK2"; 
            String username = "postgres"; 
            String password = "root"; 
            conn = DriverManager.getConnection(dbURL, username, password);

            // Step 2: Start a transaction (disable auto-commit)
            conn.setAutoCommit(false); // Disable auto-commit to manage transactions manually

            // Step 3: Prepare SQL statements
            String sql1 ="UPDATE accounts SET balance = balance - ? WHERE id = ?";
            stmt1 = conn.prepareStatement(sql1);
            stmt1.setDouble(1, amount);
            stmt1.setInt(2, fromAccountId);
            stmt1.executeUpdate();

            String sql2 = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
            stmt2 = conn.prepareStatement(sql2);
            stmt2.setDouble(1, amount);
            stmt2.setInt(2, toAccountId);
            stmt2.executeUpdate();

            // Step 4: Commit the transaction
            conn.commit();
            System.out.println("Transaction completed successfully!");

        } catch (Exception e) {
            // If any error occurs, rollback the transaction
            try {
                if (conn != null) {
                    conn.rollback(); // Rollback the transaction on error
                    System.out.println("Transaction rolled back due to an error.");
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }

            e.printStackTrace();

        } finally {
            // Step 5: Clean up resources
            try {
                if (stmt1 != null) stmt1.close();
                if (stmt2 != null) stmt2.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Main method to test the transaction
    public static void main(String[] args) {
        // Transfer funds from account 1 to account 2
        transferFunds(1, 2, 1000.0);
    }
}
