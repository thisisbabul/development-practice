package frame;

import java.awt.Color;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class FrameIcon extends JFrame {

    private ImageIcon icon;
    private Container c;

    public FrameIcon() {
        initComponent();
    }

    private void initComponent() {
        setVisible(true);
        setBounds(400, 200, 400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("This is a title");
        icon = new ImageIcon(getClass().getResource("info.png"));
        setIconImage(icon.getImage());
        
        c = this.getContentPane();
        c.setBackground(Color.PINK);
    }

    public static void main(String[] args) {
        new FrameIcon();
    }

}
