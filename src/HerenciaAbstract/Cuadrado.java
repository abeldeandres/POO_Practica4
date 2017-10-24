package HerenciaAbstract;

public class Cuadrado extends Figura{

	public Cuadrado(double l) {
		super(4,l);
	}

	public double area(){
		return this.lado*this.lado;
	}
}
