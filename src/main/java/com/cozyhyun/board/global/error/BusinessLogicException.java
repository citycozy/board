package com.sku.codesnippetshop.global.error;


import com.sku.codesnippetshop.global.response.ResponseStatus;

public class BusinessLogicException extends RuntimeException{

    public BusinessLogicException(ResponseStatus responseStatus){
        super(responseStatus.getMessage());
    }

    public BusinessLogicException(String message){
        super(message);
    }
}