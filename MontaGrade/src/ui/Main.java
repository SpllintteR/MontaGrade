package ui;

import java.io.FileNotFoundException;

import utils.GenerateBase;
import data.Horario;
import data.HorarioManager;

public class Main {
	
	public static void main(String[] args) {
		Horario horario;
		try {
			horario = HorarioManager.loadHorario();
		} catch (FileNotFoundException e) {
			GenerateBase.main(null);
			try {
				horario = HorarioManager.loadHorario();
			} catch (FileNotFoundException e1) {
				throw new RuntimeException("se caiu aqui o mundo acabou");
			}
		}
	}
	
	//
}
