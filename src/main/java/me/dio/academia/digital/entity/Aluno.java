package me.dio.academia.digital.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //ADICIONA OS GETTERS E SETTERS
@NoArgsConstructor
@AllArgsConstructor
@Entity //CRIA A TABELA NO BANCO DE DADOS E PEDE, POR DEFAULT, UM ID
@Table(name = "alunos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno {

	@Id  //ID = CHAVE PRIMARIA DE CADA ALUNO
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@Column(unique = true)
	private String cpf;
	
	private String bairro;
	
	private LocalDate dataDeNascimento;
	
	@OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY) //mappedBy -> "aluno" está sendo usado em AvaliacaoFisica  fetch.LAZY = carrega "aluno" sem as avaliacoes
	@JsonIgnore
	private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

}
