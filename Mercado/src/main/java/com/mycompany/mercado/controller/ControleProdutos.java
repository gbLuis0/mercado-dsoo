/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mercado.controller;

import com.mycompany.mercado.modelos.Produto;
import com.mycompany.mercado.bd.DadosProduto;
import java.util.ArrayList;

/**
 *
 * @author 202212030002
 */
public class ControleProdutos {
    private DadosProduto dadosProduto;
    private String mensagem;
    
    public ControleProdutos(){
        dadosProduto = new DadosProduto();
    }
    
    public boolean adicionarProduto(int quantidade, float preco, String nome){
        Produto produto = new Produto(quantidade, preco, nome);
        boolean inseriu = dadosProduto.adicionar(produto);
        mensagem = dadosProduto.getMensagem();
        return inseriu;
    }

    public String getMensagem() {
        return mensagem;

    }
    
    public ArrayList<Produto> selecionarTodos(){
        ArrayList<Produto> produtos;
        produtos = dadosProduto.selecionarTodos();
        mensagem = dadosProduto.getMensagem();
        return produtos;
    }
    
    public boolean excluir(int cod){
        boolean excluiu = dadosProduto.excluir(cod);
        mensagem = dadosProduto.getMensagem();
        return excluiu;
    }
    
    public boolean editar(Produto produto){
        boolean editou = dadosProduto.alterar(produto);
        mensagem = dadosProduto.getMensagem();
        return editou;
    }
}
