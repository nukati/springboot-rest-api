package com.demo.api.model;

import java.io.Serializable;

public class SwapBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String decode;
	private String endcode;
	public String getDecode() {
		return decode;
	}
	public void setDecode(String decode) {
		this.decode = decode;
	}
	public String getEndcode() {
		return endcode;
	}
	public void setEndcode(String endcode) {
		this.endcode = endcode;
	}
	public SwapBean(String decode, String endcode) {
		super();
		this.decode = decode;
		this.endcode = endcode;
	}
	public SwapBean() {
		super();
		this.decode = decode;
		this.endcode = endcode;
	}
}
