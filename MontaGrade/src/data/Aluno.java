package data;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

	private final List<Materia>	materiasFeitas	= new ArrayList<>();

	public void add(final Materia m) {
		materiasFeitas.add(m);
	}
}
