package com.mycompany.mercado.controller;

import com.mycompany.mercado.bd.ConexaoBanco;

public class ControleConexaoBanco {
    private String mensagem;
    private ConexaoBanco conexaoBanco;
    private boolean conectado;
    private static ControleConexaoBanco instancia = null;
    
    private ControleConexaoBanco(){
        conexaoBanco = ConexaoBanco.getInstancia();
    }

    public String getMensagem() {
        return mensagem;
    }
    
    public boolean isConectado() {
        return conectado;
    }
    
    public boolean conectarBanco(){
        conectado = conexaoBanco.conectar();
        mensagem = conexaoBanco.getMensagem();
        return conectado;
    }
    
    public boolean desconectarBanco(){
        conectado = conexaoBanco.desconectar();
        mensagem = conexaoBanco.getMensagem();
        return conectado;
    }

    public static ControleConexaoBanco getInstancia() {
        if (instancia == null){
            instancia = new ControleConexaoBanco();
        }
        return instancia;
    }
}
