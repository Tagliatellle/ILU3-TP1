package jeu;

import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import cartes.Carte;

public class Sabot implements Iterable<Carte> {
	private Carte[] cartes;
	private int nbCartes;
	private int nbOperation = 0;

	public Sabot(Carte[] cartes) {
		this.cartes = cartes.clone();
		this.nbCartes = cartes.length;
	}

	public boolean estVide() {
		return this.nbCartes == 0;
	}

	public Carte[] ajouterCartes(Carte newCarte) {
		for (int i = 0; i < nbCartes; i++) {
			if (cartes[i] == null) {
				cartes[i] = newCarte;
				nbCartes++;
				nbOperation++;
				return cartes;
			}
		}
		throw new IllegalStateException("Capacité maximale dépassée");
	}

	public Carte piocher() {
		Iterator<Carte> iter = iterator();
		if (!iter.hasNext()) {
			throw new IllegalStateException("Sabot vide");
		}
		Carte carte = iter.next();
		iter.remove();
		return carte;
	}

	@Override
	public Iterator<Carte> iterator() {
		return new Iterateur();
	}

	private class Iterateur implements Iterator<Carte> {
		private int indiceIterateur = 0;
		private int nbOperationReference = nbOperation;
		private boolean nextEffectue = false;

		@Override
		public boolean hasNext() {
			while (indiceIterateur < cartes.length && cartes[indiceIterateur] == null) {
				indiceIterateur++;
			}
			return indiceIterateur < cartes.length;
		}

		@Override
		public Carte next() {
			verificationConcurrence();
			if (hasNext()) {
				Carte carte = cartes[indiceIterateur];
				nextEffectue = true;
				indiceIterateur++;
				return carte;
			}
			throw new NoSuchElementException();
		}

		public void remove() {
			verificationConcurrence();
			if (!nextEffectue) {
				throw new IllegalStateException();
			}

			cartes[indiceIterateur - 1] = null;
			nbCartes--;
			nbOperation++;
			nbOperationReference = nbOperation;
			nextEffectue = false;
		}

		private void verificationConcurrence() {
			if (nbOperation != nbOperationReference) {
				throw new ConcurrentModificationException();
			}
		}
	}

}
