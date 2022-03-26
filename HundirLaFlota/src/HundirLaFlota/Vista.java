package HundirLaFlota;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;

public class Vista extends JFrame implements Observer {

	private JPanel contentPane;
	private static Vista mVista;
	
	private JLabel[][] gDer;	//De la IA
	private JLabel[][] gIzq;	//Del usuario

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = Vista.getVista();
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
	
	private boolean turnoUsr;
	private int estado;
	
	private JPanel menuAcciones;
	private JPanel menuPonerBarcos;
	
	private JLabel lblBarcosusr;
	private JLabel lblBarcosia;
	
	public Vista() {
		this.estado = 0;
		
		this.gDer = new JLabel[10][10];
		this.gIzq = new JLabel[10][10];
		
		/// Creacion general
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		/// Creacion de paneles
		JPanel pnlCentro = new JPanel();
		contentPane.add(pnlCentro, BorderLayout.CENTER);
		pnlCentro.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel gridIzq = new JPanel();
		gridIzq.setBorder(new EmptyBorder(10, 10, 10, 10));
		pnlCentro.add(gridIzq);
		gridIzq.setLayout(new GridLayout(10, 10, 5, 5));
		
		
		JLabel aux;
		for (int i=0;i<10;i++) {
			for (int j=0;j<10;j++) {
				aux = new JLabel(j+""+i+"I");
				aux.setOpaque(true);
				this.cambiarColorCasilla(aux, Color.DARK_GRAY);
				aux.addMouseListener(Controlador.getControlador());
				gridIzq.add(aux);
				gIzq[j][i] = aux;
			}
		}
		
		JPanel gridDer = new JPanel();
		gridDer.setBorder(new EmptyBorder(10, 10, 10, 10));
		pnlCentro.add(gridDer);
		gridDer.setLayout(new GridLayout(10, 10, 5, 5));
		
		for (int i=0;i<10;i++) {
			for (int j=0;j<10;j++) {
				aux = new JLabel(j+""+i+"D");
				aux.setOpaque(true);
				this.cambiarColorCasilla(aux, Color.DARK_GRAY);
				aux.addMouseListener(Controlador.getControlador());
				gridDer.add(aux);
				gDer[j][i] = aux;
			}
		}
		
		JPanel pnlBajo = new JPanel();
		contentPane.add(pnlBajo, BorderLayout.SOUTH);
		pnlBajo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		menuAcciones = new JPanel();
		pnlBajo.add(menuAcciones);
		menuAcciones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		menuAcciones.hide();
		
		JButton btnBomba = new JButton("Bomba");
		menuAcciones.add(btnBomba);
		btnBomba.addActionListener(Controlador.getControlador());

		JButton btnMisil = new JButton("Misil");
		menuAcciones.add(btnMisil);
		btnMisil.addActionListener(Controlador.getControlador());

		menuPonerBarcos = new JPanel();
		pnlBajo.add(menuPonerBarcos);
		menuPonerBarcos.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel barcos = new JPanel();
		menuPonerBarcos.add(barcos);
		barcos.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnPortaviones = new JButton("Portaviones");
		barcos.add(btnPortaviones);
		btnPortaviones.addActionListener(Controlador.getControlador());
		
		JButton btnSubmarino = new JButton("Submarino");
		barcos.add(btnSubmarino);
		btnSubmarino.addActionListener(Controlador.getControlador());
		
		JButton btnDestructor = new JButton("Destructor");
		barcos.add(btnDestructor);
		btnDestructor.addActionListener(Controlador.getControlador());
		
		JButton btnFragata = new JButton("Fragata");
		barcos.add(btnFragata);
		btnFragata.addActionListener(Controlador.getControlador());
		
		JPanel direcciones = new JPanel();
		menuPonerBarcos.add(direcciones);
		
		JButton btnArriba = new JButton("Arriba");
		direcciones.add(btnArriba);
		btnArriba.addActionListener(Controlador.getControlador());
		
		JButton btnAbajo = new JButton("Abajo");
		direcciones.add(btnAbajo);
		btnAbajo.addActionListener(Controlador.getControlador());
		
		JButton btnDerecha = new JButton("Derecha");
		direcciones.add(btnDerecha);
		btnDerecha.addActionListener(Controlador.getControlador());
		
		JButton btnIzquierda = new JButton("Izquierda");
		direcciones.add(btnIzquierda);
		btnIzquierda.addActionListener(Controlador.getControlador());
		
		
		
		////###############################################################
		JPanel panel = new JPanel();
		pnlBajo.add(panel);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		lblBarcosusr = new JLabel("BarcosUsr:");
		panel.add(lblBarcosusr);
				
		lblBarcosia = new JLabel("BarcosIA:");
		panel.add(lblBarcosia);
		
		
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
		if (o instanceof Tile) {
			JLabel aux = this.buscarPanel(((Tile) o).getCoordX(),((Tile) o).getCoordY());
			if((Integer)arg==0) {
				if(o instanceof Agua)	this.cambiarColorCasilla(aux, Color.blue);
				else if(o instanceof TBarco)	this.cambiarColorCasilla(aux, Color.black);
			}else if ((Integer)arg==1) {
				this.cambiarColorCasilla(aux, Color.red);
			}			
		}else if (o instanceof Jugador) {
			String aux;
			if(((Integer)arg)==1) {
				aux="F";
			}else if(((Integer)arg)==2) {
				aux="D";
			}else if(((Integer)arg)==3) {
				aux="S";
			}else {
				aux="P";
			}
			JLabel union;
			if(o instanceof IA) {
				union = lblBarcosia;
			}else {
				union =lblBarcosusr;
			}
			union.setText(union.getText() +" "+ aux);
		}else if (o instanceof Modelo) {
			//Cambio de estado
			if(arg instanceof Integer) {
				this.menuPonerBarcos.setVisible(false);
				this.menuAcciones.setVisible(true);
				this.estado=(int) arg;
			}else {
				this.turnoUsr = (boolean) arg;
			}
		}
	}
	
	private JLabel buscarPanel(int x, int y) {
		JLabel[][] matriz;
		if(this.estado==0) {
			if(this.turnoUsr) matriz = this.gIzq;
			else matriz = this.gDer;
		}else /*if (estado==1)*/ {
			if(this.turnoUsr) matriz = this.gDer;
			else matriz = this.gIzq;
		}
		return matriz[x][y];
	}
	
	private void cambiarColorCasilla(JLabel jl, Color cl) {
		jl.setBackground(cl);
		jl.setForeground(cl);
	}
	
	public boolean getTurnoUsr() {
		return this.turnoUsr;
	}
	
	public void TESTOCUPADO(int x, int y) {
		gIzq[x][y].setBackground(Color.green);;
	}
}
