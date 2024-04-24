package com.eazybytes.accounts.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntity{
    @Column(name="customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native")
    @Id
    private Integer customerId;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="mobile_number")
    private String mobileNumber;


}
