package data;

import java.io.Serializable;

/**
 * @author PauloWeber
 */
public class Materia implements Serializable {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;
	private final int			semestre;
	private Aula				aula1;
	private Aula				aula2;
	private String				nome;
	private Materia				preRequisito;

	/**
	 * @param semestre
	 * @param nome
	 */
	public Materia(final int semestre, final String nome) {
		this.semestre = semestre;
		this.nome = nome;
	}

	/**
	 * @param aulas
	 */
	public void setAulas(final Aula aula1, final Aula aula2) {
		this.aula1 = aula1;
		this.aula2 = aula2;
	}

	public void setPreRequisito(final Materia m) {
		preRequisito = m;
	}

	/**
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 */
	public void setNome(final String nome) {
		this.nome = nome;
	}

	/**
	 * @return
	 */
	public int getSemestre() {
		return semestre;
	}

	@Override
	public boolean equals(final Object obj) {
		Materia other = (Materia) obj;
		return this.getNome().equals(other.getNome());
	}
}
