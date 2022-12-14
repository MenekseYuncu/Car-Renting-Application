/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package arackiralama;

import Islemler.AracIslemleri;
import Islemler.KiralamaIslemleri;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import tablo.Kiralama;

/**
 *
 * @author baior
 */
public class KiralananTablo extends javax.swing.JFrame {
DefaultTableModel model;
    KiralamaIslemleri kiralamaIslemleri = new KiralamaIslemleri(); 
    AracIslemleri aracIslemleri =  new AracIslemleri();
    
    public KiralananTablo() {
        initComponents();
        
        model = (DefaultTableModel) jTable1.getModel(); 
        kiralamaListele();
    }

    public void kiralamaListele(){
        model.setRowCount(0);
        ArrayList<Kiralama> kiralamas = new ArrayList<Kiralama>();
        
        kiralamas = kiralamaIslemleri.BirlesikListele();

        
        if (kiralamas != null) {
            
            for (Kiralama kira : kiralamas) {
                
                String durum = "pasif";
                if (kira.getDurum()== 1) {
                    durum = "aktif";
                }
                
                Object[] eklenecek = {kira.getKiralamaID(), kira.getKullAdi(),kira.getPlaka(),kira.getAlisTarih(),
                kira.getVerisTarih(),kira.getTurar(),durum};
                model.addRow(eklenecek);
            }
        }
    }
    public void DinamikAra(String p){
        
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        
        jTable1.setRowSorter(tr);
        
        tr.setRowFilter(RowFilter.regexFilter(p));
        
    }
    /**
     * Creates new form KiralananTablo
     */
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtAra = new javax.swing.JTextField();
        sil = new javax.swing.JButton();
        pasif = new javax.swing.JButton();
        iptal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        txtAra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAraKeyReleased(evt);
            }
        });

        sil.setText("Sil");
        sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silActionPerformed(evt);
            }
        });

        pasif.setText("Pasif Yap");
        pasif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasifActionPerformed(evt);
            }
        });

        iptal.setText("İptal");
        iptal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iptalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(txtAra)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sil, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pasif, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                        .addComponent(iptal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtAra, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pasif, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sil, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(iptal, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silActionPerformed
       int selectetRow = jTable1.getSelectedRow();
        if (selectetRow == -1) {
            if (model.getRowCount() == 0) {
                System.out.println("boş");
            }else{
                System.out.println("seçiniz");
            }
        }else{
            
            int id = (int) model.getValueAt(selectetRow, 0);
            kiralamaIslemleri.sil(id);
            kiralamaListele();
        }
    }//GEN-LAST:event_silActionPerformed

    private void pasifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasifActionPerformed
       int selectetRow = jTable1.getSelectedRow();
        int id = (int) model.getValueAt(selectetRow, 0);
        
        kiralamaIslemleri.guncelle(0, id);
        kiralamaListele();
    }//GEN-LAST:event_pasifActionPerformed

    private void iptalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iptalActionPerformed
        Giris giris = new Giris();
        giris.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_iptalActionPerformed

    private void txtAraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAraKeyReleased
        String ara = txtAra.getText();
        DinamikAra(ara);
    }//GEN-LAST:event_txtAraKeyReleased

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
            java.util.logging.Logger.getLogger(KiralananTablo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KiralananTablo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KiralananTablo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KiralananTablo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new KiralananTablo().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton iptal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton pasif;
    private javax.swing.JButton sil;
    private javax.swing.JTextField txtAra;
    // End of variables declaration//GEN-END:variables
}
