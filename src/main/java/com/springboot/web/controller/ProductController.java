package com.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.web.domain.Product;
import com.springboot.web.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	// show new form to add product
	@RequestMapping("/new")
	public String newProduct(Model model) {
		model.addAttribute("product", new Product());
		return "productform";
	}

	// save product in database
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(Product product) {
		productService.saveProduct(product);
		return "redirect:/products/" + product.getId();
	}

	// show a product by id
	@RequestMapping("/{id}")
	public String showProduct(@PathVariable Integer id, Model model) {
		model.addAttribute("product", productService.getProductById(id));
		return "productshow";
	}

	// show all products
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("products", productService.listAllProducts());
		return "products";
	}

	// update a product by id
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("product", productService.getProductById(id));
		return "productform";
	}

	// delete a product by id
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		productService.deleteProduct(id);
		return "redirect:/products";
	}
}
