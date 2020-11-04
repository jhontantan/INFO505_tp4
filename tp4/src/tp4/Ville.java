package tp4;

public class Ville {
  	private int x;
  	private int y;
  	private int id;

  	public static int ID = 0;

  	public Ville(int x, int y) {
  		this.id = ID++;
  		this.x = x;
  		this.y = y;
  	}

  	public Ville() {
  		this((int) (Math.random() * Carte.LARGEUR), (int) (Math.random() * Carte.HAUTEUR));
  	}
  	
  	public int getX() {
  		return x;
  	}
  	
  	public int getY() {
  		return y;
  	}

  	public int getID(){
  		return id;	
  	}
  	
  	public boolean equals(Object obj) {
  		if(obj != null) {
  	  		if(obj instanceof Ville) {
  	  			Ville ville = (Ville) obj;
  	  			return this.id == ville.id; 
  	  		}
  		}
  		return false;  		
  	}


  }