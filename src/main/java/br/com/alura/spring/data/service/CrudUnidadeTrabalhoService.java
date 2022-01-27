package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.UnidadeTrabalho;
import br.com.alura.spring.data.repository.UnidadeTrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudUnidadeTrabalhoService {
    private Boolean system = true;
    @Autowired
    private UnidadeTrabalhoRepository unidadeTrabalhoRepository;

    public void inicial(Scanner scanner){
        while(system){
            System.out.println("UNIDADE TRABALHO -Qual ação de cargo deseja executar");
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
        System.out.println("Descrição: ");
        String descricao = scanner.next();
        System.out.println("Endereço: ");
        String endereco = scanner.next();
        UnidadeTrabalho u = new UnidadeTrabalho();
        u.setDescricao(descricao);
        u.setEndereco(endereco);
        this.unidadeTrabalhoRepository.save(u);
        System.out.println("Salvo com sucesso! ");
    }

    private void atualizar(Scanner scanner){
        System.out.println("Digite o id: ");
        Integer id = scanner.nextInt();
        System.out.println("Descrição: ");
        String descricao = scanner.next();
        System.out.println("Endereço: ");
        String endereco = scanner.next();
        UnidadeTrabalho u = new UnidadeTrabalho();
        u.setId(id);
        u.setDescricao(descricao);
        u.setEndereco(endereco);
        this.unidadeTrabalhoRepository.save(u);
        System.out.println("Alterado com sucesso! ");
    }

    private void visualizar(){
        Iterable<UnidadeTrabalho> unidades = this.unidadeTrabalhoRepository.findAll();
        unidades.forEach(unidade->System.out.println(unidade));
    }

    private void deletar(Scanner scanner){
        System.out.println("Informe o ID: ");
        int id = scanner.nextInt();
        unidadeTrabalhoRepository.deleteById(id);
    }
}
