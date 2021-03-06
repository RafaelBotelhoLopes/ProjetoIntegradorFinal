/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.ConsultaDAO;
import dao.FuncionarioDAO;
import dao.PacienteDAO;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import model.ObjConsulta;
import model.ObjFuncionario;
import model.ObjPaciente;

/**
 *
 * @author 181710038
 */
public class FrmConsulta1 extends javax.swing.JFrame {

    /**
     * Creates new form FrmConsulta1
     */
    private ObjConsulta consulta;
    private ObjFuncionario medico;
    private TelaSecretaria telaSecretaria;
    private List<ObjPaciente> listaDePacientes;
    private boolean veioDaSecretaria;
    
    
//    public FrmConsulta1() {
//        initComponents();
//        lblMedico.setText("");
//        consulta = new ObjConsulta();
//        veioDaSecretaria = false;
//    }
    public FrmConsulta1 (TelaSecretaria telaSecretaria, ObjFuncionario medico){
        initComponents();
        this.medico = medico;
        carregarFormulario();
        carregarPacientes();
        this.telaSecretaria = telaSecretaria;
        veioDaSecretaria = true;
        
        
        
    }

    public void carregarFormulario (){
        
        lblMedico.setText( medico.getNome() );
    }
    
    public void carregarPacientes(){
        listaDePacientes = PacienteDAO.getPaciente();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        ObjPaciente pac = new ObjPaciente("Selecione...");
        listaDePacientes.add(0, pac);
        
        for (ObjPaciente paciente : listaDePacientes){
            modelo.addElement(paciente);
        }
        cbPaciente.setModel(modelo);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblMedico = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbPaciente = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtDataCon = new javax.swing.JFormattedTextField();
        btnSalvarCon = new javax.swing.JButton();
        btnLimparCon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Consulta");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 20)); // NOI18N
        jLabel1.setText("Médico:");

        lblMedico.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        lblMedico.setText("Nome do Médico");

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 20)); // NOI18N
        jLabel3.setText("Paciente:");

        cbPaciente.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        cbPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPacienteActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Cambria", 0, 20)); // NOI18N
        jLabel4.setText("Data da consulta:");

        try {
            txtDataCon.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("  ##  /  ##  /  ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataConActionPerformed(evt);
            }
        });

        btnSalvarCon.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnSalvarCon.setText("SALVAR");
        btnSalvarCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarConActionPerformed(evt);
            }
        });

        btnLimparCon.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnLimparCon.setText("LIMPAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMedico))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnSalvarCon, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnLimparCon, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataCon, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDataCon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblMedico))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbPaciente))
                        .addGap(31, 31, 31)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarCon, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimparCon, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarConActionPerformed

        ObjConsulta con = new ObjConsulta();
        con.setPaciente( (ObjPaciente) cbPaciente.getSelectedItem() );
        String sData = txtDataCon.getText();
        int dia = Integer.valueOf(  sData.substring(2, 4)   );
        int mes = Integer.valueOf(  sData.substring(9, 11)   );
        int ano = Integer.valueOf(  sData.substring(16, 20)   );
        Date data = new Date(ano, (mes - 1), dia);
        con.setData_consulta(data);
        con.setFuncionario(medico);
        
        ConsultaDAO.inserir(con);
        
        txtDataCon.setText("");
        
    }//GEN-LAST:event_btnSalvarConActionPerformed

    private void cbPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPacienteActionPerformed
        
                
    }//GEN-LAST:event_cbPacienteActionPerformed

    private void txtDataConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataConActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataConActionPerformed

    
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimparCon;
    private javax.swing.JButton btnSalvarCon;
    private javax.swing.JComboBox<String> cbPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblMedico;
    private javax.swing.JFormattedTextField txtDataCon;
    // End of variables declaration//GEN-END:variables
}
