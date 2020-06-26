package br.com.romaninicorp.projeto.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.romaninicorp.projeto.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{
	
	public Usuario findByEmailAndSenha(String email, String senha);
	public Usuario findByRacfAndSenha(String racf, String senha);
	public Usuario findByRacfOrSenha(String racf, String senha);
	
}
