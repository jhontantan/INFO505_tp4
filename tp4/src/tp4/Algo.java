package tp4;

import java.util.ArrayList;
import java.util.Observable;

public class Algo extends Observable  {
	
	/*
	int a = 1;
	int b = 1;
	double c = 0.7;
	int q = 1;
	int nombreVille = 15;
	int nombreFourmi = 1;
	int nombreCycle = 1;*/
	
	private int q;
	private double c;
	private int a;
	private int b;
	private int nombreVille;
	private int nombreFourmi;
	private int nombreCycle;
	private ArrayList<Arrete> ArretesMC;

	 
	private Carte carte;
	private Colonie colonie;

	

	public Algo(int q, double c, int a, int b, int nombreVille, int nombreFourmi, int nombreCycle) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.q = q;
		this.nombreVille = nombreVille;
		this.nombreFourmi = nombreFourmi;
		this.nombreCycle = nombreCycle;
		
		carte = new Carte(nombreVille, a, b, q, c); //Generation de la carte (placement aleatoire des villes)
		colonie = new Colonie(nombreFourmi); //Initialisation des fourmis

	}

	
	public ArrayList<Arrete> algoFourmi() { //Retourne le meilleur cycle
		ArrayList<Arrete> meilleurCycle = new ArrayList<Arrete>();
		//ArretesMC = new ArrayList<Arrete>();

		carte.repartirFourmis(colonie); //Repartition aleatoire des fourmis sur la carte
		//ATTENTION reinitialiser le chemin des fourmis
		int j = 0;

		while (/*!colonie.converge()*/ j < 100) {
			for (int i = 0; i < colonie.getNombreFourmi(); i++) {
				Fourmi fourmiCourante = colonie.getFourmi(i);
				while (!fourmiCourante.cheminFini(nombreVille)) { //Si le cycle fourmi n'est pas termine
					fourmiCourante.villeSuivante(carte); //Alors la fourmi se deplace sur la ville suivante
				}
			}
	
			carte.evaporation();
			carte.deposerPheromone(colonie);
			
		//	System.out.println("avant"+colonie.getFourmi(0).getChemin().size());

			meilleurCycle = garderMeilleurCycle(colonie.getMeilleurCycle(), meilleurCycle);
		//	System.out.println("ID: "+colonie.getFourmi(0).getChemin().get(0).getVille1().getID());

			
			carte.repartirFourmis(colonie);
			j++;
		}
			//System.out.println("Ville1: "+meilleurCycle.get(1).getVille1().getID());
			//System.out.println("Ville1: "+meilleurCycle.get(1).getVille2().getID());

//			System.out.println("ori: "+meilleurCycle.size());		
			ArretesMC = (ArrayList<Arrete>)meilleurCycle.clone();
	//		System.out.println("Ville1: "+ArretesMC.get(1).getVille1().getID());
	//		System.out.println("Ville1: "+ArretesMC.get(1).getVille2().getID());
			System.out.println("copy: "+ArretesMC.size());		

		return meilleurCycle;
	}
	
	private ArrayList<Arrete> garderMeilleurCycle(ArrayList<Arrete> cycle1, ArrayList<Arrete> cycle2){
		double dist1 = Carte.calculerDistanceChemin(cycle1);
		double dist2 = Carte.calculerDistanceChemin(cycle2);
		if(dist1 == 0) {
			return cycle2;
		} else if (dist2 == 0) {
			return cycle1;
		} else if(dist1 > dist2) {
			return cycle2;
		} else {
			return cycle1;
		}
	}
	
	
	public ArrayList<Arrete> getArretesMC() {
		return ArretesMC;
	}

	public Carte getCarte() {
		return carte;
	}
	
	public Colonie getColonie() {
		return colonie;
	}
	
	
	public void update() {
		this.setChanged();
		this.notifyObservers();
	}
	
}
