package com.example.demo_API4.models;
import javax.persistence.*;
import java.awt.print.Book;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.example.demo_API4.models.Account;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="Customer")
public class customerModel {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="customer_no")
    private long  customer_no;

    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name="birthday")
    private Date birthday;
    @Column(name="email")
    private String email;
    @Column(name="phone_no")
    private String phone_no;


    @OneToMany(targetEntity = Account.class,fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true )
    @JoinColumn(name="cust_no",referencedColumnName ="customer_no" )



    public List<Account> account;


    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }


    public long getCustomer_no(){//duhet string
        return customer_no;
    }
    public void setCustomer_no(long  customer_no){
        this.customer_no=customer_no;
    }

    //
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    //
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    //
    public Date getBirthday(){
        return birthday;
    }
    public void setBirthday(Date birthday){
        this.birthday=birthday;
    }

    //
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }

    //
    public String getPhone_no(){
        return phone_no;
    }
    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }
}
