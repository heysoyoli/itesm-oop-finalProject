public class Mochila{

	private Item[] items;
	private Arma[] armas;

	public Mochila(){
		this.items = new Item[2];
		this.armas = new Arma[2];
	}

	public Item[] getItems(){
		return items;
	}

	public Arma[] getArmas(){
		return armas;
	}

	public void guardarItem(Item item){
		items[0] = item;
	}

	public void guardarArma(Arma arma){
		armas[0] = arma;
	}
}