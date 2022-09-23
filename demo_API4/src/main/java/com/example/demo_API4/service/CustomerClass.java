package com.example.demo_API4.service;
import com.example.demo_API4.exception.ResourceNotFoundExc;
import com.example.demo_API4.models.Account;
import com.example.demo_API4.models.customerModel;
import com.example.demo_API4.repository.AccountRepository;
import com.example.demo_API4.repository.CustomerRepository;
import com.example.demo_API4.service.CustemerServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.*;

import java.util.List;

@Service
@Transactional
public class CustomerClass implements  CustemerServiceInter{

    @Autowired
    private CustomerRepository  customerRepository;
    @Autowired
    private AccountRepository accountRepository;


    @Override
    public customerModel createCustomer(customerModel customer) {
        return customerRepository.save(customer);

    }



    @Override
    public customerModel updateCustomer(customerModel customer) {
        Optional<customerModel> customerDb=this.customerRepository.findById(customer.getCustomer_no());


         if(customerDb.isPresent()){
             customerModel customerUpdate =customerDb.get();
             customerUpdate.setCustomer_no(customer.getCustomer_no());
             customerUpdate.setFirstName(customer.getFirstName());
             customerUpdate.setLastName(customer.getLastName());
             customerUpdate.setBirthday(customer.getBirthday());
             customerUpdate.setEmail(customer.getEmail());
             customerUpdate.setPhone_no(customerUpdate.getPhone_no());
             customerUpdate.setAccount(customer.getAccount());
             customerRepository.save(customerUpdate);
             return customerUpdate;

         }
         else{
             throw new ResourceNotFoundExc("SORRY :/ but record not found with id:"+customer.getCustomer_no() );
         }
    }


    @Override
    public List<customerModel> getAllcustomerModel() {
        return this.customerRepository.findAll();
    }


    @Override
    public List<Account> getCustAndAccById(long customer_no){
        return  this.accountRepository.findByCust_no(customer_no);
    }


    @Override
    public customerModel getCustomerById(long customer_no) {

            Optional<customerModel> customerDb=this.customerRepository.findById(customer_no);


            if(customerDb.isPresent()) {
                return customerDb.get();
            }
            else{
                throw new ResourceNotFoundExc("SORRY :/ but record not found with id:"+ customer_no );
            }
}

    @Override
    public void deleteCustomer(long customer_no) {

        Optional<customerModel> customerDb=this.customerRepository.findById(customer_no);


        if(customerDb.isPresent()) {
           this.customerRepository.delete(customerDb.get());
        }
        else{
            throw new ResourceNotFoundExc("SORRY :/ but record not found with id:"+ customer_no );
        }
    }
}