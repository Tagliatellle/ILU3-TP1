package testsFonctionnels;

import java.util.ArrayList;
import java.util.List;

import cartes.Attaque;
import cartes.Borne;
import cartes.Botte;
import cartes.Configuration;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Parade;
import cartes.Type;
import jeu.Sabot;
import cartes.Carte;

public class TestSabot {

	public static void main(String[] args) {
		
		Configuration[] config = new Configuration[19];
		config[0] = new Configuration(new Borne(25), 10);
		config[1] = new Configuration(new Borne(50), 10);
		config[2] = new Configuration(new Borne(75), 10);
		config[3] = new Configuration(new Borne(100), 12);
		config[4] = new Configuration(new Borne(200), 4);
		config[5] = new Configuration(new Parade(Type.FEU), 14);
		config[6] = new Configuration(new FinLimite(), 6);
		config[7] = new Configuration(new Parade(Type.ESSENCE), 6);
		config[8] = new Configuration(new Parade(Type.CREVAISON), 6);
		config[9] = new Configuration(new Parade(Type.ACCIDENT), 6);
		config[10] = new Configuration(new Attaque(Type.FEU), 5);
		config[11] = new Configuration(new DebutLimite(), 5);
		config[12] = new Configuration(new Attaque(Type.ESSENCE), 3);
		config[13] = new Configuration(new Attaque(Type.CREVAISON), 3);
		config[14] = new Configuration(new Attaque(Type.ACCIDENT), 3);
		config[15] = new Configuration(new Botte(Type.FEU), 1);
		config[16] = new Configuration(new Botte(Type.ESSENCE), 1);
		config[17] = new Configuration(new Botte(Type.CREVAISON), 1);
		config[18] = new Configuration(new Botte(Type.ACCIDENT), 1);
		
		List<Carte> sabot = new ArrayList<Carte>();
		
		for (int i=0 ; i<19 ; i++) {
			for (int x = 0 ; x<config[i].getNbExemplaires();x++) {
				sabot.add(config[i].getCarte());
			}
		}
		
		Sabot jeu = new Sabot(sabot);
		while (!jeu.estVide()) {
			Carte carte = jeu.piocher();
			System.out.println("je pioche "+carte.toString());
		}

	}

}
