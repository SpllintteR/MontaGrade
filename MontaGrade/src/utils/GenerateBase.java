package utils;

import data.Aula;
import data.DiaDaSemana;
import data.Horario;
import data.HorarioManager;
import data.Materia;
import data.Periodo;

/**
 * @author Usuario
 */
public class GenerateBase {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		Horario h = new Horario();
		Aula aula1;
		Aula aula2;
		Semestre s = new Semestre();

		Materia m = new Materia(1, "M11");
		aula1 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.TERCA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia(1, "M12");
		aula1 = new Aula(DiaDaSemana.QUARTA, Periodo.P2);
		aula2 = new Aula(DiaDaSemana.SEXTA, Periodo.P1);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia(1, "M13");
		aula1 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P2);
		aula2 = new Aula(DiaDaSemana.SEXTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia(1, "M14");
		aula1 = new Aula(DiaDaSemana.TERCA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.QUINTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia(1, "M15");
		aula1 = new Aula(DiaDaSemana.QUARTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.QUINTA, Periodo.P1);
		m.setAulas(aula1, aula2);
		s.add(m);
		h.addSemestre(s);
		// #################################

		m = new Materia(1, "M21");
		aula1 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.QUARTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia(1, "M22");
		aula1 = new Aula(DiaDaSemana.TERCA, Periodo.P2);
		aula2 = new Aula(DiaDaSemana.SEXTA, Periodo.P1);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia(1, "M23");
		aula1 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P2);
		aula2 = new Aula(DiaDaSemana.QUINTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		m.setPreRequisito(h.get(0).get(2));
		s.add(m);

		m = new Materia(1, "M24");
		aula1 = new Aula(DiaDaSemana.TERCA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.SEXTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia(1, "M25");
		aula1 = new Aula(DiaDaSemana.QUARTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.QUINTA, Periodo.P1);
		m.setAulas(aula1, aula2);
		m.setPreRequisito(h.get(0).get(4));
		s.add(m);
		h.addSemestre(s);

		// #################################
		s = new Semestre();
		m = new Materia(1, "M31");
		aula1 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.QUINTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia(1, "M32");
		aula1 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P2);
		aula2 = new Aula(DiaDaSemana.QUINTA, Periodo.P1);
		m.setAulas(aula1, aula2);
		s.add(m);
		m.setPreRequisito(h.get(1).get(1));

		m = new Materia(1, "M33");
		aula1 = new Aula(DiaDaSemana.TERCA, Periodo.P2);
		aula2 = new Aula(DiaDaSemana.QUARTA, Periodo.P1);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia(1, "M34");
		aula1 = new Aula(DiaDaSemana.TERCA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.SEXTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);
		m.setPreRequisito(h.get(1).get(4));

		m = new Materia(1, "M35");
		aula1 = new Aula(DiaDaSemana.QUARTA, Periodo.P2);
		aula2 = new Aula(DiaDaSemana.SEXTA, Periodo.P1);
		m.setAulas(aula1, aula2);
		s.add(m);
		h.addSemestre(s);

		// #################################
		s = new Semestre();
		m = new Materia(1, "M41");
		aula1 = new Aula(DiaDaSemana.SEXTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.QUARTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);
		m.setPreRequisito(h.get(2).get(3));

		m = new Materia(1, "M42");
		aula1 = new Aula(DiaDaSemana.TERCA, Periodo.P2);
		aula2 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia(1, "M43");
		aula1 = new Aula(DiaDaSemana.TERCA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.QUINTA, Periodo.P1);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia(1, "M44");
		aula1 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.SEXTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia(1, "M45");
		aula1 = new Aula(DiaDaSemana.QUARTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.QUINTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);
		h.addSemestre(s);

		// #################################
		s = new Semestre();
		m = new Materia(1, "M51");
		aula1 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.TERCA, Periodo.P2);
		m.setAulas(aula1, aula2);
		m.setPreRequisito(h.get(3).get(0));
		s.add(m);

		m = new Materia(1, "M52");
		aula1 = new Aula(DiaDaSemana.QUARTA, Periodo.P2);
		aula2 = new Aula(DiaDaSemana.QUINTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia(1, "M53");
		aula1 = new Aula(DiaDaSemana.SEXTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.QUINTA, Periodo.P1);
		m.setAulas(aula1, aula2);
		m.setPreRequisito(h.get(3).get(3));
		s.add(m);

		m = new Materia(1, "M54");
		aula1 = new Aula(DiaDaSemana.QUARTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.TERCA, Periodo.P1);
		m.setAulas(aula1, aula2);
		m.setPreRequisito(h.get(3).get(1));
		s.add(m);

		m = new Materia(1, "M55");
		aula1 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P2);
		aula2 = new Aula(DiaDaSemana.SEXTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);
		h.addSemestre(s);

		// #################################
		s = new Semestre();
		m = new Materia(1, "M61");
		aula1 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.SEXTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia(1, "M62");
		aula1 = new Aula(DiaDaSemana.TERCA, Periodo.P2);
		aula2 = new Aula(DiaDaSemana.QUINTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		m.setPreRequisito(h.get(4).get(1));
		s.add(m);

		m = new Materia(1, "M63");
		aula1 = new Aula(DiaDaSemana.QUARTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P2);
		m.setAulas(aula1, aula2);
		m.setPreRequisito(h.get(4).get(0));
		s.add(m);

		m = new Materia(1, "M64");
		aula1 = new Aula(DiaDaSemana.TERCA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.SEXTA, Periodo.P1);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia(1, "M65");
		aula1 = new Aula(DiaDaSemana.QUINTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.QUARTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);
		h.addSemestre(s);

		// #################################
		s = new Semestre();
		m = new Materia(1, "M71");
		aula1 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.QUINTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		m.setPreRequisito(h.get(5).get(3));
		s.add(m);

		m = new Materia(1, "M72");
		aula1 = new Aula(DiaDaSemana.TERCA, Periodo.P2);
		aula2 = new Aula(DiaDaSemana.SEXTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia(1, "M73");
		aula1 = new Aula(DiaDaSemana.QUARTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P2);
		m.setAulas(aula1, aula2);
		m.setPreRequisito(h.get(5).get(2));
		s.add(m);

		m = new Materia(1, "M74");
		aula1 = new Aula(DiaDaSemana.QUINTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.SEXTA, Periodo.P1);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia(1, "M75");
		aula1 = new Aula(DiaDaSemana.TERCA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.QUARTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);
		h.addSemestre(s);

		// #################################
		s = new Semestre();
		m = new Materia(1, "M81");
		aula1 = new Aula(DiaDaSemana.SEXTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.TERCA, Periodo.P2);
		m.setAulas(aula1, aula2);
		m.setPreRequisito(h.get(6).get(1));
		s.add(m);

		m = new Materia(1, "M82");
		aula1 = new Aula(DiaDaSemana.QUARTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P2);
		m.setAulas(aula1, aula2);
		m.setPreRequisito(h.get(6).get(3));
		s.add(m);

		m = new Materia(1, "M83");
		aula1 = new Aula(DiaDaSemana.QUINTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.SEXTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia(1, "M84");
		aula1 = new Aula(DiaDaSemana.TERCA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P1);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia(1, "M85");
		aula1 = new Aula(DiaDaSemana.QUINTA, Periodo.P2);
		aula2 = new Aula(DiaDaSemana.QUARTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);
		h.addSemestre(s);

		// #################################
		s = new Semestre();
		m = new Materia(1, "M91");
		aula1 = new Aula(DiaDaSemana.QUINTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.QUARTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		m.setPreRequisito(h.get(7).get(0));
		s.add(m);

		m = new Materia(1, "M92");
		aula1 = new Aula(DiaDaSemana.SEXTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia(1, "M93");
		aula1 = new Aula(DiaDaSemana.TERCA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.SEXTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia(1, "M94");
		aula1 = new Aula(DiaDaSemana.QUARTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P1);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia(1, "M95");
		aula1 = new Aula(DiaDaSemana.TERCA, Periodo.P2);
		aula2 = new Aula(DiaDaSemana.QUINTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);
		h.addSemestre(s);

		HorarioManager.saveHorario(h);
		System.out.println("Sucesso!");
	}
}
