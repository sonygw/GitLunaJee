package com.formation.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.formation.context.ConteneurSpring;
import com.formation.model.Commande;
import com.formation.service.CommandeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConteneurSpring.class)
public class CommandeServiceTest {

	@Autowired
	CommandeService commandeService;

	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConteneurSpring.class);

	@Test
	@Transactional
	public void testSelectAllCommandes() {

		assertNotNull(commandeService.SelectAllCommandes());
	}

	@Test
	@Transactional
	public void testSaveOrUpdateCommande() {

		commandeService = context.getBean(CommandeService.class);

		Commande commande = new Commande();

		assertTrue(commandeService.SaveOrUpdateCommande(commande));

	}

	@Test
	@Transactional
	public void testSelectLastCommande() {

		assertTrue(commandeService.SelectLastCommande());

	}

	@Test
	@Transactional
	public void testSelectCommande() {

		assertEquals(40, commandeService.SelectCommande(40).getIdCommande());

	}

	@Test
	@Transactional
	public void testSelectCommandeClient() {

		assertNotNull(commandeService.SelectCommandesClient(500));

	}

	@Test
	@Transactional
	public void testDeleteCommande() {

		commandeService = context.getBean(CommandeService.class);

		Commande commande = new Commande();

		assertTrue(commandeService.DeleteCommande(commande));

	}
}
