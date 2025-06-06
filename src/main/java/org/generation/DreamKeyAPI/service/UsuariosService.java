package org.generation.DreamKeyAPI.service;

import java.util.List; 
import java.util.Optional;

import org.generation.DreamKeyAPI.dto.ChangePassword;
import org.generation.DreamKeyAPI.model.Usuarios;

import org.generation.DreamKeyAPI.repository.UsuariosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UsuariosService {
		
		@Autowired
		private PasswordEncoder encoder;
		
		private final UsuariosRepository usuariosRepository;
		
		@Autowired
		public UsuariosService(UsuariosRepository usuariosRepository){
			this.usuariosRepository = usuariosRepository;
		}//constructor
		
		public List<Usuarios> getUsuarios() {
			return usuariosRepository.findAll();
		}//getUsuarios

		public Usuarios getUsuario(Long id) {
			return usuariosRepository.findById(id).orElseThrow(
		()-> new IllegalArgumentException("El usuario con el id[ " + id
				+ " ] no existe.")
					);
		}//getUsuario
		
		
		public Usuarios deleteUsuario(Long id) {
			
			Usuarios user = null;
			if(usuariosRepository.existsById(id)) {
				user = usuariosRepository.findById(id).get();
				usuariosRepository.deleteById(id);
			}//if exists
			return user;
		}//deleteUsuarios

		public Usuarios addUsuario(Usuarios usuario) {
			Optional<Usuarios> user = usuariosRepository.findByCorreo(usuario.getCorreo());
			if(user.isEmpty()) {
				usuario.setContraseña(encoder.encode(usuario.getContraseña()));
				usuariosRepository.save(usuario);
			} else {
				usuario = null;
			}
			return usuario;
		}//addUsuarios

		public Usuarios updateUsuario(Long id, ChangePassword changePassword){
			Usuarios user = null;
			if(usuariosRepository.existsById(id)) {
				user = usuariosRepository.findById(id).get();
				//if(user.getContraseña().equals(changePassword.getPassword())) {
				if(encoder.matches(changePassword.getPassword(), user.getContraseña())) {
					user.setContraseña(encoder.encode(changePassword.getNpassword()));
					usuariosRepository.save(user);
				}else {
					user = null;
				}//ifequals
			}//if exists
			return user;
		}//updateUsuario

		public boolean validateUser(Usuarios usuarios) {
			Optional<Usuarios> user = usuariosRepository.findByCorreo(usuarios.getCorreo());
			if(user.isPresent()) {
				Usuarios tmp = user.get();
				if(encoder.matches(usuarios.getContraseña(), tmp.getContraseña())) {
					return true;
				}//matches
			} //if isPresent
			return false;
		}//validateUser
	
}// class UsuariosService