package com.mycompany.mercado.janelas;

import com.mycompany.mercado.controller.ControleClientes;
import com.mycompany.mercado.modelos.Cliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JanelaCliente extends javax.swing.JInternalFrame {
    private ControleClientes ctlClientes;

    public JanelaCliente() {
        ctlClientes = new ControleClientes();
        initComponents();
        carregarTabelaClientes();
    }
    
    private Cliente pegarCliente(){
        DefaultTableModel modeloTabela = (DefaultTableModel) TabelaClientes.getModel();
        int numeroLinhaSelecionada = TabelaClientes.getSelectedRow();
        if (numeroLinhaSelecionada < 0){
            JOptionPane.showMessageDialog(this, "Por favor, selecione um cliente.");
            return null;
        }
        int cod =  (Integer) modeloTabela.getValueAt(numeroLinhaSelecionada, 0);
        String nome = (String) modeloTabela.getValueAt(numeroLinhaSelecionada, 1);
        String telefone = (String) modeloTabela.getValueAt(numeroLinhaSelecionada, 2);
        String email = (String) modeloTabela.getValueAt(numeroLinhaSelecionada, 3);
        return new Cliente(cod, nome,telefone,email);
        
    }
    
    private void carregarTabelaClientes(){
        ControleClientes controleClientes = new ControleClientes();
        ArrayList<Cliente> clientes = controleClientes.selecionarTodos();
        DefaultTableModel modeloTabela = (DefaultTableModel) TabelaClientes.getModel();
        modeloTabela.setRowCount(0);
        
        if (clientes != null && !clientes.isEmpty()){
            for (Cliente clienteAtual : clientes){
                modeloTabela.addRow(new Object[]{
                    clienteAtual.getCod(),
                    clienteAtual.getNome(),
                    clienteAtual.getTelefone(),
                    clienteAtual.getEmail(),
                });
            }
        }else{
            JOptionPane.showMessageDialog(null, controleClientes.getMensagem());
        }
    }
    
    private void excluirCliente(){
        Cliente clt = pegarCliente();
        if (clt != null){
            if (JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir o Cliente " + clt.getNome() + "?") == 0){
                ctlClientes.excluir(clt.getCod());
                JOptionPane.showMessageDialog(this, ctlClientes.getMensagem());
                carregarTabelaClientes();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaClientes = new javax.swing.JTable();
        btnAdicionarCliente = new javax.swing.JButton();
        btnEditarCliente = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        btnApagarCliente = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        TabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Telefone", "E-mail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TabelaClientes);

        btnAdicionarCliente.setText("Adicionar");
        btnAdicionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarClienteActionPerformed(evt);
            }
        });

        btnEditarCliente.setText("Editar");
        btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClienteActionPerformed(evt);
            }
        });

        lblNome.setText("Nome:");

        btnApagarCliente.setText("Apagar");
        btnApagarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarClienteActionPerformed(evt);
            }
        });

        lblEmail.setText("E-mail:");

        lblTelefone.setText("Telefone:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAdicionarCliente)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(btnApagarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionarCliente)
                    .addComponent(btnEditarCliente))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefone)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnApagarCliente))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarClienteActionPerformed

        boolean inseriu = ctlClientes.adicionarCliente(txtNome.getText(), txtTelefone.getText(), txtEmail.getText());
        // parei aqui
        JOptionPane.showMessageDialog(this, ctlClientes.getMensagem());   
        DefaultTableModel cliente = (DefaultTableModel) TabelaClientes.getModel();
        Object [] dados = {txtNome.getText(), txtTelefone.getText(), txtEmail.getText()};
        cliente.addRow(dados);
        carregarTabelaClientes();
    }//GEN-LAST:event_btnAdicionarClienteActionPerformed

    private void btnApagarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarClienteActionPerformed
        excluirCliente();
    }//GEN-LAST:event_btnApagarClienteActionPerformed

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed
        Cliente clienteEditado = pegarCliente();
        
        if(clienteEditado != null){
            String novoNome = txtNome.getText();
            String novoTelefone = txtTelefone.getText();
            String novoEmail = txtEmail.getText();
            
            if (novoNome.isEmpty() || novoTelefone.isEmpty() || novoEmail.isEmpty()){
                JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");
                return;
            }
            
            clienteEditado.setNome(novoNome);
            clienteEditado.setTelefone(novoTelefone);
            clienteEditado.setEmail(novoEmail);
            
            boolean editou = ctlClientes.editar(clienteEditado);
            
            JOptionPane.showMessageDialog(this, ctlClientes.getMensagem());
            
            carregarTabelaClientes();
            
        }
    }//GEN-LAST:event_btnEditarClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaClientes;
    private javax.swing.JButton btnAdicionarCliente;
    private javax.swing.JButton btnApagarCliente;
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
