package adler;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;

/**
 * Das grafische Fenster für den Benutzer, welches einen Calculator darstellt
 * @author Philipp Adler
 * @version 2015-02-05
 */
public class CalcGUI {

	private JFrame frame;
	private JTextField textField;
	private CalcController c;

	/**
	 * Der Konstruktor welcher als Parameter den Listener für die GUI-Elemente enthaelt
	 * @param c der Listener für die GUI-Elemente
	 */
	public CalcGUI(CalcController c) {
		this.c = c;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		this.frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(4, 2));
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 3, 4, 4));
		
		JButton btnNewButton_1 = new JButton("7");
		btnNewButton_1.addActionListener(this.c);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("8");
		btnNewButton_3.addActionListener(this.c);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("9");
		btnNewButton_2.addActionListener(this.c);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_6 = new JButton("4");
		btnNewButton_6.addActionListener(this.c);
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_4 = new JButton("5");
		btnNewButton_4.addActionListener(this.c);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("6");
		btnNewButton_5.addActionListener(this.c);
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_9 = new JButton("1");
		btnNewButton_9.addActionListener(this.c);
		panel_1.add(btnNewButton_9);
		
		JButton btnNewButton_7 = new JButton("2");
		btnNewButton_7.addActionListener(this.c);
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("3");
		btnNewButton_8.addActionListener(this.c);
		panel_1.add(btnNewButton_8);
		
		JButton btnNewButton_14 = new JButton("0");
		btnNewButton_14.addActionListener(this.c);
		panel_1.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton(".");
		btnNewButton_15.addActionListener(this.c);
		panel_1.add(btnNewButton_15);
		
		JButton btnC = new JButton("reset");
		btnC.addActionListener(this.c);
		panel_1.add(btnC);
		
		textField = new JTextField();
		textField.setEditable(false);
		frame.getContentPane().add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.EAST);
		panel.setLayout(new GridLayout(5, 0, 0, 0));
		
		JButton btnNewButton = new JButton("/");
		btnNewButton.addActionListener(this.c);
		btnNewButton.setActionCommand("operator");
		panel.add(btnNewButton);
		
		JButton btnNewButton_10 = new JButton("x");
		btnNewButton_10.addActionListener(this.c);
		btnNewButton_10.setActionCommand("operator");
		panel.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("-");
		btnNewButton_11.addActionListener(this.c);
		btnNewButton_11.setActionCommand("operator");
		panel.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("+");
		btnNewButton_12.addActionListener(this.c);
		btnNewButton_12.setActionCommand("operator");
		panel.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("=");
		btnNewButton_13.addActionListener(this.c);
		panel.add(btnNewButton_13);
	}

	/**
	 * Diese Methode gibt den Inhalt des Textfelds aus
	 * @return den Inhalt des Textfelds
	 */
	public String getTextField() {
		return textField.getText();
	}

	/**
	 * Diese Methode aendert den Inhalt des Textfelds
	 * @param textField der neue Inhalt des Textfelds
	 */
	public void setTextField(String textField) {
		this.textField.setText(textField);
	}
}
