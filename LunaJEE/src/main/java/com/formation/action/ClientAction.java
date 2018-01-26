package com.formation.action;

import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.model.Client;
import com.formation.service.ClientService;
import com.formation.service.CommandeService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("com.formation")
@Namespace(value = "/")
public class ClientAction extends ActionSupport implements ModelDriven<Client>, SessionAware {

	@Autowired
	private ClientService clientService;

	@Autowired
	private CommandeService commandeService;

	// ------------------------------------------------------------------ VARIABLES
	// GLOBALES A L'APPLICATION -----
	private Map<String, Object> sessionMap;

	@Override
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		this.sessionMap = map;
	}

	// ------------------------------------------------------------------------------------------------------------
	private static final long serialVersionUID = 1L;

	private Client client = new Client();
	private Client clientUpdate;
	private int codeCli;
	private List<Client> models = null;

	public boolean verifUser() {
		boolean b = false;
		try {
			b = (boolean) sessionMap.get("authentification");
			System.out.println(b);

		} catch (NullPointerException e) {
			System.out.println(b);

		}
		return b;
	}

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

	@Action(value = "affTabCli", results = { @Result(name = "success", location = "clientAccueil", type = "tiles"),
			@Result(name = "inconnu", location = "/403.jsp") })
	public String AffichTable() {
		if (!verifUser())
			return "inconnu";

		setModels();
		return SUCCESS;
	}

	@Action(value = "deleteCli", results = { @Result(name = "success", location = "affTabCli", type = "redirect"),
			@Result(name = "inconnu", location = "/403.jsp")})
	public String DeleteClient() {
		if (!verifUser())
			return "inconnu";

		clientService.DeleteClient(clientService.SelectClient(codeCli));
		return SUCCESS;

	}

	@Action(value = "updateCli1", results = { @Result(name = "success", location = "clientModif", type = "tiles"),
			@Result(name = "inconnu", location = "/403.jsp") })
	public String redirectionUpdate() {

		if (!verifUser())
			return "inconnu";

		client = clientService.SelectClient(codeCli);
		return SUCCESS;
	}

	@Action(value = "updateCli2", results = { @Result(name = "success", location = "affTabCli", type = "redirect"),
			@Result(name = "inconnu", location = "/403.jsp") })
	public String UpdateClient() {

		if (!verifUser())
			return "inconnu";

		client.setIdClient(codeCli);

		clientService.SaveOrUpdateClient(client);
		return SUCCESS;

	}

	@Action(value = "createCli", results = { @Result(name = "success", location = "affTabCli", type = "redirect"),
			@Result(name = "inconnu", location = "/403.jsp") })
	public String createClient() {

		if (!verifUser())
			return "inconnu";

		clientService.SaveOrUpdateClient(client);

		return SUCCESS;

	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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