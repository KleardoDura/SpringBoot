package com.example.demo_API4.service;
import com.example.demo_API4.exception.ResourceNotFoundExc;
import com.example.demo_API4.models.Account;
import com.example.demo_API4.repository.AccountRepository;
import com.example.demo_API4.service.AccServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo_API4.exception.ResourceNotFoundExc;

import javax.transaction.Transactional;
import java.util.*;

import java.util.List;

@Service
@Transactional
public class AccServiceClass implements AccServiceInter {

    @Autowired
    private  AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Account account){
        Optional<Account> accountDb=this.accountRepository.findById(account.getAccount_no());

        if (accountDb.isPresent()){
            Account accountUpdate = accountDb.get();
            accountUpdate.setAccount_no(account.getAccount_no());
            accountUpdate.setCust_no(account.getCust_no());
            accountUpdate.setBranch_code(account.getBranch_code());
            accountUpdate.setAcc_open_date(account.getAcc_open_date());
            accountUpdate.setCcy(account.getCcy());
            accountUpdate.setAmount(account.getAmount());
          //  accountUpdate.setCustomer(account.getCustomer());
            accountRepository.save(accountUpdate);
            return accountUpdate;
        }

        else{
            throw new ResourceNotFoundExc("SORRY :/ but record not found with id:"+account.getAccount_no());
        }

    }

    @Override
   public List<Account> getAllAccount() {
        return  this.accountRepository.findAll();
    }
    @Override
    public Account getAccountById(long account_no){
        Optional<Account> accountDb=this.accountRepository.findById(account_no);

        if(accountDb.isPresent()){
            return accountDb.get();
        }
        else{
            throw new ResourceNotFoundExc("SORRY :/ but record not found with id:"+ account_no );
        }

    }

    @Override
    public void deleteAccount(long account_no){
        Optional<Account> accountDb=this.accountRepository.findById(account_no);
        if(accountDb.isPresent()){
           this.accountRepository.delete(accountDb.get());
        }
        else{
            throw new ResourceNotFoundExc("SORRY :/ but record not found with id:"+ account_no );
        }

    }







}
