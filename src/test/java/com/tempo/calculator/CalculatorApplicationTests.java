package com.tempo.calculator;

import java.math.BigDecimal;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tempo.calculator.app.CalculatorController;
import com.tempo.calculator.dto.UserInput;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = CalculatorController.class)
public class CalculatorApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void validateAddWithPositiveNumbers() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addNum").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(new UserInput(new BigDecimal(6), new BigDecimal(2))));
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		Assert.isTrue(result.getResponse().getStatus() == 200, "/addnum call returned 200 status");
		Object output = new JSONObject(result.getResponse().getContentAsString()).get("result");
		Assert.isTrue(output.equals("8"), "Add functionaity is working as expected");
	}

	@Test
	void validateAddWithNegativeNumbers() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addNum").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(new UserInput(new BigDecimal(-6), new BigDecimal(2))));
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		Assert.isTrue(result.getResponse().getStatus() == 200, "/addnum call returned 200 status");
		Object output = new JSONObject(result.getResponse().getContentAsString()).get("result");
		Assert.isTrue(output.equals("-4"), "Add functionaity is working as expected for negative numbers");
	}
	
	@Test
	void validateSubtractWithPositiveNumbers() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/subtractNum").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(new UserInput(new BigDecimal(6), new BigDecimal(2))));
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		Assert.isTrue(result.getResponse().getStatus() == 200, "/subtractNum call returned 200 status");
		Object output = new JSONObject(result.getResponse().getContentAsString()).get("result");
		Assert.isTrue(output.equals("4"), "Subtract functionaity is working as expected");
	}

	@Test
	void validateSubtractWithNegativeNumbers() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/subtractNum").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(new UserInput(new BigDecimal(-6), new BigDecimal(2))));
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		Assert.isTrue(result.getResponse().getStatus() == 200, "/subtractNum call returned 200 status");
		Object output = new JSONObject(result.getResponse().getContentAsString()).get("result");
		Assert.isTrue(output.equals("-8"), "Subtract functionaity is working as expected for negative numbers");
	}
	
	@Test
	void validateMultiplyWithPositiveNumbers() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/multiplyNum").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(new UserInput(new BigDecimal(6), new BigDecimal(2))));
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		Assert.isTrue(result.getResponse().getStatus() == 200, "/multiplyNum call returned 200 status");
		Object output = new JSONObject(result.getResponse().getContentAsString()).get("result");
		Assert.isTrue(output.equals("12"), "Multiply functionaity is working as expected");
	}
	
	
	@Test
	void validateMultiplyWithNegativeNumbers() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/multiplyNum").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(new UserInput(new BigDecimal(6), new BigDecimal(-2))));
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		Assert.isTrue(result.getResponse().getStatus() == 200, "/multiplyNum call returned 200 status");
		Object output = new JSONObject(result.getResponse().getContentAsString()).get("result");
		Assert.isTrue(output.equals("-12"), "Multiply functionaity is working as expected");
	}
	
	@Test
	void validateDivisor() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/divideNum").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(new UserInput(new BigDecimal(6), new BigDecimal(2))));
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		Assert.isTrue(result.getResponse().getStatus() == 200, "/divideNum call returned 200 status");
		Object output = new JSONObject(result.getResponse().getContentAsString()).get("result");
		Assert.isTrue(output.equals("3"), "Divisor functionaity is working as expected");
	}
	
	@Test
	void validateDivisorWithZero() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/divideNum").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(new UserInput(new BigDecimal(6), new BigDecimal(0))));
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		Assert.isTrue(result.getResponse().getStatus() == 500, "/divideNum call returned 500 status");
	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
