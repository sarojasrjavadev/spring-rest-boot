package com.newsfetch.springboot.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.newsfetch.springboot.model.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class NewsFetchService {

	private static final Logger logger = LoggerFactory.getLogger(NewsFetchService.class);

	private static final String URL = "https://newsapi.org/v2/top-headlines?country=us&apiKey=9dc773bc688c4f75bdbe3ca4db53a5c1";

	private final RestTemplate restTemplate;

	public NewsFetchService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public List<Article> fetchHeadLines() {
		if (restTemplate != null) {
			NewsHeadlinesResponse response = restTemplate.getForObject(URL, NewsHeadlinesResponse.class);
			if (response != null) {
				return response.getArticles();
			}
		}
		logger.info("Unable to fetch headlines"); 
		return new ArrayList<>();

	}
}
