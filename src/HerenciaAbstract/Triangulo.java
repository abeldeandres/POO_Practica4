package HerenciaAbstract;

public class Triangulo extends Figura {

	public Triangulo(double l) {
		super(3, l);
	}
	//Polimorfismo
	public double area(){
		return this.lado*this.lado/2;
	}
}
