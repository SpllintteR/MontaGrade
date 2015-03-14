package ui;

import java.util.Random;

import data.Horario;
import data.Materia;
import data.HorarioManager;

/**
 * @author Usuario
 */
public class Main {

	/**
	 * 
	 */
	public static final int	QTD_SEMESTRES				= 9;
	/**
	 * 
	 */
	public static final int	QTD_DISCIPLINA_POR_SEMESTRE	= 5;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		generateBase();
	}

	private static void generateBase() {
		Random r = new Random();
		Horario h = new Horario();
		boolean aulaValida;
		for (int i = 0; i < QTD_SEMESTRES; i++) {
			boolean[] aulas = new boolean[] { false, false, false, false, false, false, false, false, false, false };
			for (int j = 1; j <= QTD_DISCIPLINA_POR_SEMESTRE; j++) {
				Materia m = new Materia(i, "Materia " + ((QTD_DISCIPLINA_POR_SEMESTRE * i) + j));
				int[] horas = new int[2];
				for (int k = 0; k < 2; k++) {
					aulaValida = false;
					int aula = 0;
					while (!aulaValida) {
						aula = r.nextInt(10);
						if (!aulas[aula]) {
							if (k > 0){
								if (aula % 2 != 0) {
									aulaValida = !(horas[0] == aula-1);
								} else {
									aulaValida = !(horas[0] == aula+1);
								}
							}else{
								aulaValida = true;
							}
						}
					}
					aulas[aula] = true;
					horas[k] = aula;
				}
				m.setAulas(horas);
				h.addMateria(m, i, j-1);
			}
		}
		HorarioManager.saveHorario(h);
	}
}
