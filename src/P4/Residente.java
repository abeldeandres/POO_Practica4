package P4;

public class Residente extends Vehiculo {
	private int    Minutos;
	private String DNI;
	private String Direccion;
	private long   Telefono;
	private String Nombre;
	private String Apellido;
	
	
	public Residente(String matricula, String dNI,String direccion, long telefono, String nombre, String apellido) {
		super(matricula, null);
		DNI       = dNI;
		Direccion = direccion;
		Telefono  = telefono;
		Nombre    = nombre;
		Apellido  = apellido;
		Minutos   = 0;
	}


	public float importeMes(){
		return (float) (0.005*this.Minutos);
	}
	public void resetear(){
		this.Minutos=0;
	}
	public int getMinutos(){
		return this.Minutos;
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
		return "RESIDENTE";
	}
	
	public String getMatricula()
	{
		return super.Matricula;
	}
	
	public String toString()
	{
		return Matricula+" "+Minutos+" "+importeMes() +"\n";
	}

}
