package br.com.alura.spring.data.repository;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.FuncionarioProjecao;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.List;

public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer>,
        JpaSpecificationExecutor<Funcionario> {
    List<Funcionario> findByNome(String nome);

    //Usando o ORM
    @Query("SELECT f FROM Funcionario f WHERE f.nome = :nome " +
            "AND f.salario = :salario AND f.dataContratacao = :data")
    List<Funcionario> findByNomeSalarioMaiorDataContratacao(String nome, Double salario, LocalDate data);
    //Usando a query nativa do SQL
    @Query(value = "SELECT * FROM funcionarios f WHERE f.data_contratacao >= :data", nativeQuery = true)
    List<Funcionario> findDataContratacaoMaior(LocalDate data);

    //Exemplificando como retornar apenas 3 campos usando entidade com escopo reduzido(criando uma interface)
    @Query(value = "SELECT f.id, f.nome, f.salario FROM funcionarios f", nativeQuery = true)
    List<FuncionarioProjecao> findFuncionarioSalario();

}
