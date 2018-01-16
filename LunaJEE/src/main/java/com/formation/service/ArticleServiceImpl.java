package com.formation.service;

import java.util.ArrayList;


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
	public boolean DeleteArticle(Article art) {

		return articleDao.DeleteArticle(art);
	}

	@Override
	public boolean UpdateArticle(Article obj) {

		return articleDao.UpdateArticle(obj);
	}

	@Override
	public boolean CreateArticle(Article obj) {
		return articleDao.CreateArticle(obj);
	}


	@Override
	public Article SelectLastArticle() {

		return articleDao.SelectLastArticle();
	}


	@Override
	public ArrayList<Article> SelectArticleByDesign(String design) {

		return SelectArticleByDesign(design);

	}

}