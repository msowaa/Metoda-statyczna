public class Podciągi {
	
	private final char[] s1, s2;
	private final int m, n;
	
	/**
	 * Konstruktor przyjmujący dane wejściowe zadania z możliwością włączenia/wyłączenia debugowania
	 * @param s1
	 * @param s2
	 * @param DEBUG
	 */
	public Podciągi(String s1, String s2) {
		// konwertujemy na tablice znaków
		this.s1 = s1.toCharArray();
		this.s2 = s2.toCharArray();
		// wyznaczamy długości ciągów
		m = s1.length();
		n = s2.length();
	}
	
	/**
	 * Metoda wykonująca zadanie w oparciu o programowanie dynamiczne
	 */
	public void wykonaj() {
		
		System.out.println("Dane wejściowe:");
		System.out.println("\tA = " + new String(s1));
		System.out.println("\tB = " + new String(s2));
		
		int[][] L = new int[m+1][n+1];
		
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (s1[i] == s2[j])
					L[i + 1][j + 1] = 1 + L[i][j];
				else
					L[i + 1][j + 1] = L[i+1][j] < L[i][j + 1] ? L[i][j + 1] : L[i+1][j];
					
		int i = m - 1;
		int j = n - 1;
		
		// bufor na którym będziemy zapisywać wspólne znaki
		StringBuffer buffer = new StringBuffer();
		
		// szukamy wspólnych znaków iterując po odpowiednich komórkach tablic
		 while((i >= 0) && (j >= 0)) {
			 if (s1[i] == s2[j]) {
				 buffer.append(s1[i]);
				 i--;
				 j--;
			 }
			 else if(L[i + 1][j] > L[i][j + 1]) j--;
			 else i--;
		 }
		 
		 // odwracamy zapisany na buforze ciąg znaków, gdyż iterowaliśmy od końca do początku
		 buffer.reverse();
		 
		 System.out.println("Maksymalna długość podciągu: " + L[m][n]);
		 System.out.println("Podciąg: " + buffer.toString());
	}
	
}
