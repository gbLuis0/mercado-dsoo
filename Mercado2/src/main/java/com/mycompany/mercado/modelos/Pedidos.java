package com.mycompany.mercado.modelos;

public class Pedidos {
    private int cod_pedido, cod_produto, cod_cliente, quantidade;
    private String data;

    public int getCod_pedido() {
        return cod_pedido;
    }

    public void setCod_pedido(int cod_pedido) {
        this.cod_pedido = cod_pedido;
    }

    public int getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(int cod_produto) {
        this.cod_produto = cod_produto;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Pedidos(int cod_pedido, int cod_produto, int cod_cliente, int quantidade, String data) {
        this.cod_pedido = cod_pedido;
        this.cod_produto = cod_produto;
        this.cod_cliente = cod_cliente;
        this.quantidade = quantidade;
        this.data = data;
    }
    public Pedidos(int cod_produto, int cod_cliente, int quantidade, String data) {
        this.cod_pedido = cod_pedido;
        this.cod_produto = cod_produto;
        this.cod_cliente = cod_cliente;
        this.quantidade = quantidade;
        this.data = data;
    }
    
}
