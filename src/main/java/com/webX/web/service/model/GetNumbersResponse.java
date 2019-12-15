/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webX.web.service.model;
import com.webX.web.service.model.base.BaseResponse;
import com.webX.web.table.Number;
import java.util.List;

/**
 *
 * @author Laughmare
 */
//getNumbers servisi için dönecek değerleri tutan class
public class GetNumbersResponse extends BaseResponse {
    List<Number> numberList;

    public List<Number> getNumberList() {
        return numberList;
    }

    public void setNumberList(List<Number> numberList) {
        this.numberList = numberList;
    }
    
    
}
