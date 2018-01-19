package com.formation.DAO;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.model.Article;

@Repository
public class ArticleDAOImpl implements ArticleDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public ArticleDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Article> SelectAllArticles() {

		@SuppressWarnings("unchecked")
		TypedQuery<Article> result = sessionFactory.getCurrentSession().createQuery("from Article");
		return (ArrayList<Article>) result.getResultList();
	}

	@Override
	public Article SelectArticleById(int id) {

		@SuppressWarnings("unchecked")
		TypedQuery<Article> result = sessionFactory.getCurrentSession()
				.createQuery("from Article where idArticle =" + id);
		return (Article) result.getResultList();
	}

	@Override
	public Article DeleteArticle(Article obj) {

		sessionFactory.getCurrentSession().delete(obj);;
		return obj;
	}

	@Override
	public Article SaveOrUpdateArticle(Article obj) {

		sessionFactory.getCurrentSession().saveOrUpdate(obj);
		return obj;
	}


	@SuppressWarnings("rawtypes")
	@Override
	public Article SelectLastArticle() {

		Query query = sessionFactory.getCurrentSession()
				.createQuery("FROM Article ORDER BY idArticle DESC LIMIT 1 ");
		query.executeUpdate();
		return (Article) query.getResultList();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ArrayList<Article> SelectArticleByDesign(String design) {

		Query query = sessionFactory.getCurrentSession()
				.createQuery("Select * from Article where description like '%" + design + "%'");
		query.executeUpdate();
		return (ArrayList<Article>) query.getResultList();

	}

}