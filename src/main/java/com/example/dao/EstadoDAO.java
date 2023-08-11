package com.example.dao;
import java.sql.Statement;

import com.example.model.Estado;

import java.sql.Connection;
import java.sql.SQLException;

public class EstadoDAO extends DAO{ 

    public EstadoDAO(Connection conn) throws SQLException {
        super(conn);
    }

    public void searchByUF(String uf) {

        try {

            var sql = "select * from estado where uf= ?";
            var statement = conn.prepareStatement(sql);

            statement.setString(1, uf);

            var result = statement.executeQuery();

            if (result.next()) {
                System.out.printf("Id: %d Nome: %s UF: %s\n", result.getInt("id"), result.getString("nome"),
                        result.getString("uf"));
            } else {
                System.err.println("Estado not found");
            }

        } catch (SQLException e) {
            System.err.println("Não foi possível executar busca SQL no DB");
            System.err.println(e.getMessage());
        }
    }

    public void listAll() {
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
    }

    public void insert(Estado estado) {
        var sql = "insert into estado (nome, uf, regiao_id, area_km2, populacao) values (?, ?, ?, ?, ?)";

        try {
            var statement = conn.prepareStatement(sql);

            statement.setString(1, estado.getNome());
            statement.setString(2, estado.getUf());
            statement.setLong(3, estado.getRegiao().getId());
            statement.setInt(4, estado.getAreaKM());
            statement.setLong(5, estado.getPopulacao());

            if (statement.executeUpdate() == 1) {
                System.out.println();
                System.err.println("insert worked");
            }
            
        } catch (SQLException e) {
            System.err.println("Insert Failed");
            e.printStackTrace();
        }
    }

    public void update(Estado estado, long id) {
        var sql = "update estado set nome = ?, uf = ?, regiao_id = ?, area_km2 = ?, populacao = ? where id = ?";

        try {
            var statement = conn.prepareStatement(sql);

            statement.setString(1, estado.getNome());
            statement.setString(2, estado.getUf());
            statement.setLong(3, estado.getRegiao().getId());
            statement.setInt(4, estado.getAreaKM());
            statement.setLong(5, estado.getPopulacao());
            statement.setLong(6, id);

            var result = statement.executeUpdate();

            if (result == 1){
                System.out.println();
                System.err.println("update worked");
                findById("estado", id);
            } 

        } catch (SQLException e) {
            System.err.println("update Failed");
            e.printStackTrace();
        }
    }

    public void deleteByID(String operator, long id) {
        var sql = "delete from estado where id" + operator + "?";

        try {
            var statement = conn.prepareStatement(sql);

            statement.setLong(1, id);
            findById("estado", id);

            if (statement.executeUpdate() == 1) {
                System.out.println("Estate deleted:");
            } else {
                System.err.println("Delete Failed: Product not found");
            }

        } catch (SQLException e) {
            System.err.println("Delete Failed");
            e.printStackTrace();
        }
    }

}
