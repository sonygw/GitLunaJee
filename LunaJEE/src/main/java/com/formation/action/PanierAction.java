package com.formation.action;

import java.util.ArrayList;
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
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.formation.context.ConteneurSpring;
import com.formation.model.ArtCom;
import com.formation.model.Article;
import com.formation.model.Client;
import com.formation.model.Commande;
import com.formation.model.Panier;
import com.formation.service.ArtComService;
import com.formation.service.ArticleService;
import com.formation.service.ClientService;
import com.formation.service.CommandeService;
import com.formation.service.PanierService;
import com.formation.util.DateDuJour;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("com.formation")
@Namespace(value = "/")
public class PanierAction extends ActionSupport implements ModelDriven<Panier>, SessionAware {

	@Autowired
	private PanierService panierService;

	@Autowired
	private ArticleService articleService;

	@Autowired
	private CommandeService commandeService;

	@Autowired
	private ArtComService artComService;

	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConteneurSpring.class);

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

	private Panier panier = new Panier();
	private int codePan;
	private int codeArt;
	private String regle;

	private List<Panier> models = null;

	@Override
	public Panier getModel() {
		// TODO Auto-generated method stub
		return panier;
	}

	public void setModels() {
		Client cli = (Client) sessionMap.get("client");
		models = panierService.SelectPanierFromClient(cli);
	}

	public List<Panier> getModels() {
		return models;
	}

	@Action(value = "affTabPan", results = { @Result(name = "success", location = "panier", type = "tiles"),
			@Result(name = "inconnu", location = "/403.jsp") })
	public String AffichTablePanier() {

		if (!verifUser())
			return "inconnu";

		setModels();
		return SUCCESS;
	}

	@Action(value = "deletePan", results = { @Result(name = "success", location = "affTabPan", type = "redirect"),
			@Result(name = "inconnu", location = "/403.jsp") })
	public String DeletePanier() {

		if (!verifUser())
			return "inconnu";

		panier = panierService.SelectPanierById(codePan);

		Article arti = panier.getArticle();
		arti.setQuantite((arti.getQuantite() + panier.getQuantite()));

		articleService.SaveOrUpdateArticle(arti);

		panierService.DeletePanier(panier);

		return SUCCESS;

	}

	public int getCodePan() {
		return codePan;
	}

	public void setCodePan(int codePan) {
		this.codePan = codePan;
	}

	@Action(value = "validPanier", results = { @Result(name = "success", location = "affTabCli", type = "redirect"),
			@Result(name = "inconnu", location = "/403.jsp") })
	public String ValidPanierFromClient() {

		if (!verifUser())
			return "inconnu";

		Commande commande = context.getBean(Commande.class);
		Client cli = (Client) sessionMap.get("client");
		commande.setAdresse(cli.getAdresse());

		commande.setNomCli(cli.getNom());	
		commande.setPrenomCli(cli.getPrenom());
		commande.setDate(DateDuJour.getDateDuJour());
		commande.setRef("COM" + (commandeService.SelectLastCommande().getIdCommande() + 1));

		commande.setReglement(regle);

		ArrayList<Panier> listPan = panierService.SelectPanierFromClient(cli);
		double prixtotal = 0;

		for (Panier p : listPan)
			prixtotal += p.getPrixHT();

		commande.setPrixHT(prixtotal);

		commandeService.SaveOrUpdateCommande(commande);

		for (Panier p : listPan)
			artComService.SaveOrUpdateArtCom(new ArtCom(p.getQuantite(), p.getArticle(), commande));

		panierService.DeletePanierFromClient(cli);
		return SUCCESS;

	}

	public int getCodeArt() {
		return codeArt;
	}

	public void setCodeArt(int codeArt) {
		this.codeArt = codeArt;
	}

	public String getRegle() {
		return regle;
	}

	public void setRegle(String regle) {
		this.regle = regle;
	}

}