package com.dairy.service;

import com.dairy.dto.milkRate.MilkRateRequestDto;

public interface MilkRateService {

	Float getMilkRateByTypeAndFatAndSNFAndBranch(String type, float fat, float snf, int branchId);

	boolean saveMilkRate(MilkRateRequestDto milkRate);

}
