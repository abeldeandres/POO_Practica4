package HerenciaNormal;

public class Cuadrado extends Figura{

	public Cuadrado(double l) {
		super(4,l);
	}
	//Polimorfismo
	public double area(){
		return this.lado*this.lado;
	}
}
