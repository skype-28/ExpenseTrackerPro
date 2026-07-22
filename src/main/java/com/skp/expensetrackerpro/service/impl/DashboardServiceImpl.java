package com.skp.expensetrackerpro.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.skp.expensetrackerpro.dto.DashboardDto;
import com.skp.expensetrackerpro.entity.User;
import com.skp.expensetrackerpro.repository.ExpenseRepository;
import com.skp.expensetrackerpro.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final ExpenseRepository expenseRepository;

    public DashboardServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public DashboardDto getDashboard(User user) {

        DashboardDto dto = new DashboardDto();

        BigDecimal expense = expenseRepository.getTotalExpense(user);

        dto.setTotalExpense(expense);

        dto.setTotalTransactions(

                expenseRepository.countByUser(user)

        );

        dto.setRecentExpenses(

                expenseRepository
                        .findTop5ByUserOrderByExpenseDateDesc(user)

        );

        dto.setTotalIncome(BigDecimal.ZERO);

        dto.setBalance(

                dto.getTotalIncome().subtract(expense)

        );

        return dto;

    }

}