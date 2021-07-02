package br.ufsm.csi.model;

import java.sql.Date;

public class Estadia {

    private int codEstadia;
    private Date data;
    private String hr_entrada;
    private String hr_saida;
    private Vaga vaga;
    private Veiculo veiculo;

    public Estadia() {
    }

    public Estadia(String hr_entrada, String hr_saida, Vaga vaga, Veiculo veiculo) {
        this.hr_entrada = hr_entrada;
        this.hr_saida = hr_saida;
        this.vaga = vaga;
        this.veiculo = veiculo;
    }

    public int getCodEstadia() {
        return codEstadia;
    }

    public void setCodEstadia(int codEstadia) {
        this.codEstadia = codEstadia;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHr_entrada() {
        return hr_entrada;
    }

    public void setHr_entrada(String hr_entrada) {
        this.hr_entrada = hr_entrada;
    }

    public String getHr_saida() {
        return hr_saida;
    }

    public void setHr_saida(String hr_saida) {
        this.hr_saida = hr_saida;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}
