
package component;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import model.Model_Profile;


public class ListProfile<E extends Object> extends JList<E> {
    
    private final DefaultListModel model;
    private int playindex = -1;
    
    public ListProfile(){
     model = new DefaultListModel();
     setModel(model);
     setOpaque(false);
     addMouseListener(new MouseAdapter(){
     @Override
     public void mouseClicked(MouseEvent me){
     if(SwingUtilities.isLeftMouseButton(me)){
     playindex = locationToIndex(me.getPoint());
     repaint();
     }
     }
     });
    }
    @Override
    public ListCellRenderer getCellRenderer(){
    return new DefaultListCellRenderer(){
    @Override
    public Component getListCellRendererComponent(JList<?> jlist, Object o, int index, boolean selected, boolean focus){
    Model_Profile data;
    if(o instanceof Model_Profile){data = (Model_Profile) o;}
    else{ data = new Model_Profile("Name","Description",new ImageIcon(getClass().getResource("/icon/artists_selected.png")));}
    ItemProfile item = new ItemProfile(data);
    return item;
    }
    };
    }
    public void addItem(Model_Profile data){model.addElement(data);}
}
          
            
    
    

