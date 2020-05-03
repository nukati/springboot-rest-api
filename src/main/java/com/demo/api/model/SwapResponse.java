package com.demo.api.model;

import java.io.Serializable;

public class SwapResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String encodeFunnyStr;
	private String decodeFunnyStr;
	private String encodeSwap;
	private String swap;
	public SwapResponse() {
		this.encodeFunnyStr=encodeFunnyStr;
		this.decodeFunnyStr=decodeFunnyStr;
		this.encodeSwap=encodeSwap;
		this.swap=swap;
	}
	public String getEncodeFunnyStr() {
		return encodeFunnyStr;
	}
	public void setEncodeFunnyStr(String encodeFunnyStr) {
		this.encodeFunnyStr = encodeFunnyStr;
	}
	public String getDecodeFunnyStr() {
		return decodeFunnyStr;
	}
	public void setDecodeFunnyStr(String decodeFunnyStr) {
		this.decodeFunnyStr = decodeFunnyStr;
	}
	public String getEncodeSwap() {
		return encodeSwap;
	}
	public void setEncodeSwap(String encodeSwap) {
		this.encodeSwap = encodeSwap;
	}
	public String getSwap() {
		return swap;
	}
	public void setSwap(String swap) {
		this.swap = swap;
	}
	public SwapResponse(String encodeFunnyStr, String decodeFunnyStr, String encodeSwap, String swap) {
		super();
		this.encodeFunnyStr = encodeFunnyStr;
		this.decodeFunnyStr = decodeFunnyStr;
		this.encodeSwap = encodeSwap;
		this.swap = swap;
	}
	
	
}
