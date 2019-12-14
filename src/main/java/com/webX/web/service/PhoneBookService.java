package com.webX.web.service;

import com.webX.web.service.operation.callType.PhoneBookCallType;
import com.webX.web.service.model.GetPeopleResponse;
import com.webX.web.service.model.GetNumbersResponse;
import com.webX.web.service.model.base.BaseResponse;
import com.webX.web.service.operation.PhoneBookOperations;
import com.webX.web.service.operation.base.BaseOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/PhoneBook")
public class PhoneBookService{
    BaseOperations pbo;
    
    public PhoneBookService(){
        pbo = new PhoneBookOperations();
    }
    
    public PhoneBookService(BaseOperations operations){
        pbo = operations;
    }
    
    @RequestMapping(value = "/getNumbers", method = RequestMethod.GET)
    public GetNumbersResponse getNumbers() {
        return (GetNumbersResponse) pbo.doOperation(PhoneBookCallType.GetNumbers);
    }

    @RequestMapping(value = "/getPeople", method = RequestMethod.GET)
    public GetPeopleResponse getPeople() {
        return (GetPeopleResponse) pbo.doOperation(PhoneBookCallType.GetPeople);
    }

    @RequestMapping(value = "/addNumber", method = RequestMethod.POST)
    public BaseResponse addNumber(@RequestParam(value = "personId") Integer personId, @RequestParam(value = "number") String number) {
        return pbo.doOperation(PhoneBookCallType.AddNumber, personId, number);
    }

    @RequestMapping(value = "/addPerson", method = RequestMethod.POST)
    public BaseResponse addPerson(@RequestParam(value = "name") String name) {
        return pbo.doOperation(PhoneBookCallType.AddPerson, name);
    }
}
