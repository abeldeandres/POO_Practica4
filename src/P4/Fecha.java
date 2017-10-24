package P4;

import java.util.Calendar;

public class Fecha {
		int dia;
		int hora;
		int minuto;
		int mes;
		int año;

		
		public Fecha(){
			Calendar fecha= Calendar.getInstance();
			this.mes   = fecha.get(Calendar.MONTH)+1;
			this.año   = fecha.get(Calendar.YEAR);
			this.dia   = fecha.get(Calendar.DAY_OF_MONTH);
			this.hora  = fecha.get(Calendar.HOUR_OF_DAY);
			this.minuto= fecha.get(Calendar.MINUTE);
		}

		public int distancia(Fecha f1){
			int res  = 0;
			int min1 = f1.dia*24*60 + f1.minuto;
			int min2 = dia*24*60 + minuto;
			
			res = min1 - min2;
			if(res<0) res =(-1)*res;
			return res;
		}
		
		public String toStringFecha()
		{
			String fecha;
			fecha= dia+"/"+mes+"/"+año+"";
			return fecha;
		}
		
		public String toStringHora()
		{
			String Hora;
			Hora= hora+":"+minuto+"";
			return Hora;
		}
		
		
		
}
