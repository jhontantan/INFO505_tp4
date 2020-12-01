package tp4;

import java.util.ArrayList;
import java.util.Observable;

import javax.naming.directory.InvalidAttributeIdentifierException;

public class Algo extends Observable  {
	
	
	private int q;
	private double c;
	private int a;
	private int b;
	private int nombreVille;
	private int nombreFourmi;
	private int nombreCycle;
    long duree;
    
    private final double indiceConvergence = 0.99;


	 
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
	
	public Algo() {
		this(1,0.7,1,1,10,1000,1);
	}


	public ArrayList<Arrete> algoFourmi() { //Retourne le meilleur cycle
		System.out.println("io,rg");
		ArrayList<Arrete> meilleurCycle = new ArrayList<Arrete>();
		ArrayList<Arrete> ancienMeilleurCycle = new ArrayList<Arrete>();
		long start = System.currentTimeMillis();
		carte.repartirFourmis(colonie); //Repartition aleatoire des fourmis sur la carte
		int j = 0;
		

		while (!converge(ancienMeilleurCycle, meilleurCycle)) {
			System.out.println(j);
			for (int i = 0; i < colonie.getNombreFourmi(); i++) {
				Fourmi fourmiCourante = colonie.getFourmi(i);
				while (!fourmiCourante.cheminFini(nombreVille)) { //Si le cycle fourmi n'est pas termine
					fourmiCourante.villeSuivante(carte); //Alors la fourmi se deplace sur la ville suivante
				}
			}
	
			carte.evaporation();
			carte.deposerPheromone(colonie);
			ancienMeilleurCycle = meilleurCycle; 
			meilleurCycle = garderMeilleurCycle(colonie.getMeilleurCycle(), meilleurCycle);
	
			carte.repartirFourmis(colonie);
			j++;
		}
		duree = System.currentTimeMillis() - start;
		
		return meilleurCycle;
	}
	
	private boolean converge(ArrayList<Arrete> ancienMeilleurCycle, ArrayList<Arrete> meilleurCycle) {
		if(ancienMeilleurCycle.size() != 0) {
			double ancienDist = Carte.calculerDistanceChemin(ancienMeilleurCycle);
			double dist = Carte.calculerDistanceChemin(meilleurCycle);
			
			if(ancienDist/dist <= 1 && ancienDist/dist > indiceConvergence) {
				return true;
			} else {
				return false;
			}
		}
		
		return false;
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

	public Carte getCarte() {
		return carte;
	}
	
	public Colonie getColonie() {
		return colonie;
	}
	
	public long getDuree() {

		return duree;
	}
	
	public void update() {
		this.setChanged();
		this.notifyObservers();
	}

	public void setNombreVille(int nombreVille) {
		this.nombreVille = nombreVille;
	}

	public void setNombreFourmi(int nombreFourmi) {
		this.nombreFourmi = nombreFourmi;
	}
	
	

	
}
