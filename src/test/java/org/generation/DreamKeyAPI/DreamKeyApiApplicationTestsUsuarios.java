package org.generation.DreamKeyAPI;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.generation.DreamKeyAPI.model.Usuarios;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.hamcrest.Matchers.containsString;


//imports para crear json
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;



@SpringBootTest
@AutoConfigureMockMvc
class DreamKeyApiApplicationTestsUsuarios {

	
	@Autowired
	private MockMvc mockMvc; //punto de partida para probar los métodos;
	
	@Test
	@Disabled
	@DisplayName("Se prueba el GET del endpoint http://localhost:8080/api/dreamkey/usuarios/2")
	void pruebaGET() throws Exception {
		this.mockMvc.perform(get("/api/dreamkey/usuarios/2"))
		.andDo(print()) 
		.andExpect(status().isOk() )
		.andExpect(content().string(containsString("Alvarez")));
		
	}//pruebaGet
	
	
	
	
	@Test
	@Disabled("Probado para una vez, deshabilitado para subsecuentes ocurrencias")
	@DisplayName("Se prueba borrar el producto con el id 4 del endpoint  http://localhost:8080/api/dreamkey/usuarios/4")
	void pruebaDELETE() throws Exception {
		this.mockMvc.perform(delete("/api/dreamkey/usuarios/4"))
			//	.header("Authorization" , token))
		.andDo(print()) 
		.andExpect(status().isOk() )
		.andExpect(content().string(containsString("55896325583")));
	}//pruebaDELETE
	
	
	
	
	@Test
	@Disabled
	@DisplayName("Se prueba actualizar el producto con el id 3 del endpoint http://localhost:8080/api/dreamkey/usuarios/3")
	void pruebaPUT() throws Exception {
		this.mockMvc.perform(put("/api/dreamkey/usuarios/3?password=contra12345678&npassword=contra20"))
		//	.header("Authorization", token))
		.andDo(print()) 
		.andExpect(status().isOk() )
		.andExpect(content().string(containsString("contra12345678")))
		.andExpect(content().string(containsString("contra20")));
		
	}//pruebaPUT
	
	

	@Test
	@Disabled
	@DisplayName("Se prueba crear un  usuario con el endpoint http://localhost:8080/api/dreamkey/usuarios/")
	void pruebaPOST() throws Exception {
		Usuarios u = new Usuarios("Juan Pablo",
				"5562174392",
				"juanpi@gmail.com", 
				"contra963");
		this.mockMvc.perform(post("/api/dreamkey/usuarios/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(u)))
				//.header("Authorization", token))
		.andDo(print()) 
		.andExpect(status().isOk() )
		.andExpect(content().string(containsString("Juan Pablo") )  );
		}//pruebaPUT
	
	
	
	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}//catch
	}//asJsonString

} // class DreamKeyApiApplicationTestsUsuarios
