package com.scaler.Splitwise.service;

import com.scaler.Splitwise.model.*;
import com.scaler.Splitwise.repository.ExpenseRepository;
import com.scaler.Splitwise.repository.GroupRepository;
import com.scaler.Splitwise.repository.UserExpenseRepository;
import com.scaler.Splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitServiceImpl implements InitService{

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserExpenseRepository userExpenseRepository;

    @Autowired
    private ExpenseRepository expenseRepository;



    @Override
    public void initialise() {
        Group group = new Group();
        group.setName("Go Goa Gone");
        group.setDescription("Goa trip that will never happen");
        group.setDefaultCurrency(Currency.INR);
        Group savedGroup = groupRepository.save(group);

        User a = User.builder()
                .name("A")
                .email("a@email.com")
                .phoneNumber("123")
                .groups(List.of(savedGroup)).build();

        User b = User.builder()
                .name("B")
                .email("b@email.com")
                .phoneNumber("123")
                .groups(List.of(savedGroup)).build();

        User c = User.builder()
                .name("C")
                .email("c@email.com")
                .phoneNumber("123")
                .groups(List.of(savedGroup)).build();

        User d = User.builder()
                .name("D")
                .email("d@email.com")
                .phoneNumber("123")
                .groups(List.of(savedGroup)).build();

        User e = User.builder()
                .name("E")
                .email("e@email.com")
                .phoneNumber("123")
                .groups(List.of(savedGroup)).build();

        User f = User.builder()
                .name("F")
                .email("f@email.com")
                .phoneNumber("123")
                .groups(List.of(savedGroup)).build();

        User savedUserA = userRepository.save(a);
        User savedUserB = userRepository.save(b);
        User savedUserC = userRepository.save(c);
        User savedUserD = userRepository.save(d);
        User savedUserE = userRepository.save(e);
        User savedUserF = userRepository.save(f);

        savedGroup.setUsers(List.of(savedUserA, savedUserB, savedUserC, savedUserD, savedUserE, savedUserF));
        savedGroup = groupRepository.save(savedGroup);

        UserExpense userExpenseA = new UserExpense();
        userExpenseA.setUserExpenseType(UserExpenseType.HADTOPAY);
        userExpenseA.setAmount(500);
        userExpenseA.setUser(savedUserA);
        UserExpense savedUserExpenseA = userExpenseRepository.save(userExpenseA);

        UserExpense userExpenseB = new UserExpense();
        userExpenseB.setUserExpenseType(UserExpenseType.HADTOPAY);
        userExpenseB.setAmount(2000);
        userExpenseB.setUser(savedUserB);
        UserExpense savedUserExpenseB = userExpenseRepository.save(userExpenseB);

        UserExpense userExpenseC = new UserExpense();
        userExpenseC.setUserExpenseType(UserExpenseType.HADTOPAY);
        userExpenseC.setAmount(500);
        userExpenseC.setUser(savedUserC);
        UserExpense savedUserExpenseC = userExpenseRepository.save(userExpenseC);

        UserExpense userExpenseD = new UserExpense();
        userExpenseD.setUserExpenseType(UserExpenseType.PAID);
        userExpenseD.setAmount(1500);
        userExpenseD.setUser(savedUserD);
        UserExpense savedUserExpenseD = userExpenseRepository.save(userExpenseD);

        UserExpense userExpenseE = new UserExpense();
        userExpenseE.setUserExpenseType(UserExpenseType.PAID);
        userExpenseE.setAmount(500);
        userExpenseE.setUser(savedUserE);
        UserExpense savedUserExpenseE = userExpenseRepository.save(userExpenseE);

        UserExpense userExpenseF = new UserExpense();
        userExpenseF.setUserExpenseType(UserExpenseType.PAID);
        userExpenseF.setAmount(1000);
        userExpenseF.setUser(savedUserF);
        UserExpense savedUserExpenseF = userExpenseRepository.save(userExpenseF);

        Expense expense = new Expense();
        expense.setDescription("Total trip expense");
        expense.setAmount(3000);
        expense.setUserExpenses(List.of(savedUserExpenseA, savedUserExpenseB, savedUserExpenseC, savedUserExpenseD, savedUserExpenseE, savedUserExpenseF));
        expense.setCurrency(Currency.INR);
        Expense savedExpense = expenseRepository.save(expense);

        savedGroup.setExpenses(List.of(savedExpense));
        groupRepository.save(savedGroup);

    }
}
