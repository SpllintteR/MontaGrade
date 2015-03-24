package data;

import java.io.Serializable;

public class Aula implements Serializable {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;
	private final DiaDaSemana	dia;
	private final Periodo		perido;

	public Aula(final DiaDaSemana dia, final Periodo perido) {
		super();
		this.dia = dia;
		this.perido = perido;
	}

	public DiaDaSemana getDia() {
		return dia;
	}

	public Periodo getPerido() {
		return perido;
	}

	public boolean mesmoHorario(final Aula aula) {
		return aula.getDia().equals(this.getDia()) && aula.getPerido().equals(this.getPerido());
	}

}
