package calculators.expressionPlotter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import mainFrame.AdvCalcFrame;
import notifications.Message;

public class ExprPlotter extends AdvCalcFrame{

	private ExprPlotterGUI epGUI;
	
	private ExprPlotterEval plotter; 

	private JButton[] jBNumerical;
	private JButton[] jBOperator;
	private JButton[] jBFunction;
	private JButton[] jBBracket;
	private JButton[] jBClear;
	private JButton jBPoint;
	
	private JButton jBComma;
	private JButton jBVariable;
	private JTextField jTextFieldSelect;
	
    private JTextField jTextDisplay;
    private String inputString;
    private String number;
  	private String ans;

	public ExprPlotter() {
		inputString="";
    	number="";
    	ans="";
    	
		initialize();
		super.selMode[4].setSelected(true);
	}

	private void initialize() {
		epGUI = new ExprPlotterGUI();
		plotter = new ExprPlotterEval();
		jBNumerical = epGUI.jBNumerical;					
		jBPoint = epGUI.jBPoint;							
		jBOperator = epGUI.jBOperator;					
		jBFunction = epGUI.jBFunction;															
		jBBracket = epGUI.jBBracket;						
		jBClear = epGUI.jBClear; 
		///////
		jBComma = epGUI.jBComma;
		jTextDisplay = epGUI.jTextDisplay;
		jTextFieldSelect=jTextDisplay;
		jBVariable=epGUI.jBVariable;
		

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
	            //jTextFieldSelect.setText("selected");
	        }
	    });
		jTextFieldSelect=jTextDisplay;
		
		//Variable Buttons

		jBVariable.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	           	jBOperator(evt);
	            }
	      });
		
		
		//Function Buttons
		for(int i=0; i<25; i++){	
			jBFunction[i].addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	            	jBOperator(evt);
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

		super.gui.add(epGUI);
		super.gui.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		super.gui.setTitle("Advanced Calculator");
		super.gui.setResizable(false);
		super.gui.setBounds(230, 115, 500, 410);
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
			
				if(!(jTextDisplay.getText().equals(""))) {
					//new Message(jTextFieldSelect.getText(),-1);
					plotter.plot(jTextDisplay.getText());
				}
				else {
					new Message("Please Enter Expression!",-1);
				}
				
				
			///
		}
		else{
			if(number.length()>0){
				//inputString=inputString + " ";
			}
			
			if(inputString.length()<120){
				String actionCommand=evt.getActionCommand();
				
				if(actionCommand=="pi"){
					inputString=inputString + "3.141592654";
				}else if(actionCommand=="E"){
					inputString=inputString + "2.718281828";
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
					inputString=inputString + "2.718281828^";
				}else if(actionCommand=="sqrt"){
					inputString=inputString + "sqrt(";
				}else if(actionCommand=="cos"){
					inputString=inputString + "cos(";
				}else if(actionCommand=="sin"){
					inputString=inputString + "sin(";
				}else if(actionCommand=="tan"){
					inputString=inputString + "tan(";
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
			jTextDisplay.setText(inputString);

	}
	
	}
	
	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception ex) {
			// do nothing if operation is unsuccessful
		}

		new ExprPlotter();
	}
}


