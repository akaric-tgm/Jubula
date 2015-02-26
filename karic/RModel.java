package karic;

import java.math.BigDecimal;

/**
 * Modelklasse des Rechners
 * @author Adin Karic
 * @version 2015-02-06
 */
public class RModel {
	//Attribute
	private BigDecimal zahl;
	private BigDecimal zahl2;
	private String op;
	/**
	 * Konstruktor der Modelklasse
	 */
	public RModel(){
		zahl=null;
		zahl=null;
		op ="";
	}
	/**
	 * Methode zum Rechnen
	 * @param z eine Zahl
	 * @param operation der Operand
	 */
	public void rechne(BigDecimal z,String operation){
		try{
			if(zahl == null && op == ""){
				zahl = z;
				op= operation;
			}else{
				zahl2=z;
				//Je nachdem welche Operation gewaehlt wurde
				switch(op){
				case "+":
					this.zahl = this.zahl.add(zahl2);
					break;
				case "-":
					this.zahl = this.zahl.subtract(zahl2);
					break;
				case "X":
					this.zahl = this.zahl.multiply(zahl2);
					break;
				case "/":
					this.zahl = this.zahl.divide(zahl2,12,BigDecimal.ROUND_UP);
					break;
				}

				op=operation;
			}
		}catch(Exception e){
			System.err.println("Fehler ist aufgetreten! Uberpruefen Sie Ihre Eingabe!");
			this.setZ();
		}
	}
	/**
	 * Methode zum Erhalten des Ergebnisses
	 * @param z eine Zahl
	 * @return das Ergebnis als String
	 */
	public String getErg(String z){
		try{
			this.rechne(new BigDecimal(z),"=");
			return zahl.toString();
		}catch(Exception e){
			System.err.println("Fehler ist aufgetreten! Uberpruefen Sie Ihre Eingabe!");
			//Im Fehlerfall wird der Speicher gelöscht
			this.setZ();
			return "";
		}
	}
	/**
	 * Methode zum Loeschen des Speichers
	 */
	public void setZ(){
		this.zahl=null;
		this.zahl2=null;
		op="";
	}

}
