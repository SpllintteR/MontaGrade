package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import utils.Semestre;

/**
 * @author Usuario
 *
 */
public class Horario implements Serializable {

	/**
	 *
	 */
	private static final long		serialVersionUID	= 1L;
	private final List<Semestre>	semestres			= new ArrayList<>();

	public void addSemestre(final Semestre s) {
		semestres.add(s);
	}

	public Semestre get(final int i) {
		return semestres.get(i);
	}

}
