package adler.test;

import java.util.List;

import org.junit.Test;

import adler.calculator.Calculator;
import adler.operationen.*;

/**
 * Diese Klasse ist eine Testklasse welche überprüft das der Calculator und die Operationen nach unseren
 * Vorstellungen funktionieren
 * 
 * @author Philipp Adler
 * @version 2014-11-08
 */
public class TestCalculator {

	/**
	 * Diese Methode testet die Addition Klasse
	 */
	@Test
	public void rechnenplus(){
		Calculator cal = new Calculator();
		cal.setcalc(new Addition());//setzt den Operator auf Addtion
		cal.addValue(2.0);//fügt der Liste eine Zahl hinzu
		cal.setModifier(2.0);//modfier ist 2
		List<Double> values = cal.calc();//rechnet und speichert das neue Ergebnis in die Liste
		if(!values.get(0).equals(4.0)){//sollt 4 sein
			throw new RuntimeException("Addition Failed");
		}
	}
	
	/**
	 * Diese Methode testet die Subtraktion Klasse
	 */
	@Test
	public void rechnenminus(){
		Calculator cal = new Calculator();
		cal.setcalc(new Subtraktion());//setzt den Operator auf Subtraktion
		cal.addValue(2);//fügt der Liste eine Zahl hinzu
		cal.setModifier(2.0);//modfier ist 2
		List<Double> values = cal.calc();//rechnet und speichert das neue Ergebnis in die Liste
		if(!values.get(0).equals(0.0)){//sollt 0 sein
			throw new RuntimeException("Subtraktion Failed");
		}
	}

	/**
	 * Diese Methode testet die Multiplikation Klasse
	 */
	@Test
	public void rechnenmultiplikation(){
		Calculator cal = new Calculator();
		cal.setcalc(new Multiplikation());//setzt den Operator auf Multiplikation
		cal.addValue(2);//fügt der Liste eine Zahl hinzu
		cal.setModifier(2.0);//modfier ist 2
		List<Double> values = cal.calc();//rechnet und speichert das neue Ergebnis in die Liste
		if(!values.get(0).equals(4.0)){//sollt 4 sein
			throw new RuntimeException("Multiplikation Failed");
		}
	}
	
	/**
	 * Diese Methode testet die Division Klasse
	 */
	@Test
	public void rechnendivision(){
		Calculator cal = new Calculator();
		cal.setcalc(new Division());//setzt den Operator auf Division
		cal.addValue(2);//fügt der Liste eine Zahl hinzu
		cal.setModifier(2.0);//modfier ist 2
		List<Double> values = cal.calc();//rechnet und speichert das neue Ergebnis in die Liste
		if(!values.get(0).equals(1.0)){//sollt 1 sein
			throw new RuntimeException("Division Failed");
		}
	}
	
	/**
	 * Hier überprüfen wir die Klasse Calulator ob er richtig hinzufügt, removed und die Ausgabe
	 */
	@Test
	public void Calculator(){
		Calculator cal = new Calculator();
		cal.addValue(2);//fügt der Liste eine Zahl hinzu
		cal.addValue(3);//fügt der Liste eine Zahl hinzu
		cal.addValue(4);//fügt der Liste eine Zahl hinzu
		cal.removeValue(2);//löscht
		cal.setcalc(new Addition());//Operation ist addieren
		cal.setModifier(1);//modifier ist 1
		if(cal.calc().size()!=2){//größe der Liste sollte 2 sein da eins gelöscht wurde
			throw new RuntimeException("Add and Remove Fail");
		}
		if(!cal.toString().equals("4.0 5.0 ")){//sollte 4 und 5 sein
			throw new RuntimeException("toString Fail");
		}
	}
}