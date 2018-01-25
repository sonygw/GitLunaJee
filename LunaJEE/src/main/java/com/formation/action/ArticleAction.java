package com.formation.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.UploadContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.formation.context.ConteneurSpring;
import com.formation.model.Article;
import com.formation.model.Client;
import com.formation.model.Panier;
import com.formation.service.ArticleService;
import com.formation.service.PanierService;
import com.formation.util.UserUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("unused")
@ParentPackage("com.formation")
@Namespace(value = "/")
public class ArticleAction extends ActionSupport implements ModelDriven<Article>, SessionAware {

	@Autowired
	private ArticleService articleService;

	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConteneurSpring.class);

	
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

	private Article article =  context.getBean(Article.class);

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	private Article articleUpdate;
	private int codeArt;
	private int qte;


	private List<Article> models = null;

	@Override
	public Article getModel() {
		// TODO Auto-generated method stub
		return article;
	}

	public void setModels() {
		models = articleService.SelectAllArticles();
	}

	public List<Article> getModels() {
		return models;
	}

	@Action(value = "affTabArt", results = { @Result(name = "success", location = "articleAccueil", type = "tiles"),
			@Result(name = "rate", location = "/index.jsp") })
	public String AffichTable() {

		// if (UserUtil.verifUser())
		// return "rate";
		// else
		setModels();
		return SUCCESS;
	}

	@Action(value = "deleteArt", results = { @Result(name = "success", location = "affTabArt", type = "redirect") })
	public String DeleteClient() {
		articleService.DeleteArticle(articleService.SelectArticleById(codeArt));
		return SUCCESS;

	}

	@Action(value = "updateArt1", results = { @Result(name = "success", location = "articleModif", type = "tiles") })
	public String redirectionUpdate() {
		article = articleService.SelectArticleById(codeArt);

		return SUCCESS;
	}

	@Action(value = "updateArt2", results = { @Result(name = "success", location = "affTabArt", type = "redirect") })
	public String UpdateClient() {

		article.setIdArticle(codeArt);

		articleService.SaveOrUpdateArticle(article);
		return SUCCESS;

	}

	@Action(value = "createArt", results = { @Result(name = "success", location = "affTabArt", type = "redirect") })
	public String createClient() {

		article.setCode("ART" + article.getIdArticle());
		article.setVisible(true);

		articleService.SaveOrUpdateArticle(article);

		return SUCCESS;

	}

	@Action(value = "voirArt", results = { @Result(name = "success", location = "articleResume", type = "tiles") })
	public String AffichArticle() {

		article = articleService.SelectArticleById(codeArt);
		sessionMap.put("article", article);
		return SUCCESS;

	}

	@Action(value = "submitAjout", results = { @Result(name = "success", location = "affTabArt", type = "redirect") })
	public String createPanierFromArticle() {

		
		Article arti = (Article) sessionMap.get("article");
		Client cli = (Client) sessionMap.get("client");
		Panier panier = context.getBean(Panier.class);
		
		arti.setQuantite((arti.getQuantite() - qte));
		
		articleService.SaveOrUpdateArticle(arti);
		
		panier.setArticle(arti);
		panier.setClient(cli);
		panier.setQuantite(qte);
		panier.setPrixHT( arti.getPrixHT() * qte);
		panierService.SaveOrUpdatePanier(panier);

		return SUCCESS;

	}

	public int getCodeArt() {
		return codeArt;
	}

	public void setCodeArt(int codeArt) {
		this.codeArt = codeArt;
	}
	
	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public Article getArticleUpdate() {
		return articleUpdate;
	}

	public void setArticleUpdate(Article articleUpdate) {
		this.articleUpdate = articleUpdate;
	}
}