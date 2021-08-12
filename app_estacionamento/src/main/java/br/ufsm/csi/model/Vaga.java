package br.ufsm.csi.model;

public class Vaga {

    private int numVaga;
    private String andar;
    private boolean ocupado;

    public Vaga() {
    }

    public Vaga(int numVaga){
        this.numVaga = numVaga;
    }

    public Vaga(int numVaga, String andar) {
        this.numVaga = numVaga;
        this.andar = andar;
    }

    public Vaga(int numVaga, String andar, boolean ocupado) {
        this.numVaga = numVaga;
        this.andar = andar;
        this.ocupado = ocupado;
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

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}
