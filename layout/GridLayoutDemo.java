
package layout;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutDemo extends JFrame{

    private Container c;
    private GridLayout gLayout;
    private JButton buttons[];
    
    public GridLayoutDemo() {
        initComponents();
    }
    
    private void initComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(200, 100, 400, 400);
        
        c = this.getContentPane();
   
        gLayout = new GridLayout(3,3,5,5);
        c.setLayout(gLayout);
        buttons = new JButton[9];
        
        for(int i = 0; i<9; i++){
            buttons[i] = new JButton(""+(i+1));
            c.add(buttons[i]);
        }
        
        
    }
    
    public static void main(String[] args) {
        GridLayoutDemo frame = new GridLayoutDemo();
        frame.setVisible(true);
    }

    
}
