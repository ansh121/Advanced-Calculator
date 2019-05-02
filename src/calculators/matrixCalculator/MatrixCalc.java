package calculators.matrixCalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import mainFrame.AdvCalcFrame;
import notifications.Message;

public class MatrixCalc extends AdvCalcFrame{

	private MatrixCalcGUI mcGUI;
	
	private MatrixCalcEval evaluator = new MatrixCalcEval(); 

	private JButton[] jBNumerical;
	private JButton[] jBOperator;
	private JButton[] jBFunction;
	private JButton[] jBBracket;
	private JButton[] jBMemory;
	private JButton[] jBClear;
	private JButton jBShift;
	private JButton jBPoint;
	
	private JButton jBComma;
	private JButton[] jBVariable;
	private JButton jNext;
	private int NoOfMatrix=0;
	private int[] sizeA=new int[2];
	private int[] sizeB=new int[2];
	private int[] sizeC=new int[2];
	private int[] sizeD=new int[2];
	private int countA=0;
	private int countB=0;
	private int countC=0;
	private int countD=0;
	private String A="[[";
	private String B="[[";
	private String C="[[";
	private String D="[[";
	private JLabel jIndicator;
	private JTextField[] jVariableTextField;
	private JTextField jTextFieldSelect;
	
    private JTextArea jLabelDisplay;
    private JTextField jTextDisplay;
    private String inputString;
    private String number;
  	private boolean shiftOn;
  	private double memory;
  	private String ans;

	public MatrixCalc() {
		inputString="";
    	number="";
    	shiftOn=false;
    	memory=0;
    	ans="";
		initialize();
		super.selMode[1].setSelected(true);
	}

	private void initialize() {
		mcGUI = new MatrixCalcGUI();

		jBNumerical = mcGUI.jBNumerical;					
		jBPoint = mcGUI.jBPoint;							
		jBOperator = mcGUI.jBOperator;					
		jBFunction = mcGUI.jBFunction;		
		jBShift = mcGUI.jBShift;							
		jBMemory = mcGUI.jBMemory;						
		jBBracket = mcGUI.jBBracket;						
		jBClear = mcGUI.jBClear; 
		///////
		jBComma = mcGUI.jBComma;
		jBVariable = mcGUI.jBVariable;
		jNext=mcGUI.jNext;
		jIndicator=mcGUI.jIndicator;
		jVariableTextField=mcGUI.jVariableText;
		jTextFieldSelect=jTextDisplay;
		//////
        jLabelDisplay = mcGUI.jLabelDisplay;
        jTextDisplay = mcGUI.jTextDisplay;
        
        //set w,x,y,z empty
        for(int i=0; i<4; i++) {
    		jVariableTextField[i].setText("");
    	}
        
        //Matrix Size
    	sizeA[0]=sizeA[1]=0;
    	sizeB[0]=sizeB[1]=0;
    	sizeC[0]=sizeC[1]=0;
    	sizeD[0]=sizeD[1]=0;
        
        //Next 
        jNext.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	jNextActionPerformed(evt);
	        }
	    });
		//Numeric Buttons
		for(int i=0; i<10; i++){
			jBNumerical[i].addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	            	jBNumericalActionPerformed(evt);
	            }
	        });
		}
		
		//Point
		jBPoint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	jBNumericalActionPerformed(evt);
            }
        });
		
		//Comma
		jBComma.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	jBNumericalActionPerformed(evt);
	        }
	    });
			
		//Operator Buttons
		for(int i=0; i<7; i++){
			jBOperator[i].addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	            	jBOperator(evt);
	            }
	        });
		}
		
		//Variable Text Field
				jTextDisplay.addMouseListener(new MouseAdapter(){
			        public void mouseClicked(MouseEvent e){
			            jTextFieldSelect=jTextDisplay;
			            if(!(jIndicator.getText().contentEquals("Enter Expression"))) jNext.setEnabled(true);
			            //jTextFieldSelect.setText("selected");
			        }
			    });
				jVariableTextField[0].addMouseListener(new MouseAdapter(){
			        public void mouseClicked(MouseEvent e){
			            jTextFieldSelect=jVariableTextField[0];
			            jNext.setEnabled(false);
			            //jTextFieldSelect.setText("selected");
			        }
			    });
				jVariableTextField[1].addMouseListener(new MouseAdapter(){
			        public void mouseClicked(MouseEvent e){
			            jTextFieldSelect=jVariableTextField[1];
			            jNext.setEnabled(false);
			            //jTextFieldSelect.setText("selected");
			        }
			    });
				jVariableTextField[2].addMouseListener(new MouseAdapter(){
			        public void mouseClicked(MouseEvent e){
			            jTextFieldSelect=jVariableTextField[2];
			            jNext.setEnabled(false);
			            //jTextFieldSelect.setText("selected");
			        }
			    });
				jVariableTextField[3].addMouseListener(new MouseAdapter(){
			        public void mouseClicked(MouseEvent e){
			            jTextFieldSelect=jVariableTextField[3];
			            jNext.setEnabled(false);
			            //jTextFieldSelect.setText("selected");
			        }
			    });
				jTextFieldSelect=jTextDisplay;
		
		
		//Variable Buttons
		for(int i=0; i<8; i++) {
			jBVariable[i].addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	            	jBOperator(evt);
	            }
	        });
		}
		
		//Function Buttons
		for(int i=0; i<30; i++){	
			jBFunction[i].addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	            	jBOperator(evt);
	            }
	        });
		}

		//Shift button
		jBShift.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	jBShiftActionPerformed(evt);
            }
        });
			
		//Memory Buttons
		for(int i=0; i<2; i++){
			jBMemory[i].addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	            	jBMemoryActionPerformed(evt);
	            }
	        });
		}
		
		//bracket button
		for(int i=0; i<2; i++){
			jBBracket[i].addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	            	jBOperator(evt);
	            }
	        });
		}
		
		//Clear Buttons
		for(int i=0; i<3; i++){
			jBClear[i].addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	            	jBClearActionPerformed(evt);
	            }
	        });
		}
		
		super.gui.add(mcGUI);
		super.gui.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		super.gui.setTitle("Advanced Calculator");
		super.gui.setResizable(false);
		super.gui.setBounds(230, 115, 685, 400);
		super.gui.setFocusable(true);
		
		//GetInputMatrix();
	}

	/*//get input matrix
	private void getMatrices(){
		mcGUI.getMatrix(sizeA,sizeB,sizeC,sizeD);
	}
	*/
	
	// Action Events 
	private void jNextActionPerformed(ActionEvent evt){
		//No. of Matrices
		if(jIndicator.getText().contentEquals("Number of Matrices (up to 4)")){
			
			try{
				NoOfMatrix=Integer.parseInt(jTextDisplay.getText());
				if(NoOfMatrix<1 || NoOfMatrix>4) {
					throw new Exception("sizeError");
				}
				jIndicator.setText("Size of Matrix A (m x n), m = ");
			}
			catch(Exception e) {
				new Message("Enter valid number!",-1);
			}
		}
		//SizeA
		else if(jIndicator.getText().contentEquals("Size of Matrix A (m x n), m = ")){
			try{
				sizeA[0]=Integer.parseInt(jTextDisplay.getText());
				if(sizeA[0]<1 || sizeA[0]>30) {
					throw new Exception("sizeError");
				}
				jIndicator.setText("Size of Matrix A (m x n), n = ");
			}
			catch(Exception e) {
				new Message("Enter valid size!",-1);
			}
		}
		else if(jIndicator.getText().contentEquals("Size of Matrix A (m x n), n = ")){
			try{
				sizeA[1]=Integer.parseInt(jTextDisplay.getText());
				if(sizeA[1]<1 || sizeA[1]>30) {
					throw new Exception("sizeError");
				}
				if(NoOfMatrix>1) 
					jIndicator.setText("Size of Matrix B (m x n), m = ");
				else 
					jIndicator.setText("A(1,1) = ");
			}
			catch(Exception e) {
				new Message("Enter valid size!",-1);
			}
		}
		//SizeB
		else if(jIndicator.getText().contentEquals("Size of Matrix B (m x n), m = ")){
			try{
				sizeB[0]=Integer.parseInt(jTextDisplay.getText());
				if(sizeB[0]<1 || sizeB[0]>30) {
					throw new Exception("sizeError");
				}
				jIndicator.setText("Size of Matrix B (m x n), n = ");
			}
			catch(Exception e) {
				new Message("Enter valid size!",-1);
			}
		}
		else if(jIndicator.getText().contentEquals("Size of Matrix B (m x n), n = ")){
			try{
				sizeB[1]=Integer.parseInt(jTextDisplay.getText());
				if(sizeB[1]<1 || sizeB[1]>30) {
					throw new Exception("sizeError");
				}
				if(NoOfMatrix>2) 
					jIndicator.setText("Size of Matrix C (m x n), m = ");
				else 
					jIndicator.setText("A(1,1) = ");
			}
			catch(Exception e) {
				new Message("Enter valid size!",-1);
			}
		}
		//SizeC
		else if(jIndicator.getText().contentEquals("Size of Matrix C (m x n), m = ")){
			try{
				sizeC[0]=Integer.parseInt(jTextDisplay.getText());
				if(sizeC[0]<1 || sizeC[0]>30) {
					throw new Exception("sizeError");
				}
				jIndicator.setText("Size of Matrix C (m x n), n = ");
			}
			catch(Exception e) {
				new Message("Enter valid size!",-1);
			}
		}
		else if(jIndicator.getText().contentEquals("Size of Matrix C (m x n), n = ")){
			try{
				sizeC[1]=Integer.parseInt(jTextDisplay.getText());
				if(sizeC[1]<1 || sizeC[1]>30) {
					throw new Exception("sizeError");
				}
				if(NoOfMatrix>3) 
					jIndicator.setText("Size of Matrix D (m x n), m = ");
				else 
					jIndicator.setText("A(1,1) = ");
			}
			catch(Exception e) {
				new Message("Enter valid size!",-1);
			}
		}
		//SizeD
		else if(jIndicator.getText().contentEquals("Size of Matrix D (m x n), m = ")){
			try{
				sizeD[0]=Integer.parseInt(jTextDisplay.getText());
				if(sizeD[0]<1 || sizeD[0]>30) {throw new Exception("sizeError");}
				jIndicator.setText("Size of Matrix D (m x n), n = ");
			}
			catch(Exception e) {
				new Message("Enter valid size!",-1);
			}
		}
		else if(jIndicator.getText().contentEquals("Size of Matrix D (m x n), n = ")){
			try{
				sizeD[1]=Integer.parseInt(jTextDisplay.getText());
				if(sizeD[1]<1 || sizeD[1]>30) {
					throw new Exception("sizeError");
				}
				jIndicator.setText("A(1,1) = ");
			}
			catch(Exception e) {
				new Message("Enter valid size!",-1);
			}
		}
		//input A
		else if(countA<sizeA[0]*sizeA[1]) {
			try {
				A = A+jTextDisplay.getText();
				countA++;
				if(countA%sizeA[1]==0) {
					if(countA==sizeA[0]*sizeA[1]) 
						A=A+"]]";
					else 
						A=A+"],[";
				}
				else 
					A=A+',';
				jIndicator.setText("A("+(countA/sizeA[1]+1)+","+(countA%sizeA[1]+1)+") =");
				if(countA==sizeA[0]*sizeA[1]) {
					if(NoOfMatrix==1) 
						jIndicator.setText("Enter Expression");
					else 
						jIndicator.setText("B(1,1) = ");
				}
			}
			catch(Exception e) {new Message("Enter valid input!",-1);}
		}
		//input B
		else if(countB<sizeB[0]*sizeB[1]) {
			try {
				B=B+jTextDisplay.getText()+" ";
				countB++;
				if(countB%sizeB[1]==0) {
					if(countB==sizeB[0]*sizeB[1]) 
						B=B+"]]";
					else 
						B=B+"],[";
				}
				else 
					B=B+',';
				jIndicator.setText("B("+(countB/sizeB[1]+1)+","+(countB%sizeB[1]+1)+") =");
				if(countB==sizeB[0]*sizeB[1]) {
					if(NoOfMatrix==2) jIndicator.setText("Enter Expression");
					else jIndicator.setText("C(1,1) = ");
				}
			}
			catch(Exception e) {new Message("Enter valid input!",-1);}
		}
		//input C
		else if(countC<sizeC[0]*sizeC[1]) {
			try {
				C=C+jTextDisplay.getText()+" ";
				countC++;
				if(countC%sizeC[1]==0){
					if(countC==sizeC[0]*sizeC[1]) 
						C=C+"]]";
					else 
						C=C+"],[";
				}
				else 
					C=C+',';
				jIndicator.setText("C("+(countC/sizeC[1]+1)+","+(countC%sizeC[1]+1)+") =");
				if(countC==sizeC[0]*sizeC[1]) {
					if(NoOfMatrix==3) jIndicator.setText("Enter Expression");
					else jIndicator.setText("D(1,1) = ");
				}
			}
			catch(Exception e) {new Message("Enter valid input!",-1);}
		}
		//input D
		else if(countD<sizeD[0]*sizeD[1]) {
			try {
				D=D+jTextDisplay.getText()+" ";
				countD++;
				if(countD%sizeD[1]==0){
					if(countD==sizeD[0]*sizeD[1]) 
						D=D+"]]";
					else 
						D=D+"],[";
				}
				else 
					D=D+',';
				jIndicator.setText("D("+(countD/sizeD[1]+1)+","+(countD%sizeD[1]+1)+") =");
				if(countD==sizeD[0]*sizeD[1]) {
					if(NoOfMatrix==4) jIndicator.setText("Enter Expression");
				}
			}
			catch(Exception e) {new Message("Enter valid input!",-1);}
		}
		
		if(jIndicator.getText().contentEquals("A(1,1) = ")) {
			for(int i=4;i<8;i++) {
				jBVariable[i].setEnabled(true);
			}
		}
		
		if(jIndicator.getText().contentEquals("Enter Expression")) {
			jNext.setEnabled(false);
			jBVariable[0].setEnabled(true);
			if(NoOfMatrix>1) jBVariable[1].setEnabled(true);
			if(NoOfMatrix>2) jBVariable[2].setEnabled(true);
			if(NoOfMatrix>3) jBVariable[3].setEnabled(true);
			jBOperator[5].setEnabled(true);
			jBFunction[25].setEnabled(true);
			jBFunction[26].setEnabled(true);
			jBFunction[27].setEnabled(true);
			jBFunction[28].setEnabled(true);
			jBFunction[29].setEnabled(true);
			jTextDisplay.setText("");
		}
		jTextDisplay.setText("");
	}
	
	//numerical buttons
	private void jBNumericalActionPerformed(ActionEvent evt){
		inputString=jTextFieldSelect.getText();
		if(inputString.length()<100){
			if(!(number.contains(".") && evt.getActionCommand().equals("."))){
				inputString=inputString + evt.getActionCommand();	
				number=number+evt.getActionCommand();
			}
		}
		jTextFieldSelect.setText(inputString);
	}
	
	
	//operator buttons
	private void jBOperator(ActionEvent evt){
		inputString=jTextFieldSelect.getText();
		if(evt.getActionCommand().equals("=")){
			
			if(jTextDisplay.getText().equals("")) {
				jLabelDisplay.setText("0.0000000");
			}
			else {
				String w = jVariableTextField[0].getText();
				String x = jVariableTextField[1].getText();
				String y=jVariableTextField[2].getText();
				String z=jVariableTextField[3].getText();
				if(A=="[[") A="[]";
				if(B=="[[") B="[]";
				if(C=="[[") C="[]";
				if(D=="[[") D="[]";
				String result = evaluator.evaluate(A,B,C,D,w,x,y,z,jTextDisplay.getText());
				jLabelDisplay.setText(result);
				if(!result.equals("")) 
					ans=result;
			}
		}
		else{
			if(inputString.length()<120){
				String actionCommand=evt.getActionCommand();
				
				if(actionCommand=="pi"){
					inputString=inputString + "pi";
				}else if(actionCommand=="E"){
					inputString=inputString + "E";
				}else if(actionCommand=="Abs"){
					inputString=inputString + "Abs(";
				}else if(actionCommand=="Ans"){
					inputString=inputString+ans;
				}else if(actionCommand=="log"){
					inputString=inputString + "log(";
				}else if(actionCommand=="bin(n,r)"){
					inputString=inputString + "binomial(";
				}else if(actionCommand=="n!"){
					inputString=inputString + "fact(";
				}else if(actionCommand=="ln"){
					inputString=inputString + "ln(";
				}else if(actionCommand=="E^"){
					inputString=inputString + "E^";
				}else if(actionCommand=="sqrt"){
					inputString=inputString + "sqrt(";
				}else if(actionCommand=="cbrt"){
					inputString=inputString + "cbrt(";
				}else if(actionCommand=="cos"){
					inputString=inputString + "cos(";
				}else if(actionCommand=="sin"){
					inputString=inputString + "sin(";
				}else if(actionCommand=="tan"){
					inputString=inputString + "tan(";
				}else if(actionCommand=="cosh"){
					inputString=inputString + "cosh(";
				}else if(actionCommand=="sinh"){
					inputString=inputString + "sinh(";
				}else if(actionCommand=="tanh"){
					inputString=inputString + "tanh(";
				}else if(actionCommand=="acos"){
					inputString=inputString + "acos(";
				}else if(actionCommand=="asin"){
					inputString=inputString + "asin(";
				}else if(actionCommand=="atan"){
					inputString=inputString + "atan(";
				}else if(actionCommand=="acosh"){
					inputString=inputString + "acosh(";
				}else if(actionCommand=="asinh"){
					inputString=inputString + "asinh(";
				}else if(actionCommand=="atanh"){
					inputString=inputString + "atanh(";
				}else if(actionCommand=="Adjoint"){
					inputString=inputString + "Adj(";
				}else if(actionCommand=="Inverse"){
					inputString=inputString + "Inv(";
				}else if(actionCommand=="Determinant"){
					inputString=inputString + "det(";
				}else if(actionCommand=="Eigen Value"){
					inputString=inputString + "EigenVals(";
				}else if(actionCommand=="Transpose"){
					inputString=inputString + "T(";
				}else{
					if(actionCommand.equals("*")){
						actionCommand="*";
					}else if(actionCommand.equals("r")){
						actionCommand="sqrt(";
					}
					
					inputString=inputString + actionCommand ;
				}
			}
			jTextFieldSelect.setText(inputString);
		}
		number=""; 
	}
	
	//Shift
	private void jBShiftActionPerformed(ActionEvent evt){
		if(!shiftOn){
			shiftOn=true;
			
			jBFunction[0].setLocation(1000, 320); 
			jBFunction[1].setLocation(1000, 320); 
			jBFunction[2].setLocation(270, 320); 
			jBFunction[3].setLocation(324, 320); 
			jBFunction[6].setLocation(1000, 280);
			jBFunction[7].setLocation(1000, 280);
			jBFunction[8].setLocation(270, 280);
			jBFunction[9].setLocation(324, 280);
			jBFunction[12].setLocation(1000, 240);
			jBFunction[13].setLocation(1000, 240);
			jBFunction[14].setLocation(270, 240);
			jBFunction[15].setLocation(324, 240);
			
			///
			jBFunction[4].setLocation(1000, 320);
			jBFunction[10].setLocation(1000, 280);
			jBFunction[16].setLocation(1000, 240);
			jBFunction[22].setLocation(378, 320);
			jBFunction[23].setLocation(378, 280);
			jBFunction[24].setLocation(378, 240);
			
			jBShift.setBackground(new java.awt.Color(255, 255, 225));
			jBShift.setText("<~Shift~>");
		}else{
			shiftOn=false;
			
			jBFunction[0].setLocation(270, 320);
			jBFunction[1].setLocation(324, 320);
			jBFunction[2].setLocation(1000, 320);
			jBFunction[3].setLocation(1000, 320);
			jBFunction[6].setLocation(270, 280);
			jBFunction[7].setLocation(324, 280);
			jBFunction[8].setLocation(1000, 280);
			jBFunction[9].setLocation(1000, 280);
			jBFunction[12].setLocation(270, 240);
			jBFunction[13].setLocation(324, 240);
			jBFunction[14].setLocation(1000, 240);
			jBFunction[15].setLocation(1000, 240);
			
			///
			jBFunction[4].setLocation(378, 320);
			jBFunction[10].setLocation(378, 280);
			jBFunction[16].setLocation(378, 240);
			jBFunction[22].setLocation(1000, 320);
			jBFunction[23].setLocation(1000, 280);
			jBFunction[24].setLocation(1000, 240);
			
			jBShift.setBackground(new java.awt.Color(178, 190, 200));
			jBShift.setText("Shift");
		}
	}
	
	//memory buttons
	private void jBMemoryActionPerformed(ActionEvent evt){
		inputString = jTextDisplay.getText();
		if(evt.getActionCommand()=="M" || evt.getActionCommand().equals("m")){
			number = number + memory;
			inputString=inputString+memory;
			jTextDisplay.setText(inputString);
		}
		else if(evt.getActionCommand()=="MS" || evt.getActionCommand().equals("s")){
			if(jLabelDisplay.getText().length()>0){
				try {
					memory = Double.parseDouble(jLabelDisplay.getText());
				}
				catch(Exception e) {
					memory = 0;
				}
			}
		}
	}
	
	//clear button
	private void jBClearActionPerformed(ActionEvent evt){
		inputString=jTextFieldSelect.getText();
		if(evt.getActionCommand()=="<B" || evt.getActionCommand().equals("\b")){
			if(inputString.length()>0){
				inputString=inputString.substring(0, inputString.length()-1);
			}
			if(number.length()>0){
				number=number.substring(0, number.length()-1);
			}
			jTextFieldSelect.setText(inputString);
		}
		else if(evt.getActionCommand()=="C" || evt.getActionCommand().equals("c") || evt.getActionCommand()=="AC" || evt.getActionCommand().equals("a")){
			inputString="";
			number="";
			jTextDisplay.setText("");
			jLabelDisplay.setText("");
			if(evt.getActionCommand()=="AC" || evt.getActionCommand().equals("a")) {
				for(int i=0; i<4; i++) {
					jVariableTextField[i].setText("");
				}
				A = B = C = D = "[[";
				sizeA[0]=sizeB[0]=sizeC[0]=sizeD[0]=0;
				sizeA[1]=sizeB[1]=sizeC[1]=sizeD[1]=0;
				NoOfMatrix = countA = countB = countC = countD = 0;
				jIndicator.setText("Number of Matrices (up to 4)");
				jBFunction[5].setEnabled(false);
				jNext.setEnabled(true);
				for(int i=0; i<4; i++) {
					jBFunction[25+i].setEnabled(false);
					jBVariable[i].setEnabled(false);
				}
				jBFunction[29].setEnabled(false);
			}
		}
	}
}

