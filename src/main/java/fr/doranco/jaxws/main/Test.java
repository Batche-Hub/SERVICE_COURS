/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.jaxws.main;

import fr.doranco.entity.Cours;
import fr.doranco.enums.TYPESCOURS;
import fr.doranco.jaxws.CoursService;
import fr.doranco.jaxws.dao.CoursDAO;
import java.util.List;
import fr.doranco.jaxws.ICoursService;
import fr.doranco.jaxws.dao.ICoursDAO;

/**
 *
 * @author Boule
 */
public class Test {
    public static void main(String[] args) throws Exception{

        ICoursService coursService = new CoursService();
        
        Cours cours = new Cours(TYPESCOURS.POLITIQUE);        
        System.out.println("Test d'ajout du cours : "+cours);
        Cours coursAjoute = coursService.addCours(cours);
        
        if(coursAjoute.getId()!= 0){
            System.err.println("Le cours a bien été ajouté :" + coursAjoute);
        }else{
            System.err.println("Une erreur est survenue. L'étudiant n'a pas été ajouté.: Veuillez recommencer.");
        }
        
        Cours cours2 = new Cours(TYPESCOURS.SOCIOLOGIE);        
        System.out.println("Test d'ajout du cours : "+cours2);
        Cours coursAjoute2 = coursService.addCours(cours2);
        
        if(coursAjoute2.getId()!= 0){
            System.err.println("Le cours a bien été ajouté :" + coursAjoute);
        }else{
            System.err.println("Une erreur est survenue. L'étudiant n'a pas été ajouté.: Veuillez recommencer.");
        }
        
        
        System.err.println("Test de récupération de la liste des étudiants...");
        List<Cours> listeCours = coursService.getListeCours();
        
        for(Cours coursAjoutes : listeCours){
            System.err.println("Voici les cours : "+coursAjoutes);
        }
    }
}
