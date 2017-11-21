public class Casilla{

  protected Item item;
  protected Arma arma;
  protected Enemigo enemigo;
  protected String historia;
  protected int tipoContenido;  //protected boolean tipoEnemigo;
//  protected int numero;


public Casilla(String historia){
  this.historia = historia;
}

public Casilla(Enemigo enemigo, int tipoContenido){
    this.enemigo = enemigo;
    this.tipoContenido = 1;
  }

  public Casilla(Item item, int tipoContenido){
    this.item = item;
    this.tipoContenido = 0;
  }

  public Casilla(Arma arma, int tipoContenido){
    this.arma = arma;
    this.tipoContenido = tipoContenido;
  }



  public void setHistoria(String historia){
    this.historia = historia;
  }

  public String getHistoria(){
    return historia;
  }

  public void setItem(Item item){
    this.item = item;
  }

  public Item getItem(){
    return item;
  }

  public void setArma(Arma arma){
    this.arma = arma;
  }

  public Arma getArma(){
    return arma;
  }

  public void setEnemigo(Enemigo enemigo){
    this.enemigo = enemigo;
  }

  public Enemigo getEnemigo(){
    return enemigo;
  }

  public void setTipoContenido(int tipoContenido){
    this.tipoContenido = tipoContenido;
  }

  public int getTipoContenido(){
    return tipoContenido;
  }

}