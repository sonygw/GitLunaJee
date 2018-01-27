package com.formation.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.formation.context.ConteneurSpring;
import com.formation.model.Article;
import com.formation.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ConteneurSpring.class })
public class ArticleServiceTest {

	@Autowired
	private ArticleService AS;
	
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConteneurSpring.class);

	/**
	 * Test de creation d'un article
	 * Resultat doit etre true
	 */
	 @Test
	 public void CreateArticleTest() {
	
	 Article art = context.getBean(Article.class);
	
	 art.setDescription("ok");
	 art.setPrixHT(50);
	 art.setQuantite(150);
	 art.setCategorie("cat 3");
	
	 assertTrue(AS.SaveOrUpdateArticle(art));
	 }
	
	 /**
		 * Test de creation d'un article
		 * Id de l'article selectionne doit etre a l'id de l'article obtenu
		 */
	 @Test
	 public void SelectArticleTest() {
	
	 Article art = context.getBean(Article.class);
	
	 art = AS.SelectArticleById((int) AS.SelectAllArticles().get(1).getIdArticle());
	 assertEquals((int) AS.SelectAllArticles().get(1).getIdArticle(), art.getIdArticle());
	 }
	
	 /**
		 * Test de selection des articles
		 * La liste ne doit pas etre nulle.
		 */
	 @Test
	 public void SelectAllArticlesTest()
	 {
	 //Article art = context.getBean(Article.class);
	
	 ArrayList<Article> list = new ArrayList<Article>();
	
	 list = AS.SelectAllArticles();
	
	 assertNotNull(list);
	
	 }
	
	 /**
		 * Test de creation d'un article par un design
		 * 
		 */
	 @Test
	 public void SelectAllArticlesbyDesignTest()
	 {
	 //Article art = context.getBean(Article.class);
	
	 ArrayList<Article> list = new ArrayList<Article>();
	
	 list = AS.SelectArticleByDesign("ok");
	 System.out.println(list.size());
	 assertNotNull(list);
	
	 }
	
	 /**
		 * Test de selection du dernier article
		 * 
		 */
	 @Test
	 public void SelectLastArticleTest() {
	
	 Article art = context.getBean(Article.class);
	
	 art = AS.SelectLastArticle();
	 assertNotNull(art.getIdArticle());
	 }	
	

	 /**
		 * Test de suppression d'un article
		 * 
		 */
	@Test
	public void DeleteArticleTest() {

		Article art = context.getBean(Article.class);

		art = AS.SelectLastArticle();
		
		assertFalse(AS.DeleteArticle(art));
	}	
	
}
