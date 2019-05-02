package mainFrame;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class AdvCalcGUI extends JFrame {
	private static final long serialVersionUID = 1L;
    JMenuBar menuBar;
	JMenu menuMode;
    JCheckBoxMenuItem selMode[];
    int modes;
	public AdvCalcGUI() {
		modes = 5;
		menuBar = new JMenuBar();
		menuMode = new JMenu();
		selMode = new JCheckBoxMenuItem[modes];
		menuMode.setText("Mode  ");
		for(int i = 0; i < modes; i++) {
			selMode[i] = new JCheckBoxMenuItem();
		}
        selMode[0].setText("Algebraic"); 
        selMode[1].setText("Matrix"); 
        selMode[2].setText("Integral"); 
        selMode[3].setText("Differential");
        selMode[4].setText("Graph Plotter");
		menuBar.add(menuMode);
		for(int i = 0; i < modes; i++) {
			menuMode.add(selMode[i]);
		}
		setJMenuBar(menuBar);
		setTitle("Advanced Calculator");
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    	setResizable(false);
    	setBounds(230, 115, 200, 300);
	}
}
