package com.example.ExpenseTracker.service;

import com.example.ExpenseTracker.model.Expense;
import com.example.ExpenseTracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository repository;

    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    public Expense getExpenseById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public Expense saveExpense(Expense expense) {
        return repository.save(expense);
    }

    public Expense updateExpense(Long id, Expense updatedExpense) {
        Expense expense = getExpenseById(id);
        expense.setTitle(updatedExpense.getTitle());
        expense.setAmount(updatedExpense.getAmount());
        expense.setExp_date(updatedExpense.getExp_date());
        expense.setCategory(updatedExpense.getCategory());
        expense.setDescription(updatedExpense.getDescription());
        return repository.save(expense);
    }

    public void deleteExpense(Long id) {
        repository.deleteById(id);
    }
}
