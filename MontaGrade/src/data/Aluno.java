package data;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

	private final List<Materia>	materiasFeitas	= new ArrayList<>();

	public void add(final Materia m) {
		if (materiasFeitas.contains(m)) {
			throw new RuntimeException("zica");
		}
		materiasFeitas.add(m);
	}
}
