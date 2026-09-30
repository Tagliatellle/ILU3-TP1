package cartes;

public abstract class Limite extends Carte {

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Limite limite) {
			return this.equals(limite);
		}
		return false;
	}

}
