package com.mycompany.mercado.janelas;

import com.mycompany.mercado.controller.ControlePedidos;
import com.mycompany.mercado.modelos.Pedidos;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JanelaPedidos extends javax.swing.JInternalFrame {
    private ControlePedidos ctlPedidos;

    public JanelaPedidos() {
        ctlPedidos = new ControlePedidos();
        initComponents();
        carregarTabelaPedidos();
    }
    
    private void carregarTabelaPedidos(){
        ControlePedidos controleClientes = new ControlePedidos();
        ArrayList<Pedidos> pedidos = controleClientes.selecionarTodos();
        DefaultTableModel modeloTabela = (DefaultTableModel) TabelaPedidos.getModel();
        modeloTabela.setRowCount(0);
        
        if (pedidos != null && !pedidos.isEmpty()){
            for (Pedidos pedidoAtual : pedidos){
                modeloTabela.addRow(new Object[]{
                    pedidoAtual.getCod_pedido(),
                    pedidoAtual.getCod_produto(),
                    pedidoAtual.getCod_cliente(),
                    pedidoAtual.getQuantidade(),
                    pedidoAtual.getData(),
        });
            }
        }else{
            JOptionPane.showMessageDialog(null, controleClientes.getMensagem());
        }
    }
    
    private Pedidos pegarPedido(){
        DefaultTableModel modeloTabela = (DefaultTableModel) TabelaPedidos.getModel();
        int numeroLinhaSelecionada = TabelaPedidos.getSelectedRow();
        if (numeroLinhaSelecionada < 0){
            JOptionPane.showMessageDialog(this, "Por favor, selecione um pedido.");
            return null;
        }
        
        int codPed =  (Integer) modeloTabela.getValueAt(numeroLinhaSelecionada, 0);
        int codProd =  (Integer) modeloTabela.getValueAt(numeroLinhaSelecionada, 1);
        int codCli =  (Integer) modeloTabela.getValueAt(numeroLinhaSelecionada, 2);
        
        int quantidade = (Integer) modeloTabela.getValueAt(numeroLinhaSelecionada, 3);
        String data = (String) modeloTabela.getValueAt(numeroLinhaSelecionada, 4);
        
        return new Pedidos(codPed, codProd, codCli, quantidade, data);
        
    }
    
    private void excluirPedido(){
        Pedidos pdt = pegarPedido();
        if (pdt != null){
            if (JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir o pedido de código " + pdt.getCod_pedido() + "?") == 0){
                ctlPedidos.excluir(pdt.getCod_pedido());
                JOptionPane.showMessageDialog(this, ctlPedidos.getMensagem());
                carregarTabelaPedidos();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCodProduto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaPedidos = new javax.swing.JTable();
        btnAdicionarPedido = new javax.swing.JButton();
        btnExcluirPedido = new javax.swing.JButton();
        lblCodProduto = new javax.swing.JLabel();
        lblQuantidade = new javax.swing.JLabel();
        txtQtde = new javax.swing.JTextField();
        lblCodCliente = new javax.swing.JLabel();
        txtCodCliente = new javax.swing.JTextField();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        TabelaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código pedido", "Código produto", "Código cliente", "Quantidade", "Data"
            }
        ));
        jScrollPane1.setViewportView(TabelaPedidos);

        btnAdicionarPedido.setText("Adicionar");
        btnAdicionarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarPedidoActionPerformed(evt);
            }
        });

        btnExcluirPedido.setText("Excluir");
        btnExcluirPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirPedidoActionPerformed(evt);
            }
        });

        lblCodProduto.setText("Código produto:");

        lblQuantidade.setText("Quantidade");

        lblCodCliente.setText("Código cliente:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCodCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblCodProduto, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblQuantidade, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtCodProduto)
                                    .addComponent(txtQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnExcluirPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdicionarPedido))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantidade)
                    .addComponent(txtQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionarPedido))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodProduto))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCodCliente))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluirPedido)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarPedidoActionPerformed
        ctlPedidos.adicionarPedido(Integer.parseInt(txtCodProduto.getText()), Integer.parseInt(txtCodCliente.getText()), Integer.parseInt(txtQtde.getText()));
        JOptionPane.showMessageDialog(this, ctlPedidos.getMensagem());
        carregarTabelaPedidos();
    }//GEN-LAST:event_btnAdicionarPedidoActionPerformed

    private void btnExcluirPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirPedidoActionPerformed
        excluirPedido();
    }//GEN-LAST:event_btnExcluirPedidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaPedidos;
    private javax.swing.JButton btnAdicionarPedido;
    private javax.swing.JButton btnExcluirPedido;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodCliente;
    private javax.swing.JLabel lblCodProduto;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JTextField txtCodCliente;
    private javax.swing.JTextField txtCodProduto;
    private javax.swing.JTextField txtQtde;
    // End of variables declaration//GEN-END:variables
}
