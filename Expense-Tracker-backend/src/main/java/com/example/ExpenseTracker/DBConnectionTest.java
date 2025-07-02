package com.example.ExpenseTracker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class DBConnectionTest implements CommandLineRunner {

    private final DataSource dataSource;

    public DBConnectionTest(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(String... args) {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("✅ Successfully connected to the database: " + connection.getMetaData().getURL());
        } catch (Exception e) {
            System.err.println("❌ Failed to connect to the database:");
            e.printStackTrace();
        }
    }
}



