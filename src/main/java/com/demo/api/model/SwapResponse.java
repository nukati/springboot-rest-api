package com.demo.api.model;
	
public class SwapResponse {

	private String decode;
	private String encode;
	private String swap;
	public SwapResponse() {
		this.decode=decode;
		this.encode=encode;
		this.swap=swap;
	}
	public String getDecode() {
		return decode;
	}
	public void setDecode(String decode) {
		this.decode = decode;
	}
	public String getEncode() {
		return encode;
	}
	public void setEncode(String encode) {
		this.encode = encode;
	}
	public String getSwap() {
		return swap;
	}
	public void setSwap(String swap) {
		this.swap = swap;
	}
	
}
