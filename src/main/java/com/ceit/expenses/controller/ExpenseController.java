package com.ceit.expenses.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceit.expenses.model.Expense;
import com.ceit.expenses.repository.ExpenseRepository;

@RestController
@RequestMapping("/api")
public class ExpenseController {
	@Autowired
	private ExpenseRepository expenseRepository;

	@PostMapping("/expenses")
	ResponseEntity<Expense> createExpense(@Validated @RequestBody Expense expense) throws URISyntaxException {
		Expense result = expenseRepository.save(expense);
		return ResponseEntity.created(new URI("/api/expenses/" + result.getId())).body(result);
	}

	@DeleteMapping("/expenses/{id}")
	ResponseEntity<?> deleteExpense(@PathVariable Long id) {
		expenseRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/expenses")
	Collection<Expense> getExpenses() {
		return expenseRepository.findAll();
	}
	// TODO Add put method

	@PutMapping("/expenses")
	ResponseEntity<Expense> updateExpense(@Validated @RequestBody Expense expense) throws URISyntaxException {
		Expense result = expenseRepository.save(expense);
		return ResponseEntity.created(new URI("/api/expenses/" + result.getId())).body(result);
	}

}
