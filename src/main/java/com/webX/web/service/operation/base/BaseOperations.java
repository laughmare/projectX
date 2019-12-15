/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webX.web.service.operation.base;

import com.webX.web.service.model.base.BaseResponse;

/**
 *
 * @author Laughmare
 */
//Servislerin çağıracağı classlar için ortak methodların tutulduğu class
public class BaseOperations {

    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";

    //Bu classtan türetilecek modül içerisinde override edilmelidir.
    //örnek için bkz : PhoneBookOperations.java
    public BaseResponse doOperation(Object callType, Object... args) {
        BaseResponse response = new BaseResponse();
        return response;
    }

    //Hata durumunda baseResponse'u dolduracak method
    protected BaseResponse handleResponseError(String errorMsg) {
        BaseResponse response = new BaseResponse();
        response.setStatus(ERROR_STATUS);
        response.setErrorMessage(errorMsg);
        return response;
    }

    //Başarı durumunda baseResponse'u dolduracak method
    protected BaseResponse handleResponseSuccess(BaseResponse response) {
        response.setStatus(SUCCESS_STATUS);
        return response;
    }
}
