/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.Database;

import com.mycompagny.Model.User;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.BASE64Decoder;

/**
 *
 * @author boukarabilaa
 */
public class UserDAO extends DAO<User>{

    
    public User find(String email) {
        User user=new User();
        PreparedStatement prepare =null;
         try {
            this.connect = ConnectionSql.getInstance();
            prepare = this.connect.prepareStatement(
            "SELECT `id`, `nom`, `prenom`, `email`, `password` FROM `user` WHERE email = ?");
            prepare.setString(1, email);
            ResultSet rs = prepare.executeQuery();
            
            while (rs.next()) {
                
                user.setId(rs.getInt("id"));
                user.setNom(rs.getString("nom"));
                user.setPrenom(rs.getString("prenom"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    @Override
    public User find(int id) {
        User user =new User();
        PreparedStatement prepare =null;
         try {
            this.connect = ConnectionSql.getInstance();
            prepare = this.connect.prepareStatement(
            "SELECT `id`, `nom`, `prenom`, `email`, `password` FROM `user` WHERE id = ?");
            prepare.setInt(1, id);
            ResultSet rs = prepare.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setNom(rs.getString("nom"));
                user.setPrenom(rs.getString("prenom"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
}
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    @Override
    public boolean create(User obj) {
        boolean msg =false;
        if(this.find(obj.getEmail()).getEmail() !=null){
         try {
            //this.connect = ConnectionSql.getInstance();
            PreparedStatement prepare = this.connect.prepareStatement(
            "INSERT INTO `user`( `nom`, `prenom`, `email`, `password`) VALUES (?,?,?,?)");
            prepare.setString(1, obj.getNom());
            prepare.setString(2,obj.getPrenom());
            prepare.setString(3, obj.getEmail());
            prepare.setString(4,obj.getPassword());
            prepare.executeUpdate();
            msg= true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }   
        }
        return msg;
    }

    @Override
    public User update(User obj) {
        
       PreparedStatement prepare =null;
       try {
            this.connect = ConnectionSql.getInstance();
            prepare = this.connect.prepareStatement(
            "UPDATE `user` SET `nom`=?,`prenom`=?,`password`=? WHERE email= ?");
            prepare.setString(1, obj.getNom());
            prepare.setString(2,obj.getPrenom());
            prepare.setString(3,obj.getPassword());
            prepare.setString(4,obj.getEmail());
            prepare.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return obj;
    }

    
    public void delete(String obj) {
        System.out.println("delete");
        PreparedStatement prepare =null;
       try {
            this.connect = ConnectionSql.getInstance();
            prepare = this.connect.prepareStatement(
            "DELETE FROM `user` WHERE email=?");
            prepare.setString(1, obj);
            prepare.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public List<User> getAll() {
        
        ArrayList<User> users =new ArrayList<>();
        
         try {
            //this.connect = ConnectionSql.getInstance();
            PreparedStatement prepare = this.connect.prepareStatement(
            "SELECT * FROM `user`");
            ResultSet rs = prepare.executeQuery();
            while (rs.next()) {
                User user =new User();
                user.setId(rs.getInt("id"));
                user.setNom(rs.getString("nom"));
                user.setPrenom(rs.getString("prenom"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                users.add(user);
}
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    @Override
    public void delete(User obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean isUserAuthenticated(String authString){
         
        String decodedAuth = "";
        // Header is in the format "Basic 5tyc0uiDat4"
        // We need to extract data before decoding it back to original string
        String[] authParts = authString.split("\\s+");
        String authInfo = authParts[1];
        // Decode the data back to original string
        byte[] bytes = null;
        try {
            bytes = new BASE64Decoder().decodeBuffer(authInfo);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        decodedAuth = new String(bytes);
        String[] userAuth = decodedAuth.split(":");
        
        System.out.println(userAuth[0]+userAuth[1]);
        User u= this.find(userAuth[0]);
        if(userAuth[1] == u.getPassword()){
            return true;
        }else{
        return false;
        }
        
    }

   
}
