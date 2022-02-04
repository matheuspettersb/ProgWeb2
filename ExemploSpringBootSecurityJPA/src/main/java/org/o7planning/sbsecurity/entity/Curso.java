package org.o7planning.sbsecurity.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso {

	@Column(name = "nome")
	private String nome;
	@Id
	@Column(name = "id_curso")
	private int id_curso;
	// @Column (name = "alunos")
	// private List <Aluno> alunos;
	@Column(name = "periodo")
	private String periodo;
	@Column(name = "duracao")
	private int duracao;

	public Curso(String nome, int id_curso, String periodo, int duracao) throws Exception { // List<Aluno> alunos retirado
		// verifica��o aqui/nos sets?
		super();
		setNome(nome);
		setId_curso(id_curso);
		// this.alunos = alunos;
		setPeriodo(periodo);
		setDuracao(duracao);
	}

	public Curso() {

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

	public int getId_curso() {
		return id_curso;
	}

	public void setId_curso(int id_curso) throws Exception {
		if (id_curso < 1)
			throw new Exception("Identificador do curso n�o pode ser menor que 1");
		this.id_curso = id_curso;
	}

	// public List<Aluno> getAlunos() {
	// return alunos;
	// }
	// public void setAlunos(List<Aluno> alunos) {
	// this.alunos = alunos;
	// }
	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) throws Exception {
		if (periodo != null && !periodo.isEmpty()) {
			if (periodo.equals("Matutino") || periodo.equals("Vespertino") || periodo.equals("Noturno")) {
				this.periodo = periodo;
			}else {
				throw new Exception("O per�odo deve ser Matutino, Vespertino ou Noturno");
			}
		} else {
			throw new Exception("O per�odo n�o pode se nulo e sem nome indicado");
		}
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) throws Exception {
		if (duracao < 1)
			throw new Exception("O curso n�o pode ter dura��o menor que um semestre");
		this.duracao = duracao;
	}
}