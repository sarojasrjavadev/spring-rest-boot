package com.newsfetch.springboot.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.newsfetch.springboot.Run;

import static org.junit.Assert.assertTrue;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes=Run.class)
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class NewsFetchEndPointBasicAuthAndResponseTest {
	
	private static final String TEST_URL = "/us-headlines";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void accessProtected() throws Exception {
        this.mockMvc.perform(get(NewsFetchEndPointBasicAuthAndResponseTest.TEST_URL))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void loginUser() throws Exception {
        this.mockMvc.perform(get(NewsFetchEndPointBasicAuthAndResponseTest.TEST_URL).with(httpBasic("user", "password")))
                .andExpect(authenticated());
    }

    @Test
    public void loginInvalidUser() throws Exception {
        MvcResult result = this.mockMvc.perform(get(NewsFetchEndPointBasicAuthAndResponseTest.TEST_URL).with(httpBasic("invalid", "invalid")))
                .andExpect(unauthenticated())
                .andExpect(status().is4xxClientError())
                .andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("HTTP Status 401"));
    }
    
    @Test
    public void testResponseContent() throws Exception {
    	
    	 MvcResult result = this.mockMvc.perform(get(NewsFetchEndPointBasicAuthAndResponseTest.TEST_URL).with(httpBasic("user", "password")))
                 .andExpect(authenticated())
                 .andExpect(status().is2xxSuccessful())
                 .andReturn();
         assertTrue(result.getResponse().getContentAsString().contains("description"));
         assertTrue(result.getResponse().getContentAsString().contains("source"));
         assertTrue(result.getResponse().getContentAsString().contains("author"));
         assertTrue(result.getResponse().getContentAsString().contains("title"));
    	
    }
    
    
}
