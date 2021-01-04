package com.ceit.expenses.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

import org.springframework.http.HttpStatus;
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

import com.ceit.expenses.model.Category;
import com.ceit.expenses.repository.CategoryRepository;

@RestController
@RequestMapping("/api")
public class CategoryController {
	private CategoryRepository categoryRepository;

	public CategoryController(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@GetMapping("/categories")
	Collection<Category> categories() {
		return categoryRepository.findAll();
	}

	@PostMapping("/category")
	ResponseEntity<Category> createCategory(@Validated @RequestBody Category category) throws URISyntaxException {
		Category result = categoryRepository.save(category);
		return ResponseEntity.created(new URI("/api/category/" + result.getId())).body(result);
	}

	@DeleteMapping("/category/{id}")
	ResponseEntity<?> deleteCategory(@PathVariable Long id) {
		categoryRepository.deleteById(id);
		return ResponseEntity.ok().build();

	}

	@GetMapping("/category/{id}")
	ResponseEntity<?> getCategory(@PathVariable Long id) {
		return categoryRepository.findById(id).map(ResponseEntity.ok()::body)
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PutMapping("/category")
	ResponseEntity<Category> updateCategory(@Validated @RequestBody Category category) throws URISyntaxException {
		Category result = categoryRepository.save(category);
		return ResponseEntity.ok().body(result);
	}

}
