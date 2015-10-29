package zadania;

public class Zadania {
	
	private static enum zadania {
		ZADANIE2, ZADANIE5, ZADANIE6
	}
	
	/**
	 * Metoda statyczna uruchamiaj�ca rozwi�zanie dla przekazanego przez parametr zadania
	 * @param zadanie
	 */
	private static void uruchom(zadania zadanie) {
		// wy�wietlamy informacj� kt�re zadanie jest wykonywane
		System.out.println("---" + zadanie + "---");
		
		// sprawdzamy przekazany parametr
		switch (zadanie) {
			case ZADANIE2:
				{
					// dane wej�ciowe dla zadania 2
					String[] przedzia�y = { "10,14", "16,22", "30,60", "70,90", "95,105", "110,116", "130,140", "160,210", "220,240" };
					// String[] przedzia�y = { "10,14", "16,22", "30,60", "110,116", "130,140" };
					
					new Przedzia�y(przedzia�y, 160.8).wykonaj(); // szukamy przedzia�u dla liczby
					new Przedzia�y(przedzia�y, 30.3).wykonaj(); // jw.
					new Przedzia�y(przedzia�y, 64.9).wykonaj();
					new Przedzia�y(przedzia�y, -10.2).wykonaj();
					new Przedzia�y(przedzia�y, 18.5).wykonaj();
					new Przedzia�y(przedzia�y, 341.1).wykonaj();
				}
			break;
			case ZADANIE5:
				{
					// dane wej�ciowe dla zadania 3
					String s1 = "Politechnika";
					String s2 = "toaleta";
					
					new Podci�gi(s1, s2).wykonaj();
					new Podci�gi("mas�o", "s�oma").wykonaj();
					new Podci�gi("petarda", "gepard").wykonaj();
				}
			break;
			case ZADANIE6:
				{
					String[] f1 = { "9, 11", "8, 12", "11, 13", "10, 12", "11, 15", "12, 16", "14, 17", "16, 18", "15, 19", "18, 21", "19, 21" };
					new Filmy(f1).wykonaj();
					
					String[] f2 = { "7, 10", "8, 9", "11, 14", "16, 18", "15, 19", "20, 21", "19, 21", "21, 22" };
					new Filmy(f2).wykonaj();
				}
			break;
		}
		// stosowna informacja
		System.out.println("---KONIEC---" + "\n");
	}

	public static void main(String[] args) {
		uruchom(zadania.ZADANIE2);
		uruchom(zadania.ZADANIE5);
		uruchom(zadania.ZADANIE6);
	}

}
