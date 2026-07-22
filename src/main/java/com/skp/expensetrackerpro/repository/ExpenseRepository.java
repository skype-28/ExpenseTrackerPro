package com.skp.expensetrackerpro.repository;

import java.util.List;
import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skp.expensetrackerpro.entity.Expense;
import com.skp.expensetrackerpro.entity.User;

public interface ExpenseRepository extends JpaRepository<Expense,Long>{

    List<Expense> findByUserOrderByExpenseDateDesc(User user);

    List<Expense> findTop5ByUserOrderByExpenseDateDesc(User user);

    long countByUser(User user);

    @Query("""
        SELECT COALESCE(SUM(e.amount),0)
        FROM Expense e
        WHERE e.user=:user
    """)
    BigDecimal getTotalExpense(User user);

}