package br.ufsm.csi.dao;

import br.ufsm.csi.model.Cliente;
import br.ufsm.csi.model.Tipo;
import br.ufsm.csi.model.Veiculo;

import java.sql.*;
import java.util.ArrayList;

public class VeiculoDAO {

    private String sql;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement preparedStatement;
    private String status;

    public String cadastrarVeiculo(Veiculo veiculo){

        try(Connection connection = new ConectaBD().getConexao()){

            this.sql = "INSERT INTO veiculo (placa, cor, modelo, codtipo, codcliente) VALUES" +
                    " (?, ?, ?, ?, ?);";
            this.preparedStatement = connection.prepareStatement(this.sql);

            this.preparedStatement.setString(1, veiculo.getPlaca());
            this.preparedStatement.setString(2, veiculo.getCor());
            this.preparedStatement.setString(3, veiculo.getModelo());
            this.preparedStatement.setInt(4, veiculo.getTipo().getCod_tipo());
            this.preparedStatement.setInt(5, veiculo.getCliente().getCod_cliente());

            this.preparedStatement.execute();
            this.status = "OK";

        }catch(Exception e){
            e.printStackTrace();
            this.status = "ERRO";
        }

        return this.status;
    }

    public ArrayList<Veiculo> getVeiculos(){
        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

        try(Connection connection = new ConectaBD().getConexao()){

            this.sql = "SELECT * FROM veiculo ve, cliente cli, tipo ti WHERE" +
                    " ve.codcliente = cli.cod_cliente AND" +
                    " ve.codtipo = ti.cod_tipo;";
            this.stmt = connection.createStatement();
            this.rs = this.stmt.executeQuery(sql);

            while(this.rs.next()){
                Veiculo veiculo = new Veiculo();
                veiculo.setId(this.rs.getInt("codveiculo"));
                veiculo.setPlaca(this.rs.getString("placa"));
                veiculo.setCor(this.rs.getString("cor"));

                Cliente cliente = new Cliente();
                cliente.setCod_cliente(this.rs.getInt("codcliente"));
                cliente.setNome(this.rs.getString("nome"));

                Tipo tipo = new Tipo();
                tipo.setCod_tipo(this.rs.getInt("cod_tipo"));
                tipo.setDescricao(this.rs.getString("descricao"));

                veiculo.setCliente(cliente);
                veiculo.setTipo(tipo);
                veiculos.add(veiculo);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return veiculos;
    }

}
