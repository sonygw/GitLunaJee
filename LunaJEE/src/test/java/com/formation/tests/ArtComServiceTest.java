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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConteneurSpring.class)
public class ArtComServiceTest {

	@Autowired
	private ArtComService artComService;
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConteneurSpring.class);

	@Test
	@Transactional

	public void testSaveOrUpdateArtCom() {
		artComService = context.getBean(ArtComService.class);

		ArtCom artCom = new ArtCom();
		assertTrue(artComService.SaveOrUpdateArtCom(artCom));
	}

	@Test
	@Transactional

	public void testSelectAllArtCom() {

		@SuppressWarnings("unused")
		ArtCom artCom = new ArtCom();
		assertNotNull(artComService.SelectAllArtComFromCommande(500));
	}

	@Test
	@Transactional

	public void testDeleteArtCom() {

		ArtCom artCom = artComService.SelectAllArtComFromCommande(500).get(1);
		assertFalse(artComService.DeleteArtCom(artCom));
	}
}
