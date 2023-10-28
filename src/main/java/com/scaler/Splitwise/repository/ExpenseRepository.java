package com.scaler.Splitwise.repository;

import com.scaler.Splitwise.model.Expense;
import com.scaler.Splitwise.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
}
