package com.mycompany.mercado.janelas;

import com.mycompany.mercado.controller.ControleClientes;
import com.mycompany.mercado.controller.ControleProdutos;
import com.mycompany.mercado.modelos.Cliente;
import com.mycompany.mercado.modelos.Produto;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author 202212030002
 */
public class JanelaProdutos extends javax.swing.JInternalFrame {
    private ControleProdutos ctlProdutos;
    
    public JanelaProdutos() {
        ctlProdutos = new ControleProdutos();
        initComponents();
        carregarTabelaProduto();
    }
    
    private void carregarTabelaProduto(){
        ControleProdutos controleprodutos = new ControleProdutos();
        ArrayList<Produto> produtos = controleprodutos.selecionarTodos();
        DefaultTableModel modeloTabela = (DefaultTableModel) TabelaProdutos.getModel();
        modeloTabela.setRowCount(0);
        
        if (produtos != null && !produtos.isEmpty()){
            for (Produto produtoAtual : produtos){
                modeloTabela.addRow(new Object[]{
                    produtoAtual.getCod(),
                    produtoAtual.getPreco(),
                    produtoAtual.getNome(),
                    produtoAtual.getQuantidade(),
                });
            }
        }else{
            JOptionPane.showMessageDialog(null, controleprodutos.getMensagem());
        }
    }
    
    private Produto pegarProduto(){
        DefaultTableModel modeloTabela = (DefaultTableModel) TabelaProdutos.getModel();
        int numeroLinhaSelecionada = TabelaProdutos.getSelectedRow();
        if (numeroLinhaSelecionada < 0){
            JOptionPane.showMessageDialog(this, "Por favor, selecione um produto.");
            return null;
        }
        int cod =  (Integer) modeloTabela.getValueAt(numeroLinhaSelecionada, 0);
        float preco = (float) modeloTabela.getValueAt(numeroLinhaSelecionada, 1);
        String nome = (String)modeloTabela.getValueAt(numeroLinhaSelecionada, 2);
        
        int quantidade = (Integer) modeloTabela.getValueAt(numeroLinhaSelecionada, 3);
        
        return new Produto(cod,quantidade,preco,nome);
    }
    
    private void excluirProduto(){
        Produto pdt = pegarProduto();
        if (pdt != null){
            if (JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir o Produto " + pdt.getNome() + "?") == 0){
                ctlProdutos.excluir(pdt.getCod());
                JOptionPane.showMessageDialog(this, ctlProdutos.getMensagem());
                carregarTabelaProduto();
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtQuantidade = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaProdutos = new javax.swing.JTable();
        btnAdicionarProduto = new javax.swing.JButton();
        btnEditarProduto = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        btnApagarProduto = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        lblQuantidade = new javax.swing.JLabel();
        lblPreco = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        TabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "cod", "Preço", "Nome", "Quantidade"
            }
        ));
        jScrollPane1.setViewportView(TabelaProdutos);

        btnAdicionarProduto.setText("Adicionar");
        btnAdicionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarProdutoActionPerformed(evt);
            }
        });

        btnEditarProduto.setText("Editar");
        btnEditarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProdutoActionPerformed(evt);
            }
        });

        lblNome.setText("Nome:");

        btnApagarProduto.setText("Apagar");
        btnApagarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarProdutoActionPerformed(evt);
            }
        });

        lblQuantidade.setText("Quantidade:");

        lblPreco.setText("Preço:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblQuantidade, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblPreco)
                                .addComponent(lblNome)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                            .addComponent(txtPreco)
                            .addComponent(txtNome))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAdicionarProduto)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(btnApagarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionarProduto)
                    .addComponent(btnEditarProduto))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPreco)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnApagarProduto))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuantidade))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarProdutoActionPerformed
       boolean inseriu = ctlProdutos.adicionarProduto(Integer.parseInt(txtQuantidade.getText()), Float.parseFloat(txtPreco.getText()), txtNome.getText());
       JOptionPane.showMessageDialog(this, ctlProdutos.getMensagem()); 
       DefaultTableModel cliente = (DefaultTableModel) TabelaProdutos.getModel();
        Object [] dados = {txtNome.getText(), txtPreco.getText(), txtQuantidade.getText()};
        cliente.addRow(dados);
       carregarTabelaProduto();
    }//GEN-LAST:event_btnAdicionarProdutoActionPerformed

    private void btnApagarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarProdutoActionPerformed
        excluirProduto();
    }//GEN-LAST:event_btnApagarProdutoActionPerformed

    private void btnEditarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProdutoActionPerformed
        Produto novoProduto = pegarProduto();
        
        if (novoProduto != null){
            String novoNome = txtNome.getText();
            float novoPreco = Float.parseFloat(txtPreco.getText());
            int novaQuantidade = Integer.parseInt(txtQuantidade.getText());
            
            if (novoNome.isEmpty() || txtPreco.getText().isEmpty() || txtQuantidade.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");
                return;
            }
            
            novoProduto.setNome(novoNome);
            novoProduto.setQuantidade(novaQuantidade);
            novoProduto.setPreco(novoPreco);
            
            boolean editou = ctlProdutos.editar(novoProduto);
            
            JOptionPane.showMessageDialog(this, ctlProdutos.getMensagem());
            
            carregarTabelaProduto();
        }
    }//GEN-LAST:event_btnEditarProdutoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaProdutos;
    private javax.swing.JButton btnAdicionarProduto;
    private javax.swing.JButton btnApagarProduto;
    private javax.swing.JButton btnEditarProduto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
