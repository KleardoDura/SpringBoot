package com.example.demo_API4.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo_API4.models.Account;
import org.springframework.data.jpa.repository.Query;
import com.example.demo_API4.models.customerModel;


import java.util.List;

public interface AccountRepository  extends JpaRepository<Account,Long> {

    @Query("from Account where cust_no=?1 order by  account_no")
    List<Account>  findByCust_no(long customer_no);
}
