/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webX.web.helper.base;

import org.hibernate.Session;

/**
 *
 * @author Laughmare
 */
public class BaseHelper {
    
    Session session;

    protected void startTx() {
        session.beginTransaction();
    }

    protected void commit() {
        session.getTransaction().commit();
        session.clear();
    }

    protected void rollBack() {
        session.getTransaction().rollback();
        session.clear();
    }
    
    protected Session getSession() {
        return session;
    }

    protected void setSession(Session session) {
        this.session = session;
    }
    
    
}
