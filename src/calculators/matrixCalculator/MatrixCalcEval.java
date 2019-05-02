package calculators.matrixCalculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import notifications.Message;

public class MatrixCalcEval{
	public String evaluate(String A, String B, String C, String D, String w, 
			String x, String y, String z, String exp){
		String ans = new String();
		try {
			FileWriter ofstream = new FileWriter("input.txt");
			FileReader ifstream = new FileReader("output.txt");
		    BufferedWriter out = new BufferedWriter(ofstream);
		    out.write(w+"\n"+x+"\n"+y+"\n"+z+"\n"+A+"\n"+B+"\n"+C+"\n"+D+"\n"+exp+"\n");
		    out.close();
			Runtime.getRuntime().exec("python py_scripts/matrix.py").waitFor();
			BufferedReader in = new BufferedReader(ifstream);
			int i;
			ans = "";
	        while((i = in.read())!=-1){  
	        	ans = ans+(char)i; 
	        }  
	        in.close();
			if(ans.equals("Error")) {
				new Message("Syntax Error! \nEnter a valid expression.", -1);
				return "";
			}
			else if(ans.contains("zoo")) {
				new Message("Math Error! \nCan't divide by zero.", -1);
				return "";
			}
			else if(ans.contains("I")) {
				new Message("Math Error! \nExpression can't be evaluated.", -1);
				return "";
			}
			return ans;
		}
		catch(Exception e) {
			new Message("Syntax Error! \nEnter a valid expression.", -1);
			return "";
        }
	}
}