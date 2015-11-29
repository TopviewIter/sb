package com.xluo.controller;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.xluo.StartWeb;
import com.xluo.system.controller.UserController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StartWeb.class)
@WebAppConfiguration
public class UserControllerTest {

	@Resource
	private UserController userController;
	@Resource
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before	
	public void setUp() {
		// Process mock annotations
		MockitoAnnotations.initMocks(this);
		// Setup Spring test in webapp-mode (same config as spring-boot)
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testSave() {
		try {
			this.mockMvc.perform(MockMvcRequestBuilders.get("/user/1")).andExpect(MockMvcResultMatchers.status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}

}
