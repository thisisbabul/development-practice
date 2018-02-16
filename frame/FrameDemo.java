package frame;

import javax.swing.JFrame;

public class FrameDemo extends JFrame{
    public static void main(String[] args) {
        FrameDemo frame = new FrameDemo();
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(400, 300);
        //frame.setLocationRelativeTo(null);
        //frame.setLocation(400, 200);
        frame.setBounds(400, 100, 400, 300);
        frame.setTitle("Frame Demo");
        frame.setResizable(false);
    }
}
