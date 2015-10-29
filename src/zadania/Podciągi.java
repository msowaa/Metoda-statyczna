package zadania;

public class Podci�gi {
	
	private final char[] s1, s2;
	private final int m, n;
	
	/**
	 * Konstruktor przyjmuj�cy dane wej�ciowe zadania z mo�liwo�ci� w��czenia/wy��czenia debugowania
	 * @param s1
	 * @param s2
	 * @param DEBUG
	 */
	public Podci�gi(String s1, String s2) {
		// konwertujemy na tablice znak�w
		this.s1 = s1.toCharArray();
		this.s2 = s2.toCharArray();
		// wyznaczamy d�ugo�ci ci�g�w
		m = s1.length();
		n = s2.length();
	}
	
	/**
	 * Metoda wykonuj�ca zadanie w oparciu o programowanie dynamiczne
	 */
	public void wykonaj() {
		
		System.out.println("Dane wej�ciowe:");
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
		
		// bufor na kt�rym b�dziemy zapisywa� wsp�lne znaki
		StringBuffer buffer = new StringBuffer();
		
		// szukamy wsp�lnych znak�w iteruj�c po odpowiednich kom�rkach tablic
		 while((i >= 0) && (j >= 0)) {
			 if (s1[i] == s2[j]) {
				 buffer.append(s1[i]);
				 i--;
				 j--;
			 }
			 else if(L[i + 1][j] > L[i][j + 1]) j--;
			 else i--;
		 }
		 
		 // odwracamy zapisany na buforze ci�g znak�w, gdy� iterowali�my od ko�ca do pocz�tku
		 buffer.reverse();
		 
		 System.out.println("Maksymalna d�ugo�� podci�gu: " + L[m][n]);
		 System.out.println("Podci�g: " + buffer.toString());
	}
	
}
