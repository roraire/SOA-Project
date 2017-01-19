/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.Model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author boukarabilaa
 */

@XmlRootElement 
public class Share {
    int id;
    int id_file;
    int created_by;
    int shared_with;

    public Share() {
    }

    public Share(int id, int id_file, int created_by, int shared_with) {
        this.id = id;
        this.id_file = id_file;
        this.created_by = created_by;
        this.shared_with = shared_with;
    }

    public int getId() {
        return id;
    }

    public int getId_file() {
        return id_file;
    }

    public int getCreated_by() {
        return created_by;
    }

    public int getShared_with() {
        return shared_with;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_file(int id_file) {
        this.id_file = id_file;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public void setShared_with(int shared_with) {
        this.shared_with = shared_with;
    }
    
    
    
    
    
    
    
    
    
    
}
