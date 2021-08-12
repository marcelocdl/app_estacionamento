package br.ufsm.csi.controller;

import br.ufsm.csi.dao.EstadiaDAO;
import br.ufsm.csi.dao.VagaDAO;
import br.ufsm.csi.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/estadia-controller")
public class EstadiaController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EstadiaDAO dao = new EstadiaDAO();
        String retorno = "";
        String opcao =req.getParameter("opcao");

        if(opcao.equals("telaAtualizar")){
            int id = Integer.parseInt(req.getParameter("id"));
            req.getRequestDispatcher("WEB-INF/jsp/saida_estadia.jsp?id="+id).forward(req, resp);
        }

        else if(opcao.equals("Atualizar")){
            int id = Integer.parseInt(req.getParameter("idEstadia"));
            String hrSaida = req.getParameter("hr_saida");

            Estadia estadia = new Estadia();
            estadia.setCodEstadia(id);
            estadia.setHr_saida(hrSaida);

            Estadia e = new EstadiaDAO().getEstadia(id);
            int num_vaga = e.getVaga().getNumVaga();
            System.out.println("num vaga: "+num_vaga);

            retorno = dao.saida(estadia);
            if(retorno == "OK"){
                VagaDAO v_dao = new VagaDAO();
                v_dao.desocuparVaga(num_vaga);
            }
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

            if(retorno == "OK"){
                new VagaDAO().ocuparVaga(numVaga);
                req.setAttribute("retorno", "Estadia cadastrada com SUCESSO!!");
            }else if(retorno == "ERRO"){
                req.setAttribute("retorno", "ERRO ao cadastrar estadia!!");
            }else if(retorno == "OCUPADO"){
                req.setAttribute("retorno", "A vaga "+estadia.getVaga().getNumVaga()+" já está OCUPADA!!");
            }

            System.out.println("Retorno: "+retorno);
            req.getRequestDispatcher("/").forward(req, resp);
        }
    }
}
