package slider;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class ColorChooser extends JFrame implements ActionListener{

    private JButton btn;
    private Container c;
    
    public ColorChooser() {
        initCompoents();
    }
    
    
    public static void main(String[] args) {
        ColorChooser frame = new ColorChooser();
        frame.setVisible(true);
    }

    private void initCompoents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(200, 100, 500, 500);
        
        c = this.getContentPane();
        c.setLayout(null);
        
        btn = new JButton("Color Chooser");
        btn.setBounds(180, 200, 150, 50);
        
        c.add(btn);
        btn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Color color = JColorChooser.showDialog(null, "Color chooser", Color.yellow);
        c.setBackground(color);
    }
}
