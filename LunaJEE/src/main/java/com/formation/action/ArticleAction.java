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

import com.formation.model.Article;
import com.formation.service.ArticleService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("unused")
@ParentPackage("com.formation")
@Namespace(value = "/")
public class ArticleAction extends ActionSupport implements ModelDriven<Article>, SessionAware {

	@Autowired
	private ArticleService articleService;

	//------------------------------------------------------------------ VARIABLES GLOBALES A L'APPLICATION -----
		private Map<String, Object> sessionMap;
		
		@Override
		public void setSession(Map<String, Object> map) {
			// TODO Auto-generated method stub
			this.sessionMap = map;
		}
		//------------------------------------------------------------------------------------------------------------

	private static final long serialVersionUID = 1L;

	private Article article = new Article();
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	private Article articleUpdate;
	private int codeArt;
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

	@Action(value = "affTabArt", results = { @Result(name = "success", location = "articleAccueil", type = "tiles") })
	public String AffichTable() {

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

	public int getCodeArt() {
		return codeArt;
	}

	public void setCodeArt(int codeArt) {
		this.codeArt = codeArt;
	}

	public Article getArticleUpdate() {
		return articleUpdate;
	}

	public void setArticleUpdate(Article articleUpdate) {
		this.articleUpdate = articleUpdate;
	}
}