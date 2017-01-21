/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.Model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement 
public class File {
    int id;
    int created_by;
    String file_name;
    long date;
    String type;
    String url;

    public File() {
    }

    public File( int created_by, String file_name, String type, String url) {
        Date d=new Date();
        this.created_by = created_by;
        this.file_name = file_name;
        this.date = d.getTime();
        this.type = type;
        this.url = url;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    @Override
    public String toString() {
        return "File{" + "created_by=" + created_by + ", file_name=" + file_name + ", date=" + date + ", type=" + type + ", url=" + url + '}';
    }

    

    
    public int getId() {
        return id;
    }

    public String getFile_name() {
        return file_name;
    }

    public long getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
    
    
}
