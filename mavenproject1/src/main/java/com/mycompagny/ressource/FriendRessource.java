/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.ressource;

import com.mycompagny.Database.FreindDAO;
import com.mycompagny.Database.UserDAO;
import com.mycompagny.Model.Freind;
import com.mycompagny.Model.User;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 *
 * @author BoukarabilaA
 */

@Path("/{userid}/Friends")
@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_JSON)

public class FriendRessource {
    FreindDAO freind_dao = new FreindDAO();
    UserDAO user_dao=new UserDAO();
    @GET
     public List<Freind> getFreinds(@PathParam("userid") int userid) {
		return freind_dao.getAll(userid);
	}
	
	@POST
        @Path("/{friendEmail}")
        @Produces(MediaType.TEXT_PLAIN)
        public boolean addFreind(@PathParam("userid") int userid, @FormDataParam("friendEmail")String email) {
              boolean msg=false;
              
            User u=user_dao.find(email);
            if(!freind_dao.freindExist(userid, u.getId())){
            if(freind_dao.create(userid,u.getId()) && freind_dao.create(u.getId(),userid)  ){
            msg=true;
            }
            }
            return msg;
	}
        
        @DELETE
        @Path("/{friendEmail}")
        @Produces(MediaType.TEXT_PLAIN)
	public boolean deleteFreind(@PathParam("userid") int userid, @PathParam("friendEmail") String email) {
            boolean msg=false;
            User u=user_dao.find(email);
             if( freind_dao.delete(userid,u.getId()) && freind_dao.delete(u.getId(),userid)){
                 msg=true;
             }
              return msg;
             }
	
}
