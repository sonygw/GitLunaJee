package com.formation.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.model.Client;
import com.formation.model.User;
import com.formation.service.ClientService;
import com.formation.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Namespace(value = "/")
public class ClientAction extends ActionSupport implements ModelDriven<Client> {

	@Autowired
	private ClientService clientService;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Client client = new Client();

	private List<Client> models = null;

	@Override
	public Client getModel() {
		// TODO Auto-generated method stub
		return client;
	}

	public void setModels() {
		models = clientService.SelectAllClients();
	}

	public List<Client> getModels() {
		return models;
	}
	
	@Action(value = "affTab", results = { @Result(name = "success", location = "/bodyClientAccueil.jsp") })
	public String AffichTable() {
		//userService.add(user);
		setModels();
		System.out.println(models);
		return SUCCESS;
	}
}