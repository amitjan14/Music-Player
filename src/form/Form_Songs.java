/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package form;

import model.Model_Music;

/**
 *
 * @author amit_
 */
public class Form_Songs extends javax.swing.JPanel {

    /**
     * Creates new form Form_Songs
     */
    public Form_Songs() {
        initComponents();
        init();
    }
    
    private void init(){
        listMusic.addItem(new Model_Music("1", "Peace Of Mind (feat. Vargas & Lagola)", "03:00"));
        listMusic.addItem(new Model_Music("2", "Heaven", "04:37"));
        listMusic.addItem(new Model_Music("3", "SOS (feat. Aloe Blacc)", "02:37"));
        listMusic.addItem(new Model_Music("4", "Bad Reputation (feat. Joe Janiak)", "03:25"));
        listMusic.addItem(new Model_Music("5", "Ain't A Thing", "03:03"));
        listMusic.addItem(new Model_Music("6", "Hold The line (feat. A R I Z O N A)", "02:51"));
        listMusic.addItem(new Model_Music("7", "Freak (feat. Bonn)", "02:59"));
        listMusic.addItem(new Model_Music("8", "Excuse me Mr Sir (feat. Vargas & Lagola)", "03:07"));
        listMusic.addItem(new Model_Music("9", "Heart Upon My Sleeve (feat. Imagine Dragons)", "04:14"));
        listMusic.addItem(new Model_Music("10", "Never Leave Me (feat. Joe Janiak)", "02:51"));
        listMusic.addItem(new Model_Music("11", "Fades Away (feat. Noonie Bao)", "02:58"));
        listMusic.addItem(new Model_Music("12", "Wake Me Up", "04:07"));
        listMusic.addItem(new Model_Music("13", "You Make Me", "03:53"));
        listMusic.addItem(new Model_Music("14", "Hey Brother", "04:15"));
        listMusic.addItem(new Model_Music("15", "Addicted To You", "02:28"));}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        listMusic = new component.ListMusic<>();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(47, 31, 193));
        jLabel1.setText("Songs");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(64, 64, 64));
        jLabel2.setText("Most popular");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listMusic, javax.swing.GroupLayout.PREFERRED_SIZE, 1173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listMusic, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private component.ListMusic<String> listMusic;
    // End of variables declaration//GEN-END:variables
}
