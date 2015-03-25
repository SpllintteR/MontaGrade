package ui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import utils.GenerateBase;
import utils.Semestre;
import busca.Antecessor;
import busca.BuscaIterativo;
import busca.BuscaLargura;
import busca.BuscaProfundidade;
import busca.Estado;
import busca.Nodo;
import data.Horario;
import data.HorarioManager;
import data.Materia;

/**
 * Solucao para o problema dos misssionarios e canibais.
 *
 */
public class MontaGrade implements Estado, Antecessor {

	private static Horario			h;
	private static List<Materia>	materias;
	private static List<Materia>	materiasFeitas;

	public String getDescricao() {
		return "Monta a Grade";
	}

	public MontaGrade() {
		materias = new ArrayList<>();
	}

	public MontaGrade(final List<Materia> mats, final Materia m) {
		materias = mats;
		materias.add(m);
	}

	@Override
	public boolean ehMeta() {
		return materias.size() == 4;
	}

	@Override
	public int custo() {
		return 1;
	}

	/** Lista de sucessores */
	@Override
	public List<Estado> sucessores() {
		List<Estado> suc = new LinkedList<Estado>(); // Lista de sucessores
		List<Materia> mats = new ArrayList<>();
		boolean xDone = false;
		while (!xDone) {
			for (int i = 0; (i < h.getSemestreCount()) && !xDone; i++) {
				Semestre s = h.getSemestre(i);
				for (int j = 0; (j < s.getMateriaCount()) && !xDone; j++) {
					Materia m = s.getMateria(j);
					if (tryAddMateria(suc, mats, m)) {
						xDone = suc.size() == 4;
					}
				}
			}
		}
		return suc;
	}

	private boolean tryAddMateria(final List<Estado> estados, final List<Materia> mats, final Materia m) {
		if (materiasFeitas.contains(m)) {
			return false;
		}
		if (mats.size() == 0) {
			MontaGrade n = new MontaGrade(mats, m);
			estados.add(n);
			return true;
		}
		for (Materia mat : mats) {
			if (mat.horarioCoincide(m)) {
				return false;
			}
		}
		MontaGrade n = new MontaGrade(mats, m);
		estados.add(n);
		return true;
	}

	/** Lista de antecessores, para busca bidirecional */
	@Override
	public List<Estado> antecessores() {
		return sucessores();
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
		MontaGrade inicial = new MontaGrade();

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
			if (str.equals("1")) {
				System.out.println("Busca em Largura");
				n = new BuscaLargura().busca(inicial);
			} else {
				if (str.equals("2")) {
					System.out.println("Busca em Profundidade");
					n = new BuscaProfundidade(20).busca(inicial);
				} else {
					if (str.equals("3")) {
						System.out.println("Busca em Profundidade Iterativo");
						n = new BuscaIterativo().busca(inicial);
					}
				}
			}
			if (str.equals("1") || str.equals("2") || str.equals("3")) {
				if (n == null) {
					System.out.println("Sem Solucao!");
				} else {
					System.out.println("Solucao:\n" + n.montaCaminho() + "\n\n");
				}
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
		// materias.add(h.getSemestre(1).getMateria(0));
		// System.out.println(h.getSemestre(1).getMateria(0));
		// materias.add(h.getSemestre(1).getMateria(1));
		// System.out.println(h.getSemestre(1).getMateria(1));
		// materias.add(h.getSemestre(1).getMateria(2));
		// System.out.println(h.getSemestre(1).getMateria(3));
		// materias.add(h.getSemestre(1).getMateria(3));
		// System.out.println(h.getSemestre(1).getMateria(3));
		// materias.add(h.getSemestre(2).getMateria(0));
		// System.out.println(h.getSemestre(2).getMateria(0));
		// materias.add(h.getSemestre(2).getMateria(2));
		// System.out.println(h.getSemestre(2).getMateria(2));
		// materias.add(h.getSemestre(2).getMateria(1));
		// System.out.println(h.getSemestre(2).getMateria(1));
		// materias.add(h.getSemestre(2).getMateria(4));
		// System.out.println(h.getSemestre(2).getMateria(4));
		// materias.add(h.getSemestre(3).getMateria(3));
		// System.out.println(h.getSemestre(3).getMateria(3));
		// materias.add(h.getSemestre(3).getMateria(4));
		// System.out.println(h.getSemestre(3).getMateria(4));
		// materias.add(h.getSemestre(3).getMateria(1));
		// System.out.println(h.getSemestre(3).getMateria(1));
		// materias.add(h.getSemestre(3).getMateria(2));
		// System.out.println(h.getSemestre(3).getMateria(2));
		return materias;
	}
}
