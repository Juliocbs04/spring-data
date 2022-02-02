package br.com.alura.spring.data.repository;

import br.com.alura.spring.data.orm.Funcionario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {
    List<Funcionario> findByNome(String nome);
}
