package com.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.example.dao.ConnectionManager;
import com.example.dao.EstadoDAO;
import com.example.model.Marca;
import com.example.model.Produto;

public class AppDB {

    public static void main(String[] args) {
        new AppDB();
    }

    public AppDB() {

        try (var conn = ConnectionManager.getConnection()) {
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

            System.out.println();
            var EstadoDAO = new EstadoDAO(conn);

            EstadoDAO.searchByUF("PR");
            System.out.println();
            EstadoDAO.listAll();

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



}
