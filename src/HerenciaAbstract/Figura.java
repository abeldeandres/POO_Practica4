package HerenciaAbstract;

public abstract class Figura {
	protected int numLados;
	protected double lado;
	
	public Figura(int nLado,double l){
		this.numLados=nLado;
		this.lado = l;
	}	
	
	public double perimetro(){
		return this.lado*this.numLados;
	}
	
	public abstract double area();
}
