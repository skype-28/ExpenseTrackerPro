package com.skp.expensetrackerpro.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private ExpenseCategory category;

    @Column(length = 500)
    private String description;

    private LocalDate expenseDate;

    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
    return title;
}

public void setTitle(String title) {
    this.title = title;
}

public BigDecimal getAmount() {
    return amount;
}

public void setAmount(BigDecimal amount) {
    this.amount = amount;
}

public ExpenseCategory getCategory() {
    return category;
}

public void setCategory(ExpenseCategory category) {
    this.category = category;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

public LocalDate getExpenseDate() {
    return expenseDate;
}

public void setExpenseDate(LocalDate expenseDate) {
    this.expenseDate = expenseDate;
}

public LocalDateTime getCreatedAt() {
    return createdAt;
}

public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
}

public User getUser() {
    return user;
}
    
}
