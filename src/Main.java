import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		// Creamos el array
		ArrayList <Planeta> listadoPlanetas = new ArrayList <Planeta>();
		ArrayList <Planeta> listadoPlanetasConVida=new ArrayList <Planeta>();
		
		//Contador para cambiar el nombre del planeta
		int id=0;
		
		System.out.println("Listado de los 300 planetas:");
		
		//Creamos el objeto
		for (int i=0; i<300;i++) {
			
			id+=1;
			Planeta planeta = new Planeta ("Planeta"+id);
			planeta.setNombre("Planeta"+id);
			listadoPlanetas.add(planeta);
			
			if (planeta.hayVida()) {
				
				listadoPlanetasConVida.add(planeta);
				
			}
			
			//Imprimo los 300 planetas
			System.out.println(listadoPlanetas.get(i));
			
			
		}
		
		//Imprimo los planetas con vida
		System.out.println("******************");
		System.out.println("Planetas con vida:");
		
		for (int a=0; a<=listadoPlanetasConVida.size()-1; a++) {
			
			System.out.println(listadoPlanetasConVida.get(a));
		}
		
		
		
		

	}

}
