package gildedrose;

public abstract class Update {
	
	private Update siguiente;
	private Item item;

	
	public Update(Item item){
		this.item = item;
	}
	
	public void setSiguiente(Update update){
		this.siguiente = update;
	}
	
	public Update getSiguiente(){
		return this.siguiente;
	}
	
	public abstract void actualizar();
	
	public Item getItem(){
		return this.item;
	}
}
