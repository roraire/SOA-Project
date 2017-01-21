/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.ressource;

import com.mycompagny.Database.FileDAO;
import com.mycompagny.Database.FileDAO;
import com.mycompagny.Database.ShareDAO;
import com.mycompagny.Model.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 *
 * @author boukarabilaa
 */
@Path("/")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class FileRessource {
    

        FileDAO file_dao=new FileDAO();
                
        
    	/*@GET
        @Path("/{fileid}")
	public File getFile(@PathParam("fileid")int id) {
		return file_dao.find(id);
	}*/
	
	@POST
	public void addFile( File file) {
            System.out.println("add");
            File f=file;
		file_dao.create(f);
	}
	
	@GET
	public  List<File> getAllFiles(@PathParam("userid") int id,@PathParam("type") String type) {
		return file_dao.getAll(id,type);
	}
        
         @GET
        @Path("/MyFiles")
	public  List<File> getMyFiles(@PathParam("userid") int id) {
		return file_dao.getMyFiles(id);
	}
       
        @GET
        @Path("/SharedFiles")
	public  List<File> getSharedFiles(@PathParam("userid") int id) {
                ShareDAO share_dao= new ShareDAO();
		return share_dao.getShared(id);
	}
	
	@PUT
	public  File updateFile( File file) {
		//File.set FileName(fileName);
		return file_dao.update(file);
         }
	
	@DELETE
        @Path("/{fileid}")
	public void deleteFile(@PathParam("fileid") int id) {
            System.out.println("delete");
		file_dao.delete(id);
                
	}
    
    @POST
    @Path("/upload")
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    public Response uploadPdfFile(@FormDataParam("fichier") InputStream fileInputStream,
                                    @FormDataParam("fichier") FormDataContentDisposition fileMetaData,
                                    @FormDataParam("created_by") int created_by,
                                    @FormDataParam("type") String type,
                                    @PathParam("userid") int userid)throws Exception
    { 
        String UPLOAD_PATH = "C:/Users/boukarabilaa/Downloads/mavenproject1/src/main/java/Files";
        //String file_name =fileMetaData.getFileName();
        //jsonPart.setMediaType(MediaType.APPLICATION_JSON_TYPE);
        //File file = jsonPart.getValueAs(File.class);
        File file = new File(userid,fileMetaData.getFileName(),type,UPLOAD_PATH);
        UPLOAD_PATH ="C:/Users/boukarabilaa/Downloads/mavenproject1/src/main/java/Files/"+file.getDate()+fileMetaData.getFileName();
        file.setUrl(UPLOAD_PATH);
        System.out.println(file.toString());
        
        file_dao.create(file);
        
        try
        {
            int read = 0;
            byte[] bytes = new byte[1024];

            OutputStream out = new FileOutputStream(new java.io.File(UPLOAD_PATH));
            while ((read = fileInputStream.read(bytes)) != -1) 
            {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
            
            
        } catch (IOException e) 
        {
            throw new WebApplicationException("Error while uploading file. Please try again !!");
        }
        return Response.ok(fileMetaData.getFileName() + " uploaded successfully !!").build();
    }
    
    @GET
    @Path("Photos/{fileid}")
    @Produces({"image/jpg","image/png", "image/jpeg", "image/gif"})
    public Response getFile(@PathParam("fileid") int fileid) {
            File f =file_dao.find(fileid);
            String FILE_PATH = f.getUrl();
		      System.out.println(FILE_PATH);
            java.io.File file = new java.io.File(FILE_PATH);

		Response.ResponseBuilder response = Response.ok((Object) file);
		
		return response.build();

	}
    @GET
    @Path("Video/{fileid}")
    @Produces({"video/*"})
    public Response getVideo(@PathParam("fileid") int fileid) {
            File f =file_dao.find(fileid);
            String FILE_PATH = f.getUrl();
		      System.out.println(FILE_PATH);
            java.io.File file = new java.io.File(FILE_PATH);

		Response.ResponseBuilder response = Response.ok((Object) file);
		
		return response.build();

	}
  
    
    
    
   
}
    

