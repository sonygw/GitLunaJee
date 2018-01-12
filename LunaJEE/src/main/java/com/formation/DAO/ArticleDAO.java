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
	 * @param id id de l'article a supprimer
	 * @return un bool de vérif. vrai = reussi
	 */
	public boolean DeleteArticle(int id);
	/**
	 * Update un article en fonction d'un Objet Article 
	 * @param obj Obj a inserer en base
	 * @param id id de l'objet à update
	 * @return un bool de vérif. vrai = reussi
	 */
	public boolean UpdateArticle(Article obj, int id);
	/**
	 * Créer un article 
	 * @param obj Objet à ajouter en base
	 * @return un bool de vérif. vrai = reussi
	 */
	public boolean CreateArticle(Article obj);
	/**
	 * Selectionne le dernier article
	 * @return un bool de vérif. vrai = reussi
	 */
	public Article SelectLastArticle();
	
	/**
	 * Selectionne les Article qui contiennent la chaine de caractère passée en paramètre
	 * @param design chaine de recherche
	 * @return ArrayList d'article
	 */
	public ArrayList<Article> SelectArticleByDesign(String design);
	
	
}
