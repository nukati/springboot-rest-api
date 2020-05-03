package com.demo.api.controller;

import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.api.model.SwapBean;
import com.demo.api.model.SwapRequest;
import com.demo.api.model.SwapResponse;
import com.demo.api.service.APISwapService;
import com.demo.api.util.CustomErrorType;
import com.demo.api.util.StringRegExp;

@RestController
@RequestMapping("/api")
public class APISwapController {

	public static final Logger logger = LoggerFactory.getLogger(APISwapController.class);

	@Autowired
	APISwapService apiswapService;

	@PostMapping("/swap")
	public Object swap(@RequestBody SwapRequest param) {
		System.out.println("FunnyStr : " + param.getFunnyStr());
		SwapBean swapBean = new SwapBean();
		if (param == null) {
			return new ResponseEntity<CustomErrorType>(new CustomErrorType("Unable to swap. FunnyStr is null "), HttpStatus.BAD_REQUEST);
		}

		if (param != null) {
			byte[] decodedBytes = Base64.getDecoder().decode(param.getFunnyStr());
			String decodedString = new String(decodedBytes);
			System.out.println("Decoded : " + decodedString);
			swapBean.setEndcode(param.getFunnyStr());
			swapBean.setDecode(decodedString);
			
			if (swapBean.getDecode().isEmpty()) {
				return new ResponseEntity(new CustomErrorType("Unable to swap. FunnyStr is empty "),
						HttpStatus.BAD_REQUEST);
			}

			if (swapBean.getDecode().equals(" ")) {
				return new ResponseEntity(new CustomErrorType("Unable to swap. FunnyStr is space only "),
						HttpStatus.BAD_REQUEST);
			}

			if (swapBean.getDecode().length() < 2) {
				return new ResponseEntity(
						new CustomErrorType("Input byte[] should at least have 2 bytes for base64 bytes"),
						HttpStatus.BAD_REQUEST);
			}

			
			if (!StringRegExp.isAlpha(swapBean.getDecode())) {
				return new ResponseEntity(
						new CustomErrorType("Unable to swap. API will only accept English Capital Letter or Space"),
						HttpStatus.BAD_REQUEST);
			}
		}

		SwapResponse res = new SwapResponse();
		res = apiswapService.swapEnglishCapital(swapBean);

		System.out.println("Swap : "+ res.getSwap());
		return ResponseEntity.ok().body(res);
	}

	/*@RequestMapping(value = "/swap/{funnyStr}", method = RequestMethod.GET)
	public Object swap(@PathVariable("funnyStr") String funnyStr) {
		System.out.println("FunnyStr {}: " + funnyStr);

		if (funnyStr == null) {
			return new ResponseEntity(new CustomErrorType("Unable to swap. FunnyStr is null "), HttpStatus.BAD_REQUEST);
		}

		if (funnyStr != null) {
			if (funnyStr.isEmpty()) {
				return new ResponseEntity(new CustomErrorType("Unable to swap. FunnyStr is empty "),
						HttpStatus.BAD_REQUEST);
			}

			if (funnyStr.equals(" ")) {
				return new ResponseEntity(new CustomErrorType("Unable to swap. FunnyStr is space only "),
						HttpStatus.BAD_REQUEST);
			}

			if (funnyStr.length() < 2) {
				return new ResponseEntity(
						new CustomErrorType("Input byte[] should at least have 2 bytes for base64 bytes"),
						HttpStatus.BAD_REQUEST);
			}

			byte[] decodedBytes = Base64.getDecoder().decode(funnyStr);
			String decodedString = new String(decodedBytes);

			if (!StringRegExp.isAlpha(decodedString)) {
				return new ResponseEntity(
						new CustomErrorType("Unable to swap. API will only accept English Capital Letter"),
						HttpStatus.BAD_REQUEST);
			}
		}

		SwapRequest param = new SwapRequest();
		param.setFunnyStr(funnyStr);
		SwapResponse res = apiswapService.swapEnglishCapital(param);
		logger.info("Encoding : ", res.getEncode());
		logger.info("Swap : ", res.getSwap());
		return ResponseEntity.ok().body(res);
	}*/

	

}