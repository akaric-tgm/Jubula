package adler.operationen;

import java.util.*;

/**
 * Diese Methode implementiert eine Methode für das Subtrahieren und implementiert neben bei das Interface Operation
 * 
 * @author Philipp Adler
 * @version 2014-11-08
 */
public class Subtraktion implements Operation {
	
	/**
	 * Diese Methode muss überschrieben werden da sie abstract ist
	 * Die Methode processCalculations hat als Parameter eine Liste aus zahlen die mit dem modifier subtrahiert wird
	 * @param values eine Liste von Zahlen die mit dem modifier subtrahiert wird und ein neues Ergebnis liefert 
	 * welches in die Liste zurück geschrieben wird und das alte Ergebniss ersetzt
	 * @param modifier der mit den Zahlen der Liste subtrahiert wird
	 * @return eine neue Liste mit den Ergebnissen
	 */
	@Override
	public List<Double> processCalculations(List<Double> values, double modifier) {
		for (int i = 0; i<values.size(); i++) {//gehe jedes Element von der übergebenen Liste durch
			values.set(i, values.get(i) - modifier);//speichert das Ergebniss in die neue Liste
		}
		return values;//gibt die neue Liste zurück
	}
}
