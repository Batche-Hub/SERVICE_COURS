/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.jaxws.dao;



import fr.doranco.jaxws.connexion.JaxwsDataSource;
import fr.doranco.entity.Cours;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Boule
 */
public class CoursDAO implements ICoursDAO {

    //Constructeur
    public CoursDAO() {
    }
    
    //Méthodes de l'interface à redéfinir
    @Override
    public Cours getCoursById(int id) throws Exception{
        Cours cours = new Cours();
        Connection connexion = JaxwsDataSource.getInstance().getConnection();

        String requete = "SELECT * FROM cours WHERE id = ?";
        PreparedStatement ps = null;
        try {
            
            ps = connexion.prepareStatement(requete);
            ps.setInt(1, id);
            
            
            ResultSet rs = ps.executeQuery();
            

            if (rs.next()) {
                
                cours.setId(rs.getInt("id"));
                cours.setType(rs.getString("type"));
            }
        } catch (Exception e) {
            System.out.println("Une erreur est survenue : " + e);
            return null;
        } finally {
            if (connexion != null) {
                try {
                    connexion.close();
                } catch (SQLException ex) {
                    System.err.println("Une erreur Sql est survenue : " + ex);
                    
                }

            }

        }
        return cours;
    }

    @Override
    public Cours addCours(Cours cours) throws Exception{
        Connection connexion = JaxwsDataSource.getInstance().getConnection();

        String requete = "INSERT INTO cours(type) VALUE(?)";
        PreparedStatement ps = null;
        try {
            
            ps = connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, cours.getType());


            ps.executeUpdate();

            ResultSet resultSet = ps.getGeneratedKeys();

            if (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                cours.setId(id);
            }

        } catch (Exception e) {
            System.err.println("Une erreur de connexion est survenue." + e);
        } finally {
            if (connexion != null) {
                try {
                    connexion.close();
                } catch (SQLException ex) {
                   System.err.println("Une erreur SQL est survenue : "+ex);
                }
            }

        }
        return cours;
    }

    

    @Override
    public List<Cours> getListeCours() throws Exception{
        List<Cours> listeCours = new ArrayList<>();
       
        Connection connexion = JaxwsDataSource.getInstance().getConnection();
       
        String requete = "SELECT * FROM cours";
        PreparedStatement ps = null;
        try {
            ps = connexion.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();
            
           
            while (rs.next()) {
               
                Cours cours = new Cours();
               
                cours.setId(rs.getInt("id"));
                cours.setType(rs.getString("type"));
                
               
                listeCours.add(cours);
            }
           
        } catch (SQLException e) {
            System.err.println("Une erreur SQL est survenue : "+e);
        } finally {
            if (connexion != null) {
                try {
                    connexion.close();
                } catch (SQLException ex) {
                    System.err.println("Erreur de connexion SQL : " + ex);
                }
            }
        }
        return listeCours;  
    }
}
