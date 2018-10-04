/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.ConsultaDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.ObjConsulta;
import model.ObjFuncionario;

/**
 *
 * @author 181710038
 */
public class ListaConsultasSec extends javax.swing.JFrame {

    private ObjFuncionario medico;
    private TelaSecretaria telaSecretaria;
    
    public ListaConsultasSec(TelaSecretaria telaSecretaria, ObjFuncionario medico) {
        initComponents();
        this.telaSecretaria = telaSecretaria;
        this.medico = medico;
        
        carregarFormulario();
              //ObjFuncionario medico = (ObjFuncionario) lblMedico.getText().;
                carregarTabela(medico.getCodigo());
                
       // carregarTabela();
    }
    
    public void carregarFormulario (){
        
        lblMedico.setText( medico.getNome() );
    }
    
     public void carregarTabela(int codMedico){
        DefaultTableModel modelo = new DefaultTableModel();
        String[] colunas = {};
        colunas = new String[]{"Nome", "Sexo", "Data da Consulta", "Plano de Saúde"};
        modelo.setColumnIdentifiers( colunas );
        List<ObjConsulta> listaDePacientes = ConsultaDAO.getConsultasByMedicoID( codMedico );
        for (ObjConsulta con : listaDePacientes){
            
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
                data,
                con.getPaciente().getPlano_saude()
        
           
            };    
            modelo.addRow(obj);            
        }
        telaConsultas.setModel(modelo);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblMedico = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        telaConsultas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel1.setText("Medico: ");

        lblMedico.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        lblMedico.setText("Nome do guerreiro");

        telaConsultas.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        telaConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(telaConsultas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMedico)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMedico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMedico;
    private javax.swing.JTable telaConsultas;
    // End of variables declaration//GEN-END:variables
}
