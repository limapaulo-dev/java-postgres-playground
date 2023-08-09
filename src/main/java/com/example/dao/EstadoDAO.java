package com.example.dao;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public class EstadoDAO {
    private Connection conn;

    public EstadoDAO(Connection conn) {
        this.conn = conn;
    }

    public void searchByUF(String uf) {

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

}
