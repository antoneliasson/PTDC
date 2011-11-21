
public class Complex {
	private double re, im;
	
	/**
	 * Skapar en komplex variabel med realdelen re och imaginärdelen im
	 * @param re
	 * @param im
	 */
	public Complex(double re, double im){
		this.re = re;
		this.im = im;
	}
	
	/**
	 * Tar reda på realdelen
	 * @return
	 */
	public double getRe(){
		return re;
	}
	
	/**
	 * Tar reda på imaginärdelen
	 * @return
	 */
	public double getIm(){
		return im;
	}
	
	/**
	 * Tar reda på talets absolutbelopp i kvadrat
	 * @return
	 */
	public double getAbs2(){
		return re*re + im*im;
	}
	
	/**
	 * Adderar det komplexa talet c till detta tal
	 * @param c
	 */
	public void add(Complex c){
		re += c.re;
		im += c.im;
	}
	
	/**
	 * Multiplicerar detta tal med det komplexa talet c
	 * @param c
	 */
	public void mul(Complex c){
		double re = this.re * c.re - this.im * c.im;
		double im = this.im * c.re + c.im * this.re;
		this.re = re;
		this.im = im;
	}
}
