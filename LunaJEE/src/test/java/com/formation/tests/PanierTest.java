package com.formation.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.formation.context.ConteneurSpring;
import com.formation.model.Client;
import com.formation.model.Panier;
import com.formation.service.PanierService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConteneurSpring.class)
public class PanierTest {
	
	@Autowired
	private PanierService panierService;
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConteneurSpring.class);

	@Test
	@Transactional
	public void testSaveOrUpdatePanier() {
		
		panierService = context.getBean(PanierService.class);
		
		Panier panier = new Panier();
		assertTrue(panierService.SaveOrUpdatePanier(panier));
	}
	
	
	@Test
	@Transactional
	public void testSelectPanierFromClient() {
		
		Client client = new Client();
		client.setIdClient(500);
		assertNotNull(panierService.SelectPanierFromClient(client));
	}
	
	@Test
	@Transactional
	public void testCountArticleFromPanier() {
		
		assertNotNull(panierService.SelectCountArticleFromPanier());
	}
	

	@Test
	@Transactional
	public void testDeletePanier() {
		Client client = new Client();
		client.setIdClient(500);
		ArrayList<Panier> panier = panierService.SelectPanierFromClient(client);
		assertFalse(panierService.DeletePanier(panier.get(0)));
	}
	
	@Test
	@Transactional
	public void testDeletePanierFromClient() {
		Client client = new Client();
		client.setIdClient(400);
		
		assertNull(panierService.DeletePanierFromClient(client));
	}
	

}
