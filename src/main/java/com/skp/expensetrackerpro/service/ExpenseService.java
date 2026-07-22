package com.skp.expensetrackerpro.service;

import java.util.List;

import com.skp.expensetrackerpro.dto.ExpenseDto;
import com.skp.expensetrackerpro.entity.Expense;
import com.skp.expensetrackerpro.entity.User;

public interface ExpenseService {

    void saveExpense(ExpenseDto dto, User user);

    List<Expense> getUserExpenses(User user);
    
}
