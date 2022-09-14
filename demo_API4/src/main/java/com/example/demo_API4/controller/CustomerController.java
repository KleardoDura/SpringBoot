package com.example.demo_API4.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo_API4.models.Account;


import com.example.demo_API4.models.customerModel;
import com.example.demo_API4.service.CustemerServiceInter;


@RestController
public class CustomerController {

    @Autowired
    private CustemerServiceInter customerService;


        @GetMapping("/customers")
        public ResponseEntity<List<customerModel>> getAllCustomer(){
            return ResponseEntity.ok().body(customerService.getAllcustomerModel());
        }


        @GetMapping("customer_acc/{customer_no}")
        public ResponseEntity<List<Account>> getCustAndAccById(@PathVariable long customer_no){
            return ResponseEntity.ok().body(customerService.getCustAndAccById(customer_no));
        }


        @GetMapping("/customers/{customer_no}")
        public ResponseEntity<customerModel> getProductById(@PathVariable long customer_no ){
            return ResponseEntity.ok().body(customerService.getCustomerById(customer_no));
        }

        @PostMapping("/customers")
        public ResponseEntity<customerModel>  createCustomer (@RequestBody customerModel customer){
            return ResponseEntity.ok().body(this.customerService.createCustomer(customer));
        }

        @PutMapping("/customers/{customer_no}")
        public ResponseEntity<customerModel> updateCustomer(@PathVariable long customer_no, @RequestBody customerModel customer){
            customer.setCustomer_no(customer_no);
            return ResponseEntity.ok().body(this.customerService.updateCustomer(customer));
        }

        @DeleteMapping("/customers/{customer_no}")
        public HttpStatus deleteCustomer (@PathVariable long customer_no){
            this.customerService.deleteCustomer(customer_no);
            return HttpStatus.OK;
        }
    }