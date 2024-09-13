package com.mycompany.mercado.janelas;

import com.mycompany.mercado.controller.ControleClientes;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JanelaCliente extends javax.swing.JInternalFrame {
    private ControleClientes ctlClientes;

    public JanelaCliente() {
        ctlClientes = new ControleClientes();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaClientes = new javax.swing.JTable();
        btnAdicionarCliente = new javax.swing.JButton();
        btnEditarCliente = new javax.swing.JButton();
        btnPesquisarCliente = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        btnApagarCliente = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();

        TabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Telefone", "E-mail"
            }
        ));
        jScrollPane1.setViewportView(TabelaClientes);

        btnAdicionarCliente.setText("Adicionar");
        btnAdicionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarClienteActionPerformed(evt);
            }
        });

        btnEditarCliente.setText("Editar");

        btnPesquisarCliente.setText("Pesquisar");

        lblNome.setText("Nome:");

        btnApagarCliente.setText("Apagar");

        lblEmail.setText("E-mail:");

        lblTelefone.setText("Telefone:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTelefone)
                            .addComponent(lblNome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                            .addComponent(txtTelefone)
                            .addComponent(txtNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdicionarCliente)
                                .addGap(18, 18, 18)
                                .addComponent(btnPesquisarCliente))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnApagarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionarCliente)
                    .addComponent(btnPesquisarCliente))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefone)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarCliente)
                    .addComponent(btnApagarCliente))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarClienteActionPerformed

        boolean inseriu = ctlClientes.adicionarCliente(txtNome.getText(), txtTelefone.getText(), txtEmail.getText());
        // parei aqui
        JOptionPane.showMessageDialog(this, ctlClientes.getMensagem());   
        
    }//GEN-LAST:event_btnAdicionarClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaClientes;
    private javax.swing.JButton btnAdicionarCliente;
    private javax.swing.JButton btnApagarCliente;
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JButton btnPesquisarCliente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
