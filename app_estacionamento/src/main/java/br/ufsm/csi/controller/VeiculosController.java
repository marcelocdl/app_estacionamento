package br.ufsm.csi.controller;

import br.ufsm.csi.dao.VeiculoDAO;
import br.ufsm.csi.model.Cliente;
import br.ufsm.csi.model.Tipo;
import br.ufsm.csi.model.Veiculo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("veiculo-controller")
public class VeiculosController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VeiculoDAO dao = new VeiculoDAO();
        String retorno = "";
        String opcao =req.getParameter("opcao");

        if (opcao.equals("excluir")) {
            int id = Integer.parseInt(req.getParameter("id"));
            retorno = dao.excluirVeiculo(id);
            req.getRequestDispatcher("/").forward(req, resp);

        }else if (opcao.equals("listar")) {
            req.setAttribute("veiculos", new VeiculoDAO().getVeiculos());
            req.getRequestDispatcher("listar_veiculo.jsp").forward(req, resp);

        }else if(opcao.equals("atualizar")){
                int id = Integer.parseInt(req.getParameter("id"));

                Veiculo veiculo = new VeiculoDAO().getVeiculosById(id);

                req.setAttribute("veiculo", veiculo);
                req.getRequestDispatcher("cadastrar_veiculo.jsp").forward(req, resp);

        }else{
            int id = Integer.parseInt(req.getParameter("id"));
            System.out.println("ID: "+id);
            String placa = req.getParameter("placa");
            String cor = req.getParameter("cor");
            String modelo = req.getParameter("modelo");
            int codtipo = Integer.parseInt(req.getParameter("cod_tipo"));
            int codcliente = Integer.parseInt(req.getParameter("cod_cliente"));

            Tipo tipo = new Tipo(codtipo);
            Cliente cliente = new Cliente(codcliente);

            Veiculo veiculo = new Veiculo();
            veiculo.setId(id);
            veiculo.setPlaca(placa);
            veiculo.setCor(cor);
            veiculo.setModelo(modelo);
            veiculo.setTipo(tipo);
            veiculo.setCliente(cliente);

            if(id > 0){
                retorno = dao.atualizarVeiculo(veiculo);
            }else{
                retorno = dao.cadastrarVeiculo(veiculo);
            }
            req.getRequestDispatcher("/").forward(req, resp);
            System.out.println("Retorno: "+retorno);
        }
    }
}
