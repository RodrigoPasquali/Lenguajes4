package gildedrose;

public class UpdateBackstagePasses extends Update{
	
	private UpdateSulfuras updateSulfuras;
	
	public UpdateBackstagePasses(Item item) {
		super(item);
		this.updateSulfuras = new UpdateSulfuras(item);
	}
	
	@Override
	public void actualizar() {
		if(this.getItem().name.equals("Backstage passes to a TAFKAL80ETC concert")){
			this.getItem().quality++;
		}else{
			setSiguiente(this.updateSulfuras);
		}	
	}
	
	private void aumentarCalidadSegunSellIn(){
		
	}

}
