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
import com.formation.model.Client;
import com.formation.service.ClientService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConteneurSpring.class)
public class ClientServiceTest {

	@Autowired
	private ClientService clientService;
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConteneurSpring.class);

	@Test
	@Transactional
	public void testSaveOrUpdateClient() {
		clientService = context.getBean(ClientService.class);

		Client client = context.getBean(Client.class);
		
		client.setIdClient(0);
		client.setLogin("Grosse");
		client.setMotDePasse("lou");
		client.setNom("Daniel");
		assertTrue(clientService.SaveOrUpdateClient(client));
	}
	
	@Test
	@Transactional
	public void testSaveOrUpdateClient2() {
		clientService = context.getBean(ClientService.class);

		Client client = context.getBean(Client.class);
		client.setLogin("Vache");
		client.setMotDePasse("test");
		client.setNom("Louis");
		assertTrue(clientService.SaveOrUpdateClient(client));
	}

	/**
	 * Test de selection de tous les clients
	 */
	@Test
	@Transactional
	public void testSelectAllClient() {
		assertNotNull(clientService.SelectAllClients());
	}

	/**
	 * Test de selection du dernier client
	 */
	@Test
	@Transactional
	public void testSelectLastClient() {
		assertNotNull(clientService.SelectLastClient());
	}

	/**
	 * Test de selection d'un client par son Id
	 */
	@Test
	@Transactional
	public void testSelectClientById() {
		Client client = clientService.SelectLastClient();
		assertEquals(client.getIdClient(), clientService.SelectClient((int) client.getIdClient()).getIdClient());
	}

	/**
	 * Test de selection d'un client par son nom
	 */
	@Test
	@Transactional
	public void testSelectClientByName() {
		assertNotNull(clientService.SelectAllClientsByName("Daniel"));
	}

	/**
	 * Test de selection d'un client par son login et son mot de passe
	 */
	@Test
	@Transactional
	public void testSelectClientByLogNPwd() {

		assertNotNull(clientService.SelectClientByLogNPwd("lou", "lou"));
	}

	/**
	 * Test de suppression d'un client
	 */
	@Test
	@Transactional
	public void testDeleteClient() {
		clientService = context.getBean(ClientService.class);

		Client client = clientService.SelectLastClient();
		assertFalse(clientService.DeleteClient(client));
	}

}
