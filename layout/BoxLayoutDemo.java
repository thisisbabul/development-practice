package layout;

import java.awt.Container;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BoxLayoutDemo extends JFrame{

    private Container c;
    private BoxLayout bLayout;
    private JButton buttons[];
    
    public BoxLayoutDemo() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(200, 50, 400, 400);
        
        c = this.getContentPane();
        bLayout = new BoxLayout(c, BoxLayout.Y_AXIS);
        c.setLayout(bLayout);
        
        buttons = new JButton[10];
        for(int i = 0; i<10; i++){
            buttons[i] = new JButton(""+(i+1));
            c.add(buttons[i]);
            c.add(Box.createHorizontalStrut(10));
        }
        
    }
    
    
    public static void main(String[] args) {
        BoxLayoutDemo frame = new BoxLayoutDemo();
        frame.setVisible(true);
    }
}
