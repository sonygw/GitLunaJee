package com.formation.tests;

import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.formation.context.ConteneurSpring;
import com.formation.model.ArtCom;
import com.formation.model.Article;
import com.formation.model.Commande;
import com.formation.service.ArtComService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConteneurSpring.class)
public class ArtComServiceTest {

	@Autowired
	private ArtComService artComService;
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConteneurSpring.class);

	@Test
	@Transactional
	@Rollback(true)
	public void testSaveOrUpdateArtCom() {

		artComService = context.getBean(ArtComService.class);

		Article article = new Article();
		article.setIdArticle(500);

		Commande commande = new Commande();
		commande.setIdCommande(500);
		
		ArtCom artCom = new ArtCom(3, article, commande);
		assertTrue(artComService.SaveOrUpdateArtCom(artCom));
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteArtCom() {

		artComService = context.getBean(ArtComService.class);

		Article article = new Article();
		article.setIdArticle(500);

		Commande commande = new Commande();
		commande.setIdCommande(500);
		
		ArtCom artCom = new ArtCom(3, article, commande);
		assertTrue(artComService.DeleteArtCom(artCom));
	}
	

}
