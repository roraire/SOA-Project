/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import com.mycompagny.Database.*;
import com.mycompagny.Model.*;
import java.util.List;

/**
 *
 * @author boukarabilaa
 */
public class FileService {
    
    
    public int createFile(File file){
        int msg;
        try{
            FileDAO f = new FileDAO();
            f.create(file);
            msg=1;
        }catch(Exception ex){
        msg=0;
        }
        return msg;
    }
    
    public List<Share> getAllFiles(){
    ShareDAO share = new ShareDAO();
        int msg;
        return share.getAll();
    }
     public List<Share> getMyFiles(){
    ShareDAO share = new ShareDAO();
        
        return share.getAll();
    }
    
    public List<Share> getSharedFiles(){
        ShareDAO share = new ShareDAO();
        
        return share.getAll();
    }
    public int deleteFile(){
    ShareDAO share = new ShareDAO();
        
        return 0;
    }
    public int deleteSharedFile(){
    ShareDAO share = new ShareDAO();
        
        return 0;
    }
}
