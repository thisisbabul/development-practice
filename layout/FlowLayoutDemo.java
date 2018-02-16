
package layout;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutDemo extends JFrame{

    private Container c;
    private JButton button[];
    private FlowLayout fLayout;
    
    public FlowLayoutDemo() {
        initComponents();
    }
    
    private void initComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(200, 100, 400, 400);
        c = this.getContentPane();
        
        fLayout = new FlowLayout();
        c.setLayout(fLayout);
        
        button = new JButton[10];
        
        for(int i = 0; i<10; i++){
            button[i] = new JButton(""+(i+1));
            c.add(button[i]);
        }
    }
    
    public static void main(String[] args) {
        FlowLayoutDemo frame = new FlowLayoutDemo();
        frame.setVisible(true);
    }
}
