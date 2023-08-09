package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class AppPostgresDB {
    private static final String JDBC_URL = "jdbc:postgresql://localhost/postgres";
    private static final String USERNAME = "gitpod";
    private static final String PASSWORD = "";

    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    public static void main(String[] args) {
        new AppPostgresDB();
    }

    public AppPostgresDB(){

        try (var conn = getConnection()){
            System.out.println("DB conected");

            findTable(conn, "produto");
            
/*             listStates(conn);
            System.out.println("");
            searchState(conn,"TO"); */

        } catch (SQLException e) {
            System.err.println("Não foi possível conectar ao DB");
            System.err.println(e.getMessage());
        }
    }

    private void findTable(Connection conn, String tableName) {
        var sql = "select * from " + tableName;

        try {
            var statement = conn.createStatement();
            var result = statement.executeQuery(sql);

            travelTable(result);

        } catch (SQLException e) {
            System.err.println("Query Failed");
            e.printStackTrace();
        }
    }

    private void travelTable(ResultSet result) throws SQLException {
        
        var tableMeta = result.getMetaData();
        String tableName = tableMeta.getTableName(1);
        int cols = tableMeta.getColumnCount();

        System.out.println();
        printTableName(tableName);
        System.out.println();

        printColumnTitles(tableMeta, cols);
        printColumnContent(result, cols);
    }

    private void printTableName(String tableName) {
        System.out.println("Table name: " + tableName);
    }

    private void printColumnTitles(ResultSetMetaData tableMeta, int cols) throws SQLException {
        for (int i = 1; i <= cols; i++) {
            System.out.printf("%-25s | ", tableMeta.getColumnName(i));
        }
        System.out.println();
    }  
    
    private void printColumnContent(ResultSet result, int cols) throws SQLException {
        while (result.next()){
            for (int i = 1; i <= cols; i++) {
                System.out.printf("%-25s | ", result.getString(i));
            } 
            System.out.println();                
        }
        System.out.println();
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


    

}
