package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Departamento {

    private final DB Database = new DB();

    private final Integer id;
    private String nome;

    public Departamento(Integer id){
        this.id = id;
        this.nome = this.getNome();
    }

    public Integer getId(){
        return this.id;
    }


    public String getNome(){
        String SQL = "SELECT nome FROM departamentos WHERE id = " + this.getId();
        String nome = "";

        try (Connection conn = this.Database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)){
            rs.next();
            nome = rs.getString(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return nome;
    }

    public Integer getQuantidadeFuncionarios(){
        String SQL = "SELECT COUNT(departamento_id) FROM funcionarios WHERE departamento_id = " + this.getId();
        Integer count = 0;

        try (Connection conn = this.Database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)){
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return count;
}
}
