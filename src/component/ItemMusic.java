
package component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import model.Model_Music;


public class ItemMusic extends javax.swing.JPanel {

    private final Model_Music data;
    Bottom bottom = new Bottom();
    boolean play;
    public void setPlay(boolean play){
    this.play = play;
    if(play){
        lbIcon.setText("");
        lbIcon.setIcon(new ImageIcon(getClass().getResource("/icon/playing.png")));
        lbText.setFont(new java.awt.Font("sansserif",1, 14));
        lbText.setForeground(new Color(27, 74, 233 ));
        lbTime.setFont(new java.awt.Font("sansserif",1, 14));
        lbTime.setForeground(new Color(27, 74, 233 ));
        bottom.file(data.getName());
    }
    else{
        lbIcon.setIcon(null);
        lbIcon.setText(data.getNo());
        lbText.setFont(new java.awt.Font("sansserif",0, 14));
        lbText.setForeground(new Color(51, 51, 51 ));
        lbTime.setFont(new java.awt.Font("sansserif",0, 14));
        lbTime.setForeground(new Color(51, 51, 51 ));
    }
    }
    
    
    public ItemMusic(Model_Music data) {
        this.data=data;
        initComponents();
        setOpaque(false);
        lbText.setText(data.getName());
        lbTime.setText(data.getTime());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIcon = new javax.swing.JLabel();
        lbTime = new javax.swing.JLabel();
        lbText = new javax.swing.JLabel();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        lbIcon.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbIcon.setForeground(new java.awt.Color(51, 51, 51));
        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbTime.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbTime.setForeground(new java.awt.Color(51, 51, 51));
        lbTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTime.setText("03:00");

        lbText.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbText.setForeground(new java.awt.Color(51, 51, 51));
        lbText.setText("Music Name");
        lbText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTextMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbText, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTime)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
            .addComponent(lbText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
            
    }//GEN-LAST:event_formMouseClicked

    private void lbTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTextMouseClicked
      // TODO add your handling code here:
    }//GEN-LAST:event_lbTextMouseClicked
     
    @Override
    protected void paintComponent(Graphics grphcs){
        if(play){
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setColor(new Color(246, 246, 246 ));
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2.fillRect(0, getHeight()-2,getWidth(), getHeight());
        }
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbText;
    private javax.swing.JLabel lbTime;
    // End of variables declaration//GEN-END:variables

    
}
