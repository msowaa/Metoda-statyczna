import java.util.Arrays;

class Film {
	
	private final int index;
	private final int początek, koniec;
	
	public int getIndex() {
		return index + 1;
	}
	
	public Film(int index, String film) {
		String data[] = film.split(",");
		początek = Integer.parseInt(data[0]);
		koniec = Integer.parseInt(data[1].trim());
		this.index = index;
	}
	
	public int getPoczątek() {
		return początek;
	}
	
	public int getKoniec() {
		return koniec;
	}
	
	@Override
	public String toString() {
		return "[" + początek + ", " + koniec + "]";
	}
}

public class Filmy {
	
	private final Film[] filmy;
	
	public Filmy(String[] filmy) {
		// alokujemy pamięć
		this.filmy = new Film[filmy.length];
		// tworzymy bazę filmów na podstawie danych wejściowych
		for (int i = 0; i < filmy.length; i++)
			this.filmy[i] = new Film(i, filmy[i]);
	}
	
	/**
	 * Metoda zwracająca rzeczywistą ilość filmów w tablicy
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
	 * Metoda sprawdzająca czy drugi film może być obejrzany przez widza
	 * @param f1
	 * @param f2
	 * @return
	 */
	private boolean sprawdź(Film f1, Film f2) {
		if (f1.getKoniec() <= f2.getPoczątek())
			return true;
		else
			return false;
	}
	
	/**
	 * Metoda wypisująca wartości tablicy
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
				// jeśli następny element nie jest pusty
				if (tab[counter + 1] != null)
					System.out.print(", ");
			counter++;
		}
		System.out.println();
	}
	
	/**
	 * Metoda rozwiązująca zadanie za pomocą algorytmu zachłannego
	 */
	public void wykonaj() {
		
		System.out.println("Dane wejściowe:");
		System.out.println("\tZbiór filmów = " + Arrays.toString(filmy));
		
		Film[] wynik = new Film[filmy.length];

		// zmienna na której będzie zapisywana długość tablicy wynikowej
		int length = 0;
		
		// wyznaczamy tyle kombinacji ile jest filmów w zbiorze
		for (int i = 0; i < filmy.length; i++) {
			
			// obliczamy długość tablicy wynikowej
			length = getLength(wynik);
			
			Film[] kombinacja = new Film[filmy.length];
			kombinacja[0] = filmy[i];
			
			// zmienna na której będzie zapisywana długość tablicy wyznaczającej bieżącą kombinacje
			int len = 1;
			
			// przeszukujemy zbiór
			for (Film f2 : filmy) {
				len = getLength(kombinacja);
				Film f1 = kombinacja[len-1];
				// jeśli widz może obejrzeć drugi film i nie jest to ten sam film
				if (sprawdź(f1, f2) && f1 != f2)
					kombinacja[len] = f2;
			}
			
			// jeśli widz może obejrzeć więcej filmów zapisujemy obecną kombinacje na tablicy wynikowej
			if (len > length)
				wynik = kombinacja;
		}
		
		wypisz(wynik);
	}

}
