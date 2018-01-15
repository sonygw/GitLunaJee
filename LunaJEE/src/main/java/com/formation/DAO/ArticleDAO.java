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
	 * @return un bool de v�rif. vrai = reussi
	 */
	boolean DeleteArticle(Article art);
	/**
	 * Update un article en fonction d'un Objet Article 
	 * @param obj Obj a inserer en base
	 * @param id id de l'objet � update
	 * @return un bool de v�rif. vrai = reussi
	 */
	public boolean UpdateArticle(Article obj);
	/**
	 * Cr�er un article 
	 * @param obj Objet � ajouter en base
	 * @return un bool de v�rif. vrai = reussi
	 */
	public boolean CreateArticle(Article obj);
	/**
	 * Selectionne le dernier article
	 * @return un bool de v�rif. vrai = reussi
	 */
	public Article SelectLastArticle();
	
	/**
	 * Selectionne les Article qui contiennent la chaine de caract�re pass�e en param�tre
	 * @param design chaine de recherche
	 * @return ArrayList d'article
	 */
	public ArrayList<Article> SelectArticleByDesign(String design);
	
	
	
}
