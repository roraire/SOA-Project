/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.Database;

import com.mycompagny.Model.File;
import com.mycompagny.Model.Share;
import com.mycompagny.Model.User;
import java.sql.Date;
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
public class ShareDAO extends DAO<Share>{

    @Override
    public Share find(int id) {
       Share share =new Share();
        PreparedStatement prepare =null;
         try {
            this.connect = ConnectionSql.getInstance();
            prepare = this.connect.prepareStatement(
            "SELECT `id`, `Id_file`, `created_by`, `shared_with` FROM `share` WHERE Id_file = ?");
            prepare.setInt(1, id);
            ResultSet rs = prepare.executeQuery();
            while (rs.next()) {
                
                share.setId(rs.getInt("id"));
                share.setId_file(rs.getInt("Id_file"));
                share.setCreated_by(rs.getInt("created_by"));
                share.setShared_with(rs.getInt("shared_with"));
                
}
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return share;
    }

    @Override
    public boolean create(Share obj) {
        PreparedStatement prepare =null;
         try {
            this.connect = ConnectionSql.getInstance();
            prepare = this.connect.prepareStatement(
            "INSERT INTO `share`(`Id_file`, `created_by`, `shared_with`) VALUES (?,?,?)");
            prepare.setInt(1, obj.getId_file());
            prepare.setInt(2,  obj.getCreated_by());
            prepare.setInt(3, obj.getShared_with());
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return true;
    }

    @Override
    public Share update(Share obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Share obj) {
       PreparedStatement prepare =null;
       try {
            this.connect = ConnectionSql.getInstance();
            prepare = this.connect.prepareStatement(
            "DELETE FROM `share` WHERE Id_file=? and shared_with=?");
            prepare.setInt(1,obj.getId_file());
            prepare.setInt(2,obj.getShared_with());
            prepare.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public List<Share> getAll() {
        
        ArrayList<Share> shares =new ArrayList<>();
        PreparedStatement prepare =null;
         try {
            this.connect = ConnectionSql.getInstance();
            prepare = this.connect.prepareStatement(
            "SELECT * FROM `share` ");
            
            ResultSet rs = prepare.executeQuery();
            while (rs.next()) {
                Share share =new Share();
                share.setId(rs.getInt("id"));
                share.setId_file(rs.getInt("Id_file"));
                share.setCreated_by(rs.getInt("created_by"));
                share.setShared_with(rs.getInt("shared_with"));
                shares.add(share);
}
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return shares;
    }

     public ArrayList<File> getShared(int id) {
        
        ArrayList<File> files =new ArrayList<>();
        PreparedStatement prepare =null;
         try {
             //"SELECT f.Id_file,f.created_by, f.file_name, f.Date, f.Type, f.URL FROM share s ,file f WHERE f.created_by=? and s.shared_with=? ");
            this.connect = ConnectionSql.getInstance();
            prepare = this.connect.prepareStatement(
            "SELECT f.Id_file,f.created_by, f.file_name, f.Date, f.Type, f.URL FROM share s ,file f  WHERE s.shared_with=? and s.Id_file=f.Id_file");
            prepare.setInt(1,id);
            ResultSet rs = prepare.executeQuery();
            while (rs.next()) {
                File file =new File();
                file.setId(rs.getInt("Id_file"));
                file.setCreated_by(rs.getInt("created_by"));
                file.setFile_name(rs.getString("file_name"));
                file.setDate(rs.getLong("Date"));
                file.setType(rs.getString("Type"));
                file.setUrl(rs.getString("URL"));
                files.add(file);
}
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return files;
    }
}
