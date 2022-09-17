/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrocriptohash.view;

import cadastrocriptohash.model.PessoaEntity;
import cadastrocriptohash.repository.PessoaRep;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victor
 */
public class BuscarPorNome extends javax.swing.JFrame {

    /**
     * Creates new form BuscarPorNome
     */
    public BuscarPorNome() {
        initComponents();
        addTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtPesquisaNome = new javax.swing.JTextField();
        btnPesquisaNome = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPessoa = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Nome");
        setMinimumSize(new java.awt.Dimension(417, 357));
        setName("Pesquisarnome"); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPesquisaNome.setText("Pesquisar Nome");
        btnPesquisaNome.setMaximumSize(new java.awt.Dimension(125, 23));
        btnPesquisaNome.setMinimumSize(new java.awt.Dimension(125, 23));
        btnPesquisaNome.setPreferredSize(new java.awt.Dimension(125, 23));
        btnPesquisaNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaNomeActionPerformed(evt);
            }
        });

        tblPessoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblPessoa);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 399, 342));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisaNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaNomeActionPerformed
        DefaultTableModel model =(DefaultTableModel) tblPessoa.getModel();
        model.setRowCount(0);
        if (txtPesquisaNome.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Insira um nome para Pesquisa");
        }else{
            addLinhaTabela();
        }
    }//GEN-LAST:event_btnPesquisaNomeActionPerformed
    public class tabelaPessoa{
            String nome;
            String cpf;
            String rg;
            String cep;

        public tabelaPessoa(String nome, String cpf, String rg, String cep) {
            this.nome = nome;
            this.cpf = cpf;
            this.rg = rg;
            this.cep = cep;
        }

                  
    }
    
    public ArrayList ListarPessoas(){
        
        PessoaRep pessoa = new PessoaRep();

        ArrayList<tabelaPessoa> lista = new ArrayList<>();
        
        ArrayList<PessoaEntity> listaPessoas = new PessoaRep().listarPorNome(txtPesquisaNome.getText());

            for (int i = 0; i < listaPessoas.size(); i++) {
                pessoa.setNome(listaPessoas.get(i).getNome());
                pessoa.setCpf(listaPessoas.get(i).getCpf());
                pessoa.setRg(listaPessoas.get(i).getRg());
                pessoa.setCep(listaPessoas.get(i).getCep());
            }
        tabelaPessoa tbpessoa = new tabelaPessoa(pessoa.getNome(), pessoa.getCpf(), pessoa.getRg(), pessoa.getCep());
        lista.add(tbpessoa);
        return lista;
    }
    private void addTabela(){
        DefaultTableModel model = new DefaultTableModel()
	{
		@Override
		public boolean isCellEditable(final int row, final int column) {
			return false;
		}
                
	};
        tblPessoa.setModel(model);
            model.addColumn("Nome");
            model.addColumn("Cpf");
            model.addColumn("Rg");
            model.addColumn("Cep");
           
    }
    
    public void addLinhaTabela(){
        DefaultTableModel model = (DefaultTableModel) tblPessoa.getModel();
        ArrayList<tabelaPessoa> lista = ListarPessoas();
        tblPessoa.removeAll();
        Object rowDaTa[] = new Object[6];
        for (int i = 0; i < lista.size(); i++) {
            rowDaTa[0] = lista.get(i).nome;
            rowDaTa[1] = lista.get(i).cpf;
            rowDaTa[2] = lista.get(i).rg;
            rowDaTa[3] = lista.get(i).cep;
            model.addRow(rowDaTa);
        }
    }
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(BuscarPorNome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarPorNome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarPorNome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarPorNome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarPorNome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisaNome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPessoa;
    private javax.swing.JTextField txtPesquisaNome;
    // End of variables declaration//GEN-END:variables
}
