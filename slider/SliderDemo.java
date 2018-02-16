package slider;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderDemo extends JFrame implements ChangeListener{

    private Container c;
    private JSlider slider;
    private JTextField redTf, greenTf, blueTf;
    private JPanel panel;
    
    public SliderDemo() {
        initComponents();
    }
    
    
    public static void main(String[] args) {
        SliderDemo frame = new SliderDemo();
        frame.setVisible(true);
    }

    private void initComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 800, 300);
        
        c = this.getContentPane();
        c.setLayout(null);
        
        slider = new JSlider(0,255,0);
        slider.setBounds(10, 30, 250, 20);
        c.add(slider);
        
        redTf = new JTextField();
        redTf.setBounds(280, 15, 100, 50);
        c.add(redTf);
        
        panel = new JPanel();
        panel.setBounds(400, 30, 200, 200);
        panel.setBackground(Color.red);
        c.add(panel);
        slider.addChangeListener(this);
        
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        
            int red = slider.getValue();
            redTf.setText(""+red);
            Color color = new Color(red,0,255);
            panel.setBackground(color);
        
    }
}
