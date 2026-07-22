package com.skp.expensetrackerpro.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.skp.expensetrackerpro.entity.ExpenseCategory;

import jakarta.validation.constraints.*;

public class ExpenseDto {
    
    @NotBlank
    private String title;

    @NotNull
    @DecimalMin("0.01")
    private BigDecimal amount;

    @NotNull
    private ExpenseCategory category;

    private String description;

    @NotNull
    private LocalDate expenseDate;

    public LocalDate getExpenseDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getExpenseDate'");
    }

    public String getDescription() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDescription'");
    }

    public ExpenseCategory getCategory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCategory'");
    }

    public BigDecimal getAmount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAmount'");
    }

    public String getTitle() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTitle'");
    }
}
