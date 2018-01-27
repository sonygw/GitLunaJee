package com.formation.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import com.formation.service.ClientService;
import com.formation.service.CommandeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConteneurSpring.class)
public class CommandeServiceTest {

	@Autowired
	CommandeService commandeService;

	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConteneurSpring.class);

	/**
	 * Test de selection de toutes les commandes
	 */
	@Test
	@Transactional
	public void testSelectAllCommandes() {

		assertNotNull(commandeService.SelectAllCommandes());
	}

	/**
	 * Test de modification/creation
	 */
	@Test
	@Transactional
	public void testSaveOrUpdateCommande() {

		commandeService = context.getBean(CommandeService.class);

		Commande commande = new Commande();

		assertTrue(commandeService.SaveOrUpdateCommande(commande));

	}

	/**
	 * Test de selection de la derniere commandes
	 */
	@Test
	@Transactional
	public void testSelectLastCommande() {
		Commande com = commandeService.SelectLastCommande();
		assertNotNull(com);

	}

	/**
	 * Test de selection d'une commande
	 */
	@Test
	@Transactional
	public void testSelectCommande() {

		assertEquals(commandeService.SelectLastCommande().getIdCommande(), commandeService.SelectCommande((int) commandeService.SelectLastCommande().getIdCommande()).getIdCommande());

	}

	/**
	 * Test de selection d'une commande d'un client
	 */
	@Test
	@Transactional
	public void testSelectCommandeClient() {
		
		ClientService clientSer = context.getBean(ClientService.class);
		assertNotNull(commandeService.SelectCommandesClient((int) clientSer.SelectLastClient().getIdClient()));

	}

	/**
	 * Test de selection de suppression d'une commande
	 */
	@Test
	@Transactional
	public void testDeleteCommande() {

		commandeService = context.getBean(CommandeService.class);


		assertFalse(commandeService.DeleteCommande(commandeService.SelectLastCommande()));

	}
}
