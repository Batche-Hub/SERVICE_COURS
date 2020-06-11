/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.entity;

import fr.doranco.enums.TYPESCOURS;
import javax.xml.bind.annotation.*;



/**
 *
 * @author Boule
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="cours", propOrder = {
    "id",
    "type",
})
public class Cours {
    @XmlElement(required = false)
    private Integer id;
    
    @XmlElement(required = true)
    private TYPESCOURS type;


    public Cours() {
    }

    public Cours(TYPESCOURS type) {
        this.type = type;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type.toString();
    }

    public void setType(String type) {
        this.type = TYPESCOURS.valueOf(type);
    }

    @Override
    public String toString() {
        return "Cours{" + "id=" + id + ", type=" + type + '}';
    }
 
}
