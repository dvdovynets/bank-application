package com.company.bankapplication.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "account_from_id")
    private Account accountFrom;
    @OneToOne
    @JoinColumn(name = "account_to_id")
    private Account accountTo;
    private BigDecimal amount;
    private LocalDateTime data;
    private OperationType type;

    public enum OperationType {
        INCOMING, OUTGOING
    }
}
