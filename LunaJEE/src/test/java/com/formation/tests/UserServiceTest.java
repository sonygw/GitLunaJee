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
import com.formation.model.User;
import com.formation.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConteneurSpring.class)
public class UserServiceTest {

	@Autowired
	private UserService userService;
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConteneurSpring.class);

	@Test
	@Transactional
	public void testSaveOrUpdateUser() {
		
		userService = context.getBean(UserService.class);
		User user = new User();
		user.setNom("daniel");
		assertTrue(userService.SaveOrUpdateUser(user));
	}

	@Test
	@Transactional
	public void testSelectUser() {
		assertEquals(34,userService.SelectUser(34).getIdUser());
	}

	@Test
	@Transactional
	public void testSelectAllUsers() {
		assertNotNull(userService.SelectAllUsers());
	}

	@Test
	@Transactional
	public void testDeleteUser() {
		User user = new User();
		assertTrue(userService.DeleteUser(user));
	}

}
