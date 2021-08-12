package br.ufsm.csi.controller;

import br.ufsm.csi.dao.ClienteDAO;
import br.ufsm.csi.dao.VeiculoDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/menu-controller")
public class MenuController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/";

        String opcao = req.getParameter("opcao");
        url = "WEB-INF/jsp/menu.jsp";

        if(opcao.equals("cadastrar-estadia")){
            url = "WEB-INF/jsp/cadastrar_estadia.jsp";
            req.setAttribute("veiculos", new VeiculoDAO().getVeiculos());
        }else if(opcao.equals("cadastrar-cliente")){
            url = "WEB-INF/jsp/cadastrar_cliente.jsp";
        }else if(opcao.equals("cadastrar-veiculo")){
            url = "WEB-INF/jsp/cadastrar_veiculo.jsp";
            req.setAttribute("clientes", new ClienteDAO().getClientes());
        }

        RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward(req, resp);
    }
}
