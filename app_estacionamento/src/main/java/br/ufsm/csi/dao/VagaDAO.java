package br.ufsm.csi.dao;

import br.ufsm.csi.model.Tipo;
import br.ufsm.csi.model.Vaga;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class VagaDAO {
    private String sql;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement preparedStatement;
    private String status;

    public String cadastrarVaga(Vaga vaga){

        try(Connection connection = new ConectaBD().getConexao()){

            this.sql = "INSERT INTO vaga (andar) VALUES (?);";
            this.preparedStatement = connection.prepareStatement(this.sql);

            this.preparedStatement.setString(1, vaga.getAndar());

            this.preparedStatement.execute();
            this.status = "OK";

        }catch(Exception e){
            e.printStackTrace();
        }

        return status;
    }

    public ArrayList<Vaga> getTodosVagas(){
        ArrayList<Vaga> vagas = new ArrayList<Vaga>();

        try(Connection connection = new ConectaBD().getConexao()){

            this.sql = "SELECT * FROM vaga";
            this.stmt = connection.createStatement();
            this.rs = this.stmt.executeQuery(sql);

            while(this.rs.next()){
                Vaga vaga = new Vaga();
                vaga.setNumVaga(this.rs.getInt("numvaga"));
                vaga.setAndar(this.rs.getString("andar"));

                vagas.add(vaga);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return vagas;
    }

}
