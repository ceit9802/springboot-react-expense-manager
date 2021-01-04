package com.ceit.expenses.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")
	private Long id;

	@NotNull
	private String name;

//	@ManyToOne(cascade = CascadeType.PERSIST)
//	private User user;

}
