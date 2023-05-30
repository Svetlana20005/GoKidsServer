package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServlet;

@RestController
public class HttpProductController  extends HttpServlet{
	
	@Autowired
	ProductRepository productsRep;
	@Autowired
	CategoryRepository categoriesRep;
	
	
	static ArrayList<Product> l = new ArrayList<Product>();
	

	@GetMapping("/product")
	@ResponseBody
	public List<Product> list(@Nullable @RequestParam("category_id") Long category_id) {
		System.out.println(category_id);
		if(category_id != null) {
			Optional<Category> category = categoriesRep.findById(category_id);
			System.out.println(category);
			System.out.println(category_id);
			if(!category.isEmpty()) {
				
				return productsRep.findAllByCategory(category.get());
			}
			
		}
		return productsRep.findAll();
	}
	@PutMapping("/product")
	@ResponseBody
	public void saveProduct(@RequestBody Product product) {
		product.setId(null);
		productsRep.save(product);
	}
	
	@PutMapping("/product/{id}")
	@ResponseBody
	public void editProduct(@PathVariable String id, @RequestBody Product product) {
		productsRep.save(product);
	}
}
