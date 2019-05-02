package calculators.differentialCalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import mainFrame.AdvCalcFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class DifferentialCalc extends AdvCalcFrame{

	private DifferentialCalcGUI dcGUI;
	
	private DifferentialCalcEval evaluator = new DifferentialCalcEval(); 

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
	private JTextField jTextFieldSelect;
	private JTextField[] jVariableTextField;
	private JTextField jxTextField;
	
    private JTextField jLabelDisplay;
    private JTextField jTextDisplay;
    private String inputString;
    private String number;
  	private boolean shiftOn;
  	private double memory;
  	private String ans;

	public DifferentialCalc() {
		inputString="";
    	number="";
    	shiftOn=false;
    	memory=0;
    	ans="";
		initialize();
		super.selMode[3].setSelected(true);
	}

	private void initialize() {
		dcGUI = new DifferentialCalcGUI();

		jBNumerical = dcGUI.jBNumerical;					
		jBPoint = dcGUI.jBPoint;							
		jBOperator = dcGUI.jBOperator;					
		jBFunction = dcGUI.jBFunction;		
		jBShift = dcGUI.jBShift;							
		jBMemory = dcGUI.jBMemory;						
		jBBracket = dcGUI.jBBracket;						
		jBClear = dcGUI.jBClear; 

		jBComma = dcGUI.jBComma;
		jBVariable = dcGUI.jBVariable;
		jTextFieldSelect=jTextDisplay;
		jVariableTextField=dcGUI.jVariableText;
		jxTextField=dcGUI.jxTextField;
		
		jxTextField.setText("");
		for(int i=0; i<4; i++) {
    		jVariableTextField[i].setText("");
    	}

        jLabelDisplay = dcGUI.jLabelDisplay;
        jTextDisplay = dcGUI.jTextDisplay;

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
	        }
	    });
		jVariableTextField[0].addMouseListener(new MouseAdapter(){
	        public void mouseClicked(MouseEvent e){
	            jTextFieldSelect=jVariableTextField[0];
	        }
	    });
		jVariableTextField[1].addMouseListener(new MouseAdapter(){
	        public void mouseClicked(MouseEvent e){
	            jTextFieldSelect=jVariableTextField[1];
	        }
	    });
		jVariableTextField[2].addMouseListener(new MouseAdapter(){
	        public void mouseClicked(MouseEvent e){
	            jTextFieldSelect=jVariableTextField[2];
	        }
	    });
		jVariableTextField[3].addMouseListener(new MouseAdapter(){
	        public void mouseClicked(MouseEvent e){
	            jTextFieldSelect=jVariableTextField[3];
	        }
	    });
		jxTextField.addMouseListener(new MouseAdapter(){
	        public void mouseClicked(MouseEvent e){
	            jTextFieldSelect=jxTextField;
	        }
	    });

		jTextFieldSelect=jTextDisplay;
		
		//Variable Buttons
		for(int i=0; i<4; i++) {
			jBVariable[i].addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	            	jBOperator(evt);
	            }
	        });
		}
		
		//Function Buttons
		for(int i=0; i<25; i++){	
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
		
		super.gui.add(dcGUI);
		super.gui.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		super.gui.setTitle("Advanced Calculator");
		super.gui.setResizable(false);
		super.gui.setBounds(230, 115, 590, 420);
		super.gui.setFocusable(true);
	}

	// Action Events
	
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
			if(jVariableTextField[0].getText().equals("")) {
				jVariableTextField[0].setText("0");
			}
			if(jVariableTextField[1].getText().equals("")) {
				jVariableTextField[1].setText("0");
			}
			if(jVariableTextField[2].getText().equals("")) {
				jVariableTextField[2].setText("0");
			}
			if(jVariableTextField[3].getText().equals("")) {
				jVariableTextField[3].setText("0");
			}
			if(jTextDisplay.getText().equals("")) {
				jLabelDisplay.setText("0.0000000");
			}
			else {
				String result = evaluator.differentiate(jTextDisplay.getText(),
						jVariableTextField[0].getText(),jVariableTextField[1].getText(),
						jVariableTextField[2].getText(),jVariableTextField[3].getText(),
						jxTextField.getText());
				jLabelDisplay.setText(result);
				if(!result.equals("")) ans=result;
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
				}else if(actionCommand=="10^"){
					inputString=inputString + "10^(";
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
			
			jBFunction[0].setLocation(600, 320); 
			jBFunction[1].setLocation(600, 320); 
			jBFunction[2].setLocation(270, 320); 
			jBFunction[3].setLocation(324, 320); 
			jBFunction[6].setLocation(600, 280);
			jBFunction[7].setLocation(600, 280);
			jBFunction[8].setLocation(270, 280);
			jBFunction[9].setLocation(324, 280);
			jBFunction[12].setLocation(600, 240);
			jBFunction[13].setLocation(600, 240);
			jBFunction[14].setLocation(270, 240);
			jBFunction[15].setLocation(324, 240);
			
			jBFunction[4].setLocation(600, 320);
			jBFunction[10].setLocation(600, 280);
			jBFunction[16].setLocation(600, 240);
			jBFunction[22].setLocation(378, 320);
			jBFunction[23].setLocation(378, 280);
			jBFunction[24].setLocation(378, 240);
			
			jBShift.setBackground(new java.awt.Color(255, 255, 225));
			jBShift.setText("<~Shift~>");
		}else{
			shiftOn=false;
			
			jBFunction[0].setLocation(270, 320);
			jBFunction[1].setLocation(324, 320);
			jBFunction[2].setLocation(600, 320);
			jBFunction[3].setLocation(600, 320);
			jBFunction[6].setLocation(270, 280);
			jBFunction[7].setLocation(324, 280);
			jBFunction[8].setLocation(600, 280);
			jBFunction[9].setLocation(600, 280);
			jBFunction[12].setLocation(270, 240);
			jBFunction[13].setLocation(324, 240);
			jBFunction[14].setLocation(600, 240);
			jBFunction[15].setLocation(600, 240);
			
			jBFunction[4].setLocation(378, 320);
			jBFunction[10].setLocation(378, 280);
			jBFunction[16].setLocation(378, 240);
			jBFunction[22].setLocation(600, 320);
			jBFunction[23].setLocation(600, 280);
			jBFunction[24].setLocation(600, 240);
			
			jBShift.setBackground(new java.awt.Color(178, 190, 200));
			jBShift.setText("Shift");
		}
	}
	
	//memory buttons
	private void jBMemoryActionPerformed(ActionEvent evt){
		inputString=jTextFieldSelect.getText();
		if(evt.getActionCommand()=="M" || evt.getActionCommand().equals("m")){
			number=number+memory;
			inputString=inputString+memory;
			jTextFieldSelect.setText(inputString);
		}else if(evt.getActionCommand()=="MS" || evt.getActionCommand().equals("s")){
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
		}else if(evt.getActionCommand()=="C" || evt.getActionCommand().equals("c")){
			inputString="";
			number="";
			jTextDisplay.setText("");
			jLabelDisplay.setText("");
		}else if(evt.getActionCommand()=="AC" || evt.getActionCommand().equals("a")){
			inputString="";
			number="";
			jTextDisplay.setText("");
			jLabelDisplay.setText("");
			memory = 0;
			jVariableTextField[0].setText("");
			jVariableTextField[1].setText("");
			jVariableTextField[2].setText("");
			jVariableTextField[3].setText("");
			jxTextField.setText("");
		}
	}
}

