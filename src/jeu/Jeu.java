package jeu;

import java.util.*;
import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
	private Sabot sabot;

	public Jeu() {

		JeuDeCartes jeu = new JeuDeCartes();
		Carte[] liste = jeu.donnerCartes();
		List<Carte> newList = new ArrayList<Carte>();
		Collections.addAll(newList, liste);
		newList = GestionCartes.melanger(newList);
		Carte[] carteMelanges = newList.toArray(new Carte[0]);
		this.sabot = new Sabot(carteMelanges);
	}

	public Sabot getSabot() {
		return this.sabot;
	}
}
