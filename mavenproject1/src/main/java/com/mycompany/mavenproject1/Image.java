/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RoosY
 */
@XmlRootElement 
public class Image {
    String id;
    String nom;

    public Image() {
    }

    public Image(String id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public String getId() {
        return id;
    }

   

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    
}
