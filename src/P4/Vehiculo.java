package P4;

public abstract class Vehiculo {
	protected String Matricula;
	protected Fecha Entrada;

	
	public Vehiculo(String matricula, Fecha entrada) {
		Matricula = matricula;
		Entrada = entrada;
	}
	/**
	 * Metodo que implentan los hijos para registrar una entrada
	 * Estos se implementan en los hijos
	 */
	public void registrarEntrada(){
		this.Entrada = new Fecha();
	}
	public abstract String registrarSalida();
	public abstract String getTipo();
	public String getMatricula()
	{
		return Matricula;
	}
	
	public Fecha getFechaEntrada()
	{
		return Entrada;
	}
	
	public int getdia()
	{
		Fecha fechadia =new Fecha();
		return fechadia.dia;
	}
	public String toString()
	{
		return Matricula+" "+getTipo()+"\n";
	}
	
	
}
