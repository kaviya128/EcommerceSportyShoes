package com.ecommerce.repositorysamples;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.modelsamples.PurchaseReport;

@Repository
public interface PurchaseReportRepository extends JpaRepository<PurchaseReport,Integer>{

	List<PurchaseReport> findByCategory(String category);
	List<PurchaseReport> findByDatePurchasedBy(Date date);
}
