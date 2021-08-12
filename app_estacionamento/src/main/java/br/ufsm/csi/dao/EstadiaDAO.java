package br.ufsm.csi.dao;

import br.ufsm.csi.model.Estadia;
import br.ufsm.csi.model.Vaga;
import br.ufsm.csi.model.Veiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EstadiaDAO {

    private String sql;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement preparedStatement;
    private String status;

    public String cadastrarEstadia(Estadia estadia){

        try(Connection connection = new ConectaBD().getConexao()){

            Vaga v_dao = new VagaDAO().getVagaById(estadia.getVaga().getNumVaga());

            if(v_dao.isOcupado()){
                return this.status = "OCUPADO";
            }
            else {
                this.sql = "INSERT INTO estadia (data, hrentrada, hrsaida, numvaga, codveiculo) VALUES" +
                        " (CURRENT_DATE, ?, ?, ?, ?);";
                this.preparedStatement = connection.prepareStatement(this.sql);

                this.preparedStatement.setString(1, estadia.getHr_entrada());
                this.preparedStatement.setString(2, estadia.getHr_saida());
                this.preparedStatement.setInt(3, estadia.getVaga().getNumVaga());
                this.preparedStatement.setInt(4, estadia.getVeiculo().getId());

                this.preparedStatement.execute();
                this.status = "OK";
            }
        }catch(Exception e){
            e.printStackTrace();
            this.status = "ERRO";
        }

        return this.status;
    }

    public ArrayList<Estadia> getEstadias(){
        ArrayList<Estadia> estadias = new ArrayList<Estadia>();

        try(Connection connection = new ConectaBD().getConexao()){

            this.sql = "SELECT * FROM estadia e, veiculo ve, vaga va WHERE " +
                    "e.codveiculo = ve.codveiculo AND " +
                    "e.numvaga = va.numvaga;";
            this.stmt = connection.createStatement();
            this.rs = this.stmt.executeQuery(sql);

            while(this.rs.next()){
                Estadia estadia = new Estadia();
                estadia.setCodEstadia(this.rs.getInt("codestadia"));
                estadia.setData(this.rs.getDate("data"));
                estadia.setHr_entrada(this.rs.getString("hrentrada"));
                estadia.setHr_saida(this.rs.getString("hrsaida"));

                Vaga vaga = new Vaga();
                vaga.setNumVaga(this.rs.getInt("numvaga"));

                Veiculo veiculo = new Veiculo();
                veiculo.setId(this.rs.getInt("codveiculo"));
                veiculo.setPlaca(this.rs.getString("placa"));

                estadia.setVaga(vaga);
                estadia.setVeiculo(veiculo);
                estadias.add(estadia);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return estadias;
    }

    public Estadia getEstadia(int id){
        Estadia estadia = null;

        try(Connection connection = new ConectaBD().getConexao()){

            this.sql = "SELECT * FROM estadia e, veiculo ve, vaga va WHERE " +
                    "e.codveiculo = ve.codveiculo AND " +
                    "e.numvaga = va.numvaga AND e.codestadia = ?;";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);
            this.rs = this.preparedStatement.executeQuery();

            while(this.rs.next()){
                int codestadia = (this.rs.getInt("codestadia"));
                String hr_entrada = (this.rs.getString("hrentrada"));
                String hr_saida = (this.rs.getString("hrsaida"));

                Vaga vaga = new Vaga();
                vaga.setNumVaga(this.rs.getInt("numvaga"));

                Veiculo veiculo = new Veiculo();
                veiculo.setId(this.rs.getInt("codveiculo"));
                veiculo.setPlaca(this.rs.getString("placa"));

                estadia = new Estadia(codestadia, hr_entrada, hr_saida, vaga, veiculo);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return estadia;
    }

    public String saida(Estadia estadia){
        try(Connection connection = new ConectaBD().getConexao()){

            this.sql = "UPDATE estadia SET " +
                    "hrsaida = ? WHERE estadia.codestadia = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);

            this.preparedStatement.setString(1, estadia.getHr_saida());
            this.preparedStatement.setInt(2, estadia.getCodEstadia());

            this.preparedStatement.execute();
            this.status = "OK";



        }catch(Exception e){
            e.printStackTrace();
            this.status = "ERRO";
        }

        return this.status;
    }

}
