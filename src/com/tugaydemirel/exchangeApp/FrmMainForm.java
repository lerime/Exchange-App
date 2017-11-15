/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugaydemirel.exchangeApp;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

/**
 *
 * @author Java_sabah
 */
public class FrmMainForm extends javax.swing.JFrame {

    /**
     * Creates new form FrmMainForm
     */
    public FrmMainForm() {
        initComponents();
        //loadDatas();
        Timer tm = new Timer();
        tm.schedule(tsk, 1000, 1000);
    }
    int sayac = 0 ;
    
    TimerTask tsk = new TimerTask() {
        @Override
        public void run() {
            sayac ++;
            System.out.println("timer çalıştı "+sayac);
            loadDatas();
        }
    };

    
    void loadDatas(){
        try {
            // servis url'i oluştur
            String url = "http://www.tcmb.gov.tr/kurlar/today.xml";
            String data = Jsoup.connect(url).timeout(30000).execute().body();
            Document doc = Jsoup.parse(data, "", Parser.xmlParser());
            Elements elems = doc.select("Currency");
            
            HashMap<String,String> dfb = new HashMap<>();
            HashMap<String,String> dfs = new HashMap<>();
            HashMap<String,String> dbb = new HashMap<>();
            HashMap<String,String> dbs = new HashMap<>();
            
            for (Element item : elems) {
                
                String isim = item.getElementsByTag("Isim").text();
                String fb = item.getElementsByTag("ForexBuying").text();
                String fs = item.getElementsByTag("ForexSelling").text();
                String bb = item.getElementsByTag("BanknoteBuying").text();
                String bs = item.getElementsByTag("BanknoteSelling").text();
                System.out.println("isim : " + isim + " alış : " + fb);
                
                dfb.put(isim, fb);
                dfs.put(isim, fs);
                dbb.put(isim, bb);
                dbs.put(isim, fs);
            }
            
            txtBankBuyingDlr.setText(dbb.get("ABD DOLARI").toString());
            txtBankSellingDlr.setText(dbs.get("ABD DOLARI").toString());
            txtForexBuyingDlr.setText(dfb.get("ABD DOLARI").toString());
            txtForexSellingDlr.setText(dfs.get("ABD DOLARI").toString());
            
            txtBankBuyingEur.setText(dbb.get("EURO").toString());
            txtBankSellingEur.setText(dbs.get("EURO").toString());
            txtForexBuyingEur.setText(dfb.get("EURO").toString());
            txtForexSellingEur.setText(dfs.get("EURO").toString());

        } catch (Exception e) {
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDolar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBankBuyingDlr = new javax.swing.JTextField();
        txtForexBuyingDlr = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtBankSellingDlr = new javax.swing.JTextField();
        txtForexSellingDlr = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        pnlEuro = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtForexBuyingEur = new javax.swing.JTextField();
        txtBankBuyingEur = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtForexSellingEur = new javax.swing.JTextField();
        txtBankSellingEur = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlDolar.setBorder(javax.swing.BorderFactory.createTitledBorder("Dolar"));

        jLabel1.setText("Banka Alış");

        jLabel2.setText("Piyasa Alış");

        txtBankBuyingDlr.setEditable(false);
        txtBankBuyingDlr.setMinimumSize(new java.awt.Dimension(60, 20));
        txtBankBuyingDlr.setPreferredSize(new java.awt.Dimension(60, 25));

        txtForexBuyingDlr.setEditable(false);
        txtForexBuyingDlr.setMinimumSize(new java.awt.Dimension(60, 20));
        txtForexBuyingDlr.setPreferredSize(new java.awt.Dimension(60, 25));

        jLabel3.setText("Banka Satış");

        txtBankSellingDlr.setEditable(false);
        txtBankSellingDlr.setMinimumSize(new java.awt.Dimension(60, 20));
        txtBankSellingDlr.setPreferredSize(new java.awt.Dimension(60, 25));
        txtBankSellingDlr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBankSellingDlrActionPerformed(evt);
            }
        });

        txtForexSellingDlr.setEditable(false);
        txtForexSellingDlr.setMinimumSize(new java.awt.Dimension(60, 20));
        txtForexSellingDlr.setPreferredSize(new java.awt.Dimension(60, 25));

        jLabel4.setText("Piyasa Satış");

        javax.swing.GroupLayout pnlDolarLayout = new javax.swing.GroupLayout(pnlDolar);
        pnlDolar.setLayout(pnlDolarLayout);
        pnlDolarLayout.setHorizontalGroup(
            pnlDolarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDolarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDolarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(pnlDolarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBankBuyingDlr, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(txtForexBuyingDlr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDolarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(pnlDolarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBankSellingDlr, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(txtForexSellingDlr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlDolarLayout.setVerticalGroup(
            pnlDolarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDolarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDolarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDolarLayout.createSequentialGroup()
                        .addGroup(pnlDolarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtBankSellingDlr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDolarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtForexSellingDlr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlDolarLayout.createSequentialGroup()
                        .addGroup(pnlDolarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtBankBuyingDlr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDolarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtForexBuyingDlr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlEuro.setBorder(javax.swing.BorderFactory.createTitledBorder("Euro"));

        jLabel5.setText("Banka Alış");

        jLabel6.setText("Piyasa Alış");

        txtForexBuyingEur.setEditable(false);
        txtForexBuyingEur.setMinimumSize(new java.awt.Dimension(60, 20));
        txtForexBuyingEur.setPreferredSize(new java.awt.Dimension(60, 25));
        txtForexBuyingEur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtForexBuyingEurActionPerformed(evt);
            }
        });

        txtBankBuyingEur.setEditable(false);
        txtBankBuyingEur.setMinimumSize(new java.awt.Dimension(60, 20));
        txtBankBuyingEur.setPreferredSize(new java.awt.Dimension(60, 25));

        jLabel7.setText("Banka Satış");

        jLabel8.setText("Piyasa Satış");

        txtForexSellingEur.setEditable(false);
        txtForexSellingEur.setMinimumSize(new java.awt.Dimension(60, 20));
        txtForexSellingEur.setPreferredSize(new java.awt.Dimension(60, 25));

        txtBankSellingEur.setEditable(false);
        txtBankSellingEur.setMinimumSize(new java.awt.Dimension(60, 20));
        txtBankSellingEur.setPreferredSize(new java.awt.Dimension(60, 25));
        txtBankSellingEur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBankSellingEurActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlEuroLayout = new javax.swing.GroupLayout(pnlEuro);
        pnlEuro.setLayout(pnlEuroLayout);
        pnlEuroLayout.setHorizontalGroup(
            pnlEuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEuroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(pnlEuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBankBuyingEur, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(txtForexBuyingEur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(pnlEuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(pnlEuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBankSellingEur, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(txtForexSellingEur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlEuroLayout.setVerticalGroup(
            pnlEuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEuroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlEuroLayout.createSequentialGroup()
                        .addGroup(pnlEuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtBankSellingEur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlEuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtForexSellingEur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlEuroLayout.createSequentialGroup()
                        .addGroup(pnlEuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtBankBuyingEur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlEuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtForexBuyingEur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDolar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlEuro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDolar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlEuro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBankSellingDlrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBankSellingDlrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBankSellingDlrActionPerformed

    private void txtBankSellingEurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBankSellingEurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBankSellingEurActionPerformed

    private void txtForexBuyingEurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtForexBuyingEurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtForexBuyingEurActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel pnlDolar;
    private javax.swing.JPanel pnlEuro;
    private javax.swing.JTextField txtBankBuyingDlr;
    private javax.swing.JTextField txtBankBuyingEur;
    private javax.swing.JTextField txtBankSellingDlr;
    private javax.swing.JTextField txtBankSellingEur;
    private javax.swing.JTextField txtForexBuyingDlr;
    private javax.swing.JTextField txtForexBuyingEur;
    private javax.swing.JTextField txtForexSellingDlr;
    private javax.swing.JTextField txtForexSellingEur;
    // End of variables declaration//GEN-END:variables
}
