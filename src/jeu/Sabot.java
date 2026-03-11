package jeu;

import java.util.List;

import cartes.Carte;

public class Sabot {
	private List<Carte> cartes;
	private int nbCartes;

	public Sabot(List<Carte> cartes) {
		this.cartes = cartes;
		this.nbCartes = cartes.size();
	}

	public boolean estVide() {
		return this.nbCartes == 0;
	}

	public void ajouterCartes(Carte carte) {
		this.cartes.add(carte);
		nbCartes++; // TODO lever l'exception
	}

	public Carte piocher() {
		if (this.cartes.isEmpty()) {
			return null;
		}
		Carte carte = this.cartes.removeFirst();
		nbCartes--;
		return carte;
	}

}
