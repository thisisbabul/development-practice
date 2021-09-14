package dialogwindow;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class MessageDialogShow {

    public static void main(String[] args) {
        ImageIcon icon = new ImageIcon("C:\\Users\\Babul\\Documents\\NetBeansProjects\\swing\\src\\dialogwindow\\info.png");
        JOptionPane.showMessageDialog(null, "Wrong password", "Warning", JOptionPane.PLAIN_MESSAGE, icon);
    }
}
