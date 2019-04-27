import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Giris {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Giris window = new Giris();
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
	public Giris() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 653, 526);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnKullancGirili = new JButton("Kullan\u0131c\u0131 Giri\u015Fli");
		btnKullancGirili.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KullaniciGirisi n = new KullaniciGirisi();
				frame.setVisible(false);
			}
		});
		btnKullancGirili.setBounds(71, 134, 188, 181);
		frame.getContentPane().add(btnKullancGirili);
		
		JButton btnRastgeleMatris = new JButton("Rastgele Matris");
		btnRastgeleMatris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rasgeleMatris rastfrm = new rasgeleMatris(0);
				frame.setVisible(false);
				
			}
		});
		btnRastgeleMatris.setBounds(318, 134, 188, 181);
		frame.getContentPane().add(btnRastgeleMatris);
	}
}
