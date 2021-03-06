/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webX.web.helper;

import com.webX.web.helper.base.BaseHelper;
import com.webX.web.table.Number;
import com.webX.web.table.Person;
import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import com.webX.web.util.HibernateUtil;

/**
 *
 * @author Laughmare
 */
public class PhoneBookHelper extends BaseHelper{

    //Standart constructor
    public PhoneBookHelper() {
        setSession(HibernateUtil.getSessionFactory().openSession());
    }
    
    //Session inject edilmek istenirse kullanılır
    public PhoneBookHelper(Session s) {
        setSession(s);
    }
    
    //getNumbers servisi için kullanılacak çağrı. 
    //İşlem sırasında hata çıkarsa exception fırlatır.
    public List getNumbers() throws Exception {
        Query q = getSession().createQuery("from Number number");
        return q.list();
    }

    //getPeople servisi için kullanılacak çağrı. 
    //İşlem sırasında hata çıkarsa exception fırlatır.
    public List getPeople() throws Exception {
        Query q = getSession().createQuery("from Person as person");
        return q.list();
    }

    //addPerson servisi için kullanılacak çağrı. 
    //İşlem sırasında hata çıkarsa rollback edilir ve exception fırlatır
    public void addPerson(String name) throws Exception {
        startTx();
        try {
            Person p = new Person();
            p.setName(name);
            getSession().save(p);
        } catch (Exception ex) {
            rollBack();
            throw ex;
        }
        commit();
    }

    //addPerson servisi için kullanılacak çağrı. 
    //İşlem sırasında hata çıkarsa rollback edilir ve exception fırlatır.
    public void addNumber(Integer personId, String number) throws Exception {
        startTx();
        try {
            Number n = new Number();
            n.setNumber(number);
            Person p = getSession().find(Person.class, personId);
            n.setPersonId(p.getPersonId());
            getSession().save(n);
        } catch (Exception ex) {
            rollBack();
            throw ex;
        }
        commit();
    }
}
