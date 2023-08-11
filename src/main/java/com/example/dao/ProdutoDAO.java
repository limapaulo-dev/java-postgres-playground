package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.model.Produto;

public class ProdutoDAO extends DAO{


    public ProdutoDAO(Connection conn) throws SQLException {
        super(conn);
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
