package com.mycompany.mercado.bd;

import com.mycompany.mercado.modelos.Pedidos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 202212030002
 */
public class DadosPedido {
   private ArrayList<Pedidos> pedidos;
    private String mensagem;
    private Connection conexao;
    
    public DadosPedido(){
        pedidos = new ArrayList<>();
        conexao = ConexaoBanco.getInstancia().getConexao();
    }
    
    public boolean inserir(Pedidos pedido){
        try {
            String strSQL = "insert into pedidos "
                    + " (quantidade, cod_produto, cod_cliente) value "
                    + " (?, ?, ?)";
            try (PreparedStatement preparedStatement = conexao.prepareStatement(strSQL)) {
                preparedStatement.setInt(1, pedido.getQuantidade());
                preparedStatement.setInt(2, pedido.getCod_produto());
                preparedStatement.setInt(3, pedido.getCod_cliente());
                preparedStatement.executeUpdate();
            }
            mensagem = "Pedido feito com sucesso.";
            return true;
            
        } catch (SQLException ex) {
            mensagem = "Erro ao tentar realizar o pedido: "
                    + ex.getMessage();
            return false;
        }
    }
    
    
    public ArrayList<Pedidos> selecionarTodos(){
        try {
            String strSQL = "select * from Pedidos;";
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery(strSQL);
           
            while(resultSet.next()){
                int codPed, codProd, codCli, qtde;
                String data;
                
                codPed = resultSet.getInt(1);
                qtde = resultSet.getInt(2);
                data = resultSet.getString(3);
                codProd = resultSet.getInt(4);
                codCli = resultSet.getInt(5);
                
                Pedidos listPedidos = new Pedidos(codPed, codProd, codCli, qtde, data);
                
                pedidos.add(listPedidos);
            }
                    
            mensagem = "Consulta realizada com sucesso.";
            return pedidos;
        } catch (SQLException ex) {
            mensagem = "Erro durante a realização da consulta.\n" + ex.getMessage();
            return null;
        }
    }
    
    public boolean excluir(int cod){
        try {
            String strSQL = "delete from pedidos where "
                    + " cod_pedido = " + cod + ";";
            Statement statement = conexao.createStatement();
            statement.executeUpdate(strSQL);
            statement.close();
            
            mensagem = "Pedido excluído com sucesso.";    
            return true;
        } catch (SQLException ex) {
            mensagem = "Erro ao tentar excluir o Pedido"
                    + ex.getMessage();
            return false;
        }
    }
  
    public String getMensagem() {
        return mensagem;
    }
}
