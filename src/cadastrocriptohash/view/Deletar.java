/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrocriptohash.view;

import cadastrocriptohash.model.BuscaCep;
import cadastrocriptohash.model.PessoaEntity;
import cadastrocriptohash.repository.PessoaRep;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author victor
 */
public class Deletar extends javax.swing.JFrame {

    /**
     * Creates new form Cadastro
     */
    public Deletar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDeletar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnPesquisaCpf = new javax.swing.JButton();
        btnPesquisaNome = new javax.swing.JButton();
        txtPesquisaCPF = new javax.swing.JFormattedTextField();
        txtPesquisaNome = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtComplemento = new javax.swing.JTextField();
        txtMunicipio = new javax.swing.JTextField();
        txtUF = new javax.swing.JTextField();
        txtCPF = new javax.swing.JFormattedTextField();
        txtCEP = new javax.swing.JFormattedTextField();
        txtRG = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 456, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consultar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPesquisaCpf.setText("Pesquisar Cpf");
        btnPesquisaCpf.setMaximumSize(new java.awt.Dimension(125, 23));
        btnPesquisaCpf.setMinimumSize(new java.awt.Dimension(125, 23));
        btnPesquisaCpf.setPreferredSize(new java.awt.Dimension(125, 23));
        btnPesquisaCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaCpfActionPerformed(evt);
            }
        });
        jPanel2.add(btnPesquisaCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 85, 140, -1));

        btnPesquisaNome.setText("Pesquisar Nome");
        btnPesquisaNome.setMaximumSize(new java.awt.Dimension(125, 23));
        btnPesquisaNome.setMinimumSize(new java.awt.Dimension(125, 23));
        btnPesquisaNome.setPreferredSize(new java.awt.Dimension(125, 23));
        btnPesquisaNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaNomeActionPerformed(evt);
            }
        });
        jPanel2.add(btnPesquisaNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 60, 140, -1));

        try {
            txtPesquisaCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtPesquisaCPF.setText("");
        jPanel2.add(txtPesquisaCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 85, 100, -1));
        jPanel2.add(txtPesquisaNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 60, 100, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pessoa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel1.setMinimumSize(new java.awt.Dimension(235, 328));
        jPanel1.setPreferredSize(new java.awt.Dimension(235, 328));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setText("UF");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 283, -1, -1));

        jLabel10.setText("RG");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 80, -1, -1));

        jLabel1.setText("CPF");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 51, -1, -1));

        jLabel2.setText("Nome");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 22, 40, -1));

        jLabel3.setText("CEP");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 109, -1, -1));

        jLabel4.setText("Endereço");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 138, -1, -1));

        jLabel5.setText("Número");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 167, -1, -1));

        jLabel6.setText("Bairro");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 196, -1, -1));

        jLabel7.setText("Complemento");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 225, -1, -1));

        jLabel8.setText("Município");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 254, -1, -1));

        txtNome.setEditable(false);
        jPanel1.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 19, 107, -1));

        txtEndereco.setEditable(false);
        jPanel1.add(txtEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 135, 107, -1));

        txtNumero.setEditable(false);
        jPanel1.add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 164, 107, -1));

        txtBairro.setEditable(false);
        jPanel1.add(txtBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 193, 107, -1));

        txtComplemento.setEditable(false);
        jPanel1.add(txtComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 222, 107, -1));

        txtMunicipio.setEditable(false);
        jPanel1.add(txtMunicipio, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 251, 107, -1));

        txtUF.setEditable(false);
        jPanel1.add(txtUF, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 280, 107, -1));

        txtCPF.setEditable(false);
        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPF.setText("");
        jPanel1.add(txtCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 48, 107, -1));

        txtCEP.setEditable(false);
        try {
            txtCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(txtCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 106, 107, -1));

        txtRG.setEditable(false);
        txtRG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRGKeyReleased(evt);
            }
        });
        jPanel1.add(txtRG, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 77, 107, -1));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 115, 250, -1));

        txtId.setEditable(false);
        txtId.setText("Id");
        jPanel2.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 31, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 280, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public static String maxlength(String str) {
            String valor = "";
            if(str.length() > 11){
	        valor = str.substring(0,11);
                str = valor;
            }
	    return str;
    } 
    
    private void btnPesquisaNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaNomeActionPerformed
        if (txtPesquisaNome.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Insira um nome para Pesquisa");
        }else{
            PessoaRep pessoa = new PessoaRep();
            ArrayList<PessoaEntity> listaPessoas = new PessoaRep().listarPorNomeDA(txtPesquisaNome.getText());
            
            for (int i = 0; i < listaPessoas.size(); i++) {
                pessoa.setId(listaPessoas.get(i).getId());
                txtNome.setText(listaPessoas.get(i).getNome());
                txtCPF.setText((listaPessoas.get(i).getCpf()));
                txtRG.setText((listaPessoas.get(i).getRg()));
                txtCEP.setText((listaPessoas.get(i).getCep()));
                txtEndereco.setText((listaPessoas.get(i).getEndereco()));
                txtNumero.setText((listaPessoas.get(i).getNumero()));
                txtBairro.setText((listaPessoas.get(i).getBairro()));
                txtComplemento.setText((listaPessoas.get(i).getComplemento()));
                txtMunicipio.setText((listaPessoas.get(i).getMunicipio()));
                txtUF.setText((listaPessoas.get(i).getUf()));
            }
            txtId.setText(pessoa.getId().toString());
        }
    }//GEN-LAST:event_btnPesquisaNomeActionPerformed

    private void btnPesquisaCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaCpfActionPerformed
        
        if (txtPesquisaCPF.getText().equals("   .   .   -  ")) {
            JOptionPane.showMessageDialog(this, "Insira um Cpf para Pesquisa");
            
        }else{
            PessoaRep pessoa = new PessoaRep();
            ArrayList<PessoaEntity> listaPessoas = new PessoaRep().listarPorCPFDA(txtPesquisaCPF.getText());

            for (int i = 0; i < listaPessoas.size(); i++) {
                pessoa.setId(listaPessoas.get(i).getId());
                txtNome.setText(listaPessoas.get(i).getNome());
                txtCPF.setText((listaPessoas.get(i).getCpf()));
                txtRG.setText((listaPessoas.get(i).getRg()));
                txtCEP.setText((listaPessoas.get(i).getCep()));
                txtEndereco.setText((listaPessoas.get(i).getEndereco()));
                txtNumero.setText((listaPessoas.get(i).getNumero()));
                txtBairro.setText((listaPessoas.get(i).getBairro()));
                txtComplemento.setText((listaPessoas.get(i).getComplemento()));
                txtMunicipio.setText((listaPessoas.get(i).getMunicipio()));
                txtUF.setText((listaPessoas.get(i).getUf()));
            }
            txtId.setText(pessoa.getId().toString());
        }
    }//GEN-LAST:event_btnPesquisaCpfActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        if(txtId.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Id Não encontrado");
        }else {
            
            PessoaRep pessoa = new PessoaRep();
            pessoa.setId(Integer.parseInt(txtId.getText()));
                                    
            pessoa.excluir(pessoa);
            
            txtBairro.setText("");
            txtCEP.setText("");
            txtCPF.setText("");
            txtComplemento.setText("");
            txtEndereco.setText("");
            txtId.setText("");
            txtMunicipio.setText("");
            txtNome.setText("");
            txtNumero.setText("");
            txtPesquisaCPF.setText("");
            txtPesquisaNome.setText("");
            txtRG.setText("");
            txtUF.setText("");
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void txtRGKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRGKeyReleased
        txtRG.setText(maxlength(txtRG.getText()));
    }//GEN-LAST:event_txtRGKeyReleased

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
            java.util.logging.Logger.getLogger(Deletar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Deletar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Deletar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Deletar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Deletar().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnPesquisaCpf;
    private javax.swing.JButton btnPesquisaNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCEP;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtComplemento;
    public javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtId;
    public javax.swing.JTextField txtMunicipio;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JFormattedTextField txtPesquisaCPF;
    private javax.swing.JTextField txtPesquisaNome;
    private javax.swing.JTextField txtRG;
    public javax.swing.JTextField txtUF;
    // End of variables declaration//GEN-END:variables
}
