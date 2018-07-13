package com.newsfetch.springboot.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.newsfetch.springboot.Run;
import com.newsfetch.springboot.model.Article;

@SpringBootTest(classes=Run.class)
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class NewsFetchServiceTest {
	
	@Autowired
	NewsFetchService newsFetchService;
	
	TestRestTemplate restTemplate = new TestRestTemplate();

	@Test
	public final void testFetchHeadLines() {
		
		List<Article> articles = newsFetchService.fetchHeadLines();
		assertTrue(articles.size()!=0); 
		
	}
	
}
