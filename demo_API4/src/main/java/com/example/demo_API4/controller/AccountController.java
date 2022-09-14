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
import com.example.demo_API4.service.AccServiceInter;

@RestController
public class AccountController {

    @Autowired
    private AccServiceInter accServiceInter;

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAllAccount(){
        return ResponseEntity.ok().body(accServiceInter.getAllAccount());
    }

    @GetMapping("/accounts/{account_no}")
    public ResponseEntity<Account>  getAccountByID(@PathVariable long account_no){
        return ResponseEntity.ok().body(accServiceInter.getAccountById(account_no));
    }
    @PostMapping("/accounts")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        return ResponseEntity.ok().body(this.accServiceInter.createAccount(account));
    }

    @PutMapping("/accounts/{account_no}")
    public ResponseEntity<Account> cupdateAccount(@PathVariable long account_no,@RequestBody Account account){
        account.setAccount_no(account_no);
        return ResponseEntity.ok().body(this.accServiceInter.updateAccount(account));
    }


    @DeleteMapping("/accounts/{account_no}")
    public HttpStatus deleteCustomer (@PathVariable long account_no){
        this.accServiceInter.deleteAccount(account_no);
        return HttpStatus.OK;
    }


}
