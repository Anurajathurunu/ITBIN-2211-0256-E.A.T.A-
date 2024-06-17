/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.DB;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author THURUNU
 */
public class HomeBal {
    
    public List<HomeBean> loadData(){
        List<HomeBean> list = new ArrayList<HomeBean>();
        try {
            String query = "select * from employee";
            PreparedStatement ps = DB.con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("Id");
                String firstName = rs.getString("Firstname");
                String lastName = rs.getString("Lastname");
                String gender = rs.getString("Gender");
                String city = rs.getString("City");
                Date date = rs.getDate("Date");
                String address = rs.getString("Address");
                
                HomeBean bean = new HomeBean(id,firstName, lastName, gender,city,date,address );
                list.add(bean);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, ""+e);
        }
        return list;
    }
    
    public void insert(HomeBean homeBean) {
        try {
            String query= "insert into employee values(null, ?, ? ,?, ?, ?, ?)";
            PreparedStatement ps = DB.con.prepareStatement(query);
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
            ps.setObject(5, bean.getDate());
            ps.setString(6,bean.getAddress());
            
            
        } catch (Exception e){ 
            JOptionPane.showMessageDialog(null, ""+e);
        }
    }
    
    public HomeBean returnDataToTextFields(int id){
        HomeBean bean = null;
        
        try {
            String query = "select * from employee where Id = "+id;
            PreparedStatement ps = DB.con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int ids = rs.getInt("Id");
                String firstName = rs.getString("Firstname");
                String lastName = rs.getString("Lastname");
                String gender = rs.getString("Gender");
                String city = rs.getString("City");
                Date date = rs.getDate("Date");
                String address = rs.getString("Address");
                
                bean = new HomeBean(ids,firstName,lastName,gender,city,date,address);
            }
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, ""+e);
        }
        return bean;
    }
    
    public void delete(int id){
        try {
            String query = "delete from employee where Id= ?";
            PreparedStatement ps = DB.con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "a record has been deleted");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, ""+e);
        }
        
    }
    
}
