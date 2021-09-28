package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.modelsamples.Products;
import com.ecommerce.servicesamples.ProductsService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductsService proService;
	
	
	@RequestMapping("/products")
	public String viewProductPage(Model model,@Param("category") String category) {
		List<Products> listProducts = proService.listAll(category);
		model.addAttribute("listProducts",listProducts);
		model.addAttribute("category",category);
		return "products";
	}
	
	@RequestMapping("/newproduct")
	public String showAddProductPage(Model model) {
		Products product = new Products();
		model.addAttribute("product",product);
		return "newproduct";
	}
	
	@RequestMapping(value = "/saveproduct",method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Products product) {
		proService.save(product);
		return "redirect:/products";
	}
	
	@RequestMapping("/edit/{productId}")
	public ModelAndView showEditProductPage(@PathVariable(name="productId") int productId) {
		ModelAndView mav = new ModelAndView("editproduct");
		Products product = proService.get(productId);
		mav.addObject("product",product);
		return mav;
	}
	
	@RequestMapping("/delete/{productId}")
	public String deleteProduct(@PathVariable(name="productId")int productId) {
		proService.delete(productId);
		return "redirect:/products";
	}
	
		
	@RequestMapping("/userproductpage")
	public String UserProductPage(Model model,@Param("category") String category) {
		List<Products> listProducts = proService.listAll(category);
		model.addAttribute("listProducts",listProducts);
		model.addAttribute("category",category);
		return "userproductpage";
	}
	
	@RequestMapping("/view/{productId}")
	public ModelAndView individualProductPage(@PathVariable(name="productId") int productId) {
		ModelAndView mav = new ModelAndView("viewproduct");
		Products product = proService.get(productId);
		mav.addObject("product",product);
		return mav;
	}
	
	@RequestMapping("/shoppingcart")
	public String shoppingCart() {
		return "shoppingcart";
	}
	
	@RequestMapping("/paymentprocess")
	public String paymentProcess() {
		return "paymentprocess";
	}
	
	

}
