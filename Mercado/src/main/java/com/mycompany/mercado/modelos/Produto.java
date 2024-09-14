package com.mycompany.mercado.modelos;

public class Produto {
    private int cod, quantidade;
    private float preco;
    private String nome;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Produto(int cod, int quantidade, float preco, String nome) {
        this.cod = cod;
        this.quantidade = quantidade;
        this.preco = preco;
        this.nome = nome;
    }

    public Produto(int quantidade, float preco, String nome) {
        this.quantidade = quantidade;
        this.preco = preco;
        this.nome = nome;
    }
}
