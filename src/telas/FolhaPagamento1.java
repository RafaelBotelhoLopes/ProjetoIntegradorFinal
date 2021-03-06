/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.ConsultaDAO;
import dao.FuncionarioDAO;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ObjConsulta;
import model.ObjFuncionario;

/**
 *
 * @author 181710038
 */
public class FolhaPagamento1 extends javax.swing.JFrame {

    private List<ObjFuncionario> listaDeFuncionarios, listaPagamento;
    private JDesktopPane telaPagamento;
    
    /**
     * Creates new form Tela01
     */
    public FolhaPagamento1(){
        initComponents();
        carregarFuncionarios();
    }
    
    public FolhaPagamento1(JDesktopPane telaPagamento) {
        initComponents();
        carregarFuncionarios();
        //carregarTabela(codCargo);
        this.telaPagamento = telaPagamento;
        
    }
    
    public void carregarFuncionarios (){
        
        listaDeFuncionarios = FuncionarioDAO.getFuncionarios();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        ObjFuncionario funcionario = new ObjFuncionario("Selecione...");
        listaDeFuncionarios.add(0, funcionario);
        
        for (ObjFuncionario fun : listaDeFuncionarios){
            modelo.addElement(fun);
        }
        cbListaFun.setModel(modelo);
        
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
        cbListaFun = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtHoras = new javax.swing.JTextField();
        btnCalcular = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPag = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Folha de Pagamento");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel1.setText("Selecione o funcionário:");

        cbListaFun.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        cbListaFun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbListaFunActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel2.setText("Horas trabalhadas:");

        txtHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHorasActionPerformed(evt);
            }
        });

        btnCalcular.setFont(new java.awt.Font("Cambria", 1, 11)); // NOI18N
        btnCalcular.setText("CALCULAR");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        tabelaPag.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaPag.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabelaPag);
        if (tabelaPag.getColumnModel().getColumnCount() > 0) {
            tabelaPag.getColumnModel().getColumn(0).setResizable(false);
            tabelaPag.getColumnModel().getColumn(1).setResizable(false);
            tabelaPag.getColumnModel().getColumn(2).setResizable(false);
            tabelaPag.getColumnModel().getColumn(3).setResizable(false);
            tabelaPag.getColumnModel().getColumn(4).setResizable(false);
            tabelaPag.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel3.setIcon(new javax.swing.ImageIcon("T:\\Prints tech\\zoio2.png")); // NOI18N
        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(310, 310, 310))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbListaFun, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtHoras)))
                        .addContainerGap(216, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(10, 10, 10))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbListaFun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbListaFunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbListaFunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbListaFunActionPerformed

    private void txtHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHorasActionPerformed
        
        
        
        
    }//GEN-LAST:event_txtHorasActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed

        int posicao = cbListaFun.getSelectedIndex();
        
        if (posicao == 0){
            JOptionPane.showMessageDialog(this, "Selecione um funcionário!");
        }else{
        
        ObjFuncionario fun = (ObjFuncionario) cbListaFun.getSelectedItem();
        carregarTabela(fun.getCodigo());
        cbListaFun.setSelectedIndex(0);
        txtHoras.setText("");
        }
    }//GEN-LAST:event_btnCalcularActionPerformed

//    private JDesktopPane painelFolhaPagamento;
    
    
    
    
    
    public void carregarTabela(int codCargo){
        DefaultTableModel modelo = new DefaultTableModel();
        String[] colunas = {"Salário Base", "Horas Trabalhadas", "INSS", "IRRF", "Salario Liquido", "Valor Total", "FGTS"};
        modelo.setColumnIdentifiers(colunas);
        ObjFuncionario fun = FuncionarioDAO.getSalarioByCargo(codCargo);
        double horas = Double.valueOf(txtHoras.getText());
        double salBruto = fun.getCargo().getSalario() / 220 * horas;
        double INSS = 0;
        double IRRF = 0;
        double FGTS = salBruto / 100 *8;
        
        
        if (salBruto < 1693.73){
            INSS = salBruto /100 * 8;
        }
        if (salBruto >= 1693.73 && salBruto <= 2822.90){
            INSS = salBruto /100 * 9;
        }
        if (salBruto > 2822.90 && salBruto <=  5645.80){
            INSS = salBruto /100 * 11;
        }
        if (salBruto >  5645.80){
            INSS = 5645.80 /100 * 11;
        }
        
        
        if (salBruto - INSS <= 1903.98){
            IRRF = 0;
        }
        if (salBruto - INSS > 1903.98 && salBruto - INSS <= 2826.65){
            IRRF = (salBruto - INSS)/100 * 7.5;
        }
        if (salBruto - INSS > 2826.65 && salBruto - INSS <= 3751.05){
            IRRF = (salBruto - INSS)/100 * 15;
        }
        if (salBruto - INSS > 3751.05 && salBruto - INSS <= 4664.68){
            IRRF = (salBruto - INSS)/100 * 22.5;
        }
        if (salBruto - INSS > 4664.68){
            IRRF = (salBruto - INSS)/100 * 27.5;
        }
        double salLiquido = salBruto-INSS-IRRF;
        double valorTotal = salLiquido;
        
        DecimalFormat df = new DecimalFormat("#,###.00");
        
         
            Object[] obj = {
                df.format(salBruto),
                txtHoras.getText(),
                df.format(INSS),
                df.format(IRRF),
                df.format(salLiquido),
                df.format(valorTotal),
                df.format(FGTS)
                
                
        
           
            };    
            modelo.addRow(obj);            
   //     }
            tabelaPag.setModel(modelo);
    }
                
     
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JComboBox<String> cbListaFun;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaPag;
    private javax.swing.JTextField txtHoras;
    // End of variables declaration//GEN-END:variables
}
