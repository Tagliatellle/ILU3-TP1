package cartes;

public abstract class Limite extends Carte {

	public Limite() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Limite limite) {
			return this.toString().equals(limite.toString());
		}
		return false;
	}

}
