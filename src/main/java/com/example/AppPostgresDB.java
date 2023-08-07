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
        new AppPostgresDB();
    }

    public AppPostgresDB(){
        Statement statement = null;

        try (var conn = getConnection()){
            System.out.println("DB conected");
            
            statement = conn.createStatement();

            loadDriverJDBC();
            listStates(conn, statement);
            searchState(conn, statement, "TO");

        } catch (SQLException e) {
            if (statement == null){
                System.err.println("Não foi possível conectar ao DB");
                System.err.println(e.getMessage());
            } else {
                System.err.println("Criação de Statement falhou");
                System.err.println(e.getMessage());
            }
        }
    }

    private void searchState(Connection conn, Statement statement, String uf) {
        try{
            var estados = statement.executeQuery("select * from estado");

            while(estados.next()){
                System.out.printf("Id: %d Nome: %s UF: %s\n", estados.getInt("id"), estados.getString("nome"), estados.getString("uf"));
            }
 
        } catch (SQLException e) {
            System.err.println("Não foi possível executar busca SQL no DB");
            System.err.println(e.getMessage());
        };
    }

    private void listStates(Connection conn, Statement statement) {
        try{
            var estados = statement.executeQuery("select * from estado");

            while(estados.next()){
                System.out.printf("Id: %d Nome: %s UF: %s\n", estados.getInt("id"), estados.getString("nome"), estados.getString("uf"));
            }
 
        } catch (SQLException e) {
            System.err.println("Não foi possível executar statement SQL no DB");
            System.err.println(e.getMessage());
        };
    }
    
    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    private void loadDriverJDBC() {
        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {
            System.err.println("Não foi possível carregar a biblioteca/classe para conectar ao DB");
            System.err.println(e.getMessage());
        };
    }
}
