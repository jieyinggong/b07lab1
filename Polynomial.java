import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintStream;

public class Polynomial{
	double[] coe;
	int[] exp;
	
	public Polynomial() {
		this.coe = new double[] {0};
		this.exp = new int[] {0};
			}
	
	public Polynomial(double []coe, int[] exp) {
		this.coe = coe;
		this.exp= exp;
	}
	
	public Polynomial(File poly) throws Exception {
		BufferedReader input=new BufferedReader(new FileReader(poly));
		String line= input.readLine();
		String[] terms = line.split("(?=[-+])");
		int len=terms.length;
		double[] coe= new double[len];
		int[] exp=new int[len];
		for (int i=0;i<len;i++) {
			if (terms[i].contains("x")) {
			String[] separate= terms[i].split("x");
			//coefficents 
			if (separate[0].equals("+")||separate[0].equals("-")||separate[0].isEmpty()) {
				coe[i]=Double.parseDouble(separate[0]+"1");
			}
			else {
			coe[i]=Double.parseDouble(separate[0]);}
			//exponents
			if (separate.length>1) {
			exp[i]=Integer.parseInt(separate[1]);
			}
			else {exp[i]=1;}
			}
			//constant(x is not present)
			else {
				coe[i]=Double.parseDouble(terms[i]);
				exp[i]=0;
			}
		}
		this.coe=coe;
		this.exp=exp;
		input.close();
	}
	
	
	public int Highest_exponent() {
		// if exp is an empty array return -1 
		if (this.exp.length==0) {
			return -1;
		}
		
		int max=0;
		
		for (int i=0; i < this.exp.length; i++) {
			if(this.exp[i] > max) {
				max=this.exp[i];
			}
		}
		return max;
	}
	
	public Polynomial create_nozeroterm(double[] coefficients) {
		int non_zero=0;
	    for (int i=0; i<coefficients.length; i++) {
	    	if (coefficients[i]!=0) {
	    		non_zero++;
	    	}
	    }
	    int[] new_exp=new int[non_zero];
	    double[] update_coe=new double[non_zero];
	    int k=0;
	    for (int i=0; i<coefficients.length;i++) {
	    	if (coefficients[i]!=0) {
	    		new_exp[k]=i;
	    		update_coe[k]=coefficients[i];
	    		k++;
	    	}
	    }
	    return new Polynomial(update_coe, new_exp);
	}
	 	//method named add that takes one argument of type Polynomial and 
		//returns the Polynomial resulting from adding the calling object and the argument
	
	public Polynomial add(Polynomial other) {
	    int highest_exp = Math.max(this.Highest_exponent(), other.Highest_exponent()); 
	    double [] new_coe=new double[highest_exp+1];
	    		
	    for (int i=0; i < this.coe.length; i++) {
	    	new_coe[this.exp[i]]+=this.coe[i];
	    	}
	    for (int i=0; i< other.coe.length; i++) {
	    	new_coe[other.exp[i]]+=other.coe[i];
	    }
	    
	    Polynomial new_poly=create_nozeroterm(new_coe);
	    
		return new_poly;
		}
	
		public Polynomial multiply(Polynomial other) {
		int highest_exp = this.Highest_exponent() + other.Highest_exponent(); 
		double[] new_coe=new double[highest_exp+1];
		for (int i=0;i<this.exp.length;i++) {
		    for (int j=0;j<other.exp.length;j++) {
		    	new_coe[this.exp[i]+other.exp[j]]+=this.coe[i]*other.coe[j];
		    }
		}
		
		 Polynomial new_poly=create_nozeroterm(new_coe);
		    
			return new_poly;
		}
	
	public double evaluate(double x) {
		
		double result=0.0;
		
		for (int i=0; i<this.coe.length; i++) {
			double x_power = Math.pow(x, this.exp[i]);
			result += coe[i]*x_power;
		}
		return result;		
	}
	
		/*
		 * It has a method named hasRoot that takes one argument of type double and
		 * determines whether this value is a root of the Polynomial or not. Note that a
		 * root is a value of x for which the Polynomial evaluates to zero.
		 */
	public boolean hasRoot(double root) {
		double result = this.evaluate(root);
	 return result == 0.0;
	}
	
	public void saveToFile(String name) throws Exception{
	 File file=new File(name);
	 String poly=new String(); 
	 
	 for (int i=0;i<this.coe.length;i++) {
		 //coefficients
	 if (i !=0 && this.coe[i] > 0 ) {
		 poly+="+"+this.coe[i];}
	else {poly+=this.coe[i];}
	    // exponents
	 if (this.exp[i]!=0 && this.exp[i]!=1) {
		 poly=poly+"x"+this.exp[i];
	 }else if (exp[i] == 1) {
		 poly=poly+"x";
	 }
	 }
	  
     PrintStream ps=new PrintStream(file);
     ps.println(poly);
     ps.close();
	}
	
}