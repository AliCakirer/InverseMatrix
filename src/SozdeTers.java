import java.util.Iterator;

public class SozdeTers {

	public static int m, n;
	public static int[][] EkMatris;
	public static double[][] ters;
	public static double[][] matris;
	public static double[][] transpoz;
	public static double[][] matrisxTranspoz;
	public static double[][] matrisxTranspoz_kopya;
	public static boolean sol_sag;
	static String matrisxTranspoz_icerigi = "";
	public static double[][] matrisxTranspoz_tersi;
	public static int carpimSayisi=0,toplamSayisi=0;
	

	public static double determinant(double A[][], int N) {
		double det = 0;
		if (N == 1) {
			det = A[0][0];
		} else if (N == 2) {
			det = A[0][0] * A[1][1] - A[1][0] * A[0][1];
		} else {
			det = 0;
			for (int j1 = 0; j1 < N; j1++) {
				double[][] m = new double[N - 1][];
				for (int k = 0; k < (N - 1); k++) {
					m[k] = new double[N - 1];
				}
				for (int i = 1; i < N; i++) {
					int j2 = 0;
					for (int j = 0; j < N; j++) {
						if (j == j1)
							continue;
						m[i - 1][j2] = A[i][j];
						j2++;
					}
				}
				det += Math.pow(-1.0, 1.0 + j1 + 1.0) * A[0][j1] * determinant(m, N - 1);
			}
		}
		return det;
	}

	public static void tersiniAl(double A[][], int satirsut) { // Gonderdigimiz 2. parametre matrisxtranspozun satir
																// sutun sayisi
		double[][] birim = new double[satirsut][satirsut];
		double[][] tersiAlincak = new double[satirsut][satirsut];
		tersiAlincak = A;
		for (int i = 0; i < satirsut; i++) {
			for (int j = 0; j < satirsut; j++) {
				if (i == j) {
					birim[i][j] = 1;
				} else {
					birim[i][j] = 0;
				}
			}
		}
		double d, k;
		int carpim_Sayisi;
		for (int i = 0; i < satirsut; i++) {
			d = tersiAlincak[i][i];
			for (int j = 0; j < satirsut; j++) {
				tersiAlincak[i][j] = tersiAlincak[i][j] / d;
				birim[i][j] = birim[i][j] / d;
				carpimSayisi++;
				carpimSayisi++;
			}
			for (int x = 0; x < satirsut; x++) {
				if (x != i) {
					k = tersiAlincak[x][i];
					for (int j = 0; j < satirsut; j++) {
						tersiAlincak[x][j] = tersiAlincak[x][j] - (tersiAlincak[i][j] * k);
						birim[x][j] = birim[x][j] - (birim[i][j] * k);
						carpimSayisi++;
						toplamSayisi++; toplamSayisi++;

					}
				}
			}
		}

		matrisxTranspoz_tersi = birim;

		if (sol_sag == true) {
			ters = new double[n][m];
			for (int i = 0; i < n; i++) {
				for (int z = 0; z < m; z++) {
					for (int j = 0; j < m; j++) {
						ters[i][z] += transpoz[i][j] * birim[j][z];
						carpimSayisi++; toplamSayisi++;
					}
				}
			}
		} else {
			ters = new double[n][m];
			for (int i = 0; i < n; i++) {
				for (int z = 0; z < m; z++) {
					for (int j = 0; j < n; j++) {
						ters[i][z] += birim[i][j] * transpoz[j][z];
						carpimSayisi++; toplamSayisi++;
					}
				}
			}
		}

		System.out.println("Matrisin tersi: ");
		System.out.println();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(ters[i][j] + " ");
			}
			System.out.println("\n");
		}

	}

	public static void Calistir() {
		toplamSayisi=0;
		carpimSayisi=0;
		System.out.println("m:" + m + " n:" + n);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matris[i][j] + " ");
			}
			System.out.println("\n");
		}
		System.out.println();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(transpoz[i][j] + " ");
			}
			System.out.println("\n");
		}

		matrisxTranspoz = new double[m][m];
		matrisxTranspoz_kopya = new double[m][m];
		for (int i = 0; i < m; i++) {
			for (int k = 0; k < m; k++) {
				for (int j = 0; j < n; j++) {
					matrisxTranspoz[i][k] += matris[i][j] * transpoz[j][k];
					carpimSayisi++;
					toplamSayisi++;
				}
			}
		}

		sol_sag = true;
		System.out.println();
		System.out.println(determinant(matrisxTranspoz, m));
		if (determinant(matrisxTranspoz, m) == 0.0) {
			matrisxTranspoz = new double[n][n];
			matrisxTranspoz_kopya = new double[n][n];
			for (int i = 0; i < n; i++) {
				for (int k = 0; k < n; k++) {
					for (int j = 0; j < m; j++) {
						matrisxTranspoz[i][k] += transpoz[i][j] * matris[j][k];
						carpimSayisi++;
						toplamSayisi++;
					}
				}
			}
			sol_sag = false;
		}

		System.out.println(matrisxTranspoz.length + " " + matrisxTranspoz[0].length);

		System.out.println();

		matrisxTranspoz_icerigi="";
		for (int i = 0; i < matrisxTranspoz[0].length; i++) {
			for (int j = 0; j < matrisxTranspoz[0].length; j++) {
				matrisxTranspoz_icerigi += matrisxTranspoz[i][j] + "       ";
				System.out.print(matrisxTranspoz[i][j]+"     ");
			}
			matrisxTranspoz_icerigi = matrisxTranspoz_icerigi + "\n\n";
			System.out.println();
		}
		
		if (sol_sag == true) {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < m; j++) {
					System.out.print(matrisxTranspoz[i][j] + " ");
				}
				System.out.println("\n");
			}
		} else {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(matrisxTranspoz[i][j] + " ");
				}
				System.out.println("\n");
			}
		}
		System.out.println();

		// System.out.println(determinant(matrisxTranspoz, m));

		if (sol_sag == true) {
			tersiniAl(matrisxTranspoz, m);

		} else {
			tersiniAl(matrisxTranspoz, n);

		}

	}

}
