package com.example.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DAO {

    protected Connection conn;

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

     public void findById(String tableName, long id) {
        var sql = "select * from " + tableName +" where id = ?";

        try {
            var statement = conn.prepareStatement(sql);

            statement.setLong(1, id);

            var result = statement.executeQuery();
            var metadata = result.getMetaData();

            int col = metadata.getColumnCount();

            printElement(result, metadata, col);

        } catch (SQLException e) {
            System.err.println("Object not found");
            e.printStackTrace();
        }
    }

    public void printElement(ResultSet result, ResultSetMetaData metadata, int col) throws SQLException {
        if (result.next()) {
            for (int i = 1; i <= col; i++) {
                System.out.printf("%-25s | ", metadata.getColumnName(i));
            }
            System.out.println();

            for (int i = 1; i <= col; i++) {
                System.out.printf("%-25s | ", result.getString(i));
            }
            System.out.println();
            System.out.println();
        }
    }

    public void deleteByID(String tablename, String operator, long id) {
        var sql = "delete from " + tablename + "where id" + operator + "?";

        try {
            var statement = conn.prepareStatement(sql);

            statement.setLong(1, id);
            findById(tablename, id);

            if (statement.executeUpdate() >= 1) {
                System.out.println("Object deleted");   
            } else {
                System.err.println("Delete Failed: Object not found");
            }

        } catch (SQLException e) {
            System.err.println("Delete Failed");
            e.printStackTrace();
        }
    }
}


