package com.company.bankapplication.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Getter
@Setter
@ToString
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account_number")
    private String accountNumber;
    private Currency currency;
    private BigDecimal balance;
    @Value("${isActive:true}")
    private boolean isActive;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public enum Currency {
        USD, EUR, UAN
    }
}
