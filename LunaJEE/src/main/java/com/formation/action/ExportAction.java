package com.formation.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.model.*;
import com.formation.service.ArticleService;
import com.formation.service.ClientService;
import com.formation.service.CommandeService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("com.formation")
@Namespace(value = "/")
public class ExportAction extends ActionSupport implements SessionAware {

	@Autowired
	private ClientService clientService;

	@Autowired
	private ArticleService articleService;
	
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

	private static final long serialVersionUID = 1L;

	private Commande commande = new Commande();
	private Commande commandeUpdate;

	private List<Article> articles;
	private List<Commande> commandes;

	private List<Client> clients;

	private String preview;

	@Action(value = "previewClient", results = { @Result(name = "success", location = "/preview.jsp"),
			@Result(name = "inconnu", location = "/403.jsp") })
	public String previewCli() {

		if (!verifUser())
			return "inconnu";

		preview = "client";

		clients = clientService.SelectAllClients();

		return SUCCESS;
	}

	@Action(value = "previewArticle", results = { @Result(name = "success", location = "/preview.jsp"),
			@Result(name = "inconnu", location = "/403.jsp") })
	public String previewArt() {

		if (!verifUser())
			return "inconnu";

		preview = "article";

		articles = articleService.SelectAllArticles();

		return SUCCESS;
	}

	@Action(value = "previewCommande", results = { @Result(name = "success", location = "/preview.jsp"),
			@Result(name = "inconnu", location = "/403.jsp") })
	public String previewCom() {

		if (!verifUser())
			return "inconnu";

		preview = "commande";

		commandes = commandeService.SelectAllCommandes();
		
		return SUCCESS;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Commande getCommandeUpdate() {
		return commandeUpdate;
	}

	public void setCommandeUpdate(Commande commandeUpdate) {
		this.commandeUpdate = commandeUpdate;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	
}