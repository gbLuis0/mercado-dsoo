/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mercado.controller;

import com.mycompany.mercado.modelos.Pedidos;
import com.mycompany.mercado.bd.DadosPedido;
import java.util.ArrayList;

/**
 *
 * @author 202212030002
 */
public class ControlePedidos {
    private DadosPedido dadosPedido;
    private String mensagem;
    
    public ControlePedidos(){
        dadosPedido = new DadosPedido();
    }
    
    public boolean adicionarPedido(int codprod, int codcli, int qtde, String data){
        Pedidos pedido = new Pedidos(codprod, codcli, qtde, data);
        boolean inseriu = dadosPedido.inserir(pedido);
        mensagem = dadosPedido.getMensagem();
        return inseriu;
    }

    public String getMensagem() {
        return mensagem;
    }
    /*
    public ArrayList<Pedidos> selecionarTodos(){
        ArrayList<Pedidos> pedidos;
        pedidos = dadosPedido.selecionarTodos();
        mensagem = dadosPedido.getMensagem();
        return pedidos;
    }
    
    public boolean excluir(int cod){
        boolean excluiu = dadosPedido.excluir(cod);
        mensagem = dadosPedido.getMensagem();
        return excluiu;
    }
    
    public boolean editar(Pedidos pedido){
        boolean editou = dadosPedido.alterar(pedido);
        mensagem = dadosPedido.getMensagem();
        return editou;
    }
*/ // falta add as funções no dados pedido
}
