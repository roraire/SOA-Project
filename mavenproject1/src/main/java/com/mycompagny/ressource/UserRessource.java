/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.ressource;
import com.mycompagny.Database.UserDAO;
import com.mycompagny.Model.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
/**
 *
 * @author boukarabilaa
 */
@Path("profiles")
@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_JSON)
public class UserRessource {
        UserDAO user_dao = new UserDAO();
                
        
    	@GET
        @Path("/{userid}")
	public User getUser(@PathParam("userid")int id) {
		return user_dao.find(id);
	}
	
	@POST
	public void addUser( User profile) {
		user_dao.create(profile);
	}
	
	@GET
	public  List<User> getAllUsers() {
		return user_dao.getAll();
	}
	
	@PUT
	public  User updateUser( User profile) {
		//User.set UserName(profileName);
		return user_dao.update(profile);
         }
	
	@DELETE
        @Path("/{useremail}")
	public void deleteUser(@PathParam("useremail") String email) {
            System.out.println("delete");
		user_dao.delete(email);
                
	}
        
        @Path("/{userid}/Files")
	public FileRessource getFileRessource() {
		return new FileRessource();
	}
    
}
