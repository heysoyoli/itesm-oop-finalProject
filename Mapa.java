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
	    casillas[2] = new Casilla("Primer item");
	    casillas[3]= new Casilla("Primer arma");
	    casillas[15] = new Casilla("Segundo Item");
	    casillas[24] = new Casilla(new Monolito("Andres, el monolito", 30, 10), 1);
	}

	public void crearCasillasA(){
	
    for(int i = 3; i <= 15;i++){
      int x = ThreadLocalRandom.current().nextInt(0, 1 + 1);
      int y = ThreadLocalRandom.current().nextInt(10, 20 + 1);
      int z = ThreadLocalRandom.current().nextInt(5, 7 + 1);
      

      if(x == 1){
         casillas[i] = new Casilla("Aqui hay un item");
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

      if(x == 1){
        casillas[j] = new Casilla("Aqui hay un item");

      }else{
        casillas[j] = new Casilla(new Enemigo("Espiritu", y, z), 1);
      }
    }
  }


}