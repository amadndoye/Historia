/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ.upem.localHistory.database;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author bryan
 */
@Entity
public class Monument implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;

    public String getName() {
        return name;
    }

    public void setId(String name) {
        this.name = name;
    }

   

    @Override
    public String toString() {
        return "fr.univ.upem.localHistory.database.Monument[ name=" + name + " ]";
    }
    
}
