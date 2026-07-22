package com.skp.expensetrackerpro.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skp.expensetrackerpro.dto.ExpenseDto;
import com.skp.expensetrackerpro.entity.Expense;
import com.skp.expensetrackerpro.entity.User;
import com.skp.expensetrackerpro.repository.ExpenseRepository;
import com.skp.expensetrackerpro.service.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public void saveExpense(ExpenseDto dto, User user) {

        Expense expense = new Expense();

        expense.setTitle(dto.getTitle());
        expense.setAmount(dto.getAmount());
        expense.setCategory(dto.getCategory());
        expense.setDescription(dto.getDescription());
        expense.setExpenseDate(dto.getExpenseDate());
        expense.setUser(user);

        expenseRepository.save(expense);
    }

    @Override
    public List<Expense> getUserExpenses(User user) {
        return expenseRepository.findByUserOrderByExpenseDateDesc(user);
    }

}