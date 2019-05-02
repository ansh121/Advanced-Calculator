package calculators.expressionPlotter;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import calculators.expressionPlotter.ExprPlotterGUI;

public class ExprPlotterGUI extends JLabel{
	
	private static final long serialVersionUID = 1L;
    JButton[] jBNumerical;
	JButton[] jBOperator;
	JButton[] jBFunction;
	JButton[] jBBracket;
	JButton[] jBMemory;
	JButton[] jBClear;
	JButton jBShift;
	JButton jBPoint;
	JTextField jTextDisplay;
	JButton jBComma;
	JLabel jInputIndicator;
	JButton jBVariable;
	
	public ExprPlotterGUI() {
		initialize();
	}

	
	private void initialize() {
		
		// Initialization 
		
		jBNumerical=new JButton[10];			
		jBPoint=new JButton();				
		jBOperator=new JButton[7];				
		jBFunction=new JButton[25];		
		jBShift = new JButton();				
		jBMemory=new JButton[2];				
		jBBracket=new JButton[2];			
		jBClear=new JButton[3]; 
										
		jTextDisplay=new JTextField();	
		
		jBComma=new JButton();
		jInputIndicator=new JLabel();
																		
		// Setting Bounds and Attributes of the Elements
		
		
		//Variables
		jBVariable = new JButton("x");
		jBVariable.setSize(107, 33);
		jBVariable.setFont(new Font("Calibri", 0, 19));
		jBVariable.setBackground(new Color(200, 200, 190));
		jBVariable.setBorder(null);
		jBVariable.setLocation(270, 150);
		
		//Numeric Buttons
		for(int i=0; i<10; i++){
			jBNumerical[i] = new JButton(""+i);
			jBNumerical[i].setSize(50, 40);
			jBNumerical[i].setLocation(((i-1)%3)*50+10, 280-(((i-1)/3)*40));
			jBNumerical[i].setFont(new Font("Calibri", 0, 19));
			jBNumerical[i].setBackground(new Color(200, 200, 190));
			jBNumerical[i].setBorder(null);
		}
		jBNumerical[0].setLocation(60, 320); 
		jBNumerical[0].setSize(50, 40);
		
		// Comma
		jBComma = new JButton(",");
		jBComma.setSize(50, 40);
		jBComma.setLocation(10, 320);
		jBComma.setFont(new Font("Calibri", 0, 19));
		jBComma.setBackground(new Color(200, 200, 190));
		jBComma.setBorder(null);
				
		
		//Point
		jBPoint.setBackground(new Color(210, 210, 190));
		jBPoint.setText("."); jBPoint.setBounds(110, 320, 50, 40);
		jBPoint.setFont(new Font("Vrinda", 0, 26));
			
		//Operator Buttons
		for(int i=0; i<7; i++){
			jBOperator[i] = new JButton();
			jBOperator[i].setSize(45, 40);
			jBOperator[i].setFont(new Font("Calibri", 0, 17));
			jBOperator[i].setBackground(new Color(188, 188, 188));
			jBOperator[i].setBorder(null);
		}
		jBOperator[0].setText("+"); jBOperator[0].setLocation(170, 320);
		jBOperator[1].setText("-"); jBOperator[1].setLocation(170, 280);
		jBOperator[2].setText("*"); jBOperator[2].setLocation(170, 240);
		jBOperator[3].setText("/"); jBOperator[3].setLocation(170, 200);
		jBOperator[5].setText("="); jBOperator[5].setBounds(215, 280, 45, 80);
		jBOperator[5].setFont(new Font("Arial", 0, 19));
		jBOperator[4].setText("%"); jBOperator[4].setLocation(215, 240);
		jBOperator[6].setText("^"); jBOperator[6].setLocation(215, 200);
		
		
		//Complex Operator Buttons
		for(int i=0; i<25; i++){	
			jBFunction[i] = new JButton();
			jBFunction[i].setSize(53, 40);
			jBFunction[i].setFont(new Font("Calibri", 0, 15));
			jBFunction[i].setBackground(new Color(178, 178, 178));
			jBFunction[i].setBorder(null);
		}
		
		jBFunction[19].setFont(new Font("Calibri",0,12));
		
			jBFunction[0].setLocation(270, 320); jBFunction[0].setText("^3");
			jBFunction[1].setLocation(324, 320); jBFunction[1].setText("tan");
			jBFunction[2].setLocation(600, 320); jBFunction[2].setText("cbrt");
			jBFunction[3].setLocation(600, 320); jBFunction[3].setText("atan");
			jBFunction[4].setLocation(378, 320); jBFunction[4].setText("x^2");//
			jBFunction[5].setLocation(432, 320); jBFunction[5].setText("Ans");
			jBFunction[6].setLocation(270, 280); jBFunction[6].setText("^2");
			jBFunction[7].setLocation(324, 280); jBFunction[7].setText("cos");
			jBFunction[8].setLocation(600, 280); jBFunction[8].setText("sqrt");
			jBFunction[9].setLocation(600, 280); jBFunction[9].setText("acos");
			jBFunction[10].setLocation(378, 280); jBFunction[10].setText("sqrt");//
			jBFunction[11].setLocation(432, 280); jBFunction[11].setText("pi");
			jBFunction[12].setLocation(270, 240); jBFunction[12].setText("ln");
			jBFunction[13].setLocation(324, 240); jBFunction[13].setText("sin");
			jBFunction[14].setLocation(600, 240); jBFunction[14].setText("E^");
			jBFunction[15].setLocation(600, 240); jBFunction[15].setText("asin");
			jBFunction[16].setLocation(378, 240); jBFunction[16].setText("E^");//
			jBFunction[17].setLocation(432, 240); jBFunction[17].setText("E");
			jBFunction[18].setLocation(270, 200); jBFunction[18].setText("log");
			jBFunction[19].setLocation(324, 200); jBFunction[19].setText("bin(n,r)");
			jBFunction[20].setLocation(378, 200); jBFunction[20].setText("n!");
			jBFunction[21].setLocation(432, 200); jBFunction[21].setText("Abs");
			////
			jBFunction[22].setLocation(600, 320); jBFunction[22].setText("atanh");
			jBFunction[23].setLocation(600, 280); jBFunction[23].setText("acosh");
			jBFunction[24].setLocation(600, 240); jBFunction[24].setText("asinh");
			

		//shift button
		jBShift.setText("Shift");
		jBShift.setBounds(380, 150, 105, 33);
		jBShift.setBorder(null);
		
		//bracket button
		for(int i=0; i<2; i++){
			jBBracket[i] = new JButton();
			jBBracket[i].setSize(45, 33);
			jBBracket[i].setFont(new Font("Arial", 0, 13));
			jBBracket[i].setBorder(null);
		}
		jBBracket[0].setText("("); jBBracket[0].setLocation(170, 150);
		jBBracket[1].setText(")"); jBBracket[1].setLocation(215, 150);
		
		//Clear Buttons
		for(int i=0; i<3; i++){
			jBClear[i] = new JButton();
			jBClear[i].setSize(107, 33);
			jBClear[i].setFont(new Font("Vrinda", 0, 16));
			jBClear[i].setBorder(null);
		}
		jBClear[0].setText("C"); jBClear[0].setLocation(378, 150);
		jBClear[1].setVisible(false);
		jBClear[2].setText("<B"); jBClear[2].setLocation(10, 150); jBClear[2].setSize(150, 33);
		
		//Display text
		jTextDisplay.setSize(470, 100);
		jTextDisplay.setHorizontalAlignment(2);
		jTextDisplay.setFont(new Font("Tahoma", 0, 17));
		jTextDisplay.setBackground(new Color(220, 220, 220));
		jTextDisplay.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		jTextDisplay.setLocation(10, 41);
		
		//InputIndicator
		jInputIndicator.setSize(300, 27);
		jInputIndicator.setHorizontalAlignment(2);
		jInputIndicator.setFont(new Font("Tahoma", 0, 15));
		jInputIndicator.setBackground(new Color(180, 180, 220));
		jInputIndicator.setText("For Univariate Expression y=f(x):");jInputIndicator.setLocation(12,10);
		
		//adding buttons

		add(jInputIndicator);
		add(jBVariable);	
		
		for(int i=0; i<10; i++){
			add(jBNumerical[i]);
		}
		add(jBPoint);
		add(jBComma);
		for(int i=0; i<7; i++){
			add(jBOperator[i]);
		}
		for(int i=0; i<25; i++){
			add(jBFunction[i]);
		}
		for(int i=0; i<3; i++){
			add(jBClear[i]);
		}
		add(jBShift);
		for(int i=0; i<2; i++){
			add(jBBracket[i]);
		}
		
		//adding display labels
        add(jTextDisplay);
        
		setBounds(0, 0, 500, 410);
		
	}
	
	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception ex) {
			// do nothing
		}

		ExprPlotterGUI gui = new ExprPlotterGUI();
		JFrame jFrame = new JFrame();
		jFrame.setBounds(230, 115, 500, 410);
		jFrame.setVisible(true);
		jFrame.setLayout(null);
		jFrame.add(gui);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

