package com.example.demo_API4.service;
import com.example.demo_API4.models.Account;
import com.example.demo_API4.models.customerModel;
import java.util.List;
import com.example.demo_API4.models.Account;

public interface CustemerServiceInter {


    customerModel createCustomer(customerModel customer);
    customerModel updateCustomer (customerModel customer);

     List<customerModel> getAllcustomerModel();

     customerModel getCustomerById(long  customer_no);

     void deleteCustomer(long  customer_no);


     List <Account> getCustAndAccById(long customer_no);




}
