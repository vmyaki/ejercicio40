import java.util.Random;

public class Planeta {
	//Atributos
	private String nombre;
	private double distancia;
	private char elemento;
	private double gravedad;
	private boolean hayAtmosfera;
	
	//Constructores
	/**
	 * 
	 * @param nombre - representa el nombre del planeta
	 * @param distancia - representa la distancia del planeta
	 * @param elemento - representa el elemento que predomina, carbono o silicio
	 * @param gravedad - representa la gravedad de ese planeta
	 * @param hayAtmosfera - representa si hay oxigeno o no, si hay oxigeno devuelve [x] sino []
	 */
	public Planeta (String nombre,int distancia,char elemento,double gravedad,boolean hayAtmosfera) {
		this.nombre=nombre;
		this.distancia=distancia;
		this.elemento=elemento;
		this.gravedad=gravedad;
		this.hayAtmosfera=hayAtmosfera;
	}
	
	//Creamos planetas de forma aleatoria
	public Planeta () {
		Random aleatorio=new Random();
		this.nombre="Planeta "+Integer.toHexString(this.hashCode());
		this.distancia=(aleatorio.nextInt(2000)+ aleatorio.nextDouble());
		int aleat=aleatorio.nextInt(2)+1; // 2+1 porque es desde 0 inclusive hasta el 2 exclusive
		if (aleat==1) {
			this.elemento='c';
		}
		else {
			this.elemento='s';
		}
		this.gravedad=(aleatorio.nextInt(21)+ aleatorio.nextFloat())+3;//nos da un numero entero entre 0 y 20 ,un decimal entre 0.0 y 1.0 a partir del 3
		this.hayAtmosfera=aleatorio.nextBoolean();
		/*Elemento tmb se puede hacer así, con un operador ternario en un misma fila
		 this.elemento=(aleatorio.nextBoolean() ? 'c':'s');
		 Evalúa la expresión booleana inicial, y si es true devuelve la primera parte ('c') o la segunda en caso contrario ('s').*/
	
		
	}
	
	// Constructor que solo recibe un nombre y los demás datos se crea de forma aleatoria xk llama al constructor planeta()
	public Planeta (String nombre) {
		this();
		this.nombre=nombre;
		
		
	}
	//Métodos Setters and Getters

		//Nombre
	public String isNombre() {
		return this.nombre;
	}
	
	public void setNombre (String nombreNuevo) {
		this.nombre =nombreNuevo;
	}
	
		//Distancia
	public double isDistancia() {
		return this.distancia;
			
	}
	
	public void setDistancia(double distanciaNueva) {
		this.distancia=distanciaNueva;
	}
	
		//Elemento
	public char isElemento() {
		return this.elemento;
	}
	
	public void setElemento(char elementoNuevo) {
		this.elemento=elementoNuevo;
		}
	
		//Gravedad
	public double isGravedad() {
		return this.gravedad;
	}
	
	public void setGravedad(double gravedadNueva)
	{
		this.gravedad=gravedadNueva;
	}
	
		//Hay atmósfera
	public boolean isHayAtmosfera() {
			return this.hayAtmosfera;
		}
	
	
	public void setHayAtmosfera(boolean hayAtmosferaNueva) {
		this.hayAtmosfera=hayAtmosferaNueva;
	}
	
	//Otros métodos
	
	public String toString() {
		String resultado="";
		resultado +="\nNombre: "+this.nombre;
		resultado +="\nDistancia: "+this.distancia;
		if (elemento=='c') {
			resultado += "\nElemento: Carbono";
		}
		else if (elemento=='s') {
			resultado +="\nElemento: Silicio";
		}
		else if (elemento=='x') {
			resultado +="\nElemento: Carbolíceo";
		}
		resultado +="\nGravedad: "+this.gravedad;
		if (hayAtmosfera) {
			resultado +="\nHay atmósfera: [x]";
		}
		else {
			resultado +="\nHay atmósfera: []";
		}
		
		return resultado;
	}
	
	//Metodo si tiene vida, si se cumple el if tieneVida entonces es true sino false
	public boolean hayVida() 
	{
		boolean tieneVida;
		if (this.hayAtmosfera && this.elemento=='c' && (this.gravedad>5 && this.gravedad<14) && (this.distancia>100 && this.distancia<300)) 
			{
				tieneVida=true;
			}
			else
			{
				tieneVida=false;
			}
		
		return tieneVida;
		
	}
	
	public Planeta fusion(Planeta planetaFusionar) {
		Planeta nuevo = new Planeta();
		
		nuevo.setNombre(this.nombre + "+" + planetaFusionar.isNombre());
		nuevo.setDistancia((this.distancia + planetaFusionar.isDistancia()) / 2d);
		nuevo.setGravedad((this.gravedad + planetaFusionar.isGravedad()) / 2f);
		nuevo.setHayAtmosfera(this.hayAtmosfera || planetaFusionar.isHayAtmosfera());
		if (this.elemento=='c' && planetaFusionar.isElemento()=='c')
		{
			nuevo.setElemento('c');
		}
		else if (this.elemento=='s' && planetaFusionar.isElemento()=='s')
		{
			nuevo.setElemento('s');
		}
		else {
			nuevo.setElemento('x');
		}
		
		return nuevo;
	}
}
		

	