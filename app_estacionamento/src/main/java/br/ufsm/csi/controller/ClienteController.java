package br.ufsm.csi.controller;

import br.ufsm.csi.dao.ClienteDAO;
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

@WebServlet("cliente-controller")
public class ClienteController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClienteDAO dao = new ClienteDAO();
        String retorno = "";
        String opcao =req.getParameter("opcao");

        if (opcao.equals("excluir")) {
            int id = Integer.parseInt(req.getParameter("id"));
            retorno = dao.excluirCliente(id);
            req.getRequestDispatcher("/").forward(req, resp);

        }else if (opcao.equals("listar")) {
            req.setAttribute("clientes", new ClienteDAO().getClientes());
            req.getRequestDispatcher("listar_cliente.jsp").forward(req, resp);

        }else if(opcao.equals("atualizar")){
            int id = Integer.parseInt(req.getParameter("id"));

            Cliente cliente = new ClienteDAO().getClienteById(id);

            req.setAttribute("cliente", cliente);
            req.getRequestDispatcher("cadastrar_cliente.jsp").forward(req, resp);

        }else{
            int id = Integer.parseInt(req.getParameter("id"));
            String nome = req.getParameter("nome");
            String cpf = req.getParameter("cpf");

            Cliente cliente = new Cliente();
            cliente.setCod_cliente(id);
            cliente.setNome(nome);
            cliente.setCpf(cpf);
            if(id > 0){
                retorno = dao.atualizarCliente(cliente);
            }else{
                retorno = dao.cadastrarCliente(cliente);
            }
            req.getRequestDispatcher("/").forward(req, resp);
            System.out.println("Retorno: "+retorno);
        }

    }
}
