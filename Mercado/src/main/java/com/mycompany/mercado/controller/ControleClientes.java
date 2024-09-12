/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mercado.controller;

import com.mycompany.mercado.modelos.Cliente;
import com.mycompany.mercado.bd.DadosCliente;
import java.util.ArrayList;

/**
 *
 * @author 202212030002
 */
public class ControleClientes {
    private DadosCliente dadosCliente;
    private String mensagem;
    
    public ControleClientes(){
        dadosCliente= new DadosCliente();
    }
    
    public boolean adicionarCliente(String nome, String telefone, String email, int cod){
        Cliente cliente = new Cliente(nome, telefone, email, cod);
        boolean inseriu = dadosCliente.adicionar(cliente);
        mensagem = dadosCliente.getMensagem();
        return inseriu;
    }

    public String getMensagem() {
        return mensagem;
    }
    
    public ArrayList<Cliente> selecionarTodos(){
        ArrayList<Cliente> clientes;
        clientes = dadosCliente.selecionarTodos();
        mensagem = dadosCliente.getMensagem();
        return clientes;
    }
    
    public boolean excluir(int cod){
        boolean excluiu = dadosCliente.excluir(cod);
        mensagem = dadosCliente.getMensagem();
        return excluiu;
    }
    
    public boolean editar(Cliente cliente){
        boolean editou = dadosCliente.alterar(cliente);
        mensagem = dadosCliente.getMensagem();
        return editou;
    }
}
