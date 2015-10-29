package zadania;

import java.util.Arrays;

class Film {
	
	private final int index;
	private final int pocz¹tek, koniec;
	
	public int getIndex() {
		return index + 1;
	}
	
	public Film(int index, String film) {
		String data[] = film.split(",");
		pocz¹tek = Integer.parseInt(data[0]);
		koniec = Integer.parseInt(data[1].trim());
		this.index = index;
	}
	
	public int getPocz¹tek() {
		return pocz¹tek;
	}
	
	public int getKoniec() {
		return koniec;
	}
	
	@Override
	public String toString() {
		return "[" + pocz¹tek + ", " + koniec + "]";
	}
}

public class Filmy {
	
	private final Film[] filmy;
	
	public Filmy(String[] filmy) {
		// alokujemy pamiêæ
		this.filmy = new Film[filmy.length];
		// tworzymy bazê filmów na podstawie danych wejœciowych
		for (int i = 0; i < filmy.length; i++)
			this.filmy[i] = new Film(i, filmy[i]);
	}
	
	/**
	 * Metoda zwracaj¹ca rzeczywist¹ iloœæ filmów w tablicy
	 * @param filmy
	 * @return
	 */
	private int getLength(Film[] filmy) {
		int counter = 0;
		for (Film f : filmy)
			if (f != null) counter++;
			else break;
		return counter;
	}
	
	/**
	 * Metoda sprawdzaj¹ca czy drugi film mo¿e byæ obejrzany przez widza
	 * @param f1
	 * @param f2
	 * @return
	 */
	private boolean sprawdŸ(Film f1, Film f2) {
		if (f1.getKoniec() <= f2.getPocz¹tek())
			return true;
		else
			return false;
	}
	
	/**
	 * Metoda wypisuj¹ca wartoœci tablicy
	 * @param tab
	 */
	private void wypisz(Film[] tab) {
		System.out.print("Seanse numer ");
		int counter = 0;
		for (Film f : tab) {
			if (f != null)
				System.out.print(f.getIndex());
			else
				break;
			if (counter < tab.length - 1)
				// jeœli nastêpny element nie jest pusty
				if (tab[counter + 1] != null)
					System.out.print(", ");
			counter++;
		}
		System.out.println();
	}
	
	/**
	 * Metoda rozwi¹zuj¹ca zadanie za pomoc¹ algorytmu zach³annego
	 */
	public void wykonaj() {
		
		System.out.println("Dane wejœciowe:");
		System.out.println("\tZbiór filmów = " + Arrays.toString(filmy));
		
		Film[] wynik = new Film[filmy.length];

		// zmienna na której bêdzie zapisywana d³ugoœæ tablicy wynikowej
		int length = 0;
		
		// wyznaczamy tyle kombinacji ile jest filmów w zbiorze
		for (int i = 0; i < filmy.length; i++) {
			
			// obliczamy d³ugoœæ tablicy wynikowej
			length = getLength(wynik);
			
			Film[] kombinacja = new Film[filmy.length];
			kombinacja[0] = filmy[i];
			
			// zmienna na której bêdzie zapisywana d³ugoœæ tablicy wyznaczaj¹cej bie¿¹c¹ kombinacje
			int len = 1;
			
			// przeszukujemy zbiór
			for (Film f2 : filmy) {
				len = getLength(kombinacja);
				Film f1 = kombinacja[len-1];
				// jeœli widz mo¿e obejrzeæ drugi film i nie jest to ten sam film
				if (sprawdŸ(f1, f2) && f1 != f2)
					kombinacja[len] = f2;
			}
			
			// jeœli widz mo¿e obejrzeæ wiêcej filmów zapisujemy obecn¹ kombinacje na tablicy wynikowej
			if (len > length)
				wynik = kombinacja;
		}
		
		wypisz(wynik);
	}

}
