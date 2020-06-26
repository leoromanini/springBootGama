package br.com.romaninicorp.projeto.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.romaninicorp.projeto.model.Departamento;

public interface DepartamentoDAO extends CrudRepository<Departamento, Integer>{

}
