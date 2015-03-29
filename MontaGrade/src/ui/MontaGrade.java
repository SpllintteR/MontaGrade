package ui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import utils.GenerateBase;
import utils.Semestre;
import busca.BuscaIterativo;
import busca.BuscaLargura;
import busca.BuscaProfundidade;
import busca.Estado;
import busca.MostraStatusConsole;
import busca.Nodo;
import data.Horario;
import data.HorarioManager;
import data.Materia;

/**
 * Solucao para o problema dos misssionarios e canibais.
 *
 */
public class MontaGrade implements Estado {

	private static final int META = 5;

	private static Horario h;
	private static List<Materia> materias;
	private static List<Materia> materiasFeitas;

	public String getDescricao() {
		return "Monta a Grade";
	}

	public MontaGrade() {
		materias = new ArrayList<>();
	}

	public MontaGrade(final List<Materia> mats) {
		materias = mats;
	}

	@Override
	public boolean ehMeta() {
		boolean resultado = materias.size() == META && ehValido();
		return resultado;
	}

	@Override
	public int custo() {
		return 1;
	}

	/** Lista de sucessores */
	@Override
	public List<Estado> sucessores() {
		List<Estado> suc = new LinkedList<Estado>(); // Lista de sucessores

		addMaterias(suc);
		addMaterias(suc);
		addMateriasPrimeirosSemestres(suc);
		addMateriasPrimeirosSemestres(suc);

		return suc;
	}

	private void addMaterias(List<Estado> suc) {
		List<Materia> mats = new ArrayList<>();
		Random random = new Random();

		while (mats.size() < META) {
			Semestre s = h.getSemestre(random.nextInt(h.getSemestreCount()));
			Materia m = s.getMateria(random.nextInt(s.getMateriaCount()));
			Materia preRequisito = m.getPreRequisito();
			if (preRequisito == null) {
				if (!materiasFeitas.contains(m)) {
					mats.add(m);
				}
			} else if (materiasFeitas.contains(preRequisito) && !materiasFeitas.contains(m)) {
				mats.add(m);
			}
		}

		suc.add(new MontaGrade(mats));
	}
	
	private void addMateriasPrimeirosSemestres(List<Estado> suc) {
		List<Materia> mats = new ArrayList<>();
		Random random = new Random();

		while (mats.size() < META) {
			Semestre s = h.getSemestre(random.nextInt(h.getSemestreCount() - 5));
			Materia m = s.getMateria(random.nextInt(s.getMateriaCount()));
			Materia preRequisito = m.getPreRequisito();
			if (preRequisito == null) {
				if (!materiasFeitas.contains(m)) {
					mats.add(m);
				}
			} else if (materiasFeitas.contains(preRequisito) && !materiasFeitas.contains(m)) {
				mats.add(m);
			}
		}

		suc.add(new MontaGrade(mats));
	}

	private boolean ehValido() {
		List<Materia> materiasParaVerificar = new ArrayList<Materia>();
		for (Materia materia : materias) {
			materiasParaVerificar.add(materia);
		}

		for (int i = 0; i < materias.size(); i++) {
			Materia mat = materias.get(i);

			for (int j = 0; j < materiasParaVerificar.size(); j++) {
				Materia matParaVerificar = materias.get(j);
				if (i != j) {
					if (mat.horarioCoincide(matParaVerificar)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	@Override
	public String toString() {
		String str = "";
		for (Materia m : materias) {
			str += m.toString();
		}
		return str;
	}

	public static void main(final String[] a) throws IOException {
		try {
			h = HorarioManager.loadHorario();
			materias = new ArrayList();
		} catch (FileNotFoundException e) {
			GenerateBase.main(null);
			try {
				h = HorarioManager.loadHorario();
			} catch (FileNotFoundException e1) {
				throw new RuntimeException("se caiu aqui o mundo acabou");
			}
		}

		materiasFeitas = getMateriasFeitas();

		String str;
		BufferedReader teclado;
		teclado = new BufferedReader(new InputStreamReader(System.in));

		Nodo n = null;

		System.out.print("Digite sua opcao de busca { Digite S para finalizar }\n");
		System.out.print("\t1  -  Largura\n");
		System.out.print("\t2  -  Profundidade\n");
		System.out.print("\t3  -  Pronfundidade Iterativo\n");
		System.out.print("Opcao: ");
		str = teclado.readLine().toUpperCase();
		while (!str.equals("S")) {
			MontaGrade inicial = new MontaGrade();
			if (str.equals("1")) {
				System.out.println("Busca em Largura");
				n = new BuscaLargura(new MostraStatusConsole()).busca(inicial);
			} else {
				if (str.equals("2")) {
					System.out.println("Busca em Profundidade");
					n = new BuscaProfundidade(1000, new MostraStatusConsole()).busca(inicial);
				} else {
					if (str.equals("3")) {
						System.out.println("Busca em Profundidade Iterativo");
						n = new BuscaIterativo(new MostraStatusConsole()).busca(inicial);
					}
				}
			}
			if (str.equals("1") || str.equals("2") || str.equals("3")) {
				if (n == null) {
					System.out.println("Sem Solucao!");
				} else {
					System.out.println("Solucao:\n" + n + "\n\n");
				}
				System.out.println("Profundidade:\n" + n.getProfundidade() + "\n\n");
			}
			System.out.print("Digite sua opcao de busca { Digite S para finalizar }\n");
			System.out.print("\t1  -  Largura\n");
			System.out.print("\t2  -  Profundidade\n");
			System.out.print("\t3  -  Pronfundidade Iterativo\n");
			System.out.print("Opcao: ");
			str = teclado.readLine().toUpperCase();
		}
	}

	/**
	 * Verifica se um estado � igual a outro j� inserido na lista de
	 * sucessores (usado para poda)
	 */
	@Override
	public boolean equals(final Object o) {
		try {
			MontaGrade n = (MontaGrade) o;
			boolean xIgual = true;
			int i = 0;
			while (xIgual && (i < materias.size())) {
				Materia m = materias.get(i);
				xIgual = false;
				for (Materia mx : MontaGrade.materias) {
					if (m.equals(mx)) {
						xIgual = true;
					}
				}
				i++;
			}
			return xIgual;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * retorna o hashCode desse estado (usado para poda, conjunto de fechados)
	 */
	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	private static List<Materia> getMateriasFeitas() {
		List<Materia> materias = new ArrayList<>();
		System.out.println("Materias feitas:");
		materias.add(h.getSemestre(0).getMateria(0));
		System.out.println(h.getSemestre(0).getMateria(0));
		materias.add(h.getSemestre(0).getMateria(1));
		System.out.println(h.getSemestre(0).getMateria(1));
		materias.add(h.getSemestre(0).getMateria(2));
		System.out.println(h.getSemestre(0).getMateria(2));
		materias.add(h.getSemestre(0).getMateria(3));
		System.out.println(h.getSemestre(0).getMateria(3));
		materias.add(h.getSemestre(0).getMateria(4));
		System.out.println(h.getSemestre(0).getMateria(4));
		
//		 materias.add(h.getSemestre(1).getMateria(0));
//		 System.out.println(h.getSemestre(1).getMateria(0));
//		 materias.add(h.getSemestre(1).getMateria(1));
//		 System.out.println(h.getSemestre(1).getMateria(1));
//		 materias.add(h.getSemestre(1).getMateria(2));
//		 System.out.println(h.getSemestre(1).getMateria(3));
//		 materias.add(h.getSemestre(1).getMateria(3));
//		 System.out.println(h.getSemestre(1).getMateria(3));
//		 materias.add(h.getSemestre(2).getMateria(0));
//		 System.out.println(h.getSemestre(2).getMateria(0));
//		 materias.add(h.getSemestre(2).getMateria(2));
//		 System.out.println(h.getSemestre(2).getMateria(2));
//		 materias.add(h.getSemestre(2).getMateria(1));
//		 System.out.println(h.getSemestre(2).getMateria(1));
//		 materias.add(h.getSemestre(2).getMateria(4));
//		 System.out.println(h.getSemestre(2).getMateria(4));
//		 materias.add(h.getSemestre(3).getMateria(3));
//		 System.out.println(h.getSemestre(3).getMateria(3));
//		 materias.add(h.getSemestre(3).getMateria(4));
//		 System.out.println(h.getSemestre(3).getMateria(4));
//		 materias.add(h.getSemestre(3).getMateria(1));
//		 System.out.println(h.getSemestre(3).getMateria(1));
//		 materias.add(h.getSemestre(3).getMateria(2));
//		 System.out.println(h.getSemestre(3).getMateria(2));
		return materias;
	}
}
