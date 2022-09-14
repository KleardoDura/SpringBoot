package com.example.demo_API4.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotFoundExc extends RuntimeException{

    private static final long serialVersionUID=1L;

    public ResourceNotFoundExc(String message){
        super(message);
    }

    public ResourceNotFoundExc(String message,Throwable throwable){
        super(message,throwable);
    }
}
