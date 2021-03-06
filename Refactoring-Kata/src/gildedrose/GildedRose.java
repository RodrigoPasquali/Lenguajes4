package gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
    	//Recorre array de item
        for (int i = 0; i < items.length; i++) {
        	//Resta 1 a calidad a item != a "nombreItemxxx"
         	//Si nombre != Aged Brie y != Backstage passes to a TAFKAL80ETC concert
            if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            //Si nombrItem = AgedBrie o Backstage passes to a TAFKAL80ETC concert
            } else {
            	//Entra cuando es AgedBrie
            	
            	if (items[i].quality < 50) {
            		//Suma 1 a calidad si es <50
            		//items[i].quality = items[i].quality + 1;
            		actualizarAgedBrie(items[i]);

            		//Si el nombr es Backstage passes to a TAFKAL80ETC concert
                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        //Precio < 11
                    	if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                            	//Suma 1 a calidad
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    	//Precio < 6
                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                            	//Suma 1 a calidad
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }
       
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
    

    private int degradarCalidadPorActualizacion(Item item){
    	int itemActualizado = item.quality--;
    	return itemActualizado;
    }
    
    private void actualizarAgedBrie (Item item){
    	item.quality ++;
    }
    
    private void actualizacionGeneralItem (Item item){
    	item.quality --;
    }
    
    
    
    
}
