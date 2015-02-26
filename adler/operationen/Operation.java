package adler.operationen;

import java.util.List;

/**
 * Dieses Interface stellt eine calc Methode zur verfügung welche alle Grundrechenarten kann
 * 
 * @author Philipp Adler
 * @version 2014-11-08
 */
public interface Operation {
	
	/**
	 * Die Methode processCalculations hat als Parameter eine Liste aus zahlen die mit dem modifier entweder
	 * addiert, subtrahiert, multipliziert oder dividiert werden
	 * @param values eine Liste von Zahlen die mit dem modifier ein neues Ergebnis liefern
	 * @param modifier der mit den Zahlen der Liste addiert, subtrahiert, multipliziert oder dividiert wird
	 * @return eine neue Liste mit den Ergebnissen
	 */
	public List<Double> processCalculations(List<Double> values, double modifier);
}
