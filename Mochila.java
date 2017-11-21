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

	public void guardarItem(Item item, int index){
		items[index] = item;
	}

	public void guardarArma(Arma arma, int index){
		armas[index] = arma;
	}
}