package testsFonctionnels;

import cartes.Attaque;
import cartes.Borne;
import cartes.Carte;
import cartes.Parade;
import cartes.Type;
import cartes.JeuDeCartes;

public class TestMethodeEquals {

	public static void main(String[] args) {
		Carte km1 = new Borne(25);
		Carte km2 = new Borne(25);
		
		Carte feu_rouge1 = new Attaque(Type.FEU);
		Carte feu_rouge2 = new Attaque(Type.FEU);
		
		Carte feu_vert = new Parade(Type.FEU);
		
		if (km1.equals(km2)) {
			System.out.println("KM = KM test TRUE : pass\n");
		}
		
		if (feu_rouge1.equals(feu_rouge2)) {
			System.out.println("Feu rouge = Feu rouge test TRUE : pass\n");
		}
		
		if (!feu_rouge1.equals(feu_vert)) {
			System.out.println("Feu rouge = Feu vert test FALSE : pass\n");
		}
		
	}

}
