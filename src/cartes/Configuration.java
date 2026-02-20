package cartes;

public class Configuration extends Carte {

	private int nbExemplaires;
	private Carte carte;

	public Configuration(Carte carte, int nbExemplaires) {
		this.nbExemplaires = nbExemplaires;
		this.carte = carte;
	}

	public Carte getCarte() {
		return carte;
	}

	public int getNbExemplaires() {
		return nbExemplaires;
	}

}
