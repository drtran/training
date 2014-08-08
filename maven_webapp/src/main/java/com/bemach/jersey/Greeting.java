package com.bemach.jersey;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Greeting {
	private String msg = "Hello, world!";

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}