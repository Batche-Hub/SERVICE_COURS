/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.jaxws;

import fr.doranco.entity.Cours;
import java.util.List;
import javax.jws.*;


/**
 *
 * @author Boule
 */
@WebService(name="EudiantService", targetNamespace = "http://jaxws.doranco.fr")
public interface ICoursService {
    @WebMethod
    public Cours getCoursById(@WebParam int id) throws Exception;
    @WebMethod
    public Cours addCours(@WebParam Cours etudiant) throws Exception;
    @WebMethod
    public List<Cours> getListeCours() throws Exception;
}
