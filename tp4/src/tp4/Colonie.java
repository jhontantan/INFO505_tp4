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

	public ArrayList<Arrete> getMeilleurCycle() {
		ArrayList<Arrete> meilleurCycle = new ArrayList<Arrete>();
		double meilleurDistance = 0;
		boolean premierTour = true;
		for (int i = 0; i < colonie.size(); i++) {
			Fourmi fourmiC = getFourmi(i);
			ArrayList<Arrete> cycleCourrant = fourmiC.getChemin();
			double distanceCourante = calculerDistanceChemin(cycleCourrant);
			if(distanceCourante < meilleurDistance || premierTour) {
				premierTour = false;
				meilleurDistance = distanceCourante;
				meilleurCycle = cycleCourrant;
			}
		}
		
		return meilleurCycle;
		
	}
	
	private double calculerDistanceChemin(ArrayList<Arrete> chemin) {
		double distance = 0;
		for (int i = 0; i < chemin.size(); i++) {
			distance += chemin.get(i).getDistance();
		}
		return distance;
	}
	
}