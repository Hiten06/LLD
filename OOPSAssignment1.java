class Fraction {
	private int numerator;
	private int denominator;
	
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		if (denominator == 0) {
			// TODO error out
		}
		this.denominator = denominator;
		simplify();
	}
	
	
	public int getDenominator() {
		return denominator;
	}
	
	public int getNumerator() {
		return numerator;
	}
	
	public void setNumerator(int n) {
		this.numerator = n;
		simplify();
	}
	
	
	public void setDenominator(int d) {
		if (d == 0){
			// TODO error out
			return;
		}
		this.denominator = d;
		this.simplify();
	}
	
	public void print() {
		if (denominator == 1) {
			System.out.println(numerator);
		} else {
			System.out.println(numerator + "/" + denominator);
		}

		
	}
	
	private void simplify() {
	    int n = numerator;
	    int d = denominator;
	    if(n == 0){
	        numerator/=d;
	        denominator/=d;
	        return;
	    }
	    else if(d==0){
	        numerator/=n;
	        denominator/=n;
	        return;
	    }
	    while(n!=d){
	        if(n>d){
	            n=n-d;
	        }
	        else{
	            d=d-n;
	        }
	    }
	    numerator=numerator/n;
	    denominator/=n;
	}
	
    public static Fraction addition(Fraction f1, Fraction f2) {
		int n1 = f1.numerator;
		int n2=f2.numerator;
		int d1=f1.denominator;
		int d2=f2.denominator;
		int Num= n1*d2+n2*d1;
		int Den=d1*d2;
		return  new Fraction(Num,Den);
	}
	
   public void add(Fraction f2) {
		Fraction A1 = addition(new Fraction(this.numerator,this.denominator),f2);
		this.numerator=A1.numerator;
		this.denominator=A1.denominator;
		simplify();
	}
	
	public void multiply(Fraction f2) {
	    int n = this.numerator;
	    int d = this.denominator;
	    int Num = n * f2.numerator;
	    int Den = d *f2.denominator;
	    this.numerator=Num;
	    this.denominator=Den;
	    simplify();
	}
	
}





public class MyClass {
    public static void main(String args[]) {
      Fraction frac = new Fraction(36,45);
      Fraction frac1 = new Fraction(2,3);
      System.out.println(frac.getDenominator()+","+frac.getNumerator());
      Fraction obj = Fraction.addition(frac,frac1);
      System.out.println(obj.getNumerator()+","+obj.getDenominator());
     
      frac.add(frac1);
      System.out.println(frac.getNumerator()+","+frac.getDenominator());
      Fraction f = new Fraction(36,45);
      f.multiply(frac1);
      System.out.println(f.getNumerator()+","+f.getDenominator());
    }
}
