package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudCargoService {
    private Boolean system = true;
    @Autowired
    private CargoRepository cargoRepository;

    public void inicial(Scanner scanner){
        while(system){
            System.out.println("Qual ação de cargo deseja executar");
            System.out.println("0 - Sair");
            System.out.println("1-  Salvar");
            System.out.println("2- Atualizar");

            int action = scanner.nextInt();
            switch(action){
                case 1:
                    salvar(scanner);
                    break;
                case 2:
                    atualizar(scanner);
                    break;
                default:
                    system = false;
                    break;
            }

        }
    }

    private void salvar(Scanner scanner){
        System.out.println("Descricao do cargo: ");
        String descricao = scanner.next();
        Cargo c = new Cargo();
        c.setDescricao(descricao);
        this.cargoRepository.save(c);
        System.out.println("Salvo com sucesso! ");
    }

    private void atualizar(Scanner scanner){
        System.out.println("Informe o ID: ");
        int id = scanner.nextInt();
        System.out.println("Informe a nova Descrição: ");
        String descricao = scanner.next();
        Cargo c = new Cargo();
        c.setId(id);
        c.setDescricao(descricao);

        this.cargoRepository.save(c);
        System.out.println("Alterado com sucesso! ");
    }

}
