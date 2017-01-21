/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;




public class ConnectionSql{

	/**
	 * URL de connection
	 */
	private static String url = "jdbc:mysql://localhost:3306/shootshare";
	/**
	 * Nom du user
	 */
	private static String user = "root";
	/**
	 * Mot de passe du user
	 */
	private static String passwd = "";
	/**
	 * Objet Connection
	 */
	private static Connection connect;
	
	/**
	 * Méthode qui va nous retourner notre instance
	 * et la créer si elle n'existe pas...
	 * @return
	 */
	public static Connection getInstance(){
		if(connect == null){
			try {
                            connect = DriverManager.getConnection(url, user, passwd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
                }		
		return connect;	
	}	
        }
