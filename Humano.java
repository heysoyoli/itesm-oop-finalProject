import java.io.*;

public class Humano extends Personaje implements Serializable{
	
	private int pos;

	public Humano (int pos, String nombre, int vida, int puntosAtaque){
		super(nombre, vida, puntosAtaque);
		this.pos = pos;
	}

	public void setPos(int pos){
		this.pos = pos;
	}

	public int getPos(){
		return pos;
	}

	public void atacar(){

	}

	public void atacarArma(){
		 
	}

}