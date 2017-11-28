import java.util.concurrent.ThreadLocalRandom;
import java.io.*;

public class Mapa implements Serializable{

	private Casilla[] casillas;
	private String historia;
	
	public Mapa(){
		this.casillas = new Casilla[26];
	}

	public Casilla[] getCasillas(){
		return casillas;
	}

	public void setHistoria(String historia){
		this.historia = historia;
	}

	public String getHistoria(){
		return historia;
	}


	public void crearCasillasDefault(){
		casillas[0] = new Casilla("Esta es la primer casilla", 3);
	    casillas[1]= new Casilla("Esta es la casilla que contendra al ayudante y la nota", 3); //clase?
	    casillas[2] = new Casilla("Pocion", 3);
	    casillas[3]= new Casilla(new Arma("Espada", "Te ayudara a derrotar a tus enemigos", 5), 2);
	    casillas[14] = new Casilla(new Arma("Martillo", "Los retos que vienen seran mas dificiles, esto te ayudara a superarlos.", 7),2);
	    casillas[24] = new Casilla(new Monolito("Andres, el monolito", 30, 10), 1);
	    casillas[25] = new Casilla ("Este es el fin de la historia", 3);
	}

	public void crearCasillasA(){

	    for(int i = 4; i <= 13;i++){
	      int x = ThreadLocalRandom.current().nextInt(0, 1 + 1);
	      int y = ThreadLocalRandom.current().nextInt(10, 20 + 1);
	      int z = ThreadLocalRandom.current().nextInt(5, 7 + 1);

	      int a = ThreadLocalRandom.current().nextInt(1, 5 + 1);


	      if(x == 1){
	         casillas[i] = new Casilla(new Item(a, "Pocion de curacion", "Esta pocion te dara puntos extra de vida"), 0);
	      }else{
	        casillas[i] = new Casilla(new Enemigo("Espiritu", y, z), 1);
	      }
	    }
		}


	public void crearCasillasB(){
	    for(int j = 15; j <= 23;j++){
	      int x = ThreadLocalRandom.current().nextInt(0, 1 + 1);
	      int y = ThreadLocalRandom.current().nextInt(10, 20 + 1);
	      int z = ThreadLocalRandom.current().nextInt(5, 7 + 1);

	      int a = ThreadLocalRandom.current().nextInt(2, 7 + 1);

	      if(x == 1){
	        casillas[j] = new Casilla(new Item(a, "Pocion de curacion", "Esta pocion te dara puntos extra de vida"), 0);

	      }else{
	        casillas[j] = new Casilla(new Enemigo("Espiritu", y, z), 1);
	      }
	    }
	  }


}
