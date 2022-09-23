package com.example.demo_API4.service;

import com.example.demo_API4.DTO.CustomerDto;
import com.example.demo_API4.repository.AccountRepository;
import com.example.demo_API4.repository.CustomerRepository;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import com.example.demo_API4.models.customerModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CusDtoClass {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AccountRepository accountRepository;


    private ModelMapper modelMapper;



    private CustomerDto convertEntityToDto2(customerModel  customer ){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomer_Id(customer.getCustomer_no());
        String fullName=customer.getFirstName().concat(customer.getLastName());

           customerDto.setFullName(fullName);
      return customerDto;
   }

    public List<CustomerDto>getCustomerDto() {
        return customerRepository.findAll()
                .stream()
                .map(this::convertEntityToDto2)
                .collect(Collectors.toList());

    }





}
