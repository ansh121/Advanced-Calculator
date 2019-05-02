package calculators.algebraicCalculator;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class AlgebraicCalcGUI extends JLabel{
	
	private static final long serialVersionUID = 1L;
    JButton[] jBNumerical;
	JButton[] jBOperator;
	JButton[] jBFunction;
	JButton[] jBBracket;
	JButton[] jBMemory;
	JButton[] jBClear;
	JButton jBShift;
	JButton jBPoint;
	JTextField jLabelDisplay;
	JTextField jTextDisplay;
	JButton jBComma;
	JButton[] jBVariable;
	JLabel jLabel;
	JTextField[] jVariableText;
	JLabel[] jLVariable;
	
	public AlgebraicCalcGUI() {
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
						
		jLabelDisplay=new JTextField();				
		jTextDisplay=new JTextField();	
		
		jBComma=new JButton();
		jBVariable=new JButton[4];
		jLabel=new JLabel();
		jVariableText=new JTextField[4];
		jLVariable=new JLabel[4];
																		
		// Setting Bounds and Attributes of the Elements 
			
		//Variable Text Fields
		for(int i=0; i<4; i++) {
			jVariableText[i]=new JTextField();
			jVariableText[i].setSize(60, 24);
			jVariableText[i].setHorizontalAlignment(4);
			jVariableText[i].setFont(new Font("Tahoma", 0, 12));
			jVariableText[i].setBackground(new Color(220, 220, 220));
			jVariableText[i].setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
			jVariableText[i].setLocation(500,18+27*i);
		}
		
		//Variable Label
		jLabel.setText("Constants");
		jLabel.setSize(60, 20);
		jLabel.setLocation(500 , 160);
		jLabel.setFont(new Font("Calibri", 0, 11));
		jLabel.setBackground(new Color(200, 200, 190));
		
		
		for(int i=0; i<4; i++) {
			jLVariable[i]=new JLabel();
			jLVariable[i].setSize(30, 24);
			jLVariable[i].setHorizontalAlignment(4);
			jLVariable[i].setFont(new Font("Tahoma", 0, 11));
			jLVariable[i].setBackground(new Color(180, 180, 220));
			jLVariable[i].setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
			jLVariable[i].setLocation(470,18+27*i);
		}
		jLVariable[0].setText(" a =");
		jLVariable[1].setText(" b =");
		jLVariable[2].setText(" c =");
		jLVariable[3].setText(" d =");
		
		//Variables
		jBVariable[0] = new JButton("a");
		jBVariable[1] = new JButton("b");
		jBVariable[2] = new JButton("c");
		jBVariable[3] = new JButton("d");
		for(int i=0;i<4;i++) {
			jBVariable[i].setSize(70, 40);
			jBVariable[i].setLocation(495 , 240+(((i-1)%3)*40));
			jBVariable[i].setFont(new Font("Calibri", 0, 19));
			jBVariable[i].setBackground(new Color(200, 200, 190));
			jBVariable[i].setBorder(null);
		}
		
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
			jBFunction[4].setLocation(378, 320); jBFunction[4].setText("tanh");
			jBFunction[5].setLocation(432, 320); jBFunction[5].setText("Ans");
			jBFunction[6].setLocation(270, 280); jBFunction[6].setText("^2");
			jBFunction[7].setLocation(324, 280); jBFunction[7].setText("cos");
			jBFunction[8].setLocation(600, 280); jBFunction[8].setText("sqrt");
			jBFunction[9].setLocation(600, 280); jBFunction[9].setText("acos");
			jBFunction[10].setLocation(378, 280); jBFunction[10].setText("cosh");
			jBFunction[11].setLocation(432, 280); jBFunction[11].setText("pi");
			jBFunction[12].setLocation(270, 240); jBFunction[12].setText("ln");
			jBFunction[13].setLocation(324, 240); jBFunction[13].setText("sin");
			jBFunction[14].setLocation(600, 240); jBFunction[14].setText("E^");
			jBFunction[15].setLocation(600, 240); jBFunction[15].setText("asin");
			jBFunction[16].setLocation(378, 240); jBFunction[16].setText("sinh");
			jBFunction[17].setLocation(432, 240); jBFunction[17].setText("E");
			jBFunction[18].setLocation(270, 200); jBFunction[18].setText("log");
			jBFunction[19].setLocation(324, 200); jBFunction[19].setText("bin(n,r)");
			jBFunction[20].setLocation(378, 200); jBFunction[20].setText("n!");
			jBFunction[21].setLocation(432, 200); jBFunction[21].setText("Abs");
		
			jBFunction[22].setLocation(600, 320); jBFunction[22].setText("atanh");
			jBFunction[23].setLocation(600, 280); jBFunction[23].setText("acosh");
			jBFunction[24].setLocation(600, 240); jBFunction[24].setText("asinh");
			

		//shift button
		jBShift.setText("Shift");
		jBShift.setBounds(270, 150, 105, 33);
		jBShift.setBorder(null);
			
		//Memory Buttons
		for(int i=0; i<2; i++){
			jBMemory[i] = new JButton(); 
			jBMemory[i].setSize(50, 33);
			jBMemory[i].setFont(new Font("Arial", 0, 13));
			jBMemory[i].setBorder(null);
		}
		jBMemory[0].setText("M"); jBMemory[0].setLocation(10, 150);
		jBMemory[1].setText("MS"); jBMemory[1].setLocation(60, 150);
		
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
			jBClear[i].setSize(53, 33);
			jBClear[i].setFont(new Font("Vrinda", 0, 17));
			jBClear[i].setBorder(null);
		}
		jBClear[0].setText("C"); jBClear[0].setLocation(378, 150);
		jBClear[1].setText("AC"); jBClear[1].setLocation(432, 150);
		jBClear[2].setText("<B"); jBClear[2].setLocation(110, 150); jBClear[2].setSize(50, 33);
		
		//Display text
		jTextDisplay.setSize(450, 43);
		jTextDisplay.setHorizontalAlignment(2);
		jTextDisplay.setFont(new Font("Tahoma", 0, 17));
		jTextDisplay.setBackground(new Color(220, 220, 220));
		jTextDisplay.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		jTextDisplay.setLocation(10, 18);
		
		//Display label
		jLabelDisplay.setSize(450, 60);
        jLabelDisplay.setHorizontalAlignment(4);
		jLabelDisplay.setFont(new Font("Lucida Console", 0, 14));
		jLabelDisplay.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		jLabelDisplay.setLocation(10, 63);
		jLabelDisplay.setEditable(false);
		jLabelDisplay.setDragEnabled(true);
		
		//adding buttons
		for(int i=0; i<4; i++) {
			add(jVariableText[i]);
		}
		add(jLabel);
		for(int i=0; i<4; i++) {
			add(jLVariable[i]);
		}
		for(int i=0;i<4;i++) {
			add(jBVariable[i]);	
		}
		
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
		for(int i=0; i<2; i++){
			add(jBMemory[i]);
		}
		for(int i=0; i<3; i++){
			add(jBClear[i]);
		}
		add(jBShift);
		for(int i=0; i<2; i++){
			add(jBBracket[i]);
		}
		
		//adding display labels
		add(jLabelDisplay);
        add(jTextDisplay);
        
		setBounds(0, 0, 590, 410);
		
	}
}

