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
public class Freind {
    
    int id;
    int id_user;
    int id_freind;

    public Freind() {
    }

    public Freind(int id, int id_user, int id_freind) {
        this.id = id;
        this.id_user = id_user;
        this.id_freind = id_freind;
    }

    public int getId() {
        return id;
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_freind() {
        return id_freind;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_freind(int id_freind) {
        this.id_freind = id_freind;
    }
    
    
    
}
