package layout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SlideShow extends JFrame implements ActionListener {

    private Container c;
    private JPanel panel;
    private JButton previousButton, nextButton;
    private JLabel label;
    private ImageIcon icon;
    private CardLayout cLayout;

    public SlideShow() {
        initComponents();
        showImages();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == previousButton) {
            cLayout.previous(panel);
        }
        if (e.getSource() == nextButton) {
            cLayout.next(panel);
        }
    }

    private void showImages() {
        String[] countryNames = {"bangladesh.png", "india.png", "pakistan.jpg"};

        for (String name : countryNames) {
            icon = new ImageIcon("src/image/" + name);
            Image img = icon.getImage();
            Image newImage = img.getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_SMOOTH);
            icon = new ImageIcon(newImage);
            label = new JLabel(icon);
            panel.add(label);

        }
    }

    private void initComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 600, 500);

        c = this.getContentPane();
        c.setLayout(null);

        cLayout = new CardLayout();

        panel = new JPanel(cLayout);
        panel.setBounds(40, 10, 500, 400);
        panel.setBackground(Color.GREEN);
        c.add(panel);

        previousButton = new JButton("Previous");
        nextButton = new JButton("Next");

        previousButton.setBounds(40, 420, 100, 40);
        c.add(previousButton);

        nextButton.setBounds(440, 420, 100, 40);
        c.add(nextButton);

        previousButton.addActionListener(this);
        nextButton.addActionListener(this);

    }

    public static void main(String[] args) {
        SlideShow frame = new SlideShow();
        frame.setVisible(true);
    }

}
