package forms;
import javax.swing.JFrame;
import javax.swing.JTextField;

import classes.PogodiRec;
import enums.Stanje;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmMain {

	public JFrame frame;
	private JTextField unosReci;
	private JLabel brGresaka;
	private JButton btnUnesi;
	private JLabel stanjePogadjanja;
	//protected String unetaRec;
	protected PogodiRec rec;
	private JLabel lblBrojSlova;
	private JLabel lblBrojSlovaVrednost;
	private JLabel brBodova;
	



	/**
	 * Create the application.
	 */
	public frmMain() {
		initialize();
		this.rec = new PogodiRec();
		this.lblBrojSlovaVrednost.setText(String.valueOf(this.rec.getBrSlova()));
		
		JLabel lblBrojBodova = new JLabel("Broj bodova:");
		lblBrojBodova.setBounds(32, 194, 75, 14);
		frame.getContentPane().add(lblBrojBodova);
		
		brBodova = new JLabel("");
		brBodova.setBounds(144, 194, 46, 14);
		frame.getContentPane().add(brBodova);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		unosReci = new JTextField();
		unosReci.setBounds(32, 43, 86, 20);
		frame.getContentPane().add(unosReci);
		unosReci.setColumns(10);
		
		JLabel lblUnesiteRec = new JLabel("Unesite rec:");
		lblUnesiteRec.setBounds(43, 18, 75, 14);
		frame.getContentPane().add(lblUnesiteRec);
		
		btnUnesi = new JButton("Unesi");
		btnUnesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rec.Validacija(unosReci.getText());
				
				brGresaka.setText(String.valueOf(rec.getBrTrenutnihGreski()));
				stanjePogadjanja.setText(String.valueOf(rec.getStanje()));
				brBodova.setText(String.valueOf(rec.getBrBodova()));
				
				if(rec.is_terminirajProgram()){
					
					//trazenaRec.setText(rec.getTrazenaRec());
				 JOptionPane.showMessageDialog(null, rec.getTrazenaRec(), "Trazena rec je:", JOptionPane.INFORMATION_MESSAGE);
				 System.exit(0);
					
				}
				
				if(rec.getStanje()==Stanje.sPogodjena){
					JOptionPane.showMessageDialog(null, "Trazena rec je: " + rec.getTrazenaRec(), "Pogodili ste trazenu rec!" , JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
				
				
			}
		});
		btnUnesi.setBounds(157, 42, 89, 23);
		frame.getContentPane().add(btnUnesi);
		
		JLabel lblRezultat = new JLabel("Rezultat:");
		lblRezultat.setBounds(32, 161, 46, 14);
		frame.getContentPane().add(lblRezultat);
		
		JLabel lblBrojGresaka = new JLabel("Broj gresaka:");
		lblBrojGresaka.setBounds(32, 128, 75, 14);
		frame.getContentPane().add(lblBrojGresaka);
		
		brGresaka = new JLabel("");
		brGresaka.setBounds(144, 128, 46, 14);
		frame.getContentPane().add(brGresaka);
		
		stanjePogadjanja = new JLabel("");
		stanjePogadjanja.setBounds(144, 161, 89, 14);
		frame.getContentPane().add(stanjePogadjanja);
		
		lblBrojSlova = new JLabel("Broj slova:");
		lblBrojSlova.setBounds(32, 103, 59, 14);
		frame.getContentPane().add(lblBrojSlova);
		
		lblBrojSlovaVrednost = new JLabel("");
		lblBrojSlovaVrednost.setBounds(157, 103, 46, 14);
		frame.getContentPane().add(lblBrojSlovaVrednost);
	}
}
