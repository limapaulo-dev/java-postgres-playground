package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.dao.AlunoDAO;
import com.example.dao.DAO;
import com.example.model.Aluno;

public class AppSysEns {
    private static String url = "jdbc:postgresql://localhost/postgres";
    private static String user = "postgres";
    private static String password = "localpw";

    public static Connection getconection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static double randNota() {
        double randNota = (Math.random() * 100);
        return randNota;
    }

    public static void main(String[] args) {

        new AppSysEns();

        try (Connection conn = AppSysEns.getconection()) {

            System.out.println(conn);

            Statement statement = conn.createStatement();

            var createTableAluno = "create table alunos (matricula SERIAL PRIMARY KEY, nome varchar(255) NOT NULL, nota1 decimal(10, 2) , nota2 decimal(10, 2) , nota3 decimal(10, 2))";

            statement.execute(createTableAluno);

            Aluno aluno1 = new Aluno();
            aluno1.setName("Paulo Lima");
            aluno1.setNota1(randNota());
            aluno1.setNota2(randNota());
            aluno1.setNota3(randNota());

            Aluno aluno2 = new Aluno();
            aluno2.setName("Luciana Marta");
            aluno2.setNota1(randNota());
            aluno2.setNota2(randNota());
            aluno2.setNota3(randNota());

            Aluno aluno3 = new Aluno();
            aluno3.setName("Nory Jim");
            aluno3.setNota1(randNota());
            aluno3.setNota2(randNota());
            aluno3.setNota3(randNota());

            Aluno aluno4 = new Aluno();
            aluno4.setName("Gerald of Rivia");
            aluno4.setNota1(randNota());
            aluno4.setNota2(randNota());
            aluno4.setNota3(randNota());

            Aluno aluno5 = new Aluno();
            aluno5.setName("Trinity");
            aluno5.setNota1(randNota());
            aluno5.setNota2(randNota());
            aluno5.setNota3(randNota());

            var alunoDAO = new AlunoDAO();
            alunoDAO.inserirAluno(conn, aluno1);
            alunoDAO.inserirAluno(conn, aluno2);
            alunoDAO.inserirAluno(conn, aluno3);
            alunoDAO.inserirAluno(conn, aluno4);
            alunoDAO.inserirAluno(conn, aluno5);

            var dao = new DAO(conn);

            alunoDAO.getMediaAluno(conn, "Marcos Vinicios");
            alunoDAO.getMediaAluno(conn, "Trinity");
            alunoDAO.getMediaAluno(conn, "Gerald of Rivia");

            dao.listarAlunos(conn);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
