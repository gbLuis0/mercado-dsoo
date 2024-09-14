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
        dadosCliente = new DadosCliente();
    }
    
    public boolean adicionarCliente(String nome, String telefone, String email){
        Cliente cliente = new Cliente(nome, telefone, email);
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
