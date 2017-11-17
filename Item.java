public class Item extends Objeto{

    protected int upPuntosVida;
    protected int upPtsExp;

    public Item(int upPuntosVida, int upPtsExp, String nombre, String explicacion){
      super(nombre, explicacion);
      this.upPuntosVida = upPuntosVida;
      this.upPtsExp = upPtsExp;
    }

    public void setUpPuntosVida (int upPuntosVida){
      this.upPuntosVida = upPuntosVida;
    }

    public int getUpPuntosVida(){
      return upPuntosVida;
    }

    public void setUpPtsExp (int upPtsExp){
      this.upPtsExp = upPtsExp;
    }

    public int getPtsExp(){
      return upPtsExp;
    }

}
