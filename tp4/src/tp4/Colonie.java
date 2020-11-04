package tp4;

import java.util.ArrayList;

public class Colonie {
	private ArrayList<Fourmi> colonie;
	private int nombreFourmi;

	
	public Colonie(int nombreFourmi) {
		this.nombreFourmi = nombreFourmi;
		this.colonie = new ArrayList<Fourmi>();

		for (int i = 0; i < nombreFourmi; i++) {
			colonie.add(new Fourmi());
		}
	}

	public int getNombreFourmi() {
		return nombreFourmi;
	}
	
	public ArrayList<Fourmi> getColonie(){
		return colonie;
	}

	public Fourmi getFourmi(int i) {
		return colonie.get(i);
	}
}