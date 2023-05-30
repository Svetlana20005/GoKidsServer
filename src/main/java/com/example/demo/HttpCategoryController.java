package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class HttpCategoryController extends HttpServlet{
	
	@Autowired
	CategoryRepository categoriesRep;
	
	static ArrayList<Category> l = new ArrayList<Category>();

	@GetMapping("/category")
	@ResponseBody
	public List<Category> list() {
		return categoriesRep.findAll();
	}
	@PutMapping("/category")
	@ResponseBody
	public void saveCategory(@RequestBody Category category) {
		category.setId(null);
		categoriesRep.save(category);
	}
	
	@PutMapping("/category/{id}")
	@ResponseBody
	public void editCategory(@PathVariable String id, @RequestBody Category category) {
		categoriesRep.save(category);
	}
}
