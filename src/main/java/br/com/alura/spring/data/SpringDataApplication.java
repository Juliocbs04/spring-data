package br.com.alura.spring.data;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.service.CrudCargoService;
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
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);

		while(system){
			System.out.println("Qual ação você deseja executar ? ");
			System.out.println("0 -  Sair da aplicação");
			System.out.println("1 -  Cargo\n");
			int action = sc.nextInt();
			if(action == 1){
				cargoService.inicial(sc);
			}else{
				system = false;
			}
		}

	}
}
