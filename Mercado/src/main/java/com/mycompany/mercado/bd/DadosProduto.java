/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mercado.bd;

import com.mycompany.mercado.modelos.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DadosProduto {
    private ArrayList<Produto> produtos;
    private String mensagem;
    private Connection conexao;
    

    public DadosProduto() {
        produtos = new ArrayList<>();
        mensagem = "";
        conexao = ConexaoBanco.getInstancia().getConexao();
    }
    
    public boolean adicionar(Produto produto){
        try {
            String strSQL = "insert into Produtos (preco, nome_produto, quantidade_estoque) "
                    + " value (?, ?, ?);";
            try (PreparedStatement preparedStatement = conexao.prepareStatement(strSQL)) {
                preparedStatement.setFloat(1, produto.getPreco());
                preparedStatement.setString(2, produto.getNome());
                preparedStatement.setInt(3, produto.getQuantidade());
                preparedStatement.executeUpdate();
            }
            
            mensagem = "O Produto foi inserido com sucesso.";
            return true;
        } catch (SQLException ex) {
            mensagem = "Não foi possível inserir o Produto"
                    + ex.getMessage();
            return false;
        }
    }
    
    public boolean excluir(int cod){
        try {
            String strSQL = "delete from departamento where "
                    + " cod_pedido = " + cod + ";";
            Statement statement = conexao.createStatement();
            statement.executeUpdate(strSQL);
            statement.close();
            
            mensagem = "Produto excluído com sucesso.";    
            return true;
        } catch (SQLException ex) {
            mensagem = "Erro ao tentar excluir o Produto"
                    + ex.getMessage();
            return false;
        }
    }
    
    public ArrayList<Produto> selecionarTodos(){
        try {
            String strSQL = "select * from Produtos;";
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery(strSQL);
           
            while(resultSet.next()){
                int cod, quantidade;
                float preco;
                String nome;
                
                cod = resultSet.getInt(1);
                quantidade= resultSet.getInt(2);
                preco = resultSet.getFloat(3);
                nome = resultSet.getString(4);
                Produto listProduto = new Produto(cod, quantidade, preco, nome);
                
                produtos.add(listProduto);
               
            }
                    
            mensagem = "Consulta realizada com sucesso.";
            return produtos;
        } catch (SQLException ex) {
            mensagem = "Erro durante a realização da consulta.";
            return null;
        }
    }
    
    public boolean alterar(Produto produto){
        try {
            String strSQL = "update Produtos set ";
            strSQL += "preco = ?, nome_produto = ? , quantidade_estoque = ?";
            strSQL += "where cod_produto = " + produto.getCod();
            strSQL += ";";
            try (PreparedStatement preparedStatement = conexao.prepareStatement(strSQL)) {
                preparedStatement.setFloat(1, produto.getPreco());
                preparedStatement.setString(2, produto.getNome());
                preparedStatement.setInt(3, produto.getQuantidade());
                preparedStatement.executeUpdate();
            }
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
