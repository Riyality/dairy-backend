package com.dairy.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dairy.dto.milkCollection.MilkCollectionResponseDto;
import com.dairy.entity.Branch;
import com.dairy.entity.MilkCollection;

@Repository
public interface MilkCollectionRepository extends JpaRepository<MilkCollection, Long> {


	@Query("SELECT m FROM MilkCollection m WHERE m.dateOfCollection BETWEEN :fromDate AND :toDate AND m.type = :animalType")
	List<MilkCollection> findByDateAndType(@Param("fromDate") Date fromDate, 
	                                       @Param("toDate") Date toDate, 
	                                       @Param("animalType") String animalType);

		
	
		
	@Query("SELECT m.farmer, b, SUM(m.total_amount), SUM(m.quantity) " +
		       "FROM MilkCollection m " +
		       "JOIN m.branch b " + 
		       "WHERE m.dateOfCollection BETWEEN :fromDate AND :toDate " +
		       "AND m.type = :animalType " +
		       "GROUP BY m.farmer, b")
		List<Object[]> findByDateAndTypeAndSumTotalAmountAndQuantityByFarmer(
		        @Param("fromDate") LocalDate fromDate,
		        @Param("toDate") LocalDate toDate,
		        @Param("animalType") String animalType);

	List<MilkCollection> findByBranchAndDateOfCollection(Branch branch, LocalDate dateOfCollection);

	
	@Query("SELECT m FROM MilkCollection m WHERE m.farmer.id = :farmerId")
	List<MilkCollection> findByFarmerId(@Param("farmerId") Long farmerId);

	List<MilkCollectionResponseDto> findByFarmer(int farmerId);

	@Query("SELECT m FROM MilkCollection m WHERE m.farmer.id = :farmerId AND m.dateOfCollection BETWEEN :fromDate AND :toDate AND m.type = :animalType")
	List<MilkCollection> findByFarmerDateOfCollectionAndType(@Param("farmerId") Long farmerId,
	                                                        @Param("fromDate") LocalDate fromDate,
	                                                        @Param("toDate") LocalDate toDate,
	                                                        @Param("animalType") String animalType);

	 
	 @Query("SELECT SUM(m.quantity) FROM MilkCollection m WHERE m.dateOfCollection = :today AND m.type= :animalType AND m.shift = :shift AND m.branch.id = :branchId")
	    Float findSumOfMilkCollectionByTypeAndShiftForToday(
	            @Param("today") LocalDate today,
	            @Param("animalType") String animalType,
	            @Param("shift") String shift,
	            @Param("branchId") int branchId);
	
   }
 
