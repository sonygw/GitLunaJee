package com.formation.action;

import java.util.List;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.model.Commande;
import com.formation.service.CommandeService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("com.formation")
@Namespace(value = "/")
public class CommandeAction extends ActionSupport implements ModelDriven<Commande> {

	@Autowired
	private CommandeService commandeService;

	private static final long serialVersionUID = 1L;

	private Commande commande = new Commande();
	private Commande commandeUpdate;
	private int codeCom;
	private List<Commande> models = null;

	@Override
	public Commande getModel() {
		// TODO Auto-generated method stub
		return commande;
	}

	public void setModels() {
		models = commandeService.SelectAllCommandes();
	}

	public List<Commande> getModels() {
		return models;
	}

	@Action(value = "affTabCom", results = { @Result(name = "success", location = "commandeAccueil", type = "tiles") })
	public String AffichTable() {

		setModels();

		return SUCCESS;
	}

	@Action(value = "deleteCom", results = { @Result(name = "success", location = "affTabCom", type = "redirect") })
	public String DeleteClient() {
		commandeService.DeleteCommande(commandeService.SelectCommande(codeCom));
		return SUCCESS;

	}

	@Action(value = "updateCom1", results = { @Result(name = "success", location = "commandeModif", type = "tiles") })
	public String redirectionUpdate() {
		return SUCCESS;
	}

	@Action(value = "updateCom2", results = { @Result(name = "success", location = "affTabCom", type = "redirect") })
	public String UpdateClient() {

		commandeUpdate.setIdCommande(codeCom);

		commandeService.SaveOrUpdateCommande(commandeUpdate);
		return SUCCESS;

	}

	@Action(value = "createCom", results = { @Result(name = "success", location = "affTabCom", type = "redirect") })
	public String createClient() {

		commandeService.SaveOrUpdateCommande(commande);

		return SUCCESS;

	}

	@Action(value = "voirCom", results = @Result(name = "success", location = "commandeResume", type = "tiles"))
	public String voirCom() {

		
		commande = commandeService.SelectCommande(codeCom);
	
		return SUCCESS;
	}
	

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public int getCodeCom() {
		return codeCom;
	}

	public void setCodeCom(int codeCom) {
		this.codeCom = codeCom;
	}

	public Commande getCommandeUpdate() {
		return commandeUpdate;
	}

	public void setCommandeUpdate(Commande commandeUpdate) {
		this.commandeUpdate = commandeUpdate;
	}
}