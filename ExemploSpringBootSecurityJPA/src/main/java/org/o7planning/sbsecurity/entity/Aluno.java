package org.o7planning.sbsecurity.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alunos")

public class Aluno {

	@Column(name = "nome")
	private String nome;
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_aluno")
	private int id_aluno;
	@Column(name = "endereco")
	private String endereco;
	@Column(name = "genero")
	private char genero;
	@Column(name = "idade")
	private Date idade;

	public Aluno(String nome, int id_aluno, String endereco, char genero, Date idade) {
		super();
		this.nome = nome;
		this.id_aluno = id_aluno;
		this.endereco = endereco;
		this.genero = genero;
		this.idade = idade;
	}

	public Aluno() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws Exception {
		if (nome != null && !nome.isEmpty())
			this.nome = nome;
		else {
			throw new Exception("O nome � obrigat�rio");
		}
	}

	public int getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(int id_aluno) throws Exception {
		if (id_aluno < 1)
			throw new Exception("Identificador do aluno n�o pode ser menor que 1");
		this.id_aluno = id_aluno;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) throws Exception {
		if (endereco != null && !endereco.isEmpty()) {
			this.endereco = endereco;
		} else {
			throw new Exception("O endere�o deve ser completo");
		}
	}

	public char getGenero()  {
		
		return genero;
	}

	public void setGenero(char genero) throws Exception {
		if (genero == 'M' || genero == 'F' || genero == 'N') {
			this.genero = genero;

	} else {
		throw new Exception("O genero deve ser M, F ou N");
	}
	
}

	public Date getIdade() {
		return idade;
	}

	public void setIdade(Date idade) throws Exception {
		if (idade != null && !idade.after(new Date())) {
			this.idade = idade;
		} else {
			throw new Exception("O aluno deve ter nascido para ser matriculado");
		}
		
	}

}