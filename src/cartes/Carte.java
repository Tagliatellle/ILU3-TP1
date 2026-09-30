package cartes;

public abstract class Carte {

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Carte carte) {
			return this.equals(carte);
		}
		return false;
	}
}
