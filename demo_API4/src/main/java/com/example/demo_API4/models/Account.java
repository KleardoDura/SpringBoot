package com.example.demo_API4.models;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Account")
public class Account {
    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="account_no")
    private long  account_no;

    @Column(name="branch_code")
    private String branch_code;



    @Column(name="cust_no")
    private long cust_no;

    @Column(name="ccy")
    private String ccy;

    @Column(name="amount")
    private long amount;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name="acc_open_date")
    private Date acc_open_date;



    public long getAccount_no() {
        return account_no;
    }

    public void setAccount_no(long account_no) {
        this.account_no = account_no;
    }



    public String getBranch_code() {
        return branch_code;
    }

    public void setBranch_code(String branch_code) {
        this.branch_code = branch_code;
    }


    public long getCust_no() {
        return cust_no;
    }

    public void setCust_no(long cust_no) {
        this.cust_no = cust_no;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Date getAcc_open_date() {
        return acc_open_date;
    }

    public void setAcc_open_date(Date acc_open_date) {
        this.acc_open_date = acc_open_date;
    }
}
