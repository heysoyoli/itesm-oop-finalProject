import java.util.Random;

public class Mapa{
	
	private Casilla[] casillas;
	private Humano humano;

	public Mapa(){
		this.casillas = new Casilla[25];
		this.humano = humano;
	}

	public Casilla[] getCasillas(){
		return casillas;
	}

	public void setHumano(Humano humano){
		this.humano = humano;
	}

	public Humano getHumano(){
		return humano;
	}


	public void crearCasillasDefault(){
		casillas[0] = new Casilla("Esta es la primer casilla");
	    casillas[1]= new Casilla("Esta es la casilla que contendra al ayudante y la nota"); //clase?
	    casillas[2] = new Casilla("Primer item");
	    casillas[3]= new Casilla("Primer arma");
	    casillas[15] = new Casilla("Segundo Item");
	    casillas[25] = new Casilla("Tercer item");
	}

}