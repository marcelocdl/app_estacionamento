package br.ufsm.csi.model;

public class Vaga {

    private int numVaga;
    private String andar;

    public Vaga() {
    }

    public Vaga(int numVaga, String andar) {
        this.numVaga = numVaga;
        this.andar = andar;
    }

    public int getNumVaga() {
        return numVaga;
    }

    public void setNumVaga(int numVaga) {
        this.numVaga = numVaga;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }
}
