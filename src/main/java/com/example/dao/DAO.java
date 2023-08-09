package com.example.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DAO {

    private Connection conn;

    public DAO(Connection conn) throws SQLException {
        this.conn = conn;
    }

    public ResultSet findTable(String tableName) {
        var sql = "select * from " + tableName;
        ResultSet result = null;

        try {
            var statement = conn.createStatement();
            result = statement.executeQuery(sql);

        } catch (SQLException e) {
            System.err.println("Query Failed");
            e.printStackTrace();
        }
        return result;
    }

    public void printTable(String tableName) throws SQLException {
        var result = findTable(tableName);

        var tableMeta = result.getMetaData();
        int cols = tableMeta.getColumnCount();

        System.out.println();
        printTableName(tableName);

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
        while (result.next()) {
            for (int i = 1; i <= cols; i++) {
                System.out.printf("%-25s | ", result.getString(i));
            }
            System.out.println();
        }
        System.out.println();
    }
}
