package com.demo.api.service;


import com.demo.api.model.SwapBean;
import com.demo.api.model.SwapResponse;

public interface APISwapService {

	SwapResponse swapEnglishCapital(SwapBean param);
}