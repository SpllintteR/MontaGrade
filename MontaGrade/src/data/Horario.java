package data;

import static ui.Main.*;

import java.io.Serializable;

/**
 * @author Usuario
 *
 */
public class Horario implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private Materia[][]			materias			= new Materia[QTD_SEMESTRES][QTD_DISCIPLINA_POR_SEMESTRE];

	/**
	 * @param m
	 * @param semestre
	 * @param materia
	 */
	public void addMateria(Materia m, int semestre, int materia) {
		materias[semestre][materia] = m;
	}

}
