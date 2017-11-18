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
	    casillas[24] = new Casilla("Tercer item");
	}

	public void crearCasillasA(){
	
    for(int i = 3; i <= 15;i++){
      int x = ThreadLocalRandom.current().nextInt(0, 1 + 1);
      if(x == 1){
         casillas[i] = new Casilla("Aqui hay un item");
      }else{
        casillas[i] = new Casilla("Aqui hay un enemigo");
      }
    }
	}


	public void crearCasillasB(){
    for(int j = 16; j <= 23;j++){
      int x = ThreadLocalRandom.current().nextInt(0, 1 + 1);
      if(x == 1){
        casillas[j] = new Casilla("Aqui hay un item");

      }else{
        casillas[j] = new Casilla("Aqui hay un enemigo");
      }
    }
  }


}