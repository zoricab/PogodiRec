package forms;


import javax.swing.JFrame;

import classes.PogodiRec;
import enumerations.StanjePogadjanja;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmMain {

	public JFrame frame;
	protected PogodiRec _pogodiRec;
	protected JLabel lblBrojSlovaVrednost = new JLabel("[0]");
	private final JLabel lblUnesiRec = new JLabel("Unesi rec :");
	private JTextField textFieldUnetaRec;
	private final JLabel lblBrojGreski = new JLabel("Broj Greski :");
	private final JLabel lblBrojGreskiVrednost = new JLabel("[0]");
	private final JLabel lblStatus = new JLabel("Status :");
	private final JLabel lblStatusVrednost = new JLabel("[0]");
	private final JLabel lbBrojBodovaVrednost = new JLabel("[0]");


	/**
	 * Create the application.
	 */
	public frmMain() {
		initialize();
		
		this._pogodiRec = new PogodiRec();
		this.lblBrojSlovaVrednost.setText(String.valueOf(this._pogodiRec.get_brojSlova()));
		this.lbBrojBodovaVrednost.setText(String.valueOf(this._pogodiRec.get_trenutniBrojBodova()));
		lblUnesiRec.setBounds(22, 46, 69, 14);
		
		frame.getContentPane().add(lblUnesiRec);
		
		textFieldUnetaRec = new JTextField();
		textFieldUnetaRec.setBounds(98, 43, 86, 20);
		frame.getContentPane().add(textFieldUnetaRec);
		textFieldUnetaRec.setColumns(10);
		
		JButton btnUnesiRec = new JButton("Unesi rec");
		btnUnesiRec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				_pogodiRec.Validacija(textFieldUnetaRec.getText());
				lblBrojGreskiVrednost.setText(String.valueOf(_pogodiRec.get_brojTrenutnihGreski()));
				lblStatusVrednost.setText(String.valueOf(_pogodiRec.get_stanjePogadjanja()));
				lbBrojBodovaVrednost.setText(String.valueOf(_pogodiRec.get_trenutniBrojBodova()));
				
				if (_pogodiRec.is_terminirajProgram())
				{
					JOptionPane.showMessageDialog(null, _pogodiRec.get_trazenaRec(), "Trazena rec je: " , JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
				
				if (_pogodiRec.get_stanjePogadjanja()==StanjePogadjanja.sPogodjena)
				{
					JOptionPane.showMessageDialog(null, "Trazena rec je: " +_pogodiRec.get_trazenaRec(), "Pogodili ste trazenu rec!" , JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
				
				
				
			}
		});
		btnUnesiRec.setBounds(197, 42, 89, 23);
		frame.getContentPane().add(btnUnesiRec);
		lblBrojGreski.setBounds(22, 83, 69, 14);
		
		frame.getContentPane().add(lblBrojGreski);
		lblBrojGreskiVrednost.setBounds(101, 83, 46, 14);
		
		frame.getContentPane().add(lblBrojGreskiVrednost);
		lblStatus.setBounds(22, 110, 69, 14);
		
		frame.getContentPane().add(lblStatus);
		lblStatusVrednost.setBounds(101, 110, 46, 14);
		
		frame.getContentPane().add(lblStatusVrednost);
		
		JLabel lblBrojBodova = new JLabel("Broj Bodova :");
		lblBrojBodova.setBounds(22, 145, 69, 14);
		frame.getContentPane().add(lblBrojBodova);
		
		
		lbBrojBodovaVrednost.setBounds(101, 145, 46, 14);
		frame.getContentPane().add(lbBrojBodovaVrednost);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 451, 432);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBrojSlova = new JLabel("Broj Slova: ");
		lblBrojSlova.setBounds(22, 21, 69, 14);
		frame.getContentPane().add(lblBrojSlova);
		
		
		lblBrojSlovaVrednost.setBounds(101, 21, 46, 14);
		frame.getContentPane().add(lblBrojSlovaVrednost);
	}
}
