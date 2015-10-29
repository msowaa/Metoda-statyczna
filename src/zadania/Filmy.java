package zadania;

import java.util.Arrays;

class Film {
	
	private final int index;
	private final int pocz�tek, koniec;
	
	public int getIndex() {
		return index + 1;
	}
	
	public Film(int index, String film) {
		String data[] = film.split(",");
		pocz�tek = Integer.parseInt(data[0]);
		koniec = Integer.parseInt(data[1].trim());
		this.index = index;
	}
	
	public int getPocz�tek() {
		return pocz�tek;
	}
	
	public int getKoniec() {
		return koniec;
	}
	
	@Override
	public String toString() {
		return "[" + pocz�tek + ", " + koniec + "]";
	}
}

public class Filmy {
	
	private final Film[] filmy;
	
	public Filmy(String[] filmy) {
		// alokujemy pami��
		this.filmy = new Film[filmy.length];
		// tworzymy baz� film�w na podstawie danych wej�ciowych
		for (int i = 0; i < filmy.length; i++)
			this.filmy[i] = new Film(i, filmy[i]);
	}
	
	/**
	 * Metoda zwracaj�ca rzeczywist� ilo�� film�w w tablicy
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
	 * Metoda sprawdzaj�ca czy drugi film mo�e by� obejrzany przez widza
	 * @param f1
	 * @param f2
	 * @return
	 */
	private boolean sprawd�(Film f1, Film f2) {
		if (f1.getKoniec() <= f2.getPocz�tek())
			return true;
		else
			return false;
	}
	
	/**
	 * Metoda wypisuj�ca warto�ci tablicy
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
				// je�li nast�pny element nie jest pusty
				if (tab[counter + 1] != null)
					System.out.print(", ");
			counter++;
		}
		System.out.println();
	}
	
	/**
	 * Metoda rozwi�zuj�ca zadanie za pomoc� algorytmu zach�annego
	 */
	public void wykonaj() {
		
		System.out.println("Dane wej�ciowe:");
		System.out.println("\tZbi�r film�w = " + Arrays.toString(filmy));
		
		Film[] wynik = new Film[filmy.length];

		// zmienna na kt�rej b�dzie zapisywana d�ugo�� tablicy wynikowej
		int length = 0;
		
		// wyznaczamy tyle kombinacji ile jest film�w w zbiorze
		for (int i = 0; i < filmy.length; i++) {
			
			// obliczamy d�ugo�� tablicy wynikowej
			length = getLength(wynik);
			
			Film[] kombinacja = new Film[filmy.length];
			kombinacja[0] = filmy[i];
			
			// zmienna na kt�rej b�dzie zapisywana d�ugo�� tablicy wyznaczaj�cej bie��c� kombinacje
			int len = 1;
			
			// przeszukujemy zbi�r
			for (Film f2 : filmy) {
				len = getLength(kombinacja);
				Film f1 = kombinacja[len-1];
				// je�li widz mo�e obejrze� drugi film i nie jest to ten sam film
				if (sprawd�(f1, f2) && f1 != f2)
					kombinacja[len] = f2;
			}
			
			// je�li widz mo�e obejrze� wi�cej film�w zapisujemy obecn� kombinacje na tablicy wynikowej
			if (len > length)
				wynik = kombinacja;
		}
		
		wypisz(wynik);
	}

}
