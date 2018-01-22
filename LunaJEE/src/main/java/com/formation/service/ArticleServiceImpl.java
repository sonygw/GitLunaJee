package com.formation.service;

import java.util.ArrayList;
import static java.lang.Math.toIntExact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.DAO.ArticleDAO;
import com.formation.model.Article;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDAO articleDao;

	public ArticleServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Article> SelectAllArticles() {

		return articleDao.SelectAllArticles();
	}

	@Override
	public Article SelectArticleById(int id) {

		return articleDao.SelectArticleById(id);
	}

	@Override
	public boolean DeleteArticle(Article obj) {
		articleDao.DeleteArticle(obj);

		
		if (obj.getIdArticle() != 0)
			return false;
		else
			return true;
	}

	@Override
	public boolean SaveOrUpdateArticle(Article obj) {

		if (articleDao.SaveOrUpdateArticle(obj).getIdArticle() != 0)
			return true;
		else
			return false;

	}

	@Override
	public Article SelectLastArticle() {

		return articleDao.SelectLastArticle();
	}

	@Override
	public ArrayList<Article> SelectArticleByDesign(String design) {

		return articleDao.SelectArticleByDesign(design);

	}

}