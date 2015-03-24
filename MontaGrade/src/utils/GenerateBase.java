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

		Materia m = new Materia("M11");
		aula1 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.TERCA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia("M12");
		aula1 = new Aula(DiaDaSemana.QUARTA, Periodo.P2);
		aula2 = new Aula(DiaDaSemana.SEXTA, Periodo.P1);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia("M13");
		aula1 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P2);
		aula2 = new Aula(DiaDaSemana.SEXTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia("M14");
		aula1 = new Aula(DiaDaSemana.TERCA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.QUINTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia("M15");
		aula1 = new Aula(DiaDaSemana.QUARTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.QUINTA, Periodo.P1);
		m.setAulas(aula1, aula2);
		s.add(m);
		h.addSemestre(s);
		// #################################

		s = new Semestre();
		m = new Materia("M21");
		aula1 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.QUARTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia("M22");
		aula1 = new Aula(DiaDaSemana.TERCA, Periodo.P2);
		aula2 = new Aula(DiaDaSemana.SEXTA, Periodo.P1);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia("M23");
		aula1 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P2);
		aula2 = new Aula(DiaDaSemana.QUINTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		m.setPreRequisito(h.getSemestre(0).getMateria(2));
		s.add(m);

		m = new Materia("M24");
		aula1 = new Aula(DiaDaSemana.TERCA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.SEXTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia("M25");
		aula1 = new Aula(DiaDaSemana.QUARTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.QUINTA, Periodo.P1);
		m.setAulas(aula1, aula2);
		m.setPreRequisito(h.getSemestre(0).getMateria(4));
		s.add(m);
		h.addSemestre(s);

		// #################################
		s = new Semestre();
		m = new Materia("M31");
		aula1 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.QUINTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia("M32");
		aula1 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P2);
		aula2 = new Aula(DiaDaSemana.QUINTA, Periodo.P1);
		m.setAulas(aula1, aula2);
		s.add(m);
		m.setPreRequisito(h.getSemestre(1).getMateria(1));

		m = new Materia("M33");
		aula1 = new Aula(DiaDaSemana.TERCA, Periodo.P2);
		aula2 = new Aula(DiaDaSemana.QUARTA, Periodo.P1);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia("M34");
		aula1 = new Aula(DiaDaSemana.TERCA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.SEXTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);
		m.setPreRequisito(h.getSemestre(1).getMateria(4));

		m = new Materia("M35");
		aula1 = new Aula(DiaDaSemana.QUARTA, Periodo.P2);
		aula2 = new Aula(DiaDaSemana.SEXTA, Periodo.P1);
		m.setAulas(aula1, aula2);
		s.add(m);
		h.addSemestre(s);

		// #################################
		s = new Semestre();
		m = new Materia("M41");
		aula1 = new Aula(DiaDaSemana.SEXTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.QUARTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);
		m.setPreRequisito(h.getSemestre(2).getMateria(3));

		m = new Materia("M42");
		aula1 = new Aula(DiaDaSemana.TERCA, Periodo.P2);
		aula2 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia("M43");
		aula1 = new Aula(DiaDaSemana.TERCA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.QUINTA, Periodo.P1);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia("M44");
		aula1 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.SEXTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia("M45");
		aula1 = new Aula(DiaDaSemana.QUARTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.QUINTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);
		h.addSemestre(s);

		// #################################
		s = new Semestre();
		m = new Materia("M51");
		aula1 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.TERCA, Periodo.P2);
		m.setAulas(aula1, aula2);
		m.setPreRequisito(h.getSemestre(3).getMateria(0));
		s.add(m);

		m = new Materia("M52");
		aula1 = new Aula(DiaDaSemana.QUARTA, Periodo.P2);
		aula2 = new Aula(DiaDaSemana.QUINTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia("M53");
		aula1 = new Aula(DiaDaSemana.SEXTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.QUINTA, Periodo.P1);
		m.setAulas(aula1, aula2);
		m.setPreRequisito(h.getSemestre(3).getMateria(3));
		s.add(m);

		m = new Materia("M54");
		aula1 = new Aula(DiaDaSemana.QUARTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.TERCA, Periodo.P1);
		m.setAulas(aula1, aula2);
		m.setPreRequisito(h.getSemestre(3).getMateria(1));
		s.add(m);

		m = new Materia("M55");
		aula1 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P2);
		aula2 = new Aula(DiaDaSemana.SEXTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);
		h.addSemestre(s);

		// #################################
		s = new Semestre();
		m = new Materia("M61");
		aula1 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.SEXTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia("M62");
		aula1 = new Aula(DiaDaSemana.TERCA, Periodo.P2);
		aula2 = new Aula(DiaDaSemana.QUINTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		m.setPreRequisito(h.getSemestre(4).getMateria(1));
		s.add(m);

		m = new Materia("M63");
		aula1 = new Aula(DiaDaSemana.QUARTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P2);
		m.setAulas(aula1, aula2);
		m.setPreRequisito(h.getSemestre(4).getMateria(0));
		s.add(m);

		m = new Materia("M64");
		aula1 = new Aula(DiaDaSemana.TERCA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.SEXTA, Periodo.P1);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia("M65");
		aula1 = new Aula(DiaDaSemana.QUINTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.QUARTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);
		h.addSemestre(s);

		// #################################
		s = new Semestre();
		m = new Materia("M71");
		aula1 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.QUINTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		m.setPreRequisito(h.getSemestre(5).getMateria(3));
		s.add(m);

		m = new Materia("M72");
		aula1 = new Aula(DiaDaSemana.TERCA, Periodo.P2);
		aula2 = new Aula(DiaDaSemana.SEXTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia("M73");
		aula1 = new Aula(DiaDaSemana.QUARTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P2);
		m.setAulas(aula1, aula2);
		m.setPreRequisito(h.getSemestre(5).getMateria(2));
		s.add(m);

		m = new Materia("M74");
		aula1 = new Aula(DiaDaSemana.QUINTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.SEXTA, Periodo.P1);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia("M75");
		aula1 = new Aula(DiaDaSemana.TERCA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.QUARTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);
		h.addSemestre(s);

		// #################################
		s = new Semestre();
		m = new Materia("M81");
		aula1 = new Aula(DiaDaSemana.SEXTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.TERCA, Periodo.P2);
		m.setAulas(aula1, aula2);
		m.setPreRequisito(h.getSemestre(6).getMateria(1));
		s.add(m);

		m = new Materia("M82");
		aula1 = new Aula(DiaDaSemana.QUARTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P2);
		m.setAulas(aula1, aula2);
		m.setPreRequisito(h.getSemestre(6).getMateria(3));
		s.add(m);

		m = new Materia("M83");
		aula1 = new Aula(DiaDaSemana.QUINTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.SEXTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia("M84");
		aula1 = new Aula(DiaDaSemana.TERCA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P1);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia("M85");
		aula1 = new Aula(DiaDaSemana.QUINTA, Periodo.P2);
		aula2 = new Aula(DiaDaSemana.QUARTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);
		h.addSemestre(s);

		// #################################
		s = new Semestre();
		m = new Materia("M91");
		aula1 = new Aula(DiaDaSemana.QUINTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.QUARTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		m.setPreRequisito(h.getSemestre(7).getMateria(0));
		s.add(m);

		m = new Materia("M92");
		aula1 = new Aula(DiaDaSemana.SEXTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia("M93");
		aula1 = new Aula(DiaDaSemana.TERCA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.SEXTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia("M94");
		aula1 = new Aula(DiaDaSemana.QUARTA, Periodo.P1);
		aula2 = new Aula(DiaDaSemana.SEGUNDA, Periodo.P1);
		m.setAulas(aula1, aula2);
		s.add(m);

		m = new Materia("M95");
		aula1 = new Aula(DiaDaSemana.TERCA, Periodo.P2);
		aula2 = new Aula(DiaDaSemana.QUINTA, Periodo.P2);
		m.setAulas(aula1, aula2);
		s.add(m);
		h.addSemestre(s);

		HorarioManager.saveHorario(h);
		System.out.println("Sucesso!");
	}
}
