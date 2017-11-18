public class Casilla{

  protected Item item;
  protected Arma arma;
  protected Enemigo enemigo;
  protected String historia;
  //protected boolean tipoEnemigo;
//  protected int numero;


public Casilla(String historia){
  this.historia = historia;
}

public Casilla(Enemigo enemigo){
    this.enemigo = enemigo;
  }

  public Casilla(Item item){
    this.item = item;
  }

  public Casilla(Arma arma){
    this.arma = arma;
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

}