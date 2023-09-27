public class Driver {
<<<<<<< HEAD
public static void main(String [] args) {
Polynomial p = new Polynomial();
System.out.println(p.evaluate(3));
double [] c1 = {6,5};
int [] e1= {0,3};
Polynomial p1 = new Polynomial(c1, e1);
double [] c2 = {-2,-9};
int [] e2= {1,4};
Polynomial p2 = new Polynomial(c2,e2);
Polynomial s = p1.add(p2);
System.out.println("s(0.1) = " + s.evaluate(0.1));
=======
	
public static void main(String [] args) {
Polynomial p = new Polynomial();
System.out.println(p.evaluate(3));
double [] c1 = {6,0,0,5};
Polynomial p1 = new Polynomial(c1);
double [] c2 = {0,-2,0,0,-9};
Polynomial p2 = new Polynomial(c2);
Polynomial s = p1.add(p2);
System.out.println("s(0.1) = " + s.evaluate(0.1));

>>>>>>> origin/lab2
if(s.hasRoot(1))
System.out.println("1 is a root of s");
else
System.out.println("1 is not a root of s");
}
<<<<<<< HEAD
}
=======
}
>>>>>>> origin/lab2
