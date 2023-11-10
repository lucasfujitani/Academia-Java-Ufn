
package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author luanv
 */
public class Departamento {

    private final DB Database = new DB();

    private Integer id;
    private String nome;

    public Departamento(Integer id){
        this.id = id;
        this.nome = this.getNome();
    }

    public Departamento(String nome) throws SQLException{
        this.id = 0;
        String InsertSQL = "INSERT INTO departamentos (nome) VALUES (?);";
        Connection conn = this.Database.connect(true);

        try (
                PreparedStatement pstmt = conn.prepareStatement(InsertSQL)){
            pstmt.setString(1, nome);
            pstmt.execute();
            conn.commit();

            this.id = getIdFromDatabase(nome);
            this.nome = nome;
            //getIdFromDatabase
        } catch (SQLException e){
            conn.rollback();
            System.out.println(e.getMessage());
        } finally {
            conn.close();
        }
    }

    public Integer getId(){
        return this.id;
    }

    public Integer getIdFromDatabase(String nome){
        String SQL = "SELECT id FROM departamentos WHERE nome = '" + nome + "';";
        Integer id = 0;

        try (Connection conn = this.Database.connect(true);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)){
            rs.next();
            id = rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return id;
    }

    public String getNome(){
        String SQL = "SELECT nome FROM departamentos WHERE id = " + this.getId();
        String nome = "";

        try (Connection conn = this.Database.connect(true);
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

        try (Connection conn = this.Database.connect(true);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)){
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return count;
    }

    public void destroy() throws SQLException{
        String DeleteSQL = "DELETE FROM departamentos WHERE id = ?;";
        Connection conn = this.Database.connect(true);

        try (
                PreparedStatement pstmt = conn.prepareStatement(DeleteSQL)){
            pstmt.setInt(1, this.getId());
            pstmt.execute();
//            conn.commit();
//            conn.close();
        } catch (SQLException e){
            conn.rollback();
            System.out.println(e.getMessage());
        } finally {
            conn.close();
        }
    }

}
