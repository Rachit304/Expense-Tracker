package com.example.ExpenseTracker.service;

import com.example.ExpenseTracker.model.Expense;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ExpenseService {
    List<Expense> getAllExpenses();
    Expense getExpenseById(Long id);
    Expense saveExpense(Expense expense);
    Expense updateExpense(Long id, Expense expense);
    void deleteExpense(Long id);
}

