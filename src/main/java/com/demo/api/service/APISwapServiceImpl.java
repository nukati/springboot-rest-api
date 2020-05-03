package com.demo.api.service;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.springframework.stereotype.Service;

import com.demo.api.model.SwapBean;
import com.demo.api.model.SwapResponse;
import com.demo.api.util.StringRegExp;



@Service("apiswapService")
public class APISwapServiceImpl implements APISwapService{

	@Override
	public SwapResponse swapEnglishCapital(SwapBean param) {
		SwapResponse res = new SwapResponse();
		try {
			String swap = StringRegExp.convertAlpha(param.getDecode());
			String encodeSwap = Base64.getEncoder().encodeToString(swap.getBytes("utf-8"));
			System.out.println("Swap : "+ swap);
			System.out.println("EncodeSwap : "+ encodeSwap);
			res.setDecodeFunnyStr(param.getDecode());
			res.setEncodeFunnyStr(param.getEndcode());
			res.setSwap(swap);
			res.setEncodeSwap(encodeSwap);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getCause());
		}
		
		return res;
	}

}
