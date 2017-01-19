/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.Database;

import com.mycompagny.Model.File;
import com.mycompagny.Model.Freind;
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
public class FreindDAO extends DAO<Freind>{

    @Override
    public Freind find(int id) {
        Freind freind =new Freind();
        PreparedStatement prepare =null;
         try {
            this.connect = ConnectionSql.getInstance();
            prepare = this.connect.prepareStatement(
            "SELECT `id`, `id_user`, `id_freind` FROM `freind` WHERE id_freind = ?");
            prepare.setInt(1, id);
            ResultSet rs = prepare.executeQuery();
            while (rs.next()) {
                freind.setId(rs.getInt("id"));
                freind.setId_user(rs.getInt("id_user"));
                freind.setId_freind(rs.getInt("id_freind"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return freind;
    }

    @Override
    public void create(Freind obj) {
        PreparedStatement prepare =null;
         try {
            this.connect = ConnectionSql.getInstance();
            prepare = this.connect.prepareStatement(
            "INSERT INTO `freind`( `id_user`, `id_freind`) VALUES (?,?)");
            prepare.setInt(1, obj.getId_user());
            prepare.setInt(2,obj.getId_freind());
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         

    }

    @Override
    public Freind update(Freind obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Freind obj) {
        PreparedStatement prepare =null;
       try {
            this.connect = ConnectionSql.getInstance();
            prepare = this.connect.prepareStatement(
            "DELETE FROM `freind` WHERE id_user=? and id_freind=?");
            prepare.setInt(1,obj.getId_user());
            prepare.setInt(1,obj.getId_freind());
            prepare.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public List<Freind> getAll() {
        Freind freind =new Freind();
        ArrayList<Freind> freinds =new ArrayList<Freind>();
        PreparedStatement prepare =null;
         try {
            this.connect = ConnectionSql.getInstance();
            prepare = this.connect.prepareStatement(
            "SELECT * FROM `freind`");
            ResultSet rs = prepare.executeQuery();
            while (rs.next()) {
                freind.setId(rs.getInt("id"));
                freind.setId_user(rs.getInt("id_user"));
                freind.setId_freind(rs.getInt("id_freind"));
                freinds.add(freind);
}
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return freinds;
    }
    
}
