package com.dairy.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dairy.dto.paymentToFarmer.PaymentToFarmerRequestDto;
import com.dairy.entity.Branch;
import com.dairy.entity.Farmer;
import com.dairy.entity.PaymentToFarmer;

@Repository
public interface PaymentToFarmerRepository extends JpaRepository<PaymentToFarmer, Long>{

	
	void save(PaymentToFarmerRequestDto paymentToFarmerRequestDto);

	List<PaymentToFarmer> findAllByBranch(Branch branch);

	@Query("SELECT p FROM PaymentToFarmer p WHERE p.branch = :branch AND  p.invoice_date BETWEEN :fromDate AND :toDate")
    List<PaymentToFarmer> findAllByBranchAndDateBetweenFromDateAndToDate(
            @Param("branch") Branch branch,
            @Param("fromDate") LocalDate fromDate,
            @Param("toDate") LocalDate toDate
    );


    @Query("SELECT p FROM PaymentToFarmer p " +
           "WHERE p.branch = :branch " +
           "AND p.invoice_date BETWEEN :fromDate AND :toDate " +
           "AND p.milktype = :milkType")
    List<PaymentToFarmer> findAllByBranchAndInvoice_DateBetweenAndMilkType(
            @Param("branch") Branch branch,
            @Param("fromDate") LocalDate fromDate,
            @Param("toDate") LocalDate toDate,
            @Param("milkType") String milkType
    );

    @Query("SELECT p FROM PaymentToFarmer p " +
    	       "WHERE p.branch = :branch " +
    	       "AND p.invoice_date BETWEEN :fromDate AND :toDate " +
    	       "AND (:farmer IS NULL OR p.farmer = :farmer)")
    	List<PaymentToFarmer> findAllByBranchAndInvoice_DateBetweenAndFarmer(
    	        @Param("branch") Branch branch,
    	        @Param("fromDate") LocalDate fromDate,
    	        @Param("toDate") LocalDate toDate,
    	        @Param("farmer") Farmer farmer
    	);



	

	
}
