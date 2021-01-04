package com.ceit.expenses.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "expense")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expense_sequence")
	private Long id;
	private Instant expenseDate;
	private String description;
	private Double amount;
	private String location;

	@ManyToOne
	private Category category;

	@ManyToOne
	@JsonIgnore
	private User user;

}
