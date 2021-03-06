package com.formation.DAO;

import java.util.ArrayList;

import com.formation.model.Article;

public interface ArticleDAO {

	/**
	 * Selectionne tous les articles
	 * @return ArrayList d'articles
	 */
	public ArrayList<Article> SelectAllArticles();
	/**
	 * Selectionne un article par son ID
	 * @param id id de l'article a recuperer
	 * @return Un objet Article
	 */
	public Article SelectArticleById(int id);
	/**
	 * Supprimer l'article en fonction de l'id
	 * @param article a supprimer
	 * @return un article
	 */
	Article DeleteArticle(Article art);
	/**
	 * Update un article en fonction d'un Objet Article 
	 * @param obj Obj a inserer en base
	 * @param id id de l'objet � update
	 * @return un article
	 */
	public Article SaveOrUpdateArticle(Article obj);
	
	/**
	 * Selectionne le dernier article
	 * @return un article
	 */
	public Article SelectLastArticle();
	
	/**
	 * Selectionne les Article qui contiennent la chaine de caract�re pass�e en param�tre
	 * @param design chaine de recherche
	 * @return ArrayList d'article
	 */
	public ArrayList<Article> SelectArticleByDesign(String design);
	
	
	
}
