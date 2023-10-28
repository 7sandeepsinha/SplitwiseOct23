package com.scaler.Splitwise.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "SPLITWISE_EXPENSE")
public class Expense extends BaseModel{
    private double amount;
    private String description;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @OneToMany
    @JoinColumn(name = "splitwise_expense_id")
    private List<UserExpense> userExpenses;
}
