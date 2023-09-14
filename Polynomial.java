public class Polynomial{
	double[] coe;
	
	public Polynomial() {
		this.coe = new double[] {0};
			}
	
	public Polynomial(double []coes) {
		this.coe = coes;
	}
	
	// method named add that takes one argument of type Polynomial and 
	//returns the Polynomial resulting from adding the calling object and the argument
	
	public Polynomial add(Polynomial other) {
	    int length = Math.max(this.coe.length, other.coe.length);
	    double[] new_coe = new double[length];
	    for (int i=0; i<length; i++) {                        
	    	if (i < this.coe.length) {
	    		new_coe[i]=this.coe[i];
	    	}
	    	if (i < other.coe.length) {
	    		new_coe[i]+=other.coe[i];
	    	}
	    } 
		return new Polynomial(new_coe);
		}
	
		
	
	public double evaluate(double x) {
		
		double result=0.0;
		
		for (int i=0; i<this.coe.length; i++) {
			double x_power = Math.pow(x, i);
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
	
}