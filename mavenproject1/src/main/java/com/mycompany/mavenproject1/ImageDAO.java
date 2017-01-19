/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import com.mycompagny.Database.DAO;
import java.sql.*;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author BoukarabilaA
 */
public class ImageDAO extends DAO<Image> {

    @Override
    public Image find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Image obj) {
        
        try {
			 
    			PreparedStatement prepare = this.connect.prepareStatement(
                                                    	"INSERT INTO `photo`( `nom`, `idUser`, `confidentialite`) VALUES ( ?, ? ,?) "
                                                    );
                        
				
				prepare.setString(1, "imgtset1");
				prepare.setInt(2,1);
                                prepare.setString(3, "m");  
				prepare.executeUpdate();
			
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	   
	}
        
    

    @Override
    public Image update(Image obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Image obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<Image> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
