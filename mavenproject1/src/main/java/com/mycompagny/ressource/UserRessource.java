/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.ressource;
import com.mycompagny.Database.FreindDAO;
import com.mycompagny.Database.UserDAO;
import com.mycompagny.Model.*;
import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ws.rs.CookieParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import sun.misc.BASE64Decoder;

@Path("profiles")
@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_JSON)
public class UserRessource {
        UserDAO user_dao = new UserDAO();
                
       
        @GET
        @Path("/Authentification")
	public Response getAuth(@HeaderParam("authorization") String authString) {
            System.out.println(authString );
            
           if(authString == null || authString.isEmpty() || !user_dao.isUserAuthenticated(authString)){
               String decodedAuth = "";
            String[] authParts = authString.split("\\s+");
            String authInfo = authParts[1];
        
            byte[] bytes = null;
            try {
                bytes = new BASE64Decoder().decodeBuffer(authInfo);
            } catch (IOException e) {

            e.printStackTrace();
        }
        decodedAuth = new String(bytes);
        String[] userAuth = decodedAuth.split(":");
        User u=user_dao.find(userAuth[0]);
          Response.ResponseBuilder response = Response.ok((Object) u);
		response.header("user", u);
		return response.build();
           }
            
           Response.ResponseBuilder response = Response.noContent();
		
		return response.build();
              
           //NewCookie cookie = new NewCookie("authorization",authString);
             // return Response.ok("OK").cookie(cookie).build();
		//return "you are connected";
	}
        
        /*@GET
        @Path("/Authentification")
	public String getAuth(@Context HttpServletRquest authString) {
            System.out.println(authString);
            if(authString == null || authString.isEmpty() || user_dao.isUserAuthenticated(authString))
            {
                 return "ko";
              
            }
            
             return "ok";
		//return "you are connected";
	} */  
        
    	@GET
        @Path("/{userid}")
	public User getUser(@PathParam("userid")int id, @CookieParam("authString") String authString) {
           
		return user_dao.find(id);
           
        }
	
	@POST
	public void addUser( User profile) {
            System.out.println("com.mycompagny.ressource.UserRessource.addUser()");
            
		user_dao.create(profile);
	}
	
        /*@GET
	public  List<User> getAllUsers() {
		return user_dao.getAll();
	}*/
	
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
	public Class<FileRessource> getFileRessource() {
		return FileRessource.class;
	}
        
       
        
        
    
}
