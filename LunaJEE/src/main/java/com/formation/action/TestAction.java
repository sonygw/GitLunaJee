package com.formation.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;


public class TestAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Action(value="test", results=@Result(name="test2", type="tiles",location="/template/testtiles.jsp"))
	public String test() {
		return "test2";
	}
}
