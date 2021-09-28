package com.ecommerce.servicesamples;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.modelsamples.PurchaseReport;
import com.ecommerce.repositorysamples.PurchaseReportRepository;

@Service
@Transactional
public class PurchaseReportService {
	
	@Autowired
	private PurchaseReportRepository purchaseRepo;
	
	public List<PurchaseReport> listAllCategory(String category) {
		if(category!=null) {
			return purchaseRepo.findByCategory(category);
		} 
		
	        return purchaseRepo.findAll();
		}
	
	public List<PurchaseReport> listAllDop(Date date) {
		if(date!=null) {
			return purchaseRepo.findByDatePurchasedBy(date);
		} 
		
	        return purchaseRepo.findAll();
		}
	
	
	
	
}
