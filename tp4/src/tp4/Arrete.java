package tp4;

public class Arrete {
	
	private Ville ville1;
	private Ville ville2;
	private double distance;
	private double qtePhe;
	
	public Arrete(Ville ville1, Ville ville2, double distance, double qtePhe ) {
		this.ville1=ville1;
		this.ville2=ville2;
		this.distance=distance;
		this.qtePhe=qtePhe;
		
		
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
	
	
	

}
