package br.ufsm.csi.controller;

import br.ufsm.csi.dao.EstadiaDAO;
import br.ufsm.csi.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("estadia-controller")
public class EstadiaController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EstadiaDAO dao = new EstadiaDAO();
        String retorno = "";
        String opcao =req.getParameter("opcao");

        if(opcao.equals("Atualizar")){
            int id = Integer.parseInt(req.getParameter("idEstadia"));
            String hrSaida = req.getParameter("hr_saida");

            Estadia estadia = new Estadia();
            estadia.setCodEstadia(id);
            estadia.setHr_saida(hrSaida);

            dao.saida(estadia);
            req.getRequestDispatcher("/").forward(req, resp);

        }else{
            String hrEntrada = req.getParameter("hr_entrada");
            int numVaga = Integer.parseInt(req.getParameter("num_vaga"));
            int codVeiculo = Integer.parseInt(req.getParameter("cod_veiculo"));

            Vaga vaga = new Vaga(numVaga);
            Veiculo veiculo = new Veiculo(codVeiculo);

            Estadia estadia = new Estadia();
            estadia.setHr_entrada(hrEntrada);
            estadia.setVaga(vaga);
            estadia.setVeiculo(veiculo);

            retorno = dao.cadastrarEstadia(estadia);
            req.getRequestDispatcher("/").forward(req, resp);
            System.out.println("Retorno: "+retorno);
        }
    }
}
