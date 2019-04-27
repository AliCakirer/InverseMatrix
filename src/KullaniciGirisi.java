import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class KullaniciGirisi {
	
	public static int m,n;
	private JFrame frame;
	private JTable table;
	private JTextField txtSatir;
	private JTextField txtSutun;
	DefaultTableModel modelim = new DefaultTableModel();
	public static double[][] matris;
	public static int sat,sut;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KullaniciGirisi window = new KullaniciGirisi();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public KullaniciGirisi() {
		initialize();
		this.frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 280, 231);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 244, 107);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBounds(483, 277, 327, 206);
		scrollPane.setViewportView(table);
		
		JLabel lblSatir = new JLabel("Satir");
		lblSatir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSatir.setBounds(10, 26, 54, 13);
		frame.getContentPane().add(lblSatir);
		
		txtSatir = new JTextField();
		txtSatir.setBounds(74, 24, 46, 19);
		frame.getContentPane().add(txtSatir);
		txtSatir.setColumns(10);
		
		JLabel lblSutun = new JLabel("Sutun");
		lblSutun.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSutun.setBounds(149, 26, 54, 13);
		frame.getContentPane().add(lblSutun);
		
		txtSutun = new JTextField();
		txtSutun.setColumns(10);
		txtSutun.setBounds(194, 24, 46, 19);
		frame.getContentPane().add(txtSutun);
		
		JButton btnOlutur = new JButton("Olu\u015Ftur");
		btnOlutur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sat = Integer.parseInt(txtSatir.getText());
				sut = Integer.parseInt(txtSutun.getText());
				
				modelim.setRowCount(sat);
				modelim.setColumnCount(sut);
				table.setModel(modelim);
				
				
			}
		});
		btnOlutur.setBounds(149, 166, 102, 21);
		frame.getContentPane().add(btnOlutur);
		
		JButton btnNewButton = new JButton("Tersini Al");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				matris = new double[sat][sut];
				for (int i = 0; i < sat; i++) {
					for (int j = 0; j < sut; j++) {
						matris[i][j]=Double.parseDouble(modelim.getValueAt(i,j).toString());
					}
				}
				for (int i = 0; i < sat; i++) { //Kullanýcýnýn girdigi matrisi consola yazdýrma
					for (int j = 0; j < sut; j++) {
						System.out.print(matris[i][j] + " ");
					}
					System.out.println("\n");
				}
				double[][] transpozMatrix = new double[sut][sat];
				System.out.println("transpozu: "+"\n");
				for (int i = 0; i < sat; i++) {
					for (int j = 0; j < sut; j++) {
						transpozMatrix[j][i]=matris[i][j];
					}
				}
				
				for (int i = 0; i < sut; i++) {
					for (int j = 0; j < sat; j++) {
						System.out.print(transpozMatrix[i][j]+"   ");
					}
					System.out.println();
				}
				
				rasgeleMatris n = new rasgeleMatris(1); //Elle girdiðimiz verileri yapýlan iþlemleri gösteren frame yönlendiriyoruz.
				n.matrix = matris;
				n.transpozMatrix = transpozMatrix;
				n.satir = sat;
				n.sutun = sut;
				n.Calistir();
				
			}
		});
		btnNewButton.setBounds(20, 166, 100, 21);
		frame.getContentPane().add(btnNewButton);
	}
}
