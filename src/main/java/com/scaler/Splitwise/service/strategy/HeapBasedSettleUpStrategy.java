package com.scaler.Splitwise.service.strategy;

import com.scaler.Splitwise.dto.TransactionDTO;
import com.scaler.Splitwise.model.Expense;
import com.scaler.Splitwise.model.User;
import com.scaler.Splitwise.model.UserExpense;
import com.scaler.Splitwise.model.UserExpenseType;

import java.util.*;

public class HeapBasedSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<TransactionDTO> settleUp(List<Expense> expenses) {
        HashMap<User, Double> outStandingAmountMap = new HashMap<>();
        List<TransactionDTO> transactions = new ArrayList<>();
        // Loop through all expenses and userExpenses for each expense, and calculate the final outstanding amount for each user
        for(Expense expense : expenses){
            for(UserExpense userExpense : expense.getUserExpenses()){
                User user = userExpense.getUser();
                double currentOutStandingAmount = outStandingAmountMap.getOrDefault(user, 0.00);
                outStandingAmountMap.put(user, getUpdatedOutStandingAmount(currentOutStandingAmount, userExpense));
            }
        }

        //MaxHeap -> contains all the users with positive balance
        PriorityQueue<Map.Entry<User,Double>> maxHeap = new PriorityQueue<>(
                (a,b) -> Double.compare(b.getValue(), a.getValue())
        );

        //MinHeap -> contains all the users with negative balance
        PriorityQueue<Map.Entry<User,Double>> minHeap = new PriorityQueue<>(
                Comparator.comparingDouble(Map.Entry::getValue)
        );

        //populate the heaps using the values from the map
        for(Map.Entry<User,Double> entry : outStandingAmountMap.entrySet()){
            if(entry.getValue() < 0){
                minHeap.add(entry);
            } else if(entry.getValue() > 0){
                maxHeap.add(entry);
            } else {
                System.out.println(entry.getKey().getName() + "'s is already settled up");
            }
        }


        //calculate the transactions until the heaps become empty
        //







    }

    private double getUpdatedOutStandingAmount(double currentOutStandingAmount, UserExpense userExpense){
        if(userExpense.getUserExpenseType().equals(UserExpenseType.PAID)){
            currentOutStandingAmount = currentOutStandingAmount + userExpense.getAmount();
        } else {
            currentOutStandingAmount = currentOutStandingAmount - userExpense.getAmount();
        }
        return currentOutStandingAmount;
    }
}


/*
        Expense
              paid -   A => 500 B=>500
              hadToPay - A=> 250 B=> 250 C=> 250 D=>250
 */