package adler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Diese Klasse uebernimmmt die Benutzereingabe und leitet sie an das Modell weiter
 * @author Philipp Adler
 * @version 2015-02-05
 */
public class CalcController implements ActionListener{
	private CalcModel m;
	private CalcGUI g;
	private boolean clear;//dafür dar das nach dem Ergebnis keine Zahl drangehängt werden kann

	/**
	 * Der Konstruktor erzeugt den Calculator, das Model welches alles berechnet und die GUI für den Benutzer
	 */
	public CalcController(){
		this.m = new CalcModel();
		this.g = new CalcGUI(this);
	}

	/**
	 * Der Listener kuemmert sich um die Benutzereingaben bzw. welchen Button er gedrückt hat
	 * @param e enthaelt Informationen über den gedrueckten Button
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if((((JButton)e.getSource()).getText().equals("="))){//wenn die Rechnung berechnet werden soll
			this.g.setTextField(this.m.calc(this.g.getTextField()));//gibt das Ergebnis aus
			this.clear = true;

		}else if(((JButton)e.getSource()).getText().equals("reset")){//wenn der Reset-Button gedrückt wurde
			this.g.setTextField("");

		}else if(((JButton)e.getSource()).getText().equals(".")){//
			this.g.setTextField(this.g.getTextField()+((JButton)e.getSource()).getText());
			//damit nicht 2x hintereinander .      //damit nicht nach Ergebnis .
			if((this.g.getTextField().charAt(0) == '.') ||
					(this.g.getTextField().charAt(this.g.getTextField().length()-2) == '.') ||
					(this.g.getTextField().charAt(this.g.getTextField().length()-2) == '+') ||
					(this.g.getTextField().charAt(this.g.getTextField().length()-2) == '-') ||
					(this.g.getTextField().charAt(this.g.getTextField().length()-2) == 'x') ||
					(this.g.getTextField().charAt(this.g.getTextField().length()-2) == '/') ||
					(this.g.getTextField().charAt(this.g.getTextField().length()-1) == '.' && this.clear)){
				this.g.setTextField(this.g.getTextField().substring(0, this.g.getTextField().length()-1));
			}
		}else{//wenn ein Operator oder eine Zahl eingegeben wird
			if(this.clear){//wenn nach dem Ergebnis eine Zahl eingegeben wird. Dann wird alles gelöscht
				this.g.setTextField(this.g.getTextField()+((JButton)e.getSource()).getText());
				String b = this.g.getTextField().substring(this.g.getTextField().length()-1);
				try{//überprüft ob es sich im eine Zahl handelt
					Double.parseDouble(b);
					this.g.setTextField("");
					this.g.setTextField(this.g.getTextField()+((JButton)e.getSource()).getText());
				}catch(java.lang.NumberFormatException f){
				}
				this.clear = false;


			}else if((((JButton)e.getSource()).getActionCommand().equals("operator"))){//wenn nach einen Operator ein Operator eingegeben wird
				boolean wert = true;
				try{//kontrolliert ob es sich um einen Operator handelt
					String b = this.g.getTextField().substring(this.g.getTextField().length()-1);
					Double.parseDouble(b);
				}catch(java.lang.NumberFormatException f){
					String text = "";
					text = this.g.getTextField().substring(0, this.g.getTextField().length()-1);
					this.g.setTextField(text+((JButton)e.getSource()).getText());
					wert = false;
				}catch(java.lang.StringIndexOutOfBoundsException f){//wenn man am Anfang einen Operator angibt
				}
				if(wert)this.g.setTextField(this.g.getTextField()+((JButton)e.getSource()).getText());
				if((this.g.getTextField().charAt(0) == '+') || (this.g.getTextField().charAt(0) == 'x') || (this.g.getTextField().charAt(0) == '/')){
					this.g.setTextField("");
				}
			}else{//fügt die Eingabe ein
				this.g.setTextField(this.g.getTextField()+((JButton)e.getSource()).getText());
				if(this.g.getTextField().charAt(this.g.getTextField().length()-1)=='+'){
					this.g.setTextField(this.g.getTextField().substring(0, this.g.getTextField().length()-2));
				}
			}
		}
	}
}