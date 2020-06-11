/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.jaxws.connexion;

import java.io.FileInputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;


/**
 *
 * @author Boule
 */
public class JaxwsDataSource{
    private static JaxwsDataSource instance;

    private JaxwsDataSource() {

    }

    public static JaxwsDataSource getInstance() throws Exception {
        if (instance == null) {
            instance = new JaxwsDataSource();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("C:\\Users\\Boule\\Documents\\NetBeansProjects\\SERVICE_COURS\\src\\main\\java\\fr\\doranco\\bdd\\dbfile.properties"));
            String user = prop.getProperty("user");
            String passwd = prop.getProperty("passwd");
            String url = prop.getProperty("url");

            connection = DriverManager.getConnection(url, user, passwd);
            
        } catch (Exception e) {
            System.err.println("Un problème de connexion est survenu." + e);

        }
        return connection;
    }
}
