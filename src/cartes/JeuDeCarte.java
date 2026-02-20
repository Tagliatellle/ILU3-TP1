package cartes;

public class JeuDeCarte {

	private Configuration[] typesDeCartes = new Configuration[19];

	public JeuDeCarte(Configuration[] configuration) {
		this.typesDeCartes = configuration;
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
}
