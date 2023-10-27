package com.scaler.Splitwise.service.strategy;

import com.scaler.Splitwise.dto.TransactionDTO;
import com.scaler.Splitwise.model.Expense;

import java.util.List;

public interface SettleUpStrategy {
    List<TransactionDTO> settleUp(List<Expense> expenses);
}
