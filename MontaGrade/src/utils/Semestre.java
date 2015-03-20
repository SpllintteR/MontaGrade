package utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import data.Materia;

public class Semestre implements Serializable {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;
	private final List<Materia>	materias;

	public Semestre(final Materia... ms) {
		materias = new ArrayList<>();
		for (Materia m : ms) {
			add(m);
		}
	}

	public Semestre() {
		materias = new ArrayList<>();
	}

	public void add(final Materia m) {
		materias.add(m);
	}

	public Materia get(final int i) {
		return materias.get(i);
	}
}
