package com.skp.expensetrackerpro.dto;

import java.math.BigDecimal;
import java.util.List;

import com.skp.expensetrackerpro.entity.Expense;

public class DashboardDto {

    private BigDecimal totalExpense;

    private BigDecimal totalIncome;

    private BigDecimal balance;

    private long totalTransactions;

    private List<Expense> recentExpenses;

    public DashboardDto() {

        totalExpense = BigDecimal.ZERO;
        totalIncome = BigDecimal.ZERO;
        balance = BigDecimal.ZERO;

    }

    public BigDecimal getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(BigDecimal totalExpense) {
        this.totalExpense = totalExpense;
    }

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public long getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(long totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public List<Expense> getRecentExpenses() {
        return recentExpenses;
    }

    public void setRecentExpenses(List<Expense> recentExpenses) {
        this.recentExpenses = recentExpenses;
    }

}