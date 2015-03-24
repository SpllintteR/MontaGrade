package ui;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import utils.GenerateBase;
import utils.Semestre;
import data.Alternativa;
import data.Aluno;
import data.Horario;
import data.HorarioManager;
import data.Materia;

public class Main {

	private static Horario	h;

	public static void main(final String[] args) {
		try {
			h = HorarioManager.loadHorario();
		} catch (FileNotFoundException e) {
			GenerateBase.main(null);
			try {
				h = HorarioManager.loadHorario();
			} catch (FileNotFoundException e1) {
				throw new RuntimeException("se caiu aqui o mundo acabou");
			}
		}

		Aluno aluno = new Aluno();
		List<Materia> materias = getMateriasFeitas();
		for (Materia m : materias) {
			aluno.add(m);
		}

		List<Alternativa> alternativas = new ArrayList<>();
		while (true) {
			Alternativa a = new Alternativa();
			for (int i = 0; i < h.getSemestreCount(); i++) {
				Semestre s = h.getSemestre(i);
				for (int j = 0; j < s.getMateriaCount(); j++) {
					Materia m = s.getMateria(i);
					if (!materias.contains(m)) {
						a.tryAddMateria(m);
					}
				}
			}
		}
	}

	private static List<Materia> getMateriasFeitas() {
		// TODO:tela que retorna as opções de materias que o aluno fez
		List<Materia> materias = new ArrayList<>();
		materias.add(h.getSemestre(0).get(0));
		materias.add(h.getSemestre(0).get(1));
		materias.add(h.getSemestre(0).get(2));
		materias.add(h.getSemestre(0).get(3));
		materias.add(h.getSemestre(0).get(4));
		materias.add(h.getSemestre(1).get(0));
		materias.add(h.getSemestre(1).get(1));
		materias.add(h.getSemestre(1).get(2));
		materias.add(h.getSemestre(1).get(3));
		materias.add(h.getSemestre(2).get(0));
		materias.add(h.getSemestre(2).get(2));
		materias.add(h.getSemestre(2).get(1));
		materias.add(h.getSemestre(2).get(4));
		materias.add(h.getSemestre(3).get(3));
		materias.add(h.getSemestre(3).get(4));
		materias.add(h.getSemestre(3).get(1));
		materias.add(h.getSemestre(3).get(2));
		return materias;
	}
}
