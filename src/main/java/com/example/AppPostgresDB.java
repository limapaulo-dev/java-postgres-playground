package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppPostgresDB {
    private static final String JDBC_URL = "jdbc:postgresql://localhost/postgres";
    private static final String USERNAME = "gitpod";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        loadDriverJDBC();
        listStates();
        searchState("TO");
    }

    private static void searchState(String string) {
        
    }

    private static void listStates() {
        Statement statement = null;
        try (var conn = getConnection()){
            System.out.println("Conexão com sucesso");

            statement = conn.createStatement();
            var estados = statement.executeQuery("select * from estado");

            while(estados.next()){
                System.out.printf("Id: %d Nome: %s UF: %s\n", estados.getInt("id"), estados.getString("nome"), estados.getString("uf"));
            }
 
        } catch (SQLException e) {
            if (statement == null) {
                System.err.println("Não foi possível conectar ao DB");
                System.err.println(e.getMessage());
            } else {
                System.err.println("Não foi possível executar statment SQL no DB");
                System.err.println(e.getMessage());
            }
        };
    }
    
    private static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    private static void loadDriverJDBC() {
        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {
            System.err.println("Não foi possível carregar a biblioteca/classe para conectar ao DB");
            System.err.println(e.getMessage());
        };
    }
}
