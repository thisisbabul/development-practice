package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBmysqlConnection {
    public static void main(String[] args) throws SQLException{
        Connection conn = null;
        Statement stm = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            stm = conn.createStatement();
            
            int count = stm.executeUpdate("INSERT INTO employee(name, salary) values('Sujon','8888')");
            if(count>0){
                System.out.println("Data is inserted successfully");
            }else{
                System.out.println("Data insertion failed");
            }
        }catch(Exception e){
            System.out.println("Exception is caugth "+e.getMessage());
        }finally{
            stm.close();
            conn.close();
        }
    }
}
