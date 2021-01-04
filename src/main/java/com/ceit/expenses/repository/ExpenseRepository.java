package com.ceit.expenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceit.expenses.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
