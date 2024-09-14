package com.mycompany.mercado.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 202212030002
 */
public class ConexaoBanco {
    private String mensagem; 
    private String usuario;
    private String senha;
    private String url;
    private String driver;
    private Connection conexao;
    private static ConexaoBanco instancia = null;
    
    private ConexaoBanco(){
        usuario = "root";
        senha = "";
        url = "jdbc:mysql://127.0.0.1/mercadinho";
        driver = "com.mysql.cj.jdbc.Driver";
    }

   
    public String getMensagem() {
        return mensagem;
    }

    public static ConexaoBanco getInstancia() {
        if (instancia == null){
            instancia = new ConexaoBanco();
        }
        return instancia;
    }

    public Connection getConexao() {
        return conexao;
    }

    
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public boolean conectar(){
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(
                                        url,
                                        usuario,
                                        senha
                                    );
            String textoMensagem = "Conexão realizada com sucesso.";
            setMensagem(textoMensagem);
            
           return true;
        } catch (ClassNotFoundException | SQLException ex) {
            setMensagem("Erro: Não foi possível realizar a conexão.\n" + ex.getMessage());
            return false;
        }
    }
    
    public boolean desconectar(){
        if (conexao == null){
        
            setMensagem("O banco não está conectado.");
            return false;
        }else{
            try {
                conexao.close();
                setMensagem("O banco foi desconectado com sucesso.");
                return true;
            } catch (SQLException ex) {
                setMensagem("Não foi possível realizar a desconexão.");
                return false;
            }
        }
    }
}
