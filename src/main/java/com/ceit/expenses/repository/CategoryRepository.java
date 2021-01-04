package com.ceit.expenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceit.expenses.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
