package com.example.demo_API4.repository;

import com.example.demo_API4.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo_API4.models.customerModel;
import com.example.demo_API4.models.Account;
import java.util.List;

public interface CustomerRepository  extends JpaRepository<customerModel ,Long> {



}
