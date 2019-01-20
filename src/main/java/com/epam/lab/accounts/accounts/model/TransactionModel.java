package com.epam.lab.accounts.accounts.model;

import com.epam.lab.accounts.accounts.dto.DataClass;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class TransactionModel extends DataClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(targetEntity = AccountModel.class)
    private AccountModel fromAccount;
    @OneToOne(targetEntity = AccountModel.class)
    private AccountModel toAccount;
    private BigDecimal value;
    private BigDecimal fromCurrentBalance;
    private BigDecimal toCurrentBalance;
    private BigDecimal fromTargetBalance;
    private BigDecimal toTargetBalance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountModel getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(AccountModel fromAccount) {
        this.fromAccount = fromAccount;
    }

    public AccountModel getToAccount() {
        return toAccount;
    }

    public void setToAccount(AccountModel toAccount) {
        this.toAccount = toAccount;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getFromCurrentBalance() {
        return fromCurrentBalance;
    }

    public void setFromCurrentBalance(BigDecimal fromCurrentBalance) {
        this.fromCurrentBalance = fromCurrentBalance;
    }

    public BigDecimal getToCurrentBalance() {
        return toCurrentBalance;
    }

    public void setToCurrentBalance(BigDecimal toCurrentBalance) {
        this.toCurrentBalance = toCurrentBalance;
    }

    public BigDecimal getFromTargetBalance() {
        return fromTargetBalance;
    }

    public void setFromTargetBalance(BigDecimal fromTargetBalance) {
        this.fromTargetBalance = fromTargetBalance;
    }

    public BigDecimal getToTargetBalance() {
        return toTargetBalance;
    }

    public void setToTargetBalance(BigDecimal toTargetBalance) {
        this.toTargetBalance = toTargetBalance;
    }
}
