/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.Database;

import com.mycompagny.Model.File;
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
public class FileDAO extends DAO<File> {

    @Override
    public File find(int id) {
        File file =new File();
        PreparedStatement prepare =null;
         try {
            this.connect = ConnectionSql.getInstance();
            prepare = this.connect.prepareStatement(
            "SELECT `Id_file`,`created_by`, `file_name`, `Date`, `Type`, `URL` FROM `file` WHERE Id_file = ?");
            prepare.setInt(1, id);
            ResultSet rs = prepare.executeQuery();
            while (rs.next()) {
                file.setId(rs.getInt("Id_file"));
                file.setCreated_by(rs.getInt("created_by"));
                file.setFile_name(rs.getString("file_name"));
                file.setType(rs.getString("Type"));
                file.setDate(rs.getLong("Date"));
                file.setUrl(rs.getString("URL"));
}
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return file;
    }

    @Override
    public boolean create(File obj) {
        PreparedStatement prepare =null;
         try {
            this.connect = ConnectionSql.getInstance();
            System.out.println("prepare file");
            prepare = this.connect.prepareStatement(
            "INSERT INTO `file`(`file_name`,`created_by`, `Date`, `Type`, `URL`) VALUES  (?,?,?,?,?)");
            
            prepare.setString(1, obj.getFile_name());
            prepare.setInt(2, obj.getCreated_by());
            prepare.setLong(3, obj.getDate());
            prepare.setString(4, obj.getType());
            prepare.setString(5,obj.getUrl());
             System.out.println("create file");
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return true;
    }

    @Override
    public File update(File obj) {
        PreparedStatement prepare =null;
       try {
            this.connect = ConnectionSql.getInstance();
            prepare = this.connect.prepareStatement(
            "UPDATE `file` SET `file_name`=? WHERE Id_file =?");
            prepare.setString(1, obj.getFile_name());
            prepare.setInt(2,obj.getId());
         
            prepare.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return obj;
    }

   
    public void delete(int obj) {
       PreparedStatement prepare =null;
       try {
            this.connect = ConnectionSql.getInstance();
            prepare = this.connect.prepareStatement(
            "DELETE FROM `file` WHERE Id_file=?");
            prepare.setInt(1,obj);
            prepare.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public  List<File> getAll(int userid, String type) {
        
        ArrayList<File> files =new ArrayList<File>();
        PreparedStatement prepare =null;
         try {
            this.connect = ConnectionSql.getInstance();
            prepare = this.connect.prepareStatement(
            "SELECT f.Id_file,f.created_by, f.file_name, f.Date, f.Type, f.URL FROM freind fr ,file f WHERE  f.created_by=fr.id_freind and fr.id_user=? and  f.URL=? ");
            prepare.setInt(1, userid);
            prepare.setString(2,type);
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

    @Override
    public void delete(File obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public  List<File> getMyFiles(int id) {
        
        ArrayList<File> files =new ArrayList<File>();
        PreparedStatement prepare =null;
         try {
            this.connect = ConnectionSql.getInstance();
            prepare = this.connect.prepareStatement(
            "SELECT * FROM `file` where created_by=?");
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
