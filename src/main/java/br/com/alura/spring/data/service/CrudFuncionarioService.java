package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Scanner;

@Service
public class CrudFuncionarioService {
    private Boolean system = true;
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void inicial(Scanner scanner){
        while(system){
            System.out.println("FUNCIONARIO -Qual ação de cargo deseja executar");
            System.out.println("0 - Sair");
            System.out.println("1-  Salvar");
            System.out.println("2- Atualizar");
            System.out.println("3- Visualizar");
            System.out.println("4- Deletar Registro pelo ID");

            int action = scanner.nextInt();
            switch(action){
                case 1:
                    salvar(scanner);
                    break;
                case 2:
                    atualizar(scanner);
                    break;
                case 3:
                    visualizar();
                    break;
                case 4:
                    deletar(scanner);
                    break;
                default:
                    system = false;
                    break;
            }

        }
    }

    private void salvar(Scanner scanner){
        System.out.println("Nome do funcionário: ");
        String nome = scanner.next();
        System.out.println("CPF: ");
        String cpf = scanner.next();
        System.out.println("Salario do Funcionario: ");
        Double salario = scanner.nextDouble();
        Funcionario f = new Funcionario();
        f.setNome(nome);
        f.setDataContratacao(LocalDate.now());
        f.setCpf(cpf);
        f.setSalario(salario);
        this.funcionarioRepository.save(f);
        System.out.println("Salvo com sucesso! ");
    }

    private void atualizar(Scanner scanner){
        System.out.println("Informe o ID: ");
        int id = scanner.nextInt();
        System.out.println("Informe a novo Nome: ");
        String nome = scanner.next();
        Funcionario f = new Funcionario();
        f.setId(id);
        f.setNome(nome);

        this.funcionarioRepository.save(f);
        System.out.println("Alterado com sucesso! ");
    }

    private void visualizar(){
        Iterable<Funcionario> funcionarios = this.funcionarioRepository.findAll();
        funcionarios.forEach(funcionario->System.out.println(funcionario));
    }

    private void deletar(Scanner scanner){
        System.out.println("Informe o ID: ");
        int id = scanner.nextInt();
        funcionarioRepository.deleteById(id);
    }
}
