/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.jaxws;

import fr.doranco.entity.Cours;
import fr.doranco.jaxws.dao.CoursDAO;
import java.util.List;
import javax.jws.*;

/**
 *
 * @author Boule
 */
@WebService(endpointInterface = "fr.doranco.jaxws.CoursService",
        serviceName = "CoursService",
        portName = "CoursPort")
public class CoursService implements ICoursService{

    @Override
    public Cours getCoursById(int id) throws Exception {
        CoursDAO etudiant = new CoursDAO();
        Cours etudiantAjoute = etudiant.getCoursById(id);
        return etudiantAjoute;
    }

    @Override
    public Cours addCours(Cours cours) throws Exception {
         CoursDAO coursDAO = new CoursDAO();
         cours = coursDAO.addCours(cours);
         return cours;
    }

    @Override
    public List<Cours> getListeCours() throws Exception {
        CoursDAO coursDAO = new CoursDAO();
        List<Cours> listeCours = coursDAO.getListeCours();
        return listeCours;
    }
    
}
