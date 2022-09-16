package com.example.demo_API4.controller;

import com.example.demo_API4.DTO.CustomerDto;
import com.example.demo_API4.service.CusDtoClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerDtoController {

    @Autowired
    private CusDtoClass cusDto;


    @GetMapping("/cust_dto")
    public List<CustomerDto> getCustomerDto(){

    return cusDto.getCustomerDto();
        }
}
