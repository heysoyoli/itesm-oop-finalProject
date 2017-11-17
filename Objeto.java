public abstract class Objeto{

  protected String nombre;
  protected String explicacion;
  //protected ImageIcon mostrarImagen;

  public Objeto(String nombre, String explicacion){
    this.nombre = nombre;
    this.explicacion = explicacion;
    //this.mostrarImagen =mostrarImagen;
  }

  public void setNombre (String nombre){
    this.nombre = nombre;
  }

  public String getNombre(){
    return nombre;
  }

  public void setExplicacion (String explicacion){
    this.explicacion = explicacion;
  }

  public String getExplicacion(){
    return explicacion;
  }

  /*public void setMostrarImagen(ImageIcon mostrarImagen){
		this.mostrarImagen= mostrarImagen;
	}

	public ImageIcon getMostrarImagen(){
		return mostrarImagen;
	}*/

}