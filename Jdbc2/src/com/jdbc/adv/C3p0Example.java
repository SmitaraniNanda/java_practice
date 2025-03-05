package com.jdbc.adv;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Example {
    private static ComboPooledDataSource dataSource;

    static {
        try {
            dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass("org.postgresql.Driver"); // PostgreSQL Driver
            dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/QUESTK2");
            dataSource.setUser("postgres");
            dataSource.setPassword("root");
            
            // Pool Configuration
            dataSource.setMinPoolSize(5);
            dataSource.setMaxPoolSize(5);
            dataSource.setAcquireIncrement(1);
            dataSource.setMaxIdleTime(30);
            dataSource.setCheckoutTimeout(30000);
        } catch (PropertyVetoException e) {
            throw new RuntimeException("Error initializing C3P0 DataSource", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void printConnectionStats() throws SQLException {
        System.out.println("Total Connections Created: " + dataSource.getNumConnectionsDefaultUser());
        System.out.println("Active Connections (Used): " + dataSource.getNumBusyConnectionsDefaultUser());
        System.out.println("Idle Connections (Available): " + dataSource.getNumIdleConnectionsDefaultUser());
        System.out.println("-------------------------------------------------");
    }

    public static void main(String[] args) {
        try {
            System.out.println("Before getting connections:");
            printConnectionStats();

            Connection conn1 = getConnection();
            Connection conn2 = getConnection();
            
            System.out.println("After acquiring 2 connections:");
            printConnectionStats();

            conn1.close();
            conn2.close();
            
            System.out.println("After releasing 2 connections:");
            printConnectionStats();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Closing DataSource");
            dataSource.close();
        }
    }
}
