package com.dairy.service;

public interface MilkRateService {

	Float getMilkRateByTypeAndFatAndSNFAndBranch(String type, float fat, float snf, int branchId);

}
