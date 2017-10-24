package HerenciaClaseEInterfaz;

public class Cuadrado extends Figura implements IFigura{

	public Cuadrado(double l) {
		super(4,l);
	}
	
	@Override
	public double area(){
		return this.lado*this.lado;
	}

	@Override
	public double perimetro() {
		return this.lado*4;
	}
}
