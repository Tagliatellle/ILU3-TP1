package utils;
import java.util.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class GestionCartes<T> {
	
	public static <T> T extraire(List<T> liste) {
		Random randomNumbers = new Random();
		return liste.remove(randomNumbers.nextInt(liste.size()));
	}
	
	public static <T> List<T> melanger(List<T> liste) {
		List<T> result = new ArrayList<>();
		
		while (!liste.isEmpty()) {
			result.add(extraire(liste));
		}
		
		return result;
	}
	
	public static <T> boolean verifierMelange(List<T> liste1, List<T> liste2) {
		if (liste1.size() != liste2.size()) return false;
		
		for (int i = 0 ; i<liste1.size() ; i++) {
			if (Collections.frequency(liste1, liste1.get(i)) != Collections.frequency(liste2, liste1.get(i))) {
				return false;
			}
		}
		return true;
	}
	
	public static <T> List<T> rassembler(List<T> liste) {
		List<T> result = new ArrayList<>();
		
		while (!liste.isEmpty()) {
			T element = liste.get(0);
			while (liste.contains(element)) {
				result.add(element);
				liste.remove(element);
			}
		}
		liste = result;
		return liste;
	}
	
	public static <T> boolean verifierRassemblement(List<T> liste) {
		Set<T> vus = new HashSet<>();
		
		Iterator<T> itCurrent = liste.iterator();
		Iterator<T> itNext = liste.iterator();
		
		if (itNext.hasNext()) {
			T actuel = itCurrent.next();
			T suivant = itNext.hasNext() ? itNext.next() : null;
			
			vus.add(actuel);
			
			if (suivant!= null && !actuel.equals(suivant)) {
				if (vus.contains(suivant)) {
					return false;
				}
			}
		}
		
		return true;
	}
}

