package br.com.alura.spring.data;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.service.CrudCargoService;
import br.com.alura.spring.data.service.CrudFuncionarioService;
import br.com.alura.spring.data.service.CrudUnidadeTrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
	private Boolean system = true;
	@Autowired
	private CrudCargoService cargoService;
	@Autowired
	private CrudFuncionarioService funcionarioService;
	@Autowired
	private CrudUnidadeTrabalhoService unidadeService;
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);

		while(system){
			System.out.println("Qual ação você deseja executar ? ");
			System.out.println("0 -  Sair da aplicação");
			System.out.println("1 -  Cargo");
			System.out.println("2 -  Funcionário");
			System.out.println("3 -  Unidade de Trabalho\n");
			int action = sc.nextInt();
			if(action == 1){
				cargoService.inicial(sc);
			}else if (action == 2){
				funcionarioService.inicial(sc);
			}else if (action == 3){
				unidadeService.inicial(sc);
			} else{
				system = false;
			}
		}

	}
}
