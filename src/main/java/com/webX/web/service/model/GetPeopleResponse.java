/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webX.web.service.model;

import com.webX.web.service.model.base.BaseResponse;
import com.webX.web.table.Person;
import java.util.List;

/**
 *
 * @author Laughmare
 */
public class GetPeopleResponse extends BaseResponse {
    List<Person> personList;

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    
}
