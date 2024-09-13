package com.mycompany.mercado.janelas;

import com.mycompany.mercado.controller.ControlePedidos;
import com.mycompany.mercado.modelos.Pedidos;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JanelaPedidos extends javax.swing.JInternalFrame {
    private ControlePedidos ctlPedidos;

    /**
     * Creates new form JanelaPedidos
     */
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCodProduto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaPedidos = new javax.swing.JTable();
        btnAdicionarPedido = new javax.swing.JButton();
        btnPesquisarPedido = new javax.swing.JButton();
        lblData = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
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
                "Data", "Quantidade", "Código produto", "Código cliente"
            }
        ));
        jScrollPane1.setViewportView(TabelaPedidos);

        btnAdicionarPedido.setText("Adicionar");
        btnAdicionarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarPedidoActionPerformed(evt);
            }
        });

        btnPesquisarPedido.setText("Pesquisar");

        lblData.setText("Data:");

        lblCodProduto.setText("Código produto:");

        lblQuantidade.setText("Quantidade");

        lblCodCliente.setText("Código cliente:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
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
                                    .addComponent(lblData, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCodProduto, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblQuantidade, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtCodProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                    .addComponent(txtQtde)
                                    .addComponent(txtData))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdicionarPedido)
                            .addComponent(btnPesquisarPedido))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblData)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionarPedido))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantidade)
                    .addComponent(txtQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarPedido))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodProduto))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodCliente))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarPedidoActionPerformed
        ctlPedidos.adicionarPedido(Integer.parseInt(txtCodProduto.getText()), Integer.parseInt(txtCodCliente.getText()), Integer.parseInt(txtQtde.getText()), txtData.getText());
        JOptionPane.showMessageDialog(this, ctlPedidos.getMensagem());
        carregarTabelaPedidos();
    }//GEN-LAST:event_btnAdicionarPedidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaPedidos;
    private javax.swing.JButton btnAdicionarPedido;
    private javax.swing.JButton btnPesquisarPedido;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodCliente;
    private javax.swing.JLabel lblCodProduto;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JTextField txtCodCliente;
    private javax.swing.JTextField txtCodProduto;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtQtde;
    // End of variables declaration//GEN-END:variables
}
