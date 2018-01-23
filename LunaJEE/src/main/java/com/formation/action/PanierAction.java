package com.formation.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.model.Client;
import com.formation.model.Panier;
import com.formation.service.ClientService;
import com.formation.service.PanierService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("com.formation")
@Namespace(value = "/")
public class PanierAction extends ActionSupport implements ModelDriven<Panier>, SessionAware {

	@Autowired
	private PanierService panierService;

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

	private Panier panier = new Panier();
	private Panier panierUpdate;
	private int codePan;
	private List<Panier> models = null;

	@Override
	public Panier getModel() {
		// TODO Auto-generated method stub
		return panier;
	}

	public void setModels() {
		// models = panierService.SelectPanierFromClient();
	}

	public List<Panier> getModels() {
		return models;
	}

	@Action(value = "affTabPan", results = { @Result(name = "success", location = "clientAccueil", type = "tiles") })
	public String AffichTablePanier() {

		setModels();
		return SUCCESS;
	}

	@Action(value = "deletePan", results = { @Result(name = "success", location = "affTabCli", type = "redirect") })
	public String DeletePanier() {
		panier.setIdPanier(codePan);
		panierService.DeletePanier(panier);
		return SUCCESS;

	}

	@Action(value = "deletePanFromCli", results = {
			@Result(name = "success", location = "affTabCli", type = "redirect") })
	public String DeletePanierFromClient() {
		Client cli = (Client) sessionMap.get("client");
		panierService.DeletePanierFromClient(cli);
		return SUCCESS;

	}

	@Action(value = "updatePan1", results = { @Result(name = "success", location = "clientModif", type = "tiles") })
	public String redirectionUpdate() {
		return SUCCESS;
	}

	@Action(value = "updatePan2", results = { @Result(name = "success", location = "affTabCli", type = "redirect") })
	public String UpdatePanier() {

		panierUpdate.setIdPanier(codePan);

		panierService.SaveOrUpdatePanier(panierUpdate);
		return SUCCESS;

	}

	@Action(value = "createPan", results = { @Result(name = "success", location = "affTabCli", type = "redirect") })
	public String createPanier() {

		panierService.SaveOrUpdatePanier(panier);

		return SUCCESS;

	}

}