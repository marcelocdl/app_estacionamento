package br.ufsm.csi.util;

import br.ufsm.csi.dao.ClienteDAO;
import br.ufsm.csi.dao.EstadiaDAO;
import br.ufsm.csi.dao.TipoDAO;
import br.ufsm.csi.dao.VeiculoDAO;
import br.ufsm.csi.model.*;

public class Teste {

    public static void main( String args[] ){
        //testaCadastrarClientes();
        //testaGetClientes();
        //testaCadastrarTipos();
        //testaCadastrarVeiculos();
        testaCadastrarEstadia();
    }

    public static void testaCadastrarClientes(){
        Cliente cliente = new Cliente("Marcelo", "000.000.000-00");

        new ClienteDAO().cadastrar(cliente);
    }

    public static void testaGetClientes(){
        for(Cliente u: new ClienteDAO().getClientes()){
            System.out.println("nome: "+u.getNome());
            System.out.println("cpf: "+u.getCpf());
        }
    }

    public static void testaCadastrarTipos(){
        Tipo tipo = new Tipo(1,"Motocicleta");

        new TipoDAO().cadastrarTipo(tipo);
    }

    public static void testaCadastrarVeiculos(){
        Tipo tipo = new Tipo(1,"Motocicleta");
        Cliente cliente = new Cliente(1,"Marcelo", "000.000.000-00");

        Veiculo veiculo = new Veiculo("aaa1234", "honda", "cinza", tipo, cliente);
        new VeiculoDAO().cadastrarVeiculo(veiculo);
    }

    public static void testaCadastrarEstadia(){
        Veiculo veiculo = new Veiculo(1,"Motocicleta");
        Vaga vaga = new Vaga(1, "1 andar");

        Estadia estadia = new Estadia("13:00", "15:00", vaga, veiculo);
        new EstadiaDAO().cadastrarEstadia(estadia);
    }

}
