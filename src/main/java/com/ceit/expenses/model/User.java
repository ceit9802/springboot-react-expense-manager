package com.ceit.expenses.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User {

	@Id
	private Long id;

	private String name;

//	@OneToMany(fetch = FetchType.LAZY)
//	private Set<Category> categories;
}
