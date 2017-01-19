package com.mycompany.mavenproject1;
 
import com.mycompagny.Database.UserDAO;
import com.mycompagny.Model.*;
import com.mycompagny.Model.File;
import com.mycompagny.Model.User;
import java.util.Date;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getIt() {
        System.out.println("GO");
        
        User u = new User("Boukarabila", "Abderrahim", "a@gmail.com", "abd");
        UserDAO d = new UserDAO();
        return d.getAll();
        
        //d.create(u);
        //return u;
    }
}
