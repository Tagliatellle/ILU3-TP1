package jeu;

public class Joueur {
	private String nom;
	private ZoneDeJeu zone;

	public Joueur(String nom, ZoneDeJeu zone) {
		this.nom = nom;
		this.zone = zone;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Joueur joueur) {
			return this.toString().equals(joueur.toString());
		}
		return false;
	}

}
