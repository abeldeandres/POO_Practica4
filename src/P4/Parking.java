package P4;

import java.util.ArrayList;



public class Parking {
	private ArrayList<Vehiculo>  arrayTotales;
	private ArrayList<Empresa>   arrayVEmpresa;
	private ArrayList<Residente> arrayVResidentes;
	private double importeNoResidentes;
	
	public Parking(){
		this.arrayTotales     = new ArrayList<Vehiculo>();		
		this.arrayVEmpresa    = new ArrayList<Empresa>();		
		this.arrayVResidentes = new ArrayList<Residente>();		
		this.importeNoResidentes =0;
	}
	
	public void resetear()
	{
		//Primero se recorre el array de totales, de ahi eliminar los coches de empresa. Array Temporal se almacenan los coches de empresa de totales
		//Se recorre la lista de temporal y se borran todos los elementos y se quitan 
		 ArrayList<Vehiculo>   arrayTemporales=new ArrayList<>();
		 for (int i=0; i<arrayTotales.size(); i++)
		 {
			 if (arrayTotales.get(i) instanceof Empresa || arrayTotales.get(i) instanceof NoResidente)
			 {
				 arrayTemporales.add(arrayTotales.get(i));
			 }
		 }
		 for (int j=0; j<arrayTemporales.size();j++)
		 {
			arrayTotales.remove(arrayTemporales.get(j));
		 }
		 this.importeNoResidentes=0;
		 arrayVEmpresa= new ArrayList<Empresa>();
		 for (int z=0; z<arrayVResidentes.size(); z++)
		 {
			 arrayVResidentes.get(z).resetear();
		 }
		 
	}
	
	public void registrarEntrada(String matricula){
		Vehiculo v= buscarEnEmpresa(matricula);
		if(v!=null){
			v.registrarEntrada();
			arrayTotales.add(v);
		}
		else{
			v=buscarEnResidente(matricula);
			if(v!=null){
				v.registrarEntrada();		
				arrayTotales.add(v);
			}
			else{//Entonces NO RESITDENTE
				Fecha fechaactual = new Fecha();
				if (buscarEnTotales(matricula)==null)
				{
					NoResidente noresidenteaux = new NoResidente(matricula, fechaactual);
					arrayTotales.add(noresidenteaux);
				}
			}
		}
		
	}
	public String registrarSalida(String matricula){
		Vehiculo v= buscarEnTotales(matricula);
		if (v!=null)
		{
			//Aqui llama a registrar salida de Empresa,
			String cad =v.registrarSalida();
			if(v instanceof NoResidente){
				NoResidente noResidenteAux = (NoResidente)v;
				this.importeNoResidentes += noResidenteAux.importe();
			}
			
			arrayTotales.remove(v);
			return cad;
		}
		else return "No se encuentra la matricula introducida";
	}
	
	public void agregarVResidente(String matricula,String dni,String direccion,long telefono,String nombre, String apellidos){
		if(buscarEnResidente(matricula)!=null){
			System.out.println("Matricula ya existe");
		}
		else{
			Residente res = new Residente(matricula, dni, direccion, telefono, nombre, apellidos);
			this.arrayVResidentes.add(res);
		}
	}
	
	public void agregarVEmpresa(String matricula){
		if(buscarEnEmpresa(matricula)!=null){
			System.out.println("Matricula ya existe");
		}
		else{
			Empresa Empresaaux = new Empresa(matricula);
			this.arrayVEmpresa.add(Empresaaux);
		}
	}
	
	
	private Residente buscarEnResidente(String matricula) {
		int i=0;
		boolean encontrado=false;
		Residente VResidenteEncontrado=null;
		while(i<arrayVResidentes.size() && !encontrado){
			if(arrayVResidentes.get(i).getMatricula().equalsIgnoreCase(matricula)){
				encontrado=true;
				VResidenteEncontrado=arrayVResidentes.get(i);
			}
			i++;
		}
		return VResidenteEncontrado;
	}
	private Empresa buscarEnEmpresa(String matricula) {
		int i=0;
		boolean encontrado=false;
		Empresa VEmpresaEncontrado=null;
		while(i<arrayVEmpresa.size() && !encontrado){
			if(arrayVEmpresa.get(i).getMatricula().equalsIgnoreCase(matricula)){
				encontrado=true;
				VEmpresaEncontrado=arrayVEmpresa.get(i);
			}
			i++;
		}
		return VEmpresaEncontrado;
	}
	
	private Vehiculo buscarEnTotales(String matricula) {
		int i=0;
		boolean encontrado=false;
		Vehiculo VEncontrado=null;
		while(i<arrayTotales.size() && !encontrado){
			if(arrayTotales.get(i).getMatricula().equalsIgnoreCase(matricula)){
				encontrado=true;
				VEncontrado=arrayTotales.get(i);
			}
			i++;
		}
		return VEncontrado;
	}
	

	public String getListarEmpresa()
	{
		String concatenar="INFORME DE PAGO DE VEHÍCULOS DE EMPRESA \n";
		concatenar+="Matricula \t Tiempo estacionamiento\n";
		for (int i=0; i<arrayVEmpresa.size();i++)
		{
			concatenar += arrayVEmpresa.get(i).toString()+"\n";
		}
		concatenar+="_____________________________________________________________________________ \n";
		return concatenar;
	}
	public long sumaImporteResidente()
	{
		long suma=0;
		for (int i=0; i<arrayVResidentes.size(); i++)
		{
			suma= suma+(long)arrayVResidentes.get(i).importeMes();
		}
		return suma;
	}
	
	public double getImporteNoResidentes(){
		return this.importeNoResidentes;
	}

	public String getListarResidente()
	{
		String concatenar="INFORME DE PAGO DE VEHÍCULOS DE RESIDENTES \n";
		concatenar+="Matricula___________Tiempo estacionamiento___________Cantidad a pagar(euros)\n";
		for (int i=0; i<arrayVResidentes.size();i++)
		{
			concatenar += arrayVResidentes.get(i).toString()+"\n";
		}
		concatenar+="_____________________________________________________________________________ \n";
		concatenar+="Importe Total:"+sumaImporteResidente();
		return concatenar;
	}
	public String getListadoGeneral()
	{
		Fecha fechaactual =new Fecha();
		String cadena="LISTADO DE VEHICULOS QUE SE ENCUENTRAN EN EL PARKING \n";
		cadena+="Fecha Actual:"+fechaactual.toStringFecha()+"\n";
		cadena+="Hora:"+fechaactual.toStringHora()+"\n";
		cadena+= toStringGeneral();
		return cadena;
	}
	public String toStringGeneral()
	{
		Fecha fechaactual=new Fecha();
		int dia=fechaactual.dia;
		ArrayList<Vehiculo>   arrayPorDIA=new ArrayList<>();
		 for (int i=0; i<arrayTotales.size(); i++)
		 {
			 if (arrayTotales.get(i).getdia()==dia)
			 {
				 arrayPorDIA.add(arrayTotales.get(i));
			 }
		 }
		String concatenar="";
		for (int i=0; i<arrayPorDIA.size();i++)
		{
			concatenar += arrayPorDIA.get(i).Matricula+"\t";
		    concatenar +=arrayPorDIA.get(i).getFechaEntrada().toStringHora()+"h\t";
		    concatenar +=arrayPorDIA.get(i).getTipo()+"\n";
		}
		concatenar+="_____________________________________________________________________________ \n";
		return concatenar;
	}
}
