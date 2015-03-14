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
	private int					semestre;
	private int[]				aulas				= new int[2];
	private String				nome;

	/**
	 * @param semestre
	 * @param nome
	 */
	public Materia(int semestre, String nome) {
		this.semestre = semestre;
		this.nome = nome;
	}

	/**
	 * @param aulas
	 */
	public void setAulas(int[] aulas) {
		this.aulas = aulas;
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
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return
	 */
	public int getSemestre() {
		return semestre;
	}

	/**
	 * @return
	 */
	public int[] getAulas() {
		return aulas;
	}
}
