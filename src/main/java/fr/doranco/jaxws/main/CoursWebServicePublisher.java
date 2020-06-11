/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.jaxws.main;

import fr.doranco.jaxws.CoursService;
import javax.xml.ws.Endpoint;

/**
 *
 * @author Boule
 */
public class CoursWebServicePublisher {
    public static void main(String[] args) throws ClassNotFoundException{
        try{
            System.err.println("Service Web Cours en cours");
            Endpoint.publish("http://localhost:9991/ws/cours-service", new CoursService());
            System.err.println("Le service web Cours a bien été publié.");
        }catch(Exception e){
            System.err.println("Une erreur de publication est survenue");
            System.err.println(e.getMessage());
        }
        
    }
    
}
