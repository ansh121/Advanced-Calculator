package calculators.matrixCalculator;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;


public class MatrixCalcGUI extends JLabel{
	
	private static final long serialVersionUID = 1L;
    JButton[] jBNumerical;
	JButton[] jBOperator;
	JButton[] jBFunction;
	JButton[] jBBracket;
	JButton[] jBMemory;
	JButton[] jBClear;
	JButton jBShift;
	JButton jBPoint;
	JTextArea jLabelDisplay;
	JTextField jTextDisplay;
	
	JButton jBComma;
	JButton[] jBVariable;
	JLabel[] jLabel;
	JLabel jIndicator;
	JButton jNext;
	JTextField[] jVariableText;
	JLabel[] jLVariable;
	
	//Constructor
	public MatrixCalcGUI() {
	
		initialize();
	}

	
	private void initialize() {
		
		// Initialization 
		
		jBNumerical=new JButton[10];			
		jBPoint=new JButton();				
		jBOperator=new JButton[7];				
		jBFunction=new JButton[30];		
		jBShift = new JButton();				
		jBMemory=new JButton[2];				
		jBBracket=new JButton[2];			
		jBClear=new JButton[3]; 
						
		jLabelDisplay=new JTextArea();				
		jTextDisplay=new JTextField();	
		
		jBComma=new JButton();
		jBVariable=new JButton[8];
		jLabel=new JLabel[2];
		jIndicator=new JLabel();
		jNext=new JButton();
		jVariableText=new JTextField[4];
		jLVariable=new JLabel[4];
																		
		// Setting Bounds and Attributes of the Elements
		
		//Variable Text Fields
		for(int i=0; i<4; i++) {
			jVariableText[i]=new JTextField();
			jVariableText[i].setSize(60, 22);
			jVariableText[i].setHorizontalAlignment(4);
			jVariableText[i].setFont(new Font("Tahoma", 0, 12));
			jVariableText[i].setBackground(new Color(220, 220, 220));
			jVariableText[i].setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
			jVariableText[i].setLocation(308+100*i,124);
		}
		
		//Variable text Field Label
		for(int i=0; i<4; i++) {
			jLVariable[i]=new JLabel();
			jLVariable[i].setSize(32, 22);
			jLVariable[i].setHorizontalAlignment(4);
			jLVariable[i].setFont(new Font("Tahoma", 0, 11));
			jLVariable[i].setBackground(new Color(180, 180, 220));
			jLVariable[i].setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
			jLVariable[i].setLocation(278+100*i,124);
		}
		jLVariable[0].setText("w =");
		jLVariable[1].setText("x =");
		jLVariable[2].setText("y =");
		jLVariable[3].setText("z =");
		
		//Next Button
		jNext = new JButton("Next");
		jNext.setSize(80, 40);
		jNext.setLocation(95, 95);
		jNext.setFont(new Font("Calibri", 0, 15));
		jNext.setBackground(new Color(200, 200, 190));
		jNext.setBorder(null);
		
		// Indicator Label
		jIndicator.setText("Number of Matrices (up to 4)");
		jIndicator.setSize(450, 20);
		jIndicator.setHorizontalAlignment(2);
		jIndicator.setFont(new Font("Tahoma", 2, 15));
		jIndicator.setLocation(15, 15);
		
		//Matrix Variable Label
		jLabel[0]=new JLabel();
		jLabel[0].setText("Matrices");
		jLabel[0].setSize(70, 20);
		jLabel[0].setLocation(554 , 180);
		jLabel[0].setFont(new Font("Calibri", 0, 12));
		//jLabel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		jLabel[0].setBackground(new Color(200, 200, 190));
		
		//Variables Label
		jLabel[1]=new JLabel();
		jLabel[1].setText("Variables");
		jLabel[1].setSize(70, 20);
		jLabel[1].setLocation(558 , 225);
		jLabel[1].setFont(new Font("Calibri", 0, 12));
		//jLabel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		jLabel[1].setBackground(new Color(200, 200, 190));
		
		//Variables
		jBVariable[0] = new JButton("A");
		jBVariable[1] = new JButton("B");
		jBVariable[2] = new JButton("C");
		jBVariable[3] = new JButton("D");
		jBVariable[4] = new JButton("w");
		jBVariable[5] = new JButton("x");
		jBVariable[6] = new JButton("y");
		jBVariable[7] = new JButton("z");
		for(int i=0;i<8;i++) {
			jBVariable[i].setSize(45, 33);
			jBVariable[i].setLocation(495+i*45 , 150);
			jBVariable[i].setFont(new Font("Calibri", 0, 19));
			jBVariable[i].setBackground(new Color(200, 200, 190));
			jBVariable[i].setBorder(null);
			jBVariable[i].setEnabled(false);
			//jBVariable[i].setVisible(false);
		}
		for(int i=4;i<8;i++) {
			jBVariable[i].setLocation(495+(i-4)*45, 196);
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
		jBOperator[5].setEnabled(false);
		
		//Complex Operator Buttons
		for(int i=0; i<30; i++){	
			jBFunction[i] = new JButton();
			jBFunction[i].setSize(53, 40);
			jBFunction[i].setFont(new Font("Calibri", 0, 15));
			jBFunction[i].setBackground(new Color(178, 178, 178));
			jBFunction[i].setBorder(null);
		}
		
		jBFunction[19].setFont(new Font("Calibri",0,12));
		
			jBFunction[0].setLocation(270, 320); jBFunction[0].setText("^3");
			jBFunction[1].setLocation(324, 320); jBFunction[1].setText("tan");
			jBFunction[2].setLocation(1000, 320); jBFunction[2].setText("cbrt");
			jBFunction[3].setLocation(1000, 320); jBFunction[3].setText("atan");
			jBFunction[4].setLocation(378, 320); jBFunction[4].setText("tanh");
			jBFunction[5].setLocation(432, 320); jBFunction[5].setText("Ans");
			jBFunction[6].setLocation(270, 280); jBFunction[6].setText("^2");
			jBFunction[7].setLocation(324, 280); jBFunction[7].setText("cos");
			jBFunction[8].setLocation(1000, 280); jBFunction[8].setText("aqrt");
			jBFunction[9].setLocation(1000, 280); jBFunction[9].setText("acos");
			jBFunction[10].setLocation(378, 280); jBFunction[10].setText("cosh");
			jBFunction[11].setLocation(432, 280); jBFunction[11].setText("pi");
			jBFunction[12].setLocation(270, 240); jBFunction[12].setText("ln");
			jBFunction[13].setLocation(324, 240); jBFunction[13].setText("sin");
			jBFunction[14].setLocation(1000, 240); jBFunction[14].setText("E^");
			jBFunction[15].setLocation(1000, 240); jBFunction[15].setText("asin");
			jBFunction[16].setLocation(378, 240); jBFunction[16].setText("sinh");
			jBFunction[17].setLocation(432, 240); jBFunction[17].setText("E");
			jBFunction[18].setLocation(270, 200); jBFunction[18].setText("log");
			jBFunction[19].setLocation(324, 200); jBFunction[19].setText("bin(n,r)");
			jBFunction[20].setLocation(378, 200); jBFunction[20].setText("n!");
			jBFunction[21].setLocation(432, 200); jBFunction[21].setText("Abs");
			////
			jBFunction[22].setLocation(1000, 320); jBFunction[22].setText("atanh");
			jBFunction[23].setLocation(1000, 280); jBFunction[23].setText("acosh");
			jBFunction[24].setLocation(1000, 240); jBFunction[24].setText("asinh");
			jBFunction[25].setLocation(495, 242); jBFunction[25].setText("Determinant");jBFunction[25].setSize(180,25);jBFunction[25].setEnabled(false);
			jBFunction[26].setLocation(495, 265); jBFunction[26].setText("Transpose");jBFunction[26].setSize(180,25);jBFunction[26].setEnabled(false);
			jBFunction[27].setLocation(495, 288); jBFunction[27].setText("Eigen Value");jBFunction[27].setSize(180,25);jBFunction[27].setEnabled(false);
			jBFunction[28].setLocation(495, 311); jBFunction[28].setText("Inverse");jBFunction[28].setSize(180,25);jBFunction[28].setEnabled(false);
			jBFunction[29].setLocation(495, 334); jBFunction[29].setText("Adjoint");jBFunction[29].setSize(180,25);jBFunction[29].setEnabled(false);
			

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
		jTextDisplay.setSize(250, 53);
		jTextDisplay.setHorizontalAlignment(2);
		jTextDisplay.setFont(new Font("Tahoma", 0, 17));
		jTextDisplay.setBackground(new Color(220, 220, 220));
		jTextDisplay.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		jTextDisplay.setLocation(10, 35);
		//jTextDisplay.setEditable(false);
		
		//Display label
		jLabelDisplay.setSize(400, 105);
        //jLabelDisplay.setHorizontalAlignment(4);
		jLabelDisplay.setFont(new Font("Lucida Console", 0, 12));
		jLabelDisplay.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		jLabelDisplay.setLocation(270, 13);
		jLabelDisplay.setEditable(false);
		jLabelDisplay.setDragEnabled(true);
		
		//adding buttons
		add(jNext);
		add(jIndicator);
		add(jLabel[0]);
		add(jLabel[1]);
		for(int i=0;i<8;i++) {
			add(jBVariable[i]);	
		}
		for(int i=0; i<4; i++) {
			add(jVariableText[i]);
		}
		for(int i=0; i<4; i++) {
			add(jLVariable[i]);
		}
		for(int i=0; i<10; i++){
			add(jBNumerical[i]);
		}
		add(jBPoint);
		add(jBComma);
		for(int i=0; i<7; i++){
			add(jBOperator[i]);
		}
		for(int i=0; i<30; i++){
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
        
		setBounds(0, 0, 700, 410);
		
	}
/*	
	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception ex) {
			// do nothing
		}

		MatrixCalcGUI gui = new MatrixCalcGUI();
		JFrame jFrame = new JFrame();
		jFrame.setBounds(230, 115, 685, 410);
		jFrame.setVisible(true);
		jFrame.setLayout(null);
		jFrame.add(gui);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}*/
}
