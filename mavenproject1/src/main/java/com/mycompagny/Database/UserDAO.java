/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.Database;

import com.mycompagny.Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author boukarabilaa
 */
public class UserDAO extends DAO<User>{

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
    public void create(User obj) {
        //PreparedStatement prepare =null;
         try {
            //this.connect = ConnectionSql.getInstance();
            PreparedStatement prepare = this.connect.prepareStatement(
            "INSERT INTO `user`( `nom`, `prenom`, `email`, `password`) VALUES (?,?,?,?)");
            prepare.setString(1, obj.getNom());
            prepare.setString(2,obj.getPrenom());
            prepare.setString(3, obj.getEmail());
            prepare.setString(4,obj.getPassword());
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
}
