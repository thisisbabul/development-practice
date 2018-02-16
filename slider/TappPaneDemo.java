package slider;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TappPaneDemo extends JFrame{

    private Container c;
    private JPanel panel1, panel2, panel3;
    private JTabbedPane tabb;
    
    public TappPaneDemo() {
        initComponents();
    }
    
    public static void main(String[] args) {
        TappPaneDemo frame = new TappPaneDemo();
        frame.setVisible(true);
    }

    private void initComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(200, 100, 800, 500);
        
        c = this.getContentPane();
        c.setLayout(null);
        
        panel1 = new JPanel();
        panel1.setBounds(250, 50, 300, 300);
        panel1.setBackground(Color.red);
        c.add(panel1);
        
        panel2 = new JPanel();
        panel2.setBounds(250, 50, 300, 300);
        panel2.setBackground(Color.green);
        c.add(panel2);
        
        panel3 = new JPanel();
        panel3.setBounds(250, 50, 300, 300);
        panel3.setBackground(Color.yellow);
        c.add(panel3);
        
        tabb = new JTabbedPane();
        tabb.setBounds(250, 50, 300, 300);
        tabb.addTab("Home", panel1);
        tabb.addTab("About", panel2);
        tabb.addTab("Contact", panel3);
        
        c.add(tabb);
    }
}
