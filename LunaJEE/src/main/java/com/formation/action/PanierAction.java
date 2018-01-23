package com.formation.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.model.Client;
import com.formation.model.Panier;
import com.formation.service.ClientService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("com.formation")
@Namespace(value = "/")
public class PanierAction extends ActionSupport implements ModelDriven<Panier> {

	@Autowired
	private PanierService panierService;

	

	private static final long serialVersionUID = 1L;

	private Panier panier = new Panier();
	private Panier panierUpdate;
	private int codePan;
	private List<Panier> models = null;

	@Override
	public Panier getModel() {
		// TODO Auto-generated method stub
		return Panier;
	}

	public void setModels() {
		models = panierService.SelectAllPanier();
	}

	public List<Client> getModels() {
		return models;
	}

	@Action(value = "affTabPan", results = { @Result(name = "success", location = "clientAccueil", type = "tiles") })
	public String AffichTablePanier() {

		setModels();
		return SUCCESS;
	}

	@Action(value = "deletePan", results = { @Result(name = "success", location = "affTabCli", type = "redirect") })
	public String DeletePanier() {
		panierService.DeletePanier(panierService.SelectPanier(codePan));
		return SUCCESS;

	}

	@Action(value = "updatePan1", results = { @Result(name = "success", location = "clientModif", type = "tiles") })
	public String redirectionUpdate() {
		return SUCCESS;
	}


	@Action(value = "updatePan2", results = { @Result(name = "success", location = "affTabCli", type = "redirect") })
	public String UpdatePanier() {

		panierUpdate.setIdPanier(codePan);

		panierService.SaveOrUpdateClient(panierUpdate);
		return SUCCESS;

	}

	@Action(value = "createPan", results = { @Result(name = "success", location = "affTabCli", type = "redirect") })
	public String createPanier() {

		panierService.SaveOrUpdatePanier(panier);
		
		return SUCCESS;

	}

	

	
}