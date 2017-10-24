package HerenciaClaseEInterfaz;

public class Triangulo extends Figura implements IFigura{

	public Triangulo(double l) {
		super(3, l);
	}
	@Override
	public double area(){
		return this.lado*this.lado;
	}

	@Override
	public double perimetro() {
		return this.lado*3;
	}
}
