package P4;



import java.util.Scanner;
public class Main {
	public static Scanner ent =null;
	public static Parking parking=new Parking();
	
	public static int leerInt(){
		String strNumero="";
		int numero=0;
		boolean lecturaBien=false;
		do{
			ent = new Scanner(System.in);
			System.out.print("> ");
			strNumero = ent.nextLine();
			try{
				numero= Integer.parseInt(strNumero);
				lecturaBien=true;
			}catch(Exception e){}
			
		}while(!lecturaBien);
		
		return numero;
	}
	
	public static long leerLong(){
		String strNumero="";
		long numero=0;
		boolean lecturaBien=false;
		do{
			ent = new Scanner(System.in);
			System.out.print("> ");
			strNumero = ent.nextLine();
			try{
				numero= Long.parseLong(strNumero);
				lecturaBien=true;
			}catch(Exception e){}
			
		}while(!lecturaBien);
		
		return numero;
	}
	public static String leerString(){
		String cadena="";
		do{
			ent = new Scanner(System.in);
			System.out.print("> ");
			cadena = ent.nextLine();
		}while(cadena.equalsIgnoreCase("") || cadena.equalsIgnoreCase("\n"));
		
		return cadena;
	}
	public static void OPregistrarEntrada()
	{
		System.out.println("Introduzca la matricula del vehiculo \n");
		String matricula=leerString();
		parking.registrarEntrada(matricula);	
	}
	public static void OPregistrarSalida()
	{
		System.out.println("Introduzca la matricula del vehiculo \n");
		String matricula=leerString();
		System.out.println(parking.registrarSalida(matricula));
	}
	
	public static void OPdaraltaVEmpresa()
	{
		System.out.println("Introduzca la matricula del vehiculo de empresa \n");
		String matricula=leerString();
		parking.agregarVEmpresa(matricula);
	}
	
	public static void OPdaraltaVResidente()
	{
		System.out.println("Introduzca la matricula del vehiculo residente \n");
		String matricula=leerString();
		System.out.println("Introduzca la direccion del residente \n");
		String direccion=leerString();
		System.out.println("Introduzca el DNI del residente \n");
		String dni=leerString();
		System.out.println("Introduzca el telefono del residente \n");
		long telefono=leerLong();
		System.out.println("Introduzca el nombre del residente \n");
		String nombre=leerString();
		System.out.println("Introduzca el apellido del residente \n");
		String apellidos=leerString();
		parking.agregarVResidente(matricula, dni, direccion, telefono, nombre, apellidos);
	}
	
	public static void OPiniciarmes()
	{
		parking.resetear();
		System.out.println("Se ha reseteado correctamente! \n");
	}
	
	public static void OPinformespagosresidentes()
	{
		System.out.println(""+parking.getListarResidente()+"");
	}
	
	public static void OPestanciasvehiculosempresa()
	{
		System.out.println(""+parking.getListarEmpresa()+"");
	}
	
	public static void OPimportetotalnoresidentes()
	{
		Fecha fecActual = new Fecha();
		System.out.print("INFORME de PAGO VEHICULOS (No residentes) "+fecActual.toString()+": ");
		System.out.println(parking.getImporteNoResidentes()+" Euros");
	}
	
	public static void OPlistadogeneral()
	{
		System.out.println(""+parking.getListadoGeneral()+"");
	}
	
	
	
	
	public static void mostrarMenu(){
		System.out.println("1. -Registrar entrada");
		System.out.println("2. -Registrar salida");
		System.out.println("3. -Dar de alta a un vehiculo de la empresa");
		System.out.println("4. -Dar de alta a un vehiculo residente");
		System.out.println("5. -Iniciar mes");
		System.out.println("6. -Informe de pagos de residentes");
		System.out.println("7. -Informe de estancias de vehículos de la empresa");
		System.out.println("8. -Importe total registrado de vehiculos no residentes");
		System.out.println("9. -Listado general de vehiculos que se encuentran en el parking");
		System.out.println("0.  Salir");
		System.out.println("Introduzca una opcion:");
	}
	
	public static void main(String[] args) {
		int     opcion=0;
		boolean salir=false;
		 
		do{
			mostrarMenu();
			opcion = leerInt();
			switch(opcion) {
			
			case 1: OPregistrarEntrada(); break;
			case 2: OPregistrarSalida(); break;
			case 3: OPdaraltaVEmpresa(); break;
			case 4: OPdaraltaVResidente(); break;
			case 5: OPiniciarmes(); break;
			case 6: OPinformespagosresidentes(); break;
			case 7: OPestanciasvehiculosempresa(); break;
			case 8: OPimportetotalnoresidentes(); break;
			case 9: OPlistadogeneral(); break;
			case 0:
				System.out.println("Gracias por utilizar la aplicación");
				salir=true;
				break;
				
			default:
				System.out.println("Por favor, introduzca una opcion correcta, del 0 al 10, ambos inclusive.");
				break;			
			}
			
		}while(!salir);
		
	}
}
	