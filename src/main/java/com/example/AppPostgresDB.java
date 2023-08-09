package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.model.Marca;
import com.example.model.Produto;

public class AppPostgresDB {
    private static final String JDBC_URL = "jdbc:postgresql://localhost/postgres";
    private static final String USERNAME = "gitpod";
    private static final String PASSWORD = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    public static void main(String[] args) {
        new AppPostgresDB();
    }

    public AppPostgresDB() {

        try (var conn = getConnection()) {
            System.out.println("DB conected");

            var marca = new Marca();
            marca.setId((long) 1);

            var produto = new Produto();
            produto.setMarca(marca);
            produto.setNome("Produto de teste");
            produto.setValor(250.55d);

            insertProduct(conn, produto);

            var produto2 = new Produto();
            produto2.setMarca(marca);
            produto2.setNome("Produto Mais novo");
            produto2.setValor(513.55d);

            updateProduct(conn, produto2, 211);

            deleteProduct(conn, 208);

            findTable(conn, "produto");

            /*
             * listStates(conn);
             * System.out.println("");
             * searchState(conn,"TO");
             */

        } catch (SQLException e) {
            System.err.println("Não foi possível conectar ao DB");
            System.err.println(e.getMessage());
        }
    }

    private void findById(Connection conn, String tableName, long id) {
        var sql = "select * from " + tableName +" where id = ?";

        try {
            var statement = conn.prepareStatement(sql);

            statement.setLong(1, id);

            var result = statement.executeQuery();
            var metadata = result.getMetaData();

            int col = metadata.getColumnCount();

            printElement(result, metadata, col);

        } catch (SQLException e) {
            System.err.println("Element not found");
            e.printStackTrace();
        }
    }

    private void printElement(ResultSet result, ResultSetMetaData metadata, int col) throws SQLException {
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

    private void deleteProduct(Connection conn, long id) {

        var sql = "delete from produto where id = ?";

        try {
            var statement = conn.prepareStatement(sql);

            statement.setLong(1, id);
            findById(conn, "produto", id);

            if (statement.executeUpdate() == 1) {
                System.out.println("Product deleted:");
            } else {
                System.err.println("Delete Failed: Product not found");
            }

        } catch (SQLException e) {
            System.err.println("Delete Failed");
            e.printStackTrace();
        }
    }

    private void insertProduct(Connection conn, Produto produto) {
        var sql = "insert into produto (nome, marca_id, valor) values (?, ?, ?)";

        try {
            var statement = conn.prepareStatement(sql);

            statement.setString(1, produto.getNome());
            statement.setLong(2, produto.getMarca().getId());
            statement.setDouble(3, produto.getValor());

            statement.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Insert Failed");
            e.printStackTrace();
        }
    }

    private void updateProduct(Connection conn, Produto produto, long id) {
        var sql = "update produto set nome = ?, marca_id = ?, valor = ? where id = ?";

        try {
            var statement = conn.prepareStatement(sql);

            statement.setString(1, produto.getNome());
            statement.setLong(2, produto.getMarca().getId());
            statement.setDouble(3, produto.getValor());
            statement.setLong(4, id);

            statement.executeUpdate();
            System.out.println();
            System.err.println("update worked");
            findById(conn, "produto", id);
            
        } catch (SQLException e) {
            System.err.println("update Failed");
            e.printStackTrace();
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

    private void searchState(Connection conn, String uf) {

        try {

            var sql = "select * from estado where uf= ?";
            var statement = conn.prepareStatement(sql);

            statement.setString(1, uf);

            var result = statement.executeQuery();

            while (result.next()) {
                System.out.printf("Id: %d Nome: %s UF: %s\n", result.getInt("id"), result.getString("nome"),
                        result.getString("uf"));
            }

        } catch (SQLException e) {
            System.err.println("Não foi possível executar busca SQL no DB");
            System.err.println(e.getMessage());
        }
        ;
    }

    private void listStates(Connection conn) {
        try {
            Statement statement = conn.createStatement();
            var result = statement.executeQuery("select * from estado");

            while (result.next()) {
                System.out.printf("Id: %d Nome: %s UF: %s\n", result.getInt("id"), result.getString("nome"),
                        result.getString("uf"));
            }

        } catch (SQLException e) {
            System.err.println("Não foi possível executar statement SQL no DB");
            System.err.println(e.getMessage());
        }
        ;
    }

}
