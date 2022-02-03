package br.com.alura.spring.data.repository;

import br.com.alura.spring.data.orm.Funcionario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {
    List<Funcionario> findByNome(String nome);

    @Query("SELECT f FROM Funcionario f WHERE f.nome = :nome " +
            "AND f.salario = :salario AND f.dataContratacao = :data")
    List<Funcionario> findByNomeSalarioMaiorDataContratacao(String nome, Double salario, LocalDate data);
}
