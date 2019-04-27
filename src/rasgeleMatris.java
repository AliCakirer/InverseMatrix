import java.awt.EventQueue;
import java.io.Console;
import java.text.DecimalFormat;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.SystemColor;

public class rasgeleMatris {

	public JFrame frame;
	public JTextPane textPaneMatris;
	static int satir, sutun;
	public static double[][] matrix; // Uzerinde islem yapabilecegimiz global matrisimiz
	public static double[][] transpozMatrix; // Global matrixin transpozu.
	static String Matris_icerigi = "";
	static String transpoz_icerigi = "";
	public static double[][] matrisxTranspoz;
	public static double[][] matrisxTranspoz_tersi;
	public static double[][] ters;
	static String matrisxTranspoz_icerigi = "";
	static String ters_icerigi = "";
	static String matrisxTranspoz_tersi_icerigi = "";
	public static int carpimsayisi=0,toplamsayisi=0;
	private JTextField textFieldToplam;
	private JTextField textFieldCarpim;

	public void matrisOlustur() {
		Matris_icerigi = "";
		transpoz_icerigi = "";
		matrisxTranspoz_icerigi="";
		ters_icerigi="";
		matrisxTranspoz_tersi_icerigi="";
		int m, n;
		Random r = new Random();

		m = r.nextInt(5) + 1; // 0 gelmemesi için +1 dedik.

		while (true) {
			n = r.nextInt(5) + 1; // 0 gelmemesi için +1 dedik.
			if (n != m) {
				break;
			}
		}
		System.out.println();
		System.out.println(m + " " + n);
		System.out.println();

		satir = m;
		sutun = n;

		double[][] matris = new double[m][n];
		double[][] tmptranspoz = new double[n][m];

		Random r2 = new Random();
		DecimalFormat df = new DecimalFormat("#.#");
		// Dizi Oldugu icin i her zaman 1 düþük yap ilerde m ye.
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				double tmp;
				tmp= r2.nextDouble()*10;
				if (tmp<1) {
					tmp=tmp+1;
				}
				String s = ""; 
				s=	df.format(tmp);
				s=s.replace(',', '.');
				tmp = Double.valueOf(s);
				
				matris[i][j]=tmp;
				
				//matris[i][j] = r2.nextInt(9) + 1;
				System.out.print(matris[i][j] + " ");
				Matris_icerigi += String.format("%.1f",matris[i][j] ) + "       ";
				tmptranspoz[j][i] = matris[i][j];

			}
			System.out.println();
			Matris_icerigi = Matris_icerigi + "\n\n";
		}
		matrix = matris;
		transpozMatrix = tmptranspoz;

		System.out.println();
		System.out.println();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(transpozMatrix[i][j] + " ");
				transpoz_icerigi += transpozMatrix[i][j] + "       ";
			}
			System.out.println("\n");
			transpoz_icerigi = transpoz_icerigi + "\n\n";
		}

	}

	/**
	 * 
	 * @wbp.parser.constructor
	 */

	public rasgeleMatris() {
		// matrisOlustur();
		initialize();
		// this.frame.setVisible(true);
	}

	public rasgeleMatris(int k) {
		if (k == 0) {
			matrisOlustur();
			initialize();
			this.frame.setVisible(true);
		} else {

		}

	}

	public void Calistir() {
		Matris_icerigi = "";
		transpoz_icerigi = "";
		for (int i = 0; i < satir; i++) {
			for (int j = 0; j < sutun; j++) {
				Matris_icerigi += matrix[i][j] + "       ";
			}
			Matris_icerigi = Matris_icerigi + "\n\n";
		}
		for (int i = 0; i < sutun; i++) {
			for (int j = 0; j < satir; j++) {
				transpoz_icerigi += transpozMatrix[i][j] + "       ";
				System.out.print(transpozMatrix[i][j] + "  ");
			}
			System.out.println("\n");
			transpoz_icerigi = transpoz_icerigi + "\n\n";
		}
		initialize();
		this.frame.setVisible(true);
	}

	public static void icerik_olustur() {
		System.out.println("Matrisxtranspoz:");
		/*for (int i = 0; i < matrisxTranspoz[0].length; i++) {
			for (int j = 0; j < matrisxTranspoz[0].length; j++) {
				matrisxTranspoz_icerigi += matrisxTranspoz[i][j] + "       ";
				System.out.print(matrisxTranspoz[i][j]+"     ");
			}
			matrisxTranspoz_icerigi = matrisxTranspoz_icerigi + "\n\n";
			System.out.println();
		}*/
		System.out.println("ok");

		for (int i = 0; i < matrisxTranspoz_tersi[0].length; i++) {
			for (int j = 0; j < matrisxTranspoz_tersi[0].length; j++) {
				matrisxTranspoz_tersi_icerigi += matrisxTranspoz_tersi[i][j] + "       ";
			}
			matrisxTranspoz_tersi_icerigi = matrisxTranspoz_tersi_icerigi + "\n\n";
		}

		for (int i = 0; i < sutun; i++) {
			for (int j = 0; j < satir; j++) {
				ters_icerigi += ters[i][j] + "       ";
			}
			ters_icerigi = ters_icerigi + "\n\n";
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		frame.setBounds(100, 100, 1657, 771);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblRastgeleOlusanMatris = new JLabel(
				"Rastgele Olu\u015Fan Matris \u0130\u00E7eri\u011Fi A\u015Fa\u011F\u0131daki gibidir. Yeni Matris Olu\u015Fturmak i\u00E7in t\u0131klay\u0131n  ==>");
		lblRastgeleOlusanMatris.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRastgeleOlusanMatris.setBounds(10, 21, 598, 33);
		frame.getContentPane().add(lblRastgeleOlusanMatris);

		JButton btnyeniMatris = new JButton("Yeni Matris");
		btnyeniMatris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carpimsayisi=0;
				toplamsayisi=0;
				frame.setVisible(false);
				new rasgeleMatris(0);

			}
		});
		btnyeniMatris.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnyeniMatris.setBounds(618, 29, 114, 25);
		frame.getContentPane().add(btnyeniMatris);

		textPaneMatris = new JTextPane();
		textPaneMatris.setBackground(SystemColor.control);
		textPaneMatris.setText(Matris_icerigi);
		textPaneMatris.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPaneMatris.setEditable(false);
		textPaneMatris.setBounds(10, 94, 306, 221);
		frame.getContentPane().add(textPaneMatris);

		JButton btnTersiniAl = new JButton("Tersini Al");
		btnTersiniAl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SozdeTers n = new SozdeTers();
				n.matris = matrix;
				n.transpoz = transpozMatrix;
				n.m = satir;
				n.n = sutun;
				n.Calistir();
				toplamsayisi = n.toplamSayisi;
				carpimsayisi = n.carpimSayisi;
				matrisxTranspoz_icerigi=n.matrisxTranspoz_icerigi;
				matrisxTranspoz = n.matrisxTranspoz_kopya;				
				ters = n.ters;
				matrisxTranspoz_tersi = n.matrisxTranspoz_tersi;

				icerik_olustur();

				JTextPane textPaneTranspoz = new JTextPane(); // Transpozu ekrana yazdirdigimiz alan
				textPaneTranspoz.setText(transpoz_icerigi);
				textPaneTranspoz.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textPaneTranspoz.setEditable(false);
				textPaneTranspoz.setBackground(SystemColor.menu);
				textPaneTranspoz.setBounds(326, 94, 296, 221);
				frame.getContentPane().add(textPaneTranspoz);

				JTextPane textPaneTers = new JTextPane();
				textPaneTers.setText(ters_icerigi);
				textPaneTers.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textPaneTers.setEditable(false);
				textPaneTers.setBackground(SystemColor.menu);
				textPaneTers.setBounds(618, 94, 912, 221);
				frame.getContentPane().add(textPaneTers);

				JTextPane textPaneCarpim = new JTextPane();
				textPaneCarpim.setText(matrisxTranspoz_icerigi);
				textPaneCarpim.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textPaneCarpim.setEditable(false);
				textPaneCarpim.setBackground(SystemColor.menu);
				textPaneCarpim.setBounds(10, 368, 306, 221);
				frame.getContentPane().add(textPaneCarpim);

				JTextPane textPaneCarpim_tersi = new JTextPane();
				textPaneCarpim_tersi.setText(matrisxTranspoz_tersi_icerigi);
				textPaneCarpim_tersi.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textPaneCarpim_tersi.setEditable(false);
				textPaneCarpim_tersi.setBackground(SystemColor.menu);
				textPaneCarpim_tersi.setBounds(350, 368, 893, 199);
				frame.getContentPane().add(textPaneCarpim_tersi);
				
				textFieldCarpim.setText(Integer.toString(carpimsayisi));
				textFieldToplam.setText(Integer.toString(toplamsayisi));

			}
		});
		btnTersiniAl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTersiniAl.setBounds(162, 53, 114, 25);
		frame.getContentPane().add(btnTersiniAl);

		JLabel lblMatrisimiz = new JLabel("Matrisimiz");
		lblMatrisimiz.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMatrisimiz.setBounds(20, 53, 102, 21);
		frame.getContentPane().add(lblMatrisimiz);

		JLabel lblTranspoz = new JLabel();
		lblTranspoz.setText("Transpoz");
		lblTranspoz.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTranspoz.setBounds(364, 55, 102, 21);
		frame.getContentPane().add(lblTranspoz);

		JLabel lblNewLabel = new JLabel("MatrisxTranspoz");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(20, 337, 139, 21);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblarpmlarnnTersi = new JLabel("\u00C7arp\u0131mlar\u0131n\u0131n Tersi");
		lblarpmlarnnTersi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblarpmlarnnTersi.setBounds(364, 338, 153, 19);
		frame.getContentPane().add(lblarpmlarnnTersi);

		JLabel lblSzdeTers = new JLabel("S\u00F6zde Ters");
		lblSzdeTers.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSzdeTers.setBounds(763, 55, 90, 21);
		frame.getContentPane().add(lblSzdeTers);
		
		JLabel lblToplamSays = new JLabel("Toplam Say\u0131s\u0131");
		lblToplamSays.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblToplamSays.setBounds(10, 679, 112, 25);
		frame.getContentPane().add(lblToplamSays);
		
		textFieldToplam = new JTextField();
		textFieldToplam.setBounds(132, 679, 96, 24);
		frame.getContentPane().add(textFieldToplam);
		textFieldToplam.setColumns(10);
		
		JLabel lblarpmSays = new JLabel("\u00C7arp\u0131m Say\u0131s\u0131");
		lblarpmSays.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblarpmSays.setBounds(282, 679, 112, 25);
		frame.getContentPane().add(lblarpmSays);
		
		textFieldCarpim = new JTextField();
		textFieldCarpim.setColumns(10);
		textFieldCarpim.setBounds(404, 679, 96, 24);
		frame.getContentPane().add(textFieldCarpim);

		/*
		 * JLabel lblicerik = new JLabel(Matris_icerigi); lblicerik.setBounds(20, 64,
		 * 295, 242); frame.getContentPane().add(lblicerik);
		 */
	}
}
