/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package student_admission;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DataBaseConnect {
    
    public Connection con = null;
    public Statement statement = null;
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String username, password;
    String dbname = "jdbc:mysql://localhost/admission";//getting url

    public DataBaseConnect(String userd, String passd) {
        this.password = passd;
        this.username = userd;
    }

    public void Connect() {
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(dbname, username, password);
            statement = con.createStatement();

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.err.println(ex);
        }
    }

    public void close() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Database Closing Error\n" + e);
        }
    }
    
    public static void main(String ars[])
    {
        DataBaseConnect d = new DataBaseConnect("root","");
        d.Connect();
    }
    
}

