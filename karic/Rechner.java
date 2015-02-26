package karic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JToggleButton;

import java.awt.FlowLayout;
import java.math.BigDecimal;

/**
 * View Klasse des Rechners (vom WindowBuilder erzeugt)
 * @author Adin Karic
 * @version 2015-02-06
 */
public class Rechner {
	//Attribute
	private JFrame frmFdfg;
	private JTextField textField;
	private RModel m;
	private RController c;



	/**
	 * Create the application.
	 * @param c eine Controllerinstanz
	 * @param m eine Modelinstanz
	 */
	public Rechner(RController c,RModel m) {
		this.m = m;
		this.c = c;
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Vom WindowBuilder generierte GUI Elemente
		frmFdfg = new JFrame();


		JPanel panel = new JPanel();
		frmFdfg.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(4, 3, 0, 0));

		JButton btnNewButton = new JButton("7");
		btnNewButton.addActionListener(this.c);
		panel_1.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("8");
		btnNewButton_2.addActionListener(this.c);
		panel_1.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("9");
		btnNewButton_3.addActionListener(this.c);
		panel_1.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("4");
		btnNewButton_4.addActionListener(this.c);
		panel_1.add(btnNewButton_4);

		JButton btnNewButton_6 = new JButton("5");
		btnNewButton_6.addActionListener(this.c);
		panel_1.add(btnNewButton_6);

		JButton btnNewButton_1 = new JButton("6");
		btnNewButton_1.addActionListener(this.c);
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_9 = new JButton("1");
		btnNewButton_9.addActionListener(this.c);
		panel_1.add(btnNewButton_9);

		JButton btnNewButton_5 = new JButton("2");
		btnNewButton_5.addActionListener(this.c);
		panel_1.add(btnNewButton_5);

		JButton btnNewButton_8 = new JButton("3");
		btnNewButton_8.addActionListener(this.c);
		panel_1.add(btnNewButton_8);

		JButton btnNewButton_7 = new JButton("0");
		btnNewButton_7.addActionListener(this.c);
		panel_1.add(btnNewButton_7);

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(2, 1, 0, 0));

		JButton btnNewButton_16 = new JButton(".");
		btnNewButton_16.addActionListener(this.c);
		panel_4.add(btnNewButton_16);

		JButton btnNewButton_15 = new JButton("(-)");
		btnNewButton_15.addActionListener(this.c);
		panel_4.add(btnNewButton_15);

		JButton button = new JButton("=");
		button.addActionListener(this.c);
		panel_1.add(button);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new GridLayout(4, 1, 0, 0));

		JButton btnNewButton_11 = new JButton("/");
		btnNewButton_11.addActionListener(this.c);
		panel_2.add(btnNewButton_11);

		JButton btnNewButton_12 = new JButton("X");
		btnNewButton_12.addActionListener(this.c);
		panel_2.add(btnNewButton_12);

		JButton btnNewButton_13 = new JButton("-");
		btnNewButton_13.addActionListener(this.c);
		panel_2.add(btnNewButton_13);

		JButton btnNewButton_14 = new JButton("+");
		btnNewButton_14.addActionListener(this.c);

		panel_2.add(btnNewButton_14);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		textField = new JTextField();
		textField.setEditable(false);
		panel_3.add(textField);
		textField.setColumns(24);

		JButton btnC = new JButton("C");
		btnC.addActionListener(this.c);
		panel_3.add(btnC);
		frmFdfg.setTitle("SEW macht Spa\u00DF");
		frmFdfg.setBackground(new Color(255, 204, 153));
		frmFdfg.setBounds(100, 100, 353, 324);
		frmFdfg.setVisible(true);
		frmFdfg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * Methode zum Hinzufuegen von Zahlen (dem Display)
	 * @param s die Zahl als String
	 */
	public void addText(String s){
		this.textField.setText(this.textField.getText()+s);
	}
	/**
	 * Methode zum Berechnen
	 * @param s der Operand
	 */
	public void calc(String s){
		try{
			//rechne Methode vom Model wird aufgerufen
			m.rechne(new BigDecimal(textField.getText()),s);

			textField.setText("");
		}catch(Exception e){
			System.err.println("Fehler ist aufgetreten! Uberpruefen Sie Ihre Eingabe!");
			this.erase();
		}
	}
	/**
	 * Methode zum Erhalten des Ergebnisses
	 */
	public void getE(){
		String erg = m.getErg(textField.getText()).toString();
		this.textField.setText(erg);
	}
	/**
	 * Methode zum Loeschen des Speichers
	 */
	public void erase(){
		m.setZ();
		textField.setText("");
	}
	/**
	 * Methode fuer ein negatives Vorzeichen
	 */
	public void neg(){
		try{
			if(textField.getText().charAt(0)!='-'){
				textField.setText("-"+textField.getText());
			}else{
				textField.setText(textField.getText().replaceAll("-",""));
			}
		}catch(Exception e){
			System.err.println("Fehler ist aufgetreten! Uberpruefen Sie Ihre Eingabe!");
		}
	}
}
