package com.decathlon.orderservices.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.decathlon.orderservices.OrderServicesApplication;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = OrderServicesApplication.class)
@SpringBootTest
public class OrderServiceControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void verifyOrderCreation() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/orderCreation")
		        .contentType(MediaType.APPLICATION_JSON)
		        .content("{\"orderId\":1,\"orderDate\": \"2018-07-05T18:25:43.511Z\",\"customerName\":\"Test Customer\",\"modeOfBuying\":\"Online\"}")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.type").exists())
				.andExpect(jsonPath("$.message").exists())
				.andExpect(jsonPath("$.status").exists())
				.andExpect(jsonPath("$.id").value(1)).andExpect(jsonPath("$.type").value("SUCCESS"))
				.andExpect(jsonPath("$.message").value("Order created successfully ID-1"))
				.andExpect(jsonPath("$.status").value("CREATED")).andDo(print());
	}
}
