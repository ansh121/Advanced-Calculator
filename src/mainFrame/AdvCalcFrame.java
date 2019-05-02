package mainFrame;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import calculators.algebraicCalculator.AlgebraicCalc;
import calculators.differentialCalculator.DifferentialCalc;
import calculators.expressionPlotter.ExprPlotter;
import calculators.integralCalculator.IntegralCalc;
import calculators.matrixCalculator.MatrixCalc;

public class AdvCalcFrame{
    protected AdvCalcGUI gui;
    protected JCheckBoxMenuItem selMode[];
    protected Image icon;
    private int modes;
	public AdvCalcFrame() {
        gui = new AdvCalcGUI();
		selMode = gui.selMode;
		modes = gui.modes;
		for(int i = 0; i < modes; i++) {
			selMode[i].addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	            	changeMode(evt);
	            }
	        });
        }
		icon = new ImageIcon("bin/imgs/icon2.png").getImage();
        gui.setIconImage(icon);
        gui.setVisible(true);
	}

  	private void changeMode(ActionEvent evt) {
  		if(evt.getActionCommand() == "Algebraic"){
  			AlgebraicCalc aGUI = new AlgebraicCalc();
  			int w=aGUI.getWidth(),h=aGUI.getHeight();
  			aGUI.setBounds(100,100,w,h);
  		}
  		else if(evt.getActionCommand() == "Matrix"){
  			MatrixCalc mGUI = new MatrixCalc();
        }
        else if(evt.getActionCommand() == "Integral"){
  			new IntegralCalc();
        }
        else if(evt.getActionCommand() == "Differential"){
  			new DifferentialCalc();
        }
        else if(evt.getActionCommand() == "Graph Plotter"){
  			new ExprPlotter();
        }
  		gui.dispose();
  	}
}
