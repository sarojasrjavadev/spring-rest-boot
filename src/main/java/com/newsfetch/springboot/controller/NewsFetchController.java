package com.newsfetch.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newsfetch.springboot.model.Article;
import com.newsfetch.springboot.service.NewsFetchService;

@RestController
public class NewsFetchController {

	@Autowired
	private NewsFetchService newsFetchService;

	@GetMapping(value = "/us-headlines", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Article>> getNewsHeadLines(Authentication authentication) {
		List<Article> articles;
		if (newsFetchService == null || (newsFetchService.fetchHeadLines()) == null) {
			return new ResponseEntity<List<Article>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		articles = newsFetchService.fetchHeadLines();
		return ResponseEntity.ok().body(articles);
	}

}
