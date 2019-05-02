package calculators.differentialCalculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

import notifications.Message;

public class DifferentialCalcEval{
	public String differentiate(String exp,String a,String b,String c,String d,String x){
		String ans=new String();
		try {
			FileWriter fstream = new FileWriter("input.txt");
		    BufferedWriter out = new BufferedWriter(fstream);
		    out.write(exp+"\n"+a+"\n"+b+"\n"+c+"\n"+d+"\n"+x+"\n");
		    out.close();
			Process p = Runtime.getRuntime().exec("python py_scripts/differentiate.py");
			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			ans = in.readLine();
			if(ans.equals("Error")) {
				new Message("Syntax Error! \nEnter a valid expression.", -1);
				return "";
			}
			else if(ans.equals("zoo")) {
				new Message("Math Error! \nCan't divide by zero.", -1);
				return "";
			}
			else if(ans.contains("Derivative")) {
				new Message("Error! \nDerivative doesn't exist.", -1);
				return "";
			}
			else if(ans.equals("inf") || ans.equals("-inf")) {
				new Message("Sorry! \nValue out of bounds.", -2);
				return "";
			}
			else if(ans.contains("I")) {
				new Message("Math Error! \nExpression can't be evaluated.", -1);
				return "";
			}
		}
		catch(Exception e) {
			new Message("Syntax Error! \nEnter a valid expression.", -1);
			return "";
        }
		return ans;
	}
}