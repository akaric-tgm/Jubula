package adler.calculator;

import java.util.*;

import adler.operationen.Operation;

/**
 * Diese verwendet das Interface Operation welches die Grundrechenarten implementiert
 * Diese Klasse speichert die eingegebenen Zahlen in eine Liste und
 * führt mit den übergebenen Modifier eine Grundrechenart aus welche zurück in die Liste gespeichert wird
 * 
 * @author Philipp Adler
 * @version 2014-11-08
 */
public class Calculator {
	private List<Double> values;//speichert sich alle Zahlen in eine Liste wo alle Datentypen gespeichert werden können
	private double modifier;//der Modifier der mit den Zahlen der Liste (addiert, subtrahiert, multipliziert oder dividiert) wird
	private Operation operator;//ein Interface welche die Grundrechenenarten implementiert
	
	/**
	 * Der Konstruktor erzeugt eine Liste wo die Zahlen vom Benutzer gespeichert werden
	 */
	public Calculator(){
		this.values = new ArrayList<Double>();
	}
	
	/**
	 * Die addValue Methode fügt die übergebene Zahl in die Liste
	 * @param value die Eingabe vom Benutzer welche in die Liste gespeichert wird
	 */
	public void addValue(double value){
		values.add(value);
	}
	
	/**
	 * Die setModifier Methode inizialisiert den Modifier der mit den Zahlen der Liste rechnet
	 * @param modifier die Eingabe vom Benutzer ist der neue Wert des modifier
	 */
	public void setModifier(double modifier){
		this.modifier = modifier;
	}
	
	/**
	 * Die removeValue Methode löscht die übergebene Zahl aus der Liste
	 * @param value die Zahl die aus der Liste gelöscht werden soll
	 */
	public void removeValue(double value){
		values.remove(value);
	}
	
	/**
	 * Die Methode calc ruft intern die Methode processCalculations auf, also ruft eine Grundrechenarten auf
	 * die der Benutzer in der Methode setcalc definiert hat
	 * @return List mit den neuen Ergebnissen
	 */
	public List<Double> calc(){
		this.operator.processCalculations(values, modifier);//speichert sich die neuen Ergebnisse in eine Liste
		return this.values;//gibt die neue Liste zurück
	}
	
	/**
	 * Die toString gibt den Inhalt der Liste als Text zurück
	 */
	public String toString(){
		String ausgabe = "";
		for(Double value : values){
			ausgabe += value+" ";
		}
		return ausgabe;
	}
	
	/**
	 * Die Methode setcalc definiert welche Grundrechenart verwendet werden soll
	 * @param operator der Benutzer muss die Klasse auswählen, für welche Grundrechenart er sich entscheidet
	 * das wären Addtion, Subtraktion, Multiplikaition und Division alle implementieren Operator
	 */
	public void setcalc(Operation operator){
		this.operator = operator;
	}
}
