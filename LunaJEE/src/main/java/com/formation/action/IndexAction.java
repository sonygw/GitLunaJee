package com.formation.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Action(value="menu" )
@Result(location="/jsp/menu.jsp", name="success" )
public class IndexAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
