package HundirLaFlota;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import java.awt.GridBagLayout;

public class Vista extends JFrame implements Observer {

	private JPanel contentPane;
	private static Vista mVista;

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
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlCentro = new JPanel();
		contentPane.add(pnlCentro, BorderLayout.CENTER);
		pnlCentro.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel gridIzq = new JPanel();
		pnlCentro.add(gridIzq);
		gridIzq.setLayout(new GridLayout(10, 10, 0, 0));
		
		JPanel gridDer = new JPanel();
		pnlCentro.add(gridDer);
		gridDer.setLayout(new GridLayout(10, 10, 0, 0));
		
		JPanel pnlBajo = new JPanel();
		contentPane.add(pnlBajo, BorderLayout.SOUTH);
		
		JLabel lblMenu = new JLabel("Menu");
		pnlBajo.add(lblMenu);
	}
	
	public static Vista getVista() {
		if(mVista==null) {
			mVista=new Vista();
		}
		return (mVista);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
