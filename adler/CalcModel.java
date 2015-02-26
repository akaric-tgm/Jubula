package adler;

import java.math.BigDecimal;

/**
 * Diese Klasse uebernimmmt die Benutzereingabe, verarbeitet sie und gibt das Endergebnis zurueck
 * @author Philipp Adler
 * @version 2015-02-05
 */
public class CalcModel {

	private String input;
	private boolean firstisnegativ;

	/**
	 * Diese Methode gibt die fertige Rechnung zurück
	 * @param rechnung die ungeloeste Rechnung
	 * @return die geloeste Rechnung
	 */
	public String calc(String rechnung){
		input = rechnung.replace('+', '#');
		input = input.replace('-', '&');
		//		try{
		while(input.indexOf("x") != -1){//loest alle Mulitplikationen
			inputCut('x');
		}
		while(input.indexOf("/") != -1){//loest alle Divisionen
			inputCut('/');
		}
		while(input.indexOf("&") != -1){//loest alle Subtraktionen
			inputCut('&');
		}
		while(input.indexOf("#") != -1){//loest alle Additionen
			inputCut('#');
		}
		if(this.input.equals("null"))this.input = "";
		return this.input;
	}


	private void inputCut(char operator){
		//wenn es sich um eine negative Zahl handelt
		if(this.input.charAt(0) == '#' || this.input.charAt(0) == '&' || this.input.charAt(0) == 'x' || this.input.charAt(0) == '/' ){ 
			if(this.input.charAt(0)=='&')this.firstisnegativ = true;
			this.input = this.input.substring(1, this.input.length());
		}else{
			String first = firstNumber(operator);//holt sich die erste Zahl aus der Rechnung
			String second = secondNumber(operator);//holt sich die zweite Zahl aus der Rechnung
			BigDecimal zahl = null;
			switch (operator) {
			case 'x'://multiplikation
				BigDecimal x = null;
				try{
					x = new BigDecimal(first);
				}catch(java.lang.NumberFormatException e){
					System.err.println("Die angegebene Zahl vor dem Operator ist falsch");
					break;
				}
				if(firstisnegativ){//falls es sich um eine negative Zahl handelt
					x = x.negate();
					firstisnegativ = false;
				}
				BigDecimal y = null;
				try{
					y = new BigDecimal(second);
				}catch(java.lang.NumberFormatException e){
					System.err.println("Die angegebene Zahl hinter dem Operator ist falsch");
					break;
				}
				zahl = x.multiply(y);
				break;

			case '/'://division
				if(Double.parseDouble(second) == 0){
					System.err.println("Division durch 0 nicht möglich");
					this.input = "";
				}else{
					BigDecimal x1 = null;
					try{
						x1 = new BigDecimal(first);
					}catch(java.lang.NumberFormatException e){
						System.err.println("Die angegebene Zahl vor dem Operator ist falsch");
						break;
					}
					if(firstisnegativ){//falls es sich um eine negative Zahl handelt
						x1 = x1.negate();
						firstisnegativ = false;
					}
					BigDecimal y1 = null;
					try{
						y1 = new BigDecimal(second);
					}catch(java.lang.NumberFormatException e){
						System.err.println("Die angegebene Zahl hinter dem Operator ist falsch");
						break;
					}
					zahl = x1.divide(y1, 50, 0);//wieviele Stellen Nachkommastellen
				}
				break;

			case '#'://addition
				BigDecimal x1 = null;
				try{
					x1 = new BigDecimal(first);
				}catch(java.lang.NumberFormatException e){
					System.err.println("Die angegebene Zahl vor dem Operator ist falsch");
					break;
				}
				if(firstisnegativ){//falls es sich um eine negative Zahl handelt
					x1 = x1.negate();
					firstisnegativ = false;
				}
				BigDecimal y1 = null;
				try{
					y1 = new BigDecimal(second);
				}catch(java.lang.NumberFormatException e){
					System.err.println("Die angegebene Zahl hinter dem Operator ist falsch");
					break;
				}
				zahl = x1.add(y1);
				break;

			case '&'://subtraktion
				BigDecimal x11 = null;
				try{
					x11 = new BigDecimal(first);
				}catch(java.lang.NumberFormatException e){
					System.err.println("Die angegebene Zahl vor dem Operator ist falsch");
					break;
				}
				if(firstisnegativ){//falls es sich um eine negative Zahl handelt
					x11 = x11.negate();
					firstisnegativ = false;
				}
				BigDecimal y11 = null;
				try{
					y11 = new BigDecimal(second);
				}catch(java.lang.NumberFormatException e){
					System.err.println("Die angegebene Zahl hinter dem Operator ist falsch");
					break;
				}
				zahl = x11.subtract(y11);
				break;
			}
			String old = first+""+operator+""+second;
			this.input = this.input.replaceFirst(old, zahl+"");//replact den alten wert durch den neuen
		}
	}

	/**
	 * Holt sich die erste Zahl für die gewaehlte Grundrechenart
	 * @param operator welche Grundrechenart
	 * @return die erste Zahl, also diese welche vor dem Operator steht
	 */
	private String firstNumber(char operator) {
		int ende = input.indexOf(operator);
		int anfang = input.indexOf(operator);
		if(anfang > 0){
			boolean flag = true;
			do{
				anfang--;
				if(input.charAt(anfang) == '#' || input.charAt(anfang) == '&' || input.charAt(anfang) == 'x' || input.charAt(anfang) == '/'){
					flag = false;
					anfang++;
				}
			}while(!(anfang == 0 || !flag));
		}
		return input.substring(anfang, ende);
	}

	/**
	 * Holt sich die zweite Zahl für die gewaehlte Grundrechenart
	 * @param operator welche Grundrechenart
	 * @return die zweite Zahl, also diese welche nach dem Operator steht
	 */
	private String secondNumber(char operator) {
		int anfang = input.indexOf(operator)+1;
		int ende = input.indexOf(operator);
		boolean flag = true;
		do{
			ende++;
			if(input.charAt(ende) == '#' || input.charAt(ende) == '&' || input.charAt(ende) == 'x' || input.charAt(ende) == '/'){
				flag = false;
			}
		}while(!(input.length()-1 == ende || !flag));
		if(input.length()-1 == ende){
			return input.substring(anfang, ende+1);
		}else{
			return input.substring(anfang, ende);
		}
	}
}