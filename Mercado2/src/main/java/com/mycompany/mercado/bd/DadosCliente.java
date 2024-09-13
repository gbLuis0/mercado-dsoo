/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mercado.bd;

import com.mycompany.mercado.modelos.Cliente;
import com.mycompany.mercado.bd.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DadosCliente {
    private ArrayList<Cliente> clientes;
    private String mensagem;
    private Connection conexao;
    

    public DadosCliente() {
        clientes = new ArrayList<>();
        mensagem = "";
        conexao = ConexaoBanco.getInstancia().getConexao();
    }
    
    public boolean adicionar(Cliente cliente){
        try {
            String strSQL = "insert into clientes (nome_cliente, telefone, email) "
                    + " value (?, ?, ?);";
            try (PreparedStatement preparedStatement = conexao.prepareStatement(strSQL)) {
                preparedStatement.setString(1, cliente.getNome());
                preparedStatement.setString(2, cliente.getTelefone());
                preparedStatement.setString(3, cliente.getEmail());
                preparedStatement.executeUpdate();
            }
            
            mensagem = "O Cliente foi inserido com sucesso.";
            return true;
        } catch (SQLException ex) {
            mensagem = "Não foi possível inserir o Cliente"
                    + ex.getMessage();
            return false;
        }
    }
    
    public boolean excluir(int cod){
        try {
            String strSQL = "delete from departamento where "
                    + " cod_cliente = " + cod + ";";
            Statement statement = conexao.createStatement();
            statement.executeUpdate(strSQL);
            statement.close();
            
            mensagem = "Cliente excluído com sucesso.";    
            return true;
        } catch (SQLException ex) {
            mensagem = "Erro ao tentar excluir o Cliente"
                    + ex.getMessage();
            return false;
        }
    }
    
    public ArrayList<Cliente> selecionarTodos(){
        try {
            String strSQL = "select * from Clientes;";
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery(strSQL);
           
            while(resultSet.next()){
                int cod;
                String nome, telefone, email;
                
                nome = resultSet.getString(1);
                telefone = resultSet.getString(2);
                email = resultSet.getString(3);
                cod = resultSet.getInt(4);
                Cliente listCliente = new Cliente(nome, telefone, email, cod);
                
                clientes.add(listCliente);
               
            }
                    
            mensagem = "Consulta realizada com sucesso.";
            return clientes;
        } catch (SQLException ex) {
            mensagem = "Erro durante a realização da consulta.";
            return null;
        }
    }
    
    public boolean alterar(Cliente cliente){
        try {
            String strSQL = "update cliente set ";
            strSQL += "nome = ?, telefone = ? , email = ?";
            strSQL += "where cod_cliente = " + cliente.getCod();
            strSQL += ";";
            PreparedStatement preparedStatement
                    = conexao.prepareStatement(strSQL);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getTelefone());
            preparedStatement.setString(3, cliente.getEmail());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            mensagem = "Alterações realizadas com sucesso.";
            return true;
        } catch (SQLException ex) {
            mensagem = "Erro ao tentar realizar as alterações: "
                    + ex.getMessage();
            return false;
        }
    }
    
    
    public String getMensagem() {
        return mensagem;
    }
    
}
