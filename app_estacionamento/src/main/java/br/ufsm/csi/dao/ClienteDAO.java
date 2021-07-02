package br.ufsm.csi.dao;

import br.ufsm.csi.model.Cliente;
import br.ufsm.csi.model.Tipo;

import java.sql.*;
import java.util.ArrayList;

public class ClienteDAO {
    private String sql;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement preparedStatement;
    private String status;

    public String cadastrarCliente(Cliente cliente){

        try(Connection connection = new ConectaBD().getConexao()){

            this.sql = "INSERT INTO cliente (nome, cpf) VALUES" +
                    " (?, ?);";
            this.preparedStatement = connection.prepareStatement(this.sql);

            this.preparedStatement.setString(1, cliente.getNome());
            this.preparedStatement.setString(2, cliente.getCpf());

            this.preparedStatement.execute();

            this.status = "OK";

        }catch(Exception e){
            e.printStackTrace();
            this.status = "ERRO";
        }

        return this.status;
    }

    public ArrayList<Cliente> getClientes(){
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        try(Connection connection = new ConectaBD().getConexao()){

            this.sql = "SELECT * FROM cliente";
            this.stmt = connection.createStatement();
            this.rs = this.stmt.executeQuery(sql);

            while(this.rs.next()){
                Cliente cliente = new Cliente();
                cliente.setCod_cliente(this.rs.getInt("cod_cliente"));
                cliente.setNome(this.rs.getString("nome"));
                cliente.setCpf(this.rs.getString("cpf"));

                clientes.add(cliente);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return clientes;
    }

    public String excluirCliente(int id){

        try(Connection connection = new ConectaBD().getConexao()){
            this.sql = "DELETE FROM cliente AS c WHERE c.cod_cliente = "+id+";";
            this.preparedStatement = connection.prepareStatement(this.sql);

            this.preparedStatement.execute();
            this.status = "OK";

        }catch(Exception e){
            e.printStackTrace();
            this.status = "ERRO";
        }

        return this.status;
    }

    public String atualizarCliente(Cliente cliente){

        try (Connection connection = new ConectaBD().getConexao()) {
            this.sql = "UPDATE cliente SET nome = ?, cpf = ? WHERE cliente.cod_cliente = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);

            this.preparedStatement.setString(1, cliente.getNome());
            this.preparedStatement.setString(2, cliente.getCpf());
            this.preparedStatement.setInt(3, cliente.getCod_cliente());
            this.preparedStatement.execute();

            this.status = "OK";

        }catch (Exception e){
            e.printStackTrace();
            this.status = "ERRO";
        }

        return this.status;
    }

    public Cliente getClienteById(int id){
        Cliente cliente = null;

        try(Connection connection = new ConectaBD().getConexao()){

            this.sql = "SELECT * FROM cliente WHERE cod_cliente = "+id+";";
            this.stmt = connection.createStatement();
            this.rs = this.stmt.executeQuery(sql);

            while(this.rs.next()){
                String nome = this.rs.getString("nome");
                String cpf = this.rs.getString("cpf");

                cliente = new Cliente(id, nome, cpf);
            }

        }catch(SQLException e){
            e.printStackTrace();
            this.status = "ERRO";
        }

        return cliente;
    }

}
