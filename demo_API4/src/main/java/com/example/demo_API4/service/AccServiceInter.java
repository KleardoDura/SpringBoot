package com.example.demo_API4.service;

import com.example.demo_API4.models.Account;

import java.util.List;

public interface AccServiceInter {
    Account createAccount(Account account);
    Account updateAccount(Account account);
    List<Account> getAllAccount();
    Account getAccountById(long account_no);
    void deleteAccount(long account_no);




}
