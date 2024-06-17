 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author THURUNU
 */
public class DB {
    
    /**
     *
     */
    public static Connection con = null;
    
    
    public static void loadConnection(){
        String url = "jdbc:mysql://localhost:3306/crud_app";
        String root = "root";
        String pass = "";
        
        try {
            con = DriverManager.getConnection(url, root, pass);
            if (con != null) {
            JOptionPane.showMessageDialog(null,"database has been successfully connected");
        }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"error in database loading"+e);
        }
    }
    
}
