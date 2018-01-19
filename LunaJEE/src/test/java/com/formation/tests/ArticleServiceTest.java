package com.formation.tests;

import org.hibernate.SessionFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.formation.context.ConteneurSpring;
import com.formation.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= { ConteneurSpring.class})
public class ArticleServiceTest {

	@Autowired
	ArticleService AS;
	
	@Autowired
	SessionFactory sF;
	
	public void CreateArticleTest() {
		
		
		
	}
	
}
