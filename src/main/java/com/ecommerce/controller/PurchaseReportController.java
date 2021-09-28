package com.ecommerce.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.modelsamples.PurchaseReport;
import com.ecommerce.servicesamples.PurchaseReportService;

@Controller
public class PurchaseReportController {
	@Autowired
	private PurchaseReportService purchaseService;
	
	@RequestMapping("/purchasereport")
	public String viewPurchaseReportPage(Model model,@Param("category") String category) {
		List<PurchaseReport> purchaseReportList = purchaseService.listAllCategory(category);
		model.addAttribute("purchaseReportList", purchaseReportList);
		model.addAttribute("category", category);
	
		return "purchasereport";
		
	}
	
	@RequestMapping("/purchasereportbydate")
	public String PurchaseReportDateFilter(Model model,
			@Param("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
		
		List<PurchaseReport> purchaseReportList = purchaseService.listAllDop(date);
		model.addAttribute("purchaseReportList", purchaseReportList);
		model.addAttribute("date",date);
		
		return "purchasereportbydate";
		
	}

	
}
