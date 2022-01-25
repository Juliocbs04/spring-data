package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudCargoService {
    @Autowired
    private CargoRepository cargoRepository;

    public void inicial(Scanner scanner){
        salvar(scanner);
    }

    private void salvar(Scanner scanner){
        System.out.println("Descricao do cargo: ");
        String descricao = scanner.next();
        Cargo c = new Cargo();
        c.setDescricao(descricao);
        this.cargoRepository.save(c);
        System.out.println("Salvo com sucesso! ");
    }

}
