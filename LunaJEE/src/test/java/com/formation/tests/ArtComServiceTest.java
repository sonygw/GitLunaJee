package com.formation.tests;

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
import com.formation.model.ArtCom;
import com.formation.service.ArtComService;
import com.formation.service.CommandeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConteneurSpring.class)
public class ArtComServiceTest {

	@Autowired
	private ArtComService artComService;
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConteneurSpring.class);

	/**
	 * Test de creation/modification d'un artCom dans la base
	 * Le resultat attendu doit etre true
	 */
	@Test
	@Transactional

	public void testSaveOrUpdateArtCom() {
		artComService = context.getBean(ArtComService.class);

		ArtCom artCom = new ArtCom();
		assertTrue(artComService.SaveOrUpdateArtCom(artCom));
	}

	/**
	 * Test de selection d'un artCom dans la base
	 * Le resultat attendu ne doit pas etre nul
	 */
	@Test
	@Transactional

	public void testSelectAllArtCom() {

		@SuppressWarnings("unused")
		ArtCom artCom = new ArtCom();
		assertNotNull(artComService.SelectAllArtComFromCommande(500));
	}

	/**
	 * Test de creation/modification d'un artCom dans la base
	 * Le resultat attendu doit etre false
	 */
	@Test
	@Transactional

	public void testDeleteArtCom() {

		CommandeService comSer = context.getBean(CommandeService.class);
	
		ArtCom artCom = artComService.SelectAllArtComFromCommande((int) comSer.SelectLastCommande().getIdCommande()).get(0);
		assertFalse(artComService.DeleteArtCom(artCom));
	}
}
