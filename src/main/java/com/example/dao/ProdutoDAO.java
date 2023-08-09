package com.example.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.example.model.Produto;

public class ProdutoDAO {
    private Connection conn;

    public ProdutoDAO(Connection conn) {
        this.conn = conn;
    }

    public void insert(Produto produto) {
        var sql = "insert into produto (nome, marca_id, valor) values (?, ?, ?)";

        try {
            var statement = conn.prepareStatement(sql);

            statement.setString(1, produto.getNome());
            statement.setLong(2, produto.getMarca().getId());
            statement.setDouble(3, produto.getValor());

            if (statement.executeUpdate() == 1) {
                System.out.println();
                System.err.println("insert worked");
            }
            
        } catch (SQLException e) {
            System.err.println("Insert Failed");
            e.printStackTrace();
        }
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
            System.err.println("Element not found");
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

    public void update(Produto produto, long id) {
        var sql = "update produto set nome = ?, marca_id = ?, valor = ? where id = ?";

        try {
            var statement = conn.prepareStatement(sql);

            statement.setString(1, produto.getNome());
            statement.setLong(2, produto.getMarca().getId());
            statement.setDouble(3, produto.getValor());
            statement.setLong(4, id);

            if(statement.executeUpdate() == 1){
                System.out.println();
                System.err.println("update worked");
                findById("produto", id);
            }

        } catch (SQLException e) {
            System.err.println("update Failed");
            e.printStackTrace();
        }
    }

    public void deleteByID(String operator, long id) {
        var sql = "delete from produto where id" + operator + "?";

        try {
            var statement = conn.prepareStatement(sql);

            statement.setLong(1, id);
            findById("produto", id);

            if (statement.executeUpdate() >= 1) {
                System.out.println("Product deleted");   
            } else {
                System.err.println("Delete Failed: Product not found");
            }

        } catch (SQLException e) {
            System.err.println("Delete Failed");
            e.printStackTrace();
        }
    }

}
