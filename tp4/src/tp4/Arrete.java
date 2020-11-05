package tp4;

public class Arrete {
	
	private Ville ville1;
	private Ville ville2;
	private double distance;
	private double qtePhe;
	
	public Arrete(Ville ville1, Ville ville2, double qtePhe) {
		this.ville1=ville1;
		this.ville2=ville2;
		this.qtePhe=qtePhe;
		
		if(ville2 != null) {
			int x = ville1.getX() - ville2.getX();
			int y = ville1.getY() - ville2.getY();
			this.distance = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
		} else {
			this.distance = 0;
		}
		
	}
	
	public Arrete(Ville ville1, Ville ville2) {
		this(ville1, ville2, 1);
		//On initialise la qte de pheromone à 1 et non à 0, sinon on ne peut pas calculer la probabilite de passage à une autre ville
	}
	

	public Ville getVille2() {
		return ville2;
	}

	public Ville getVille1() {
		return ville1;
	}

	public double getDistance() {
		return distance;
	}

	public double getQtePhe() {
		return qtePhe;
	}
	
	
	public boolean contient(Ville ville) {
		return ville1.equals(ville) || ville2.equals(ville);
	}

	
	public void evaporation() {
		qtePhe = qtePhe * (1 - Main.C);
	}
	
	public void deposerPhe(double qte) {
		qtePhe += qte;
	}
	
  	public boolean equals(Object obj) {
  		if(obj != null) {
  	  		if(obj instanceof Arrete) {
  	  		Arrete arrete = (Arrete) obj;
  	  			if(arrete.ville1.equals(arrete.ville2)) {
  	  				return arrete.ville1.equals(ville1) ||  arrete.ville1.equals(ville2);
  	  			} else if(ville1.equals(ville2)) {
  	  				return ville1.equals(arrete.ville1) ||  ville1.equals(arrete.ville2);
  	  			} else {
  	  				return (arrete.ville1.equals(ville1) || arrete.ville1.equals(ville2)) && (arrete.ville2.equals(ville1) || arrete.ville2.equals(ville2));
  	  			}
  	  		}
  		}
  		return false;  		
  	}


}
