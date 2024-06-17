/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author THURUNU
 */
public class Bal {
    
    public void insertDataSignup(Bean beanObj) {
        try{
            
            String query = "insert into users values(null, ?,?,?)";
            PreparedStatement ps = DB.con.prepareStatement(query);
            ps.setString(1,beanObj.getFullName());
            ps.setString(2, beanObj.getEmail());
            ps.setString(3, beanObj.getPass());
                   
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"signup successfully,now go login");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, ""+e);
        }
    }

    public boolean checkLogin( String email,String pass){
        boolean b = false;
    
    try {
        
        String query = " SELECT Email, Password FROM users WHERE Email='"+email+"'AND password='"+pass+"' ";
        Statement st = DB.con.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        if (rs.next()){
            b = true;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid email or password try again...");
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "error = "+e);
    }
        return b;
    }
}
 



