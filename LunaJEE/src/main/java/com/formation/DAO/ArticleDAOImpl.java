package com.formation.DAO;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.model.Article;

public class ArticleDAOImpl implements ArticleDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public ArticleDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Article> SelectAllArticles() {

		@SuppressWarnings("unchecked")
		TypedQuery<Article> result = sessionFactory.getCurrentSession().createQuery("from article");
		return (ArrayList<Article>) result.getResultList();
	}

	@Override
	public Article SelectArticleById(int id) {

		@SuppressWarnings("unchecked")
		TypedQuery<Article> result = sessionFactory.getCurrentSession()
				.createQuery("from article where idArticle =" + id);
		return (Article) result.getResultList();
	}

	@Override
	public boolean DeleteArticle(Article art) {

		sessionFactory.getCurrentSession().delete(art);;
		return true;
	}

	@Override
	public boolean UpdateArticle(Article obj) {

		sessionFactory.getCurrentSession().saveOrUpdate(obj);
		return true;
	}

	@Override
	public boolean CreateArticle(Article obj) {
		sessionFactory.getCurrentSession().save(obj);
		return true;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Article SelectLastArticle() {

		Query query = sessionFactory.getCurrentSession()
				.createQuery("FROM article ORDER BY idArticle DESC LIMIT 1 ");
		query.executeUpdate();
		return (Article) query.getResultList();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ArrayList<Article> SelectArticleByDesign(String design) {

		Query query = sessionFactory.getCurrentSession()
				.createQuery("Select * from article where description like '%" + design + "%'");
		query.executeUpdate();
		return (ArrayList<Article>) query.getResultList();

	}

}