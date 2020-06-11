/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.jaxws.dao;

import fr.doranco.entity.Cours;
import java.util.List;

/**
 *
 * @author Boule
 */
public interface ICoursDAO {    
    public Cours getCoursById(int id) throws Exception;
    public Cours addCours(Cours etudiant) throws Exception;
    public List<Cours> getListeCours() throws Exception;
}
