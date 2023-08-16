package com.example.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.model.Aluno;

public class AlunoDAO {

    public void inserirAluno(Connection conn, Aluno aluno) throws SQLException {

        var statement = conn.createStatement();

        var insertAluno = "insert into alunos (nome, nota1, nota2, nota3) values ('"
                + aluno.getName() + "', '"
                + aluno.getNota1() + "', '"
                + aluno.getNota2() + "', '"
                + aluno.getNota3() + "')";

        statement.execute(insertAluno);
    }

    public void getMediaAluno(Connection conn, String nome) throws SQLException {

        var queryAluno = "select * from alunos where nome = ?";

        var statQueryAluno = conn.prepareStatement(queryAluno);

        statQueryAluno.setString(1, nome);

        ResultSet resultQueryAluno = statQueryAluno.executeQuery();

        while (resultQueryAluno.next()) {

            var nota1 = resultQueryAluno.getDouble("nota1");
            var nota2 = resultQueryAluno.getDouble("nota2");
            var nota3 = resultQueryAluno.getDouble("nota3");
            var media = (nota1 + nota2 + nota3) / 3;

            System.out.printf("Matrícula = %d | Nome = %-25s | Media = %5.2f",

                    resultQueryAluno.getInt("matricula"),
                    resultQueryAluno.getString("nome"),
                    media);
            System.out.println();
        }
        System.out.println();
    }

}
