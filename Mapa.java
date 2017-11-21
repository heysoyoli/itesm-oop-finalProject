import java.util.concurrent.ThreadLocalRandom;

public class Mapa{
	
	private Casilla[] casillas;
	//private Humano humano;

	public Mapa(){
		this.casillas = new Casilla[25];
		//this.humano = humano;
	}

	public Casilla[] getCasillas(){
		return casillas;
	}

	/*public void setHumano(Humano humano){
		this.humano = humano;
	}

	public Humano getHumano(){
		return humano;
	}*/


	public void crearCasillasDefault(){
		casillas[0] = new Casilla("Esta es la primer casilla");
	    casillas[1]= new Casilla("Esta es la casilla que contendra al ayudante y la nota"); //clase?
	    casillas[2] = new Casilla(new Item(1, "Una pocion!", "Estas a punto de entrar al infierno, esta pocion te ayudara a aguantar sus llamas."),0);
	    casillas[3]= new Casilla(new Arma("Espada", "Te ayudara a derrotar a tus enemigos", 5), 2);
	    casillas[15] = new Casilla(new Item(10, "Pocion, nivel B", "Los retos que vienen seran mas dificiles, esto te ayudara a superarlos."),0);
	    casillas[24] = new Casilla(new Monolito("Andres, el monolito", 30, 10), 1);
	}

	public void crearCasillasA(){
	
    for(int i = 4; i <= 15;i++){
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
    for(int j = 16; j <= 23;j++){
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