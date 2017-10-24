package P4;

public class NoResidente extends Vehiculo {
	private int numeroMinutos;
	public NoResidente(String matricula, Fecha entrada) {
		super(matricula, entrada);
		this.numeroMinutos=0;
		// TODO Auto-generated constructor stub
	}

	/*
	@Override
	public void registrarEntrada() {
		super.Entrada = new Fecha();//ya tenemos la fecha actual
	}
	 */
	@Override
	public String registrarSalida() {
		Fecha salida=new Fecha();
		this.numeroMinutos = super.Entrada.distancia(salida);
		String concatenar="PARKING SENATOR \n";
		concatenar+="ENTRADA: Fecha:"+Entrada.toStringFecha()+"Hora"+Entrada.toStringHora()+"\n";
		concatenar+="ENTRADA: Fecha:"+salida.toStringFecha()+"Hora"+salida.toStringHora()+"\n";
		concatenar+="IMPORTE: "+numeroMinutos+" x 0.010€ = "+importe()+"\n";
	return concatenar;
	}

	@Override
	public String getTipo() {
		return "NO RESIDENTE";
	}
	
	public float importe(){
		return (float) (0.010*this.numeroMinutos);
	}
	

}
