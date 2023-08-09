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

        try (var conn = getConnection()){
            System.out.println("DB conected");
            
            listStates(conn);
            System.out.println("");
            searchState(conn,"TO");

        } catch (SQLException e) {
            System.err.println("Não foi possível conectar ao DB");
            System.err.println(e.getMessage());
        }
    }

    private void searchState(Connection conn, String uf) {

        try{
            
            var sql = "select * from estado where uf= ?";
            var statement = conn.prepareStatement(sql);

            statement.setString(1, uf);

            var result = statement.executeQuery();           

            while(result.next()){
                System.out.printf("Id: %d Nome: %s UF: %s\n", result.getInt("id"), result.getString("nome"), result.getString("uf"));
            }
 
        } catch (SQLException e) {
            System.err.println("Não foi possível executar busca SQL no DB");
            System.err.println(e.getMessage());
        };
    }

    private void listStates(Connection conn) {
        try{
            Statement statement = conn.createStatement();
            var result = statement.executeQuery("select * from estado");

            while(result.next()){
                System.out.printf("Id: %d Nome: %s UF: %s\n", result.getInt("id"), result.getString("nome"), result.getString("uf"));
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
