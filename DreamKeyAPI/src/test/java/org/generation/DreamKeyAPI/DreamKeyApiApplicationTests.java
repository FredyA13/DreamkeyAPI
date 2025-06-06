package org.generation.DreamKeyAPI;


import org.junit.jupiter.api.Test; 

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.generation.DreamKeyAPI.model.Membresias;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@SpringBootTest
@AutoConfigureMockMvc
class DreamKeyApiApplicationTests {
	private final String token= "Bearer: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJncmVnb3Jpb2dhbGluZG9AZ21haWwuY29tIiwicm9sZSI6InVzZXIiLCJpYXQiOjE3NDgyNzk2OTksImV4cCI6MTc0ODM2NjA5OX0.mYA57jOljbrVrYAxfoggleQUnO7q3_vZwLoE6Tyigmg";
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@Disabled
	@DisplayName("Se prueba el get del endpoint http://localhost:8080/api/dreamkey/membresias/6")
	void pruebaGET() throws Exception{
		
		this.mockMvc.perform(get("/api/dreamkey/membresias/6"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect( content().string(containsString(" ")));
	}
	
	@Test
	@Disabled("Probado una vez, deshabilitado para subsecuentes ocasiones")
	@DisplayName("Se prueba el delete del endpoint http://localhost:8080/api/dreamkey/membresias/2")
	void pruebaDELETE() throws Exception{
		
		this.mockMvc.perform(delete("/api/dreamkey/membresias/2")		
				.header("Authorization",token))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect( content().string(containsString("Membresia plata")));
	}
	
	
	@Test
	@Disabled("Ya se logro esto")
	@DisplayName("Se prueba el update del endpoint http://localhost:8080/api/dreamkey/membresias")
	void pruebaUPDATE() throws Exception{
		
		this.mockMvc.perform(put("/api/dreamkey/membresias/3?nombre=Gregorio")
				.header("Authorization", token))		
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect( content().string(containsString("Gregorio")));
	}
	
	@Test
	@Disabled
	@DisplayName("Se prueba el update del endpoint http://localhost:8080/api/dreamkey/membresias")
	void pruebaPOST() throws Exception{
		
		Membresias p= new Membresias(
				"El mejor",2000.0,"Excelente","imagen.jpg","compralo");
		
		this.mockMvc.perform(post("/api/dreamkey/membresias/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(p))
				.header("Authorization", token))		
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect( content().string(containsString("imagen.jpg")));
	}
	
	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}//catch
	}//asJsonString

}
