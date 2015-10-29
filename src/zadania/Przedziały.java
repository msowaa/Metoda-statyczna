package zadania;

import java.util.Arrays;

class Przedzia� {
	
	private final int pocz�tek, koniec;
	
	public Przedzia�(String przedzia�) {
		String data[] = przedzia�.split(",");
		pocz�tek = Integer.parseInt(data[0]);
		koniec = Integer.parseInt(data[1]);
	}
	
	public int getPocz�tek() {
		return pocz�tek;
	}
	
	public int getKoniec() {
		return koniec;
	}
	
	@Override
	public String toString() {
		return pocz�tek + "," + koniec;
		
	}
}

public class Przedzia�y {
	
	private final double liczba;
	private final Przedzia�[] przedzia�y;
	
	public Przedzia�[] getPrzedzia�y() {
		return przedzia�y;
	}
	
	public double getLiczba() {
		return liczba;
	}
	
	/**
	 * Konstruktor przyjmuj�cy dane wej�ciowe zadania
	 * @param przedzia�y
	 * @param liczba
	 */
	public Przedzia�y(String[] przedzia�y, double liczba) {
		// alokujemy pami��
		this.przedzia�y = new Przedzia�[przedzia�y.length];
		// tworzymy przedzia�y na podstawie danych wej�ciowych
		for (int i = 0; i < przedzia�y.length; i++)
			this.przedzia�y[i] = new Przedzia�(przedzia�y[i]);
		this.liczba = liczba;
	}
	
	private int sprawd�(int index) {
		Przedzia� p = przedzia�y[index];
		
//		System.err.println("Sprawdzana kom�rka: " + index);
//		System.err.println("Liczba: " + liczba);
//		System.err.println("Bie��cy przedzia�: " + p.toString());
		
		// je�li warunek spe�niony
		if (liczba >= p.getPocz�tek() && liczba <= p.getKoniec())
			return index;
		// je�li liczba jest mniejsza od warto�ci pocz�tkowej przedzia�u
		else if (liczba < p.getPocz�tek())
			return -1;
		// je�li liczba jest wi�ksza od warto�ci ko�cowej przedzia�u
		else if (liczba > p.getKoniec())
			return -2;
		// je�li przedzia� nie spe�nia �adnych warunk�w
		else
			return -3;
	}
	
	private int dziel(int startIndex, int endIndex) {
		
		// ilo�� element�w w tablicy
		int length = endIndex - startIndex;
		
//		System.err.println("Pocz�tek tablicy: " + startIndex);
//		System.err.println("Koniec tablicy: " + endIndex);

		int �r = (startIndex + endIndex) / 2;
		
		int wynik = sprawd�(�r);
		
//		System.err.println("Wynik dla bie��cego elementu: " + wynik);
		
		// je�li tablica posiada wi�cej element�w do sprawdzenia ni� 1
		if (length > 1) {
			// je�li liczba jest mniejsza od warto�ci pocz�tkowej przedzia�u
			if (wynik == -1)
				return dziel(startIndex, �r);
			// je�li liczba jest wi�ksza od warto�ci ko�cowej przedzia�u
			else if (wynik == -2)
				return dziel(�r, endIndex);
		}
		
		// je�li nie uda�o si� znale�� przedzia�u
		if (wynik < 0)
			return -1;
		
		// ++ bo wynik jest indeksem elementu w tablicy pod kt�rym znaleziono przedzia�
		return ++wynik;
	}
	
	/**
	 * Metoda wykonuj�ca zadanie strategi� "Dziel i zwyci�aj"
	 */
	public void wykonaj() {
		System.out.println("Dane wej�ciowe:");
		System.out.println("\tLiczba = " + liczba);
		System.out.println("\tPrzedzia�y = " + Arrays.toString(przedzia�y));
		System.out.println("Wynik: " + dziel(0, przedzia�y.length));
	}

}
