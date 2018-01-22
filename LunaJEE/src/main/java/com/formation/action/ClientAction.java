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


	private static final long serialVersionUID = 1L;

	private Client client = new Client();
	private Client clientUpdate;
	private int codeCli;
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
		
		setModels();
		return SUCCESS;
	}

	@Action(value = "deleteCli", results = { @Result(name = "success", location = "/bodyClientAccueil.jsp") })
	public String DeleteClient()
	{
		clientService.DeleteClient(clientService.SelectClient(codeCli));
		return SUCCESS;
		
	}
	
	@Action(value = "updateCli1", results = { @Result(name = "success", location = "/bodyClientModif.jsp") })
	public String redirectionUpdate()
	{
		return SUCCESS;		
	}
	
	
	@Action(value = "updateCli2", results = { @Result(name = "success", location = "/bodyClientAccueil.jsp") })
	public String UpdateClient()
	{
		System.out.println(clientUpdate);
		System.out.println(codeCli);
		clientUpdate.setIdClient(codeCli);
		
		System.out.println(clientUpdate);
		clientService.SaveOrUpdateClient(clientUpdate);
		return SUCCESS;
		
	}
	
	public int getCodeCli() {
		return codeCli;
	}

	public void setCodeCli(int codeCli) {
		this.codeCli = codeCli;
	}




	public Client getClientUpdate() {
		return clientUpdate;
	}




	public void setClientUpdate(Client clientUpdate) {
		this.clientUpdate = clientUpdate;
	}
}