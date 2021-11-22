/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mhaddad.pfw.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Charles-Antoine et athoudeft
 */
public class DbConnexion {
    
    private static Connection laConnexion = null;
    private static String urlBD = "";
    private static String user = "", password = "";
    
    private DbConnexion() {
    }
    public static void loadDriver(String driverString){
        try {
            Class.forName(driverString);
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(DbConnexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }

    public static void setUrlBD(String urlBD) {
        DbConnexion.urlBD = urlBD;
    }

    public static void setUser(String user) {
        DbConnexion.user = user;
    }

    public static void setPassword(String password) {
        DbConnexion.password = password;
    }
    
    public static Connection getConnexion() {
        try {
            if (laConnexion == null || laConnexion.isClosed()) {
                    //System.out.println("Chaine du pilote : "+chainePilote);
                    //DbConnexion.loadDriver(chainePilote);
                    //Ouvrir la connexion à la BD.
                    if ("".equals(user))
                        laConnexion = DriverManager.getConnection(urlBD);
                    else
                        laConnexion = DriverManager.getConnection(urlBD,user,password);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return laConnexion;
    }
    public static void close() {
        if (laConnexion != null)
            try {
                laConnexion.close();
                laConnexion = null;
        } catch (SQLException ex) {
            //Logger.getLogger(DbConnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
