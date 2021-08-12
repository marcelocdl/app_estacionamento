package br.ufsm.csi.util;

import br.ufsm.csi.dao.*;
import br.ufsm.csi.model.*;

public class Teste {

    public static void main( String args[] ){
        testaGetVaga();
    }

    public static void testaGetVaga(){
        Vaga vaga = new VagaDAO().getVagaById(1);
        System.out.println("NUM-> "+vaga.getNumVaga());
        System.out.println("Andar-> "+vaga.getAndar());
        System.out.println("Ocupado-> "+vaga.isOcupado());
    }


}
