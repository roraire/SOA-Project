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
public class User {
    
    int id;
    String nom;
    String prenom;
    String email;
    String password;
    String pays;
    String ville;

    public User() {
    }

    public User( String nom, String prenom, String email, String password) {
        
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        
    }
    

    
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPays() {
        return pays;
    }

    public String getVille() {
        return ville;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
    
    
    
           
    
}
