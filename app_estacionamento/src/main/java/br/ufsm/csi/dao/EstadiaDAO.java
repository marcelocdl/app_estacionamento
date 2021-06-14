package br.ufsm.csi.dao;

import br.ufsm.csi.model.Estadia;
import br.ufsm.csi.model.Veiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EstadiaDAO {

    private String sql;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement preparedStatement;
    private String status;

    public String cadastrarEstadia(Estadia estadia){

        try(Connection connection = new ConectaBD().getConexao()){

            this.sql = "INSERT INTO estadia (data, hrentrada, hrsaida, numvaga, codveiculo) VALUES" +
                    " (CURRENT_DATE, ?, ?, ?, ?);";
            this.preparedStatement = connection.prepareStatement(this.sql);

            this.preparedStatement.setString(1, estadia.getHr_entrada());
            this.preparedStatement.setString(2, estadia.getHr_saida());
            this.preparedStatement.setInt(3, estadia.getVaga().getNumVaga());
            this.preparedStatement.setInt(4, estadia.getVeiculo().getId());

            this.preparedStatement.execute();
            this.status = "OK";

        }catch(Exception e){
            e.printStackTrace();
            this.status = "ERRO";
        }

        return this.status;
    }

}
