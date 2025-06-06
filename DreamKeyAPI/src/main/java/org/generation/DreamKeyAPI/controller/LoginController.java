package org.generation.DreamKeyAPI.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;

import org.generation.DreamKeyAPI.config.JwtFilter;
import org.generation.DreamKeyAPI.dto.Token; 
import org.generation.DreamKeyAPI.model.Usuarios;
import org.generation.DreamKeyAPI.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(path="/api/dreamkey/login")  
public class LoginController {

	private final UsuariosService usuariosServices;
	
	@Autowired
	public LoginController(UsuariosService usuariosServices) {
		this.usuariosServices=usuariosServices;	
		}//Constructor
	
	
	@PostMapping
	public Token loginUser(@RequestBody Usuarios usuarios) throws ServletException{
		
		if(usuariosServices.validateUser(usuarios)) {
			return new Token(generateToken(usuarios.getCorreo()));
		}//if validateUser
		
		throw new ServletException("Nombre de usuario o contraseña incorrectos [" +
		usuarios.getCorreo() + "]");
	}//loginUser
	
	
	private String generateToken(String correo) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, 24);
		
		return Jwts.builder().setSubject(correo).claim("role", "user")
				.setIssuedAt(new Date())
				.setExpiration(calendar.getTime())
				.signWith(SignatureAlgorithm.HS256, JwtFilter.secret)
				.compact();
	}//generateToken
	
	
	
}//class LoginController
