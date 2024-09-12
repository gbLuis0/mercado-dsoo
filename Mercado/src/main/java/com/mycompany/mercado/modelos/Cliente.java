package com.mycompany.mercado.modelos;

public class Cliente {
    private String nome, telefone, email;
    private int cod;

    public int getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente(String nome, String telefone, String email, int cod) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cod = cod;
    }
}
