package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {
    private Boolean system = true;

    private final FuncionarioRepository funcionarioRepository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public RelatoriosService(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner){
        while(system){
            System.out.println("Qual ação de cargo deseja executar");
            System.out.println("0 - Sair");
            System.out.println("1-  Busca funcionário pelo nome");
            System.out.println("2-  Busca funcionário pelo nome, data contratação e salário maior");

            int action = scanner.nextInt();
            switch(action){
                case 1:
                    buscaFuncionario(scanner);
                    break;
                case 2:
                    buscarPorNomeSalario(scanner);
                    break;
                default:
                    system = false;
                    break;
            }

        }
    }

    private void buscaFuncionario(Scanner scanner){
        System.out.println("Qual nome deseja pesquisar: ");
        String nome = scanner.next();
        List<Funcionario> list = funcionarioRepository.findByNome(nome);
        /*for(int i = 0; i<list.size();i++){
            System.out.println(list.get(i).getNome());
        }*/
        list.forEach(System.out::println);
    }

    private void buscarPorNomeSalario(Scanner scanner){
        System.out.println("Qual nome deseja pesquisar: ");
        String nome = scanner.next();
        System.out.println("Digite o salario a ser pesquisado: ");
        Double salario = scanner.nextDouble();
        System.out.println("Qual a Data de contratação: ");
        String dataContratacao = scanner.next();

        List<Funcionario> list = funcionarioRepository.findByNomeSalarioMaiorDataContratacao(nome,salario,LocalDate.parse(dataContratacao, formatter));
        list.forEach(System.out::println);
    }

}
