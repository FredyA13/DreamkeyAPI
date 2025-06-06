package org.generation.DreamKeyAPI;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.springframework.test.web.servlet.MockMvc;
//import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.generation.DreamKeyAPI.model.Afiliados;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc
class DreamKeyApiApplicationTestsAfiliados {
	//TODO 	TOKEN
	
	@Autowired
	private MockMvc mockMvc;//punto de partida
	
	@Test
	@Disabled
	@DisplayName("Se prueba el  Get del endpoint http://localhost:8080/api/dreamkey/afiliados/2")
	void pruebaGET() throws Exception {
		this.mockMvc.perform(get("/api/dreamkey/afiliados/2") )
		.andDo(print()) .andExpect(status().isOk()  ) 
		.andExpect( content().string(containsString("Walmart") ) );
	}//pruebaGet
	
	@Test 
	@Disabled("Probado una vez, deshabilitado para subsecuentes ocasiones")
	@DisplayName("Se prueba el borrar el afiliado con el id 3 http://localhost:8080/api//dreamkey/afiliados/3")
	void pruebaDELETE() throws Exception {
		this.mockMvc.perform(delete("/api/dreamkey/afiliados/3") 
//			TODO	.header("Authorization", token)	
				)
		.andDo(print()) .andExpect(status().isOk() )
		.andExpect( content().string(containsString("NombreAfiliado") ) );
	}//pruebaDELETE
	
	@Test
	@Disabled
	@DisplayName("Se prueba actualizar el afiliado con el id 2 http://localhost:8080/api/dreamkey/2")
	void pruebaPUT() throws Exception {
		this.mockMvc.perform(put("/api/dreamkey/afiliados/2?img1=ImagenActualizada.jpg&img2=515ftw.jpg") 
				//TODO .header("Authorization", token)	
				)
		.andDo(print()) .andExpect(status().isOk() )
		.andExpect( content().string(containsString("ImagenActualizada") ) )
		.andExpect( content().string(containsString("515ftw.jpg") ) );
	}//pruebaPut
	
	@Test
	@Disabled
	@DisplayName("Se prueba crear un afiliado  con el endpoint http://localhost:8080/api/dreamkey/afiliados/")
	void pruebaPOST() throws Exception {
		
		Afiliados a = new Afiliados("Zebra Afiliados", 
				"Imagen Zebra","Descripcion Zebra" , 2.3, "detalles",
				"servicioZebras", "spa", "facial",
				"img1Zebra.jpg","imagen2Zebra.jpg","imagen3zebra.jpg");
		
		this.mockMvc.perform(post("/api/dreamkey/afiliados/") 
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(a))
//				.header("Authorization", token)	
				)
		.andDo(print()) .andExpect(status().isOk() )
		.andExpect( content().string(containsString("Zebra Afiliados") ) );
	}//pruebaPOST

	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}//catch
	}//asJsonString
	
	
	
}//class DreamKeyApiApplicationTestsAfiliados
