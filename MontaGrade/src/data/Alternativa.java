package data;

import java.util.ArrayList;
import java.util.List;

public class Alternativa {

	private final List<Materia>	materias;

	public Alternativa() {
		materias = new ArrayList<>();
	}

	public boolean tryAddMateria(final Materia m) {
		for (Materia mat : materias) {
			if (!mat.horarioCoincide(m)) {
				materias.add(m);
				return true;
			}
		}
		return false;
	}
}
