package princ;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vista extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
int cont;
	public Vista() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel opts = new JPanel();
		getContentPane().add(opts, BorderLayout.SOUTH);
		
		JButton btnBomba = new JButton("Bomba");
		btnBomba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.getControlador().pasarAcción(1);
			}
		});
		opts.add(btnBomba);
		
		
		//===================================================
		
		
		JPanel centro = new JPanel();
		getContentPane().add(centro, BorderLayout.CENTER);
		centro.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel gridIzq = new JPanel();
		centro.add(gridIzq);
		gridIzq.setLayout(new GridLayout(5, 5, 2, 0));
		
		JPanel gridDer = new JPanel();
		centro.add(gridDer);
		gridDer.setLayout(new GridLayout(5, 5, 0, 0));
		
		for (int i=0;i<25;i++) {
			cont = i;
			JLabel lblA = new JLabel("aaaaaaaaaa");
			gridDer.add(lblA);
			lblA.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Controlador.getControlador().pasarCoords(cont);
				}
			});
		}
		
		for (int i=0;i<25;i++) {
			JLabel lblA = new JLabel("aaaaaaaaaa");
			gridIzq.add(lblA);
		}

	}

}
