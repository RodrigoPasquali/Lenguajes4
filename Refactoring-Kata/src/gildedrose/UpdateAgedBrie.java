package gildedrose;

public class UpdateAgedBrie extends Update{
	private UpdateSulfuras updateSulfuras;
	
	public UpdateAgedBrie(Item item) {
		super(item);
		this.updateSulfuras = new UpdateSulfuras(item);
	}

	@Override
	public void actualizar() {
		if(this.getItem().name.equals("AgedBrie")){
			this.getItem().quality++;
		}else{
			setSiguiente(this.updateSulfuras);
		}
		
	}
}
