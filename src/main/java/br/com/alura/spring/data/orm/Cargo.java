package br.com.alura.spring.data.orm;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="cargos")
@Getter
@Setter
@ToString
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    @OneToMany(mappedBy = "cargo", fetch = FetchType.EAGER)
    private List<Funcionario> funcionario;
}
