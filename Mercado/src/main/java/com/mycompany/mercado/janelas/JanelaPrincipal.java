package com.mycompany.mercado.janelas;

import com.mycompany.mercado.controller.ControleConexaoBanco;
import javax.swing.JOptionPane;

public class JanelaPrincipal extends javax.swing.JFrame {
    private ControleConexaoBanco controleConexaoBanco;

    public JanelaPrincipal() {
        controleConexaoBanco = ControleConexaoBanco.getInstancia();
        initComponents();
        if (controleConexaoBanco.conectarBanco()){
            setTitle("Mercado - conectado ao banco de dados");
        }else{
            setTitle("Mercado - não conectado");
            mostrarMensagemConexao();
        }
    }
    
    private void mostrarMensagemConexao(){
        JOptionPane.showMessageDialog(this, controleConexaoBanco.getMensagem());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DesktopPane = new javax.swing.JDesktopPane();
        MenuBar = new javax.swing.JMenuBar();
        MenuCliente = new javax.swing.JMenu();
        EdtCliente = new javax.swing.JMenuItem();
        MenuProduto = new javax.swing.JMenu();
        EdtProduto = new javax.swing.JMenuItem();
        MenuPedido = new javax.swing.JMenu();
        EdtPedido = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout DesktopPaneLayout = new javax.swing.GroupLayout(DesktopPane);
        DesktopPane.setLayout(DesktopPaneLayout);
        DesktopPaneLayout.setHorizontalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        DesktopPaneLayout.setVerticalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        MenuCliente.setText("Cliente");

        EdtCliente.setText("Editar Cliente");
        EdtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EdtClienteActionPerformed(evt);
            }
        });
        MenuCliente.add(EdtCliente);

        MenuBar.add(MenuCliente);

        MenuProduto.setText("Produto");

        EdtProduto.setText("Editar Produto");
        EdtProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EdtProdutoActionPerformed(evt);
            }
        });
        MenuProduto.add(EdtProduto);

        MenuBar.add(MenuProduto);

        MenuPedido.setText("Pedido");

        EdtPedido.setText("Editar Pedido");
        EdtPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EdtPedidoActionPerformed(evt);
            }
        });
        MenuPedido.add(EdtPedido);

        MenuBar.add(MenuPedido);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DesktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DesktopPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EdtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EdtClienteActionPerformed
        // TODO add your handling code here:
        JanelaCliente janelacliente = new JanelaCliente();
        DesktopPane.add(janelacliente);
        janelacliente.setVisible(true);
 
    }//GEN-LAST:event_EdtClienteActionPerformed

    private void EdtProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EdtProdutoActionPerformed
        // TODO add your handling code here:
        JanelaProdutos janelaproduto = new JanelaProdutos();
        DesktopPane.add(janelaproduto);
        janelaproduto.setVisible(true);
    }//GEN-LAST:event_EdtProdutoActionPerformed

    private void EdtPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EdtPedidoActionPerformed
        // TODO add your handling code here:
        JanelaPedidos janelapedido = new JanelaPedidos();
        DesktopPane.add(janelapedido);
        janelapedido.setVisible(true);
    }//GEN-LAST:event_EdtPedidoActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DesktopPane;
    private javax.swing.JMenuItem EdtCliente;
    private javax.swing.JMenuItem EdtPedido;
    private javax.swing.JMenuItem EdtProduto;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenu MenuCliente;
    private javax.swing.JMenu MenuPedido;
    private javax.swing.JMenu MenuProduto;
    // End of variables declaration//GEN-END:variables
}
