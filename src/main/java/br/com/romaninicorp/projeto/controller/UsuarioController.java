package br.com.romaninicorp.projeto.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.romaninicorp.projeto.dao.UsuarioDAO;
import br.com.romaninicorp.projeto.model.Usuario;

@RestController
public class UsuarioController {

	@Autowired //injeção da dependência
	private UsuarioDAO dao;
	
	@GetMapping("/usuarios")
	public ArrayList<Usuario> listarTudo(){
		ArrayList<Usuario> lista = (ArrayList<Usuario>)dao.findAll();
		return lista;
	}
	
	@PostMapping("/login")
	public Usuario login(@RequestBody Usuario user) {
		if (user.getEmail() != null) {
			Usuario resposta = dao.findByEmailAndSenha(user.getEmail(), user.getSenha());
			return resposta;
		}else {
			Usuario resposta = dao.findByRacfAndSenha(user.getRacf(), user.getSenha());
			return resposta;
		}
	}
	
	@PostMapping("/login-status")
	public ResponseEntity<Usuario> loginStatus(@RequestBody Usuario user){
		Usuario resposta = dao.findByRacfOrSenha(user.getRacf(), user.getSenha());
		if (resposta != null) {
			if (user.getSenha().equals(resposta.getSenha())) {
				resposta.setSenha("*****");
				return ResponseEntity.ok(resposta);
			}else {
				return ResponseEntity.status(403).build();
			}
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
