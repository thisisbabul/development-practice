
package dialogwindow;

import javax.swing.JOptionPane;

public class MessageDialogInput {
    public static void main(String[] args) {
        String firstName = JOptionPane.showInputDialog(null,"Enter your first name ","This is tile",JOptionPane.INFORMATION_MESSAGE);
        String lastName = JOptionPane.showInputDialog(null,"Enter your last name ","This is title",JOptionPane.INFORMATION_MESSAGE);
        
        JOptionPane.showMessageDialog(null, firstName+" "+lastName,"This is title",JOptionPane.INFORMATION_MESSAGE);
    }
}
