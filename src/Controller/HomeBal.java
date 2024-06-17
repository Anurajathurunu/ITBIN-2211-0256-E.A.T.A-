/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import databaseCon.DB;
import java.sql.Date;


/**
 *
 * @author THURUNU
 */
public class HomeBal {
    public void insert(HomeBean homeBean) {
        try {
            String query= "insert into employee values(null, ?, ? ,?, ?, ?, ?)";
            PreparedStatement ps = DB.con.preapareStatement(query);
            ps.setString(1, homeBean.getFirstName());
            ps.setString(2, homeBean.getLastName());
            ps.setString(3, homeBean.getGender());
            ps.setString(4, homeBean.getCity());
            ps.setObject(5, homeBean.getDate());
            ps.setString(6, homeBean.getAddress());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "A record has been inserted");
              
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,""+e);
        }
    }
    
    public void updateData(HomeBean bean){
        try {
            String query = "UPDATE employee SET FirstName = ?, LastName = ?, Gender = ?, City = ?, Date = ?, Address = ? WHERE Id = ?";
           
            PreparedStatement ps = DB.con.prepareStatement(query);
            ps.setString(1,bean.getFirstName());
            ps.setString(2,bean.getLastName());
            ps.setString(3,bean.getGender());
            ps.setString(4,bean.getCity());
            ps.setDate(5, (Date) bean.getDate());
            ps.setString(6,bean.getAddress());
            
            
        } catch (Exception e){ 
            JOptionPane.showMessageDialog(null, ""+e);
        }
    }
    
}
