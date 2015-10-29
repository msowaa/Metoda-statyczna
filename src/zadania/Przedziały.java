package zadania;

import java.util.Arrays;

class Przedzia³ {
	
	private final int pocz¹tek, koniec;
	
	public Przedzia³(String przedzia³) {
		String data[] = przedzia³.split(",");
		pocz¹tek = Integer.parseInt(data[0]);
		koniec = Integer.parseInt(data[1]);
	}
	
	public int getPocz¹tek() {
		return pocz¹tek;
	}
	
	public int getKoniec() {
		return koniec;
	}
	
	@Override
	public String toString() {
		return pocz¹tek + "," + koniec;
		
	}
}

public class Przedzia³y {
	
	private final double liczba;
	private final Przedzia³[] przedzia³y;
	
	public Przedzia³[] getPrzedzia³y() {
		return przedzia³y;
	}
	
	public double getLiczba() {
		return liczba;
	}
	
	/**
	 * Konstruktor przyjmuj¹cy dane wejœciowe zadania
	 * @param przedzia³y
	 * @param liczba
	 */
	public Przedzia³y(String[] przedzia³y, double liczba) {
		// alokujemy pamiêæ
		this.przedzia³y = new Przedzia³[przedzia³y.length];
		// tworzymy przedzia³y na podstawie danych wejœciowych
		for (int i = 0; i < przedzia³y.length; i++)
			this.przedzia³y[i] = new Przedzia³(przedzia³y[i]);
		this.liczba = liczba;
	}
	
	private int sprawdŸ(int index) {
		Przedzia³ p = przedzia³y[index];
		
//		System.err.println("Sprawdzana komórka: " + index);
//		System.err.println("Liczba: " + liczba);
//		System.err.println("Bie¿¹cy przedzia³: " + p.toString());
		
		// jeœli warunek spe³niony
		if (liczba >= p.getPocz¹tek() && liczba <= p.getKoniec())
			return index;
		// jeœli liczba jest mniejsza od wartoœci pocz¹tkowej przedzia³u
		else if (liczba < p.getPocz¹tek())
			return -1;
		// jeœli liczba jest wiêksza od wartoœci koñcowej przedzia³u
		else if (liczba > p.getKoniec())
			return -2;
		// jeœli przedzia³ nie spe³nia ¿adnych warunków
		else
			return -3;
	}
	
	private int dziel(int startIndex, int endIndex) {
		
		// iloœæ elementów w tablicy
		int length = endIndex - startIndex;
		
//		System.err.println("Pocz¹tek tablicy: " + startIndex);
//		System.err.println("Koniec tablicy: " + endIndex);

		int œr = (startIndex + endIndex) / 2;
		
		int wynik = sprawdŸ(œr);
		
//		System.err.println("Wynik dla bie¿¹cego elementu: " + wynik);
		
		// jeœli tablica posiada wiêcej elementów do sprawdzenia ni¿ 1
		if (length > 1) {
			// jeœli liczba jest mniejsza od wartoœci pocz¹tkowej przedzia³u
			if (wynik == -1)
				return dziel(startIndex, œr);
			// jeœli liczba jest wiêksza od wartoœci koñcowej przedzia³u
			else if (wynik == -2)
				return dziel(œr, endIndex);
		}
		
		// jeœli nie uda³o siê znaleŸæ przedzia³u
		if (wynik < 0)
			return -1;
		
		// ++ bo wynik jest indeksem elementu w tablicy pod którym znaleziono przedzia³
		return ++wynik;
	}
	
	/**
	 * Metoda wykonuj¹ca zadanie strategi¹ "Dziel i zwyciê¿aj"
	 */
	public void wykonaj() {
		System.out.println("Dane wejœciowe:");
		System.out.println("\tLiczba = " + liczba);
		System.out.println("\tPrzedzia³y = " + Arrays.toString(przedzia³y));
		System.out.println("Wynik: " + dziel(0, przedzia³y.length));
	}

}
