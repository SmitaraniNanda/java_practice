package com.jdbc.adv;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCPMonitoring {
    private static HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/QUESTK2");
        config.setUsername("postgres");
        config.setPassword("root");
        config.setMaximumPoolSize(5); // Set max pool size
        config.setMinimumIdle(5);
        config.setIdleTimeout(30000);
        config.setConnectionTimeout(30000);

        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void printConnectionStats() {
        System.out.println("Total Connections Created: " + dataSource.getHikariPoolMXBean().getTotalConnections());
        System.out.println("Active Connections (Used): " + dataSource.getHikariPoolMXBean().getActiveConnections());
        System.out.println("Idle Connections (Available): " + dataSource.getHikariPoolMXBean().getIdleConnections());
        System.out.println("Pending Threads Waiting: " + dataSource.getHikariPoolMXBean().getThreadsAwaitingConnection());
        System.out.println("-------------------------------------------------");
    }

    public static void main(String[] args) {
        try {
            System.out.println("Before getting connections:");
            printConnectionStats();

            Connection conn1 = getConnection();
            Connection conn2 = getConnection();
			/*
			 * Connection conn3 = getConnection(); Connection conn4 = getConnection();
			 * Connection conn5 = getConnection(); Connection conn6 = getConnection();
			 */
            //Connection conn7 = getConnection();*/
            
            System.out.println("After acquiring 2 connections:");
            printConnectionStats();

            conn1.close();
            conn2.close();
            
            System.out.println("After releasing 2 connections:");
            printConnectionStats();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	System.out.println("close");
            dataSource.close();
        }
    }
}
