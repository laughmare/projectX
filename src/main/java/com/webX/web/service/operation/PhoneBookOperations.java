/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webX.web.service.operation;

import com.webX.web.service.operation.callType.PhoneBookCallType;
import com.webX.web.service.operation.base.BaseOperations;
import static com.webX.web.service.operation.callType.PhoneBookCallType.*;
import com.webX.web.helper.PhoneBookHelper;
import com.webX.web.service.model.base.BaseResponse;
import com.webX.web.service.model.GetNumbersResponse;
import com.webX.web.service.model.GetPeopleResponse;

/**
 *
 * @author Laughmare
 */
//Servislerin okunabilirliğini arttıracak ara class. 
//Her servis çağrısı doOperation methodunu çağıracaktır.
public class PhoneBookOperations extends BaseOperations{
    private PhoneBookHelper helper;
    
    //Standart constructor
    public PhoneBookOperations(){
        this.helper = new PhoneBookHelper();
    }
    
    //Test için mock class injection yaparken kullanılacak constructor
    public PhoneBookOperations(PhoneBookHelper phoneBookHelper){
        this.helper = phoneBookHelper;
    }
    
    //Her servisin çağıracağı method. 
    //Her servis için callType tanımlanmalı ve case olarak eklenmelidir.
    @Override
    public BaseResponse doOperation(Object callType, Object... args){
        BaseResponse response = new BaseResponse();
        try{
            switch ((PhoneBookCallType)callType){
                case GetNumbers:  
                    response = getNumbers();
                    break;
                case GetPeople:  
                    response = getPeople();
                    break;
                case AddNumber:  
                    response = addNumber(args);
                    break;
                case AddPerson:  
                    response = addPerson(args);
                    break;
            }
        } catch (Exception ex) {
            response = handleResponseError(ex.getMessage());
        }
        return response;
    }
    
    private GetPeopleResponse getPeople() throws Exception{
        GetPeopleResponse gpResponse = new GetPeopleResponse();    
        gpResponse.setPersonList(helper.getPeople());
        gpResponse = (GetPeopleResponse) handleResponseSuccess(gpResponse);
        return gpResponse;
    }
    
    private GetNumbersResponse getNumbers() throws Exception{
        GetNumbersResponse gnResponse = new GetNumbersResponse();    
        gnResponse.setNumberList(helper.getNumbers());
        gnResponse = (GetNumbersResponse) handleResponseSuccess(gnResponse);
        return gnResponse;
    }
    
    private BaseResponse addNumber(Object... args) throws Exception{
        Integer personId = (Integer) args[0];
        String number = (String) args[1];
        helper.addNumber(personId, number);
        return handleResponseSuccess(new BaseResponse());
    }
    
    private BaseResponse addPerson(Object... args) throws Exception{
        String name = (String) args[0];
        helper.addPerson(name);
        return handleResponseSuccess(new BaseResponse());
    }
    
}
