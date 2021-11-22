/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mhaddad.pfw.services;


import com.mhaddad.pfw.daos.PublicationDao;
import com.mhaddad.pfw.entites.Publication;
import java.util.List;

/**
 *
 * @author charl
 */
public class PublicationServices {
   private PublicationDao dao;

    public void setDao(PublicationDao dao) {
        this.dao = dao;
    }
    
    public Publication trouverPublicationParId(int id){
        return dao.findById(id);
    }
    public List<Publication> trouverToutParPseudonyme(String id){
        return dao.trouverToutParPseudonyme(id);
    }
    
}
