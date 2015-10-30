import java.util.Arrays;

class Przedział {
	
	private final int początek, koniec;
	
	public Przedział(String przedział) {
		String data[] = przedział.split(",");
		początek = Integer.parseInt(data[0]);
		koniec = Integer.parseInt(data[1]);
	}
	
	public int getPoczątek() {
		return początek;
	}
	
	public int getKoniec() {
		return koniec;
	}
	
	@Override
	public String toString() {
		return początek + "," + koniec;
		
	}
}

public class Przedziały {
	
	private final double liczba;
	private final Przedział[] przedziały;
	
	public Przedział[] getPrzedziały() {
		return przedziały;
	}
	
	public double getLiczba() {
		return liczba;
	}
	
	/**
	 * Konstruktor przyjmujący dane wejściowe zadania
	 * @param przedziały
	 * @param liczba
	 */
	public Przedziały(String[] przedziały, double liczba) {
		// alokujemy pamięć
		this.przedziały = new Przedział[przedziały.length];
		// tworzymy przedziały na podstawie danych wejściowych
		for (int i = 0; i < przedziały.length; i++)
			this.przedziały[i] = new Przedział(przedziały[i]);
		this.liczba = liczba;
	}
	
	private int sprawdź(int index) {
		Przedział p = przedziały[index];
		
//		System.err.println("Sprawdzana komórka: " + index);
//		System.err.println("Liczba: " + liczba);
//		System.err.println("Bieżący przedział: " + p.toString());
		
		// jeśli warunek spełniony
		if (liczba >= p.getPoczątek() && liczba <= p.getKoniec())
			return index;
		// jeśli liczba jest mniejsza od wartości początkowej przedziału
		else if (liczba < p.getPoczątek())
			return -1;
		// jeśli liczba jest większa od wartości końcowej przedziału
		else if (liczba > p.getKoniec())
			return -2;
		// jeśli przedział nie spełnia żadnych warunków
		else
			return -3;
	}
	
	private int dziel(int startIndex, int endIndex) {
		
		// ilość elementów w tablicy
		int length = endIndex - startIndex;
		
//		System.err.println("Początek tablicy: " + startIndex);
//		System.err.println("Koniec tablicy: " + endIndex);

		int śr = (startIndex + endIndex) / 2;
		
		int wynik = sprawdź(śr);
		
//		System.err.println("Wynik dla bieżącego elementu: " + wynik);
		
		// jeśli tablica posiada więcej elementów do sprawdzenia niż 1
		if (length > 1) {
			// jeśli liczba jest mniejsza od wartości początkowej przedziału
			if (wynik == -1)
				return dziel(startIndex, śr);
			// jeśli liczba jest większa od wartości końcowej przedziału
			else if (wynik == -2)
				return dziel(śr, endIndex);
		}
		
		// jeśli nie udało się znaleźć przedziału
		if (wynik < 0)
			return -1;
		
		// ++ bo wynik jest indeksem elementu w tablicy pod którym znaleziono przedział
		return ++wynik;
	}
	
	/**
	 * Metoda wykonująca zadanie strategią "Dziel i zwyciężaj"
	 */
	public void wykonaj() {
		System.out.println("Dane wejściowe:");
		System.out.println("\tLiczba = " + liczba);
		System.out.println("\tPrzedziały = " + Arrays.toString(przedziały));
		System.out.println("Wynik: " + dziel(0, przedziały.length));
	}

}
