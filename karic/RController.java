package karic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/**
 * Controllerklasse des Rechners
 * @author Adin Karic
 * @version 2015-02-06
 */
public class RController implements ActionListener {
	//Attribute
	private RModel m;
	private Rechner view;
	/**
	 * Konstruktor der Controllerklasse 
	 */
	public RController(){
		//Attribute werden initialisert
		this.m= new RModel();
		this.view =  new Rechner(this,m);
	}
	/**
	 * actionPerformed-Methode die dann ausgefuehrt wird wenn ein Button gedrueckt wird
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		String st = b.getText();
		//falls eine Zahl gedrueckt wurde
		if(st.matches("0|1|2|3|4|5|6|7|8|9")||st.equals(".")){
			view.addText(st);
		}else{
			//falls eine Operation gedrueckt wurde
			if(st.matches("\\+|-|/|X")){
				view.calc(st);
			}else{
				if(st.equals("=")){

					this.view.getE();
				}else{
					if(st.equals("C")){
						view.erase();
					}else{
						if(st.equals("(-)")){
							view.neg();
						}

					}
				}
			}
		}
	}
}


