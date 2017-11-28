import java.io.*;

public class Game implements Serializable{
	
	private Humano humano;
	private Mapa mapa;


	public void setHumano(Humano humano){
		this.humano = humano;
	}

	public Humano getHumano(){
		return humano;
	}

	public void setMapa(Mapa mapa){
		this.mapa = mapa;
	}

	public Mapa getMapa(){
		return mapa;
	}
}