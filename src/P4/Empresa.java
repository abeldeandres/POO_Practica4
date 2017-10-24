package P4;

public class Empresa extends Vehiculo {

	private int Minutos;
	
	
	public Empresa(String matricula) {
		super(matricula,null);
		this.Minutos=0;
	}

	@Override
	public String registrarSalida() {
		Fecha salida=new Fecha();
		this.Minutos += super.Entrada.distancia(salida);
			String concatenar="PARKING SENATOR \n";
			concatenar+="ENTRADA: Fecha:"+Entrada.toStringFecha()+"Hora"+Entrada.toStringHora()+"\n";
			concatenar+="ENTRADA: Fecha:"+salida.toStringFecha()+"Hora"+salida.toStringHora()+"\n";
		return concatenar;
	}

	@Override
	public String getTipo() {
		return "Empresa";
	}
	public String getMatricula()
	{
		return super.Matricula;
	}
	
	public String toString()
	{
		int minDif = super.Entrada.distancia(new Fecha());
		return Matricula+" "+minDif+" "+"\n";
	}
}
