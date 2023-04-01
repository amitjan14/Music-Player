
package component;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Model_Music;

public class Bottom extends javax.swing.JPanel {
    Model_Music data = new Model_Music();

    JTextField filePathField;
    private boolean isPaused;
    private boolean isLooping = false;
    private boolean running = false;
    private JFileChooser fileChooser;
    private Clip clip;
    private AudioInputStream audioStream;
    private long audioLength;
    float previousVolume = 0;
    float currentVolume = 0;
    FloatControl fc;
    boolean mute = false;
    Timer timer;
    
   
    
    public Bottom() {
        initComponents();
         timer = new javax.swing.Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                long currentFrame = clip.getFramePosition();
                long currentSeconds = (long) (currentFrame / clip.getFormat().getFrameRate());
                long totalSeconds = audioLength / (long) clip.getFormat().getFrameRate();
                String currentTime = String.format("%02d:%02d", currentSeconds / 60, currentSeconds % 60);
                String totalTime = String.format("%02d:%02d", totalSeconds / 60, totalSeconds % 60);
                timestart.setText(currentTime);
                timeend.setText(totalTime);
                if (!duration.getValueIsAdjusting()) {
                    duration.setValue((int) (100 * currentFrame / audioLength));
                }
            }
        });  
         
        setOpaque(false);
        setBackground(new Color(68,68,68));
        init();
    }
        private void init(){
        filePathField = new JTextField(20);
        isPaused = true;
        isLooping = false;
        
        fileChooser = new JFileChooser(".");
        fileChooser.setFileFilter(new FileNameExtensionFilter("WAV Files", "wav"));
        volume.setMaximum(6);
        volume.setMinimum(-50);
        volume.addChangeListener(new ChangeListener(){
        @Override
        public void stateChanged(ChangeEvent e){
        currentVolume = volume.getValue();
        fc.setValue(currentVolume);
        }
        });  
    
        }
    
        void file(String name){
            System.out.println(name);
            filePathField.setText("C:\\Users\\amit_\\Documents\\NetBeans Project\\Music\\src\\Songs\\"+name+".wav");
            filename.setText(name);
            playMusic();
        
        }
      
        void stopMusic(){
        if (clip != null && clip.isRunning()) 
        {
            clip.stop();
            clip.setFramePosition(0);

        }
        }
        void playMusic() {
        
        stopMusic();
        
        try 
        {
            File file = new File(filePathField.getText());
            audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            audioLength = audioStream.getFrameLength();
            
            fc =(FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
            if (isLooping) 
            {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            
            clip.start();
            timer.start();

            
	    
 
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    private void pauseMusic() 
    {
        if(clip==null){playMusic();}
        if (clip != null && clip.isRunning()) 
        {
            clip.stop();
            isPaused = true;
            
        } 
        else if (clip != null && isPaused) 
        {
            clip.start();
            
            if(isLooping)
            {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            
            isPaused = false;
            
        }
    }
    
    private void chooseFile() 
    {
        fileChooser.setCurrentDirectory(new File("C:\\Users\\amit_\\Documents\\NetBeans Project\\Music\\src\\Songs\\"));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) 
        {
            File selectedFile = fileChooser.getSelectedFile();
          filePathField.setText(selectedFile.getAbsolutePath());
            filename.setText(selectedFile.getName());
        }
        playMusic();
    }
    
    private void toggleLoop() 
    {
        isLooping = !isLooping;
        if (isLooping) 
        {
            Loop.setIcon(new ImageIcon(getClass().getResource("/icon/repeat.png")));
            
            if(clip.isRunning())
            {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } 
        }
        else 
        {
            Loop.setIcon(new ImageIcon(getClass().getResource("/icon/loop.png"))); 
            if(clip.isRunning())
            {
                clip.loop(0);
            }
        }

    }
    private void VolumeUp(){
       currentVolume += 1.0f;
       if(currentVolume>6.0f){currentVolume=6.0f;}
       fc.setValue(currentVolume);
       }
    private void VolumeDown(){
       currentVolume -= 1.0f;
       if(currentVolume<-50.0f){currentVolume=-50.0f;}
       fc.setValue(currentVolume);
       }
    private void VolumeMute(){
       if(mute==false){
       previousVolume = currentVolume;
       currentVolume = -50.0f;
       fc.setValue(currentVolume);
       mute = true;
       volume.setValue(volume.getMinimum());
       Speaker.setIcon(new ImageIcon(getClass().getResource("/icon/mute.png")));}
       else if(mute==true){
       currentVolume = previousVolume;
       fc.setValue(currentVolume);
       mute=false;
       volume.setValue((int) currentVolume);
       Speaker.setIcon(new ImageIcon(getClass().getResource("/icon/speaker.png")));}
    
    }
  private void nextMusic(){}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        volume = new swing.Slider();
        timestart = new javax.swing.JLabel();
        Speaker = new javax.swing.JButton();
        Favourite = new javax.swing.JButton();
        Loop = new javax.swing.JButton();
        timeend = new javax.swing.JLabel();
        Browse = new javax.swing.JButton();
        Play = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        Pause = new javax.swing.JButton();
        Next = new javax.swing.JButton();
        filename = new javax.swing.JLabel();
        duration = new swing.Slider();

        volume.setMaximum(200);
        volume.setValue(60);

        timestart.setForeground(new java.awt.Color(255, 255, 255));
        timestart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timestart.setText("00:00");

        Speaker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/speaker.png"))); // NOI18N
        Speaker.setBorder(null);
        Speaker.setContentAreaFilled(false);
        Speaker.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Speaker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpeakerActionPerformed(evt);
            }
        });

        Favourite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/love_bot.png"))); // NOI18N
        Favourite.setBorder(null);
        Favourite.setContentAreaFilled(false);
        Favourite.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Favourite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FavouriteActionPerformed(evt);
            }
        });

        Loop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/repeat.png"))); // NOI18N
        Loop.setBorder(null);
        Loop.setContentAreaFilled(false);
        Loop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Loop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoopActionPerformed(evt);
            }
        });

        timeend.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        timeend.setForeground(new java.awt.Color(255, 255, 255));
        timeend.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeend.setText("03:00");

        Browse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/browse_selected.png"))); // NOI18N
        Browse.setBorder(null);
        Browse.setContentAreaFilled(false);
        Browse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowseActionPerformed(evt);
            }
        });

        Play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/play.png"))); // NOI18N
        Play.setBorder(null);
        Play.setContentAreaFilled(false);
        Play.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayActionPerformed(evt);
            }
        });

        Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back.png"))); // NOI18N
        Back.setBorder(null);
        Back.setContentAreaFilled(false);
        Back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        Pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/playing.png"))); // NOI18N
        Pause.setBorder(null);
        Pause.setContentAreaFilled(false);
        Pause.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PauseActionPerformed(evt);
            }
        });

        Next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/next.png"))); // NOI18N
        Next.setBorder(null);
        Next.setContentAreaFilled(false);
        Next.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });

        filename.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        filename.setForeground(new java.awt.Color(255, 255, 255));
        filename.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        filename.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filename, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pause, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Next, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Play, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(Browse, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(Loop, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(Speaker, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(volume, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(Favourite, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(timestart, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(duration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(timeend, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(77, 77, 77))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(timestart, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeend, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(duration, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Play, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Favourite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Loop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Speaker, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(volume, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(Browse, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Pause, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Next, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(filename, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SpeakerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpeakerActionPerformed
        VolumeMute();
    }//GEN-LAST:event_SpeakerActionPerformed

    private void FavouriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FavouriteActionPerformed
                  // TODO add your handling code here:
    }//GEN-LAST:event_FavouriteActionPerformed

    private void LoopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoopActionPerformed
       toggleLoop();
    }//GEN-LAST:event_LoopActionPerformed

    private void BrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrowseActionPerformed
        chooseFile();
    }//GEN-LAST:event_BrowseActionPerformed

    private void PlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayActionPerformed
        stopMusic();
    }//GEN-LAST:event_PlayActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_BackActionPerformed

    private void PauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PauseActionPerformed
        pauseMusic();
    }//GEN-LAST:event_PauseActionPerformed

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        nextMusic();// TODO add your handling code here:
    }//GEN-LAST:event_NextActionPerformed
    
    @Override
    protected void paintComponent(Graphics grphcs){
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setColor(getBackground());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        g2.fillRect(0, 0, getWidth(), 25);
        super.paintComponent(grphcs);
    }
public void stateChanged(ChangeEvent e) {
        if (e.getSource() == duration) {
            if (!duration.getValueIsAdjusting()) {
                long framePosition = (long) (duration.getValue() * audioLength / 100);
                clip.setFramePosition((int) framePosition);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Browse;
    private javax.swing.JButton Favourite;
    private javax.swing.JButton Loop;
    private javax.swing.JButton Next;
    private javax.swing.JButton Pause;
    private javax.swing.JButton Play;
    private javax.swing.JButton Speaker;
    private swing.Slider duration;
    private javax.swing.JLabel filename;
    private javax.swing.JLabel timeend;
    private javax.swing.JLabel timestart;
    private swing.Slider volume;
    // End of variables declaration//GEN-END:variables

    
}
