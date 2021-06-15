package br.ufsm.csi.model;

public class Cliente {

    private int cod_cliente;
    private String nome;
    private String cpf;

    public Cliente() {
    }

    public Cliente(int cod_cliente){
        this.cod_cliente = cod_cliente;
    }

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Cliente(int cod_cliente, String nome, String cpf) {
        this.cod_cliente = cod_cliente;
        this.nome = nome;
        this.cpf = cpf;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
