package database;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DBAccessConnection extends JFrame implements ActionListener{

    private JLabel nameLabel, salaryLabel;
    private JTextField nameTxt, salaryTxt;
    private JButton saveButton;
    private Container c;
    private Connection conn;
    private PreparedStatement pstm;
        
    public DBAccessConnection() {
        initComponents();
    }
    
    public static void main(String[] args) throws SQLException{
        DBAccessConnection frame = new DBAccessConnection();
        frame.setVisible(true);
    }

    private void initComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Employee Information");
        this.setResizable(false);
        this.setBounds(400, 100, 500, 400);
        
        c = this.getContentPane();
        c.setLayout(null);
        
        nameLabel = new JLabel("Enter your name: ");
        nameLabel.setBounds(50, 50, 100, 50);
        c.add(nameLabel);
        
        nameTxt = new JTextField();
        nameTxt.setBounds(150, 60, 200, 30);
        c.add(nameTxt);
        
        salaryLabel = new JLabel("Enter salary: ");
        salaryLabel.setBounds(50, 100, 100, 50);
        c.add(salaryLabel);
        
        salaryTxt = new JTextField();
        salaryTxt.setBounds(150, 110, 200, 30);
        c.add(salaryTxt);
        
        saveButton = new JButton("Save");
        saveButton.setBounds(250, 160, 100, 30);
        c.add(saveButton);
        
        saveButton.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String database ="jdbc:ucanaccess://C:/Users/Babul/Documents/test.accdb";
            
            conn = DriverManager.getConnection(database,"","");
            pstm = conn.prepareStatement("INSERT INTO employee(name, salary) values(?,?)");
            pstm.setString(1, nameTxt.getText().toString());
            pstm.setDouble(2, Double.parseDouble(salaryTxt.getText().toString()));
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Data has been saved");
            
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBAccessConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBAccessConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
