/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.ConsultaDAO;
import dao.FuncionarioDAO;
import dao.PacienteDAO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ObjConsulta;
import model.ObjFuncionario;
import model.ObjPaciente;

/**
 *
 * @author 181710038
 */
public class TelaMedico1 extends javax.swing.JFrame {

    private List<ObjFuncionario> listaDeMedicos;
    
    private JDesktopPane painelTela;
    
    private List<ObjConsulta> listaDeConsultas;
    
    private ObjPaciente paciente;
    
    
    
    

    
    
    
    
    public TelaMedico1() {
        initComponents();
        carregarMedicos();
        
//        carregarTabela();
        
    }
    
    public TelaMedico1(JDesktopPane painelTela ){
            initComponents();
            carregarMedicos();
            int posicao = cbMedico.getSelectedIndex();
            if (posicao == 0 ){
            
            }else{
                
                ObjFuncionario medico = (ObjFuncionario) cbMedico.getSelectedItem();
                carregarTabela(medico.getCodigo());
           
           
        }
            
             this.painelTela = painelTela;

    }
    
    public TelaMedico1(String nome) {
        
        
    }
    
    public void carregarTabela(int codMedico){
        DefaultTableModel modelo = new DefaultTableModel();
        String[] colunas = {};
        colunas = new String[]{"Nome", "Sexo", "Idade", "Data da Consulta", "Plano de Saúde"};
        modelo.setColumnIdentifiers( colunas );
        listaDeConsultas = ConsultaDAO.getConsultasByMedicoID( codMedico );
        for (ObjConsulta con : listaDeConsultas){
        
            String data = con.getData_consulta().getDate()+"/"+(con.getData_consulta().getMonth()+1)+"/"+con.getData_consulta().getYear();
            
            String sexo = "";
            if (con.getPaciente().getSexo() == 1){
                sexo = "Masculino";
            }else{
                sexo = "Feminino";
            }
            
            Object[] obj = {
                con.getPaciente().getNome(),
                sexo,
                2018 - con.getPaciente().getNascimento().getYear(),
                data,
                con.getPaciente().getPlano_saude()
        
           
            };    
            modelo.addRow(obj);            
        }
        tablePacientes.setModel(modelo);
    }


    
    
    public void carregarMedicos (){
        
        listaDeMedicos = FuncionarioDAO.getMedicos();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        ObjFuncionario medico = new ObjFuncionario("Selecione...");
        listaDeMedicos.add(0, medico);
        
        for (ObjFuncionario med : listaDeMedicos){
            modelo.addElement(med);
        }
        cbMedico.setModel(modelo);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePacientes = new javax.swing.JTable();
        btnSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnLaudo = new javax.swing.JButton();
        cbMedico = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel2.setText("Médico:");

        tablePacientes.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        tablePacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablePacientes);

        btnSair.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jLabel1.setText("Consultas");

        btnLaudo.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        btnLaudo.setText("Laudo");
        btnLaudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaudoActionPerformed(evt);
            }
        });

        cbMedico.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        cbMedico.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMedicoItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(306, Short.MAX_VALUE)
                .addComponent(btnLaudo)
                .addGap(224, 224, 224)
                .addComponent(btnSair)
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(cbMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addComponent(jLabel2)
                            .addGap(0, 611, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 329, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLaudo)
                    .addComponent(btnSair))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2)
                    .addGap(54, 54, 54)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(52, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    private void btnLaudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaudoActionPerformed

        int linha = tablePacientes.getSelectedRow();
        if (linha == -1){
            JOptionPane.showMessageDialog(this, "Selecione uma consulta!");
        }else{
            int codigo = listaDeConsultas.get(linha).getCodigo();
            ListLaudo lau = new ListLaudo(codigo, this);
            lau.setVisible(true);
            
        }
    }//GEN-LAST:event_btnLaudoActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        TelaInicial ini = new TelaInicial();
        ini.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void cbMedicoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMedicoItemStateChanged
        int posicao = cbMedico.getSelectedIndex();
        if (posicao > 0){
            ObjFuncionario medico = (ObjFuncionario) cbMedico.getSelectedItem();
            carregarTabela(medico.getCodigo());
        }
        
    }//GEN-LAST:event_cbMedicoItemStateChanged

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLaudo;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox<String> cbMedico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePacientes;
    // End of variables declaration//GEN-END:variables
}