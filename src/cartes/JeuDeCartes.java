package cartes;

public class JeuDeCartes {

	private Configuration[] typesDeCartes = new Configuration[19];

	public JeuDeCartes() {
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
		
		this.typesDeCartes = config;
	}

	public String affichageJeuDeCartes() {

		StringBuilder jeu = new StringBuilder();

		for (int i = 0; i < this.typesDeCartes.length; i++) {
			jeu.append(this.typesDeCartes[i].getNbExemplaires()).append(" ")
					.append(this.typesDeCartes[i].getCarte().toString()).append("\n");
		}

		return jeu.toString();
	}

	public Carte[] donnerCartes() {
		int size = 0;

		for (int i = 0; i < this.typesDeCartes.length; i++) {
			size += this.typesDeCartes[i].getNbExemplaires();
		}

		Carte[] jeu = new Carte[size];
		int indice = 0;
		for (int i = 0; i < this.typesDeCartes.length; i++) {
			for (int nbrCarte = 0; nbrCarte < this.typesDeCartes[i].getNbExemplaires(); nbrCarte++) {
				jeu[indice] = this.typesDeCartes[i].getCarte();
				indice++;
			}
		}

		return jeu;
	}
	
	public boolean checkCount() {
		
		Carte[] cartes = this.donnerCartes();
		
		int indice = 0;
		for (int i = 0; i<this.typesDeCartes.length ; i++) {
			for (int count = 0 ; count<this.typesDeCartes[i].getNbExemplaires(); count++) {
				if (!cartes[indice].equals(this.typesDeCartes[i].getCarte())) {
					return false;
				}
				indice++;
			}
		}
		return true;
	}
}
