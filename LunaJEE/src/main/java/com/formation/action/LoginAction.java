package com.formation.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.model.Client;
import com.formation.service.ClientService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("com.formation")
public class LoginAction extends ActionSupport implements SessionAware {

	private String username;
	private String password;


	private Map<String, Object> sessionMap;

	@Autowired
	private ClientService clientService;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void setSession(Map<String, Object> map) {
		this.sessionMap = map;

	}

	@Action(value = "connecter", results = { @Result(name = "input", location = "/index.jsp"),
			@Result(name="success", type = "redirect", location = "accueil") })
	public String connecter() {

		if (username != null && password != null) {
			Client client = clientService.SelectClientByLogNPwd(username, password);
			if (client != null) {
				this.sessionMap.put("authentification", true);
				this.sessionMap.put("client", client);
				return SUCCESS;
			}
		}
		return INPUT;
	}

	@Action(value = "deconnecter", results = @Result(name = "success", location = "index/jsp"))
	public String deconnecter() {
		this.sessionMap.clear();
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

}