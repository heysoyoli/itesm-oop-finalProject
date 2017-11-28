public abstract class Personaje{

	protected String nombre;
	protected int vida;
	protected int puntosAtaque;
	//private ImageIcon mostrarImagen;

	public Personaje(String nombre, int vida, int puntosAtaque){
		this.nombre = nombre;
		this.vida = vida;
		this.puntosAtaque = puntosAtaque;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getNombre(){
		return nombre;
	}

	public void setVida(int vida){
		this.vida = vida;
	}

	public int getVida(){
		return vida;
	}

	public void setPuntosAtaque(int puntosAtaque){
		this.puntosAtaque = puntosAtaque;
	}

	public int getPuntosAtaque(){
		return puntosAtaque;
	}

	public void atacarArma(Arma arma, Enemigo enemigo){

		

	}

}
