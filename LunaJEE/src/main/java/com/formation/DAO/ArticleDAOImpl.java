package com.formation.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.formation.model.Article;
import com.formation.model.Client;

public class ArticleDAOImpl implements ArticleDAO {

	Connection conn = null;
	Statement state = null;

	public ArticleDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	public ArticleDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public ArrayList<Article> SelectAllArticles() {

		ResultSet result = null;
		ArrayList<Article> articles = new ArrayList<Article>();

		Article resultat = null;

		try {
			state = conn.createStatement();
			result = state.executeQuery("Select * from article");

			while (result.next()) {
				resultat = new Article(result.getInt("idArticle"), result.getString("code"),
						result.getString("description"), result.getDouble("prixHT"), result.getInt("quantite"),
						result.getString("categorie"));
				articles.add(resultat);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return articles;

	}

	@Override
	public Article SelectArticleById(int id) {

		ResultSet result = null;
		Article article = null;

		try {
			state = conn.createStatement();
			result = state.executeQuery("Select * from article where idArticle = " + id);
			result.next();
			article = new Article(result.getInt("idArticle"), result.getString("code"), result.getString("description"),
					result.getDouble("prixHT"), result.getInt("quantite"), result.getString("categorie"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return article;
	}

	@Override
	public boolean DeleteArticle(int id) {
		boolean result = false;
		try {
			state = conn.createStatement();
			state.executeUpdate("Delete from article where idArticle =" + id);
			result = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean UpdateArticle(Article obj, int id) {
		boolean result = false;

		try {
			state = conn.createStatement();

			String str = "Update article SET code = '" + obj.getCode() + "', description = '" + obj.getDescription()
					+ "', prixHT = " + obj.getPrixHT() + ", quantite = " + obj.getQuantite() + ", categorie = '"
					+ obj.getCategorie() + "' where idArticle = " + id;
			state.executeUpdate(str);
			result = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean CreateArticle(Article obj) {
		boolean result = false;

		try {
			state = conn.createStatement();
			state.executeUpdate("INSERT INTO article VALUES (null, '" + obj.getCode() + "','" + obj.getDescription()
					+ "'," + obj.getPrixHT() + "," + obj.getQuantite() + ",'" + obj.getCategorie() + "')");
			result = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Article SelectLastArticle() {
		ResultSet result = null;
		Article article = null;

		try {
			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM article ORDER BY idArticle DESC LIMIT 1 ");
			if (result.next())
				article = new Article(result.getInt("idArticle"), result.getString("code"),
						result.getString("description"), result.getDouble("prixHT"), result.getInt("quantite"),
						result.getString("categorie"));
			else {
				article = new Article();
				article.setIdArticle(0);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return article;
	}

	@Override
	public ArrayList<Article> SelectArticleByDesign(String design) {

		ResultSet result = null;
		ArrayList<Article> articles = new ArrayList<Article>();

		Article resultat = null;

		try {
			state = conn.createStatement();
			result = state.executeQuery("Select * from article where description like '%" + design +"%'");

			while (result.next()) {
				resultat = new Article(result.getInt("idArticle"), result.getString("code"),
						result.getString("description"), result.getDouble("prixHT"), result.getInt("quantite"),
						result.getString("categorie"));
				articles.add(resultat);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return articles;

	}

}
