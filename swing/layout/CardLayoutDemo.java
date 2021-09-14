package layout;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class CardLayoutDemo extends JFrame implements ActionListener {

    private Container c;
    private CardLayout cLayout;
    private JButton btn1, btn2, btn3;

    public CardLayoutDemo() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(200, 100, 400, 400);
        c = this.getContentPane();

        cLayout = new CardLayout(10, 10);
        c.setLayout(cLayout);

        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");

        c.add(btn1, "first");
        c.add(btn2, "second");
        c.add(btn3, "third");
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);

    }

    public static void main(String[] args) {
        CardLayoutDemo frame = new CardLayoutDemo();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cLayout.next(c);
    }
}
