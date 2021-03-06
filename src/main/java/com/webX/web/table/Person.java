package com.webX.web.table;
// Generated 12.Ara.2019 21:19:35 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Person generated by hbm2java
 */
public class Person  implements java.io.Serializable {


     private Integer personId;
     private String name;
     private Set numbers = new HashSet(0);

    public Person() {
    }

	
    public Person(String name) {
        this.name = name;
    }
    public Person(String name, Set numbers) {
       this.name = name;
       this.numbers = numbers;
    }
   
    public Integer getPersonId() {
        return this.personId;
    }
    
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Set getNumbers() {
        return this.numbers;
    }
    
    public void setNumbers(Set numbers) {
        this.numbers = numbers;
    }




}


