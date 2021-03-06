package com.formation.service;

import java.util.ArrayList;

import com.formation.model.Article;

public interface ArticleService {

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
	 * @return un bool de v�rif. false = reussi
	 */
	boolean DeleteArticle(Article obj);
	/**
	 * Update un article en fonction d'un Objet Article 
	 * @param obj Obj a inserer en base
	 * @param id id de l'objet � update
	 * @return un bool de v�rif. vrai = reussi
	 */
	public boolean SaveOrUpdateArticle(Article obj);
	
	/**
	 * Selectionne le dernier article
	 * @return un bool de v�rif. vrai = reussi
	 */
	public Article SelectLastArticle();
	
	/**
	 * Selectionne les Articles qui contiennent la chaine de caract�re pass�e en param�tre
	 * @param design chaine de recherche
	 * @return ArrayList d'article
	 */
	public ArrayList<Article> SelectArticleByDesign(String design);
	
	
	
}
