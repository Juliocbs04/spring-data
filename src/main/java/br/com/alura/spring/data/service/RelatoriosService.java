package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {
    private Boolean system = true;

    private final FuncionarioRepository funcionarioRepository;

    public RelatoriosService(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner){
        while(system){
            System.out.println("Qual ação de cargo deseja executar");
            System.out.println("0 - Sair");
            System.out.println("1-  Busca funcionário pelo nome");

            int action = scanner.nextInt();
            switch(action){
                case 1:
                    buscaFuncionario(scanner);
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
}
