
package component;

import model.Model_Music;
import component.Bottom;

public class Music extends javax.swing.JPanel {
    Bottom bottom = new Bottom();
    Model_Music data = new Model_Music();
    String name;
    
    public Music() {
        initComponents();
        init();
    }

    private void init(){
        list.addItem(new Model_Music("1", "Peace Of Mind (feat. Vargas & Lagola)", "03:00"));
        list.addItem(new Model_Music("2", "Heaven", "04:38"));
        list.addItem(new Model_Music("3", "SOS (feat. Aloe Blacc)", "02:36"));
        list.addItem(new Model_Music("4", "Bad Reputation (feat. Joe Janiak)", "03:26"));
        list.addItem(new Model_Music("5", "Ain't A Thing", "03:02"));
        list.addItem(new Model_Music("6", "Hold The line (feat. A R I Z O N A)", "02:52"));
        list.addItem(new Model_Music("7", "Freak (feat. Bonn)", "02:59"));
        list.addItem(new Model_Music("8", "Excuse me Mr Sir (feat. Vargas & Lagola)", "03:08"));
        list.addItem(new Model_Music("9", "Heart Upon My Sleeve (feat. Imagine Dragons)", "04:15"));
        list.addItem(new Model_Music("10", "Never Leave Me (feat. Joe Janiak)", "02:52"));
        list.addItem(new Model_Music("11", "Fades Away (feat. Noonie Bao)", "03:00"));
        list.addItem(new Model_Music("12", "Wake Me Up", "04:11"));
        list.addItem(new Model_Music("13", "You Make Me", "03:59"));
        list.addItem(new Model_Music("14", "Hey Brother", "04:19"));
        list.addItem(new Model_Music("15", "Addicted To You", "03:23"));
        list.addItem(new Model_Music("16", "Dont Give Up On Me", "03:16"));
        list.addItem(new Model_Music("17", "Zara Zara Bahekta Hai", "03:26"));
        list.addItem(new Model_Music("18", "My Universe", "03:48"));
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        list = new component.ListMusic<>();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Most Trending Music");

        list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(list, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(319, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(list, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMouseClicked
       // TODO add your handling code here:
    }//GEN-LAST:event_listMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private component.ListMusic<String> list;
    // End of variables declaration//GEN-END:variables
}
