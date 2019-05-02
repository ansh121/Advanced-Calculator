import calculators.algebraicCalculator.AlgebraicCalc;

public class MainApp {
	public static void main(String args[]) {
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } 
        catch (Exception ex) { }
		new AlgebraicCalc();
	}
}

