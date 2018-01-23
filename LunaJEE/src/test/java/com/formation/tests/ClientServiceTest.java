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
		
		Client client = new Client();
		client.setNom("Daniel");
		assertTrue(clientService.SaveOrUpdateClient(client));
	}
	
	@Test
	@Transactional
	public void testSelectAllClient() {
		assertNotNull(clientService.SelectAllClients());
	}
	
	@Test
	@Transactional
	public void testSelectLastClient() {
		assertNotNull(clientService.SelectLastClient());
	}
	
	@Test
	@Transactional
	public void testSelectClientById() {
		Client client = clientService.SelectLastClient();
		assertEquals(client.getIdClient(), clientService.SelectClient((int)client.getIdClient()).getIdClient());
	}
	
	@Test
	@Transactional
	public void testSelectClientByName() {
		assertNotNull(clientService.SelectAllClientsByName("Daniel"));
	}
	
	
	@Test
	@Transactional
	public void testDeleteClient() {
		clientService = context.getBean(ClientService.class);
		
		Client client = clientService.SelectLastClient();
		assertFalse(clientService.DeleteClient(client));
	}

	

}
