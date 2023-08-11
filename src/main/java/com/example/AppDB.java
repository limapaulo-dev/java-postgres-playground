package com.example;

import java.sql.SQLException;
import com.example.dao.ConnectionManager;
import com.example.dao.EstadoDAO;
import com.example.dao.DAO;
import com.example.dao.ProdutoDAO;
import com.example.model.Estado;
import com.example.model.Marca;
import com.example.model.Produto;
import com.example.model.RegiaoGeografica;

public class AppDB {

    public static void main(String[] args) {
        new AppDB();
    }

    public AppDB() {
        try (var conn = ConnectionManager.getConnection()) {
            System.out.println("--------------");
            System.out.println("DB conected");
            System.out.println("--------------");

            var marca = new Marca();
            marca.setId((long) 1);

            var produto = new Produto();
            produto.setMarca(marca);
            produto.setNome("Produto de teste");
            produto.setValor(250.55d);

            var produtoDAO = new ProdutoDAO(conn);
            produtoDAO.insert(produto);

            var produto2 = new Produto();
            produto2.setMarca(marca);
            produto2.setNome("Produto Mais novo");
            produto2.setValor(513.55d);

            produtoDAO.update(produto2, 211);

            produtoDAO.deleteByID(">", 200);

            var dao = new DAO(conn);
            dao.printTable("produto");
            System.out.println();

            var regiao = new RegiaoGeografica();
            regiao.setId((long)5);

            var estado = new Estado();
            estado.setNome("União do Sul");
            estado.setUf("US");
            estado.setRegiao(regiao);
            estado.setAreaKM(576774);
            estado.setPopulacao(30000000);

            var estadoDAO = new EstadoDAO(conn);

            estadoDAO.insert(estado);
            estadoDAO.deleteByID("=", 30);

            estadoDAO.searchByUF("PR");

            System.out.println();
            dao.printTable("estado");

        } catch (SQLException e) {
            System.err.println("Não foi possível conectar ao DB");
            System.err.println(e.getMessage());
        }
    }
}
