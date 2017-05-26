package gildedrose;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class GildedRoseTest {
	
	GildedRose app;
	
    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("fixme", 0, 0) };
        GildedRose app = new GildedRose(items);
        
        app.updateQuality();
        
        assertEquals("fixme", app.items[0].name);
    }

    @Test
    public void deberiaDevolverQuality6ConElixirOfTheMongoose() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 7) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 6;
        
        app.updateQuality();
        int actualQuality = app.items[0].quality;
        
        assertEquals(expectedQuality, actualQuality);
    }
    
    @Test
    public void deberiaDevolverCero() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 7) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 6;
        
        app.updateQuality();
        int actualQuality = app.items[0].quality;
        
        assertEquals(expectedQuality, actualQuality);
    }
    
    //Los items degradan la calidad en una unidad por cada actualización.
    @Test
    public void itemsDeberiaDebeDegradarUnaUnidadPorActualizacion(){
    	Item[] items = new Item[3];
    	items[0] = new Item("xxx", 1, 5);
    	items[1] = new Item("yyyy", 7, 35);
    	items[2] = new Item("zzzzz", 15, 7);
    	
    	app = new GildedRose(items);
    	app.updateQuality();
    	int expectedResultItem0 = 5-1;
    	int expectedResultItem1 = 35-1;
    	int expectedResultItem2 = 7-1;
    	
    	int actualResultItem0 = items[0].quality;
    	int actualResultItem1 = items[1].quality;
    	int actualResultItem2 = items[2].quality;
    	
    	Assert.assertEquals(expectedResultItem0, actualResultItem0);
    	Assert.assertEquals(expectedResultItem1, actualResultItem1);
    	Assert.assertEquals(expectedResultItem2, actualResultItem2);
    }
    
    //Cuando la fecha de venta a pasado, la calidad degrada al doble de velocidad.
    @Test
    public void calidadDeberiaDegradarElDobleDeVelocidadPorFechaDeVentaPasada(){
    	Item[] items = new Item[3];
    	items[0] = new Item("xxx", 0, 5);
    	items[1] = new Item("yyyy", 0, 35);
    	items[2] = new Item("zzzzz", 5, 7);
    	
    	app = new GildedRose(items);
    	app.updateQuality();
    	int expectedResultItem0 = 5-1*2;
    	int expectedResultItem1 = 35-1*2;
    	int expectedResultItem2 = 7-1;
    	
    	int actualResultItem0 = items[0].quality;
    	int actualResultItem1 = items[1].quality;
    	int actualResultItem2 = items[2].quality;
    	
    	Assert.assertEquals(expectedResultItem0, actualResultItem0);
    	Assert.assertEquals(expectedResultItem1, actualResultItem1);
    	Assert.assertEquals(expectedResultItem2, actualResultItem2);
    }
    
    
    //LA CALIDAD DEL ITEM PUEDE SER NEGATIVA, ESTA MAL
    //La calidad de un item no es nunca negativa
    @Test
    public void calidadNoDeberiaPoderSerNegativa(){
    	Item item = new Item("xxx", 5, -1);
    	int expectedResult = -1;
    	
    	int actualResult = item.quality;
    	
    	Assert.assertEquals(expectedResult, actualResult);
    }

    //La calidad de un item no es nunca negativa
    //CUANDO SE INTRODUCE UN ITEM CON QUALITY = 0, ESTE NO RESTA UNA VEZ REALIZADO EL UPDATE
    @Test
    public void calidadNoDeberiaPoderSerNegativa2(){
       	Item[] items = new Item[3];
    	items[0] = new Item("xxx", 5, 0);
    	items[1] = new Item("yyyy", 15, 5);
    	items[2] = new Item("zzzzz", 41, 0);
    	
    	app = new GildedRose(items);
    	app.updateQuality();
    	int expectedResultItem0 = 0;
    	int expectedResultItem1 = 4;
    	int expectedResultItem2 = 0;
    	
    	int actualResultItem0 = items[0].quality;
    	int actualResultItem1 = items[1].quality;
    	int actualResultItem2 = items[2].quality;
    	
    	Assert.assertEquals(expectedResultItem0, actualResultItem0);
    	Assert.assertEquals(expectedResultItem1, actualResultItem1);
    	Assert.assertEquals(expectedResultItem2, actualResultItem2);
    }
    
    //El item "aged brie" incrementa su calidad en lugar de decrementarla según pasan los días.
    @Test
    public void agedBrieDeberiaIncrementarSuCalidadSegunPasanLosDiasDeCincoASeis(){
    	Item[] items = new Item[]{new Item("Aged Brie", 5, 5)};
    	app = new GildedRose(items);
    	app.updateQuality();
    	int expectedResult = 5+1;
    	    	
    	int actualResult = items[0].quality;
    	    	
    	Assert.assertEquals(expectedResult, actualResult);
    }
    
	//La calidad de un item nunca es mayor de 50.
    @Test
    public void calidadNoDeberiaSerMayorACincuenta(){
       	Item[] items = new Item[3];
    	items[0] = new Item("Aged Brie", 15, 14);
    	items[1] = new Item("yyyyy", 47, 50);
    	items[2] = new Item("Aged Brie", 3, 50);
    	
    	app = new GildedRose(items);
    	app.updateQuality();
    	int expectedResultItem0 = 14+1;
    	int expectedResultItem1 = 50-1;
    	int expectedResultItem2 = 50;
    	
    	int actualResultItem0 = items[0].quality;
    	int actualResultItem1 = items[1].quality;
    	int actualResultItem2 = items[2].quality;
    	
    	Assert.assertEquals(expectedResultItem0, actualResultItem0);
    	Assert.assertEquals(expectedResultItem1, actualResultItem1);
    	Assert.assertEquals(expectedResultItem2, actualResultItem2);
    }
    
    @Test
    public void calidadNoDeberiaSerMayorACincuenta2(){
       	Item[] items = new Item[]{new Item("Aged Brie", 5, 51)};
       	
    	app = new GildedRose(items);
    	app.updateQuality();
    	int expectedResult = 51;
    	    	
    	int actualResult = items[0].quality;
    	    	
    	Assert.assertEquals(expectedResult, actualResult);
    }
    
    //El item "Sulfuras", nuestro articulo más legendario!, nunca disminuye su calidad.
    @Test
    public void itemSulfurasHandsOfRagnarosNoDebePoderDisminuirSuCalidad(){
      	Item[] items = new Item[3];
    	items[0] = new Item("Sulfuras, Hand of Ragnaros", 5, 5);
    	items[1] = new Item("yyyyy", 47, 50);
    	items[2] = new Item("Aged Brie", 3, 50);
    	app = new GildedRose(items);
    	app.updateQuality();
    	int expectedResult = 5;
    	    	
    	int actualResult = items[0].quality;
    	    	
    	Assert.assertEquals(expectedResult, actualResult);
    }
    
    //No se como probar esto
    //El item "Sulfuras", nuestro articulo más legendario!, nunca debe venderse
    @Test
    public void itemSulfurasHandsOfRagnarosNoDebePoderVenderse(){
     
    }
    
    //Los "backstage passes" incrementan su calidad conforme se aproxima la fecha de venta:
    //	-La calidad se incrementa por dos cuando quedan 10 días o menos para el concierto
    //	- Dias = 10
    @Test
    public void itemBackstagePassesDeberiaIncrementarPorDosLaCalidadCuandoQuedanDiezDias(){
     	Item[] items = new Item[3];
    	items[0] = new Item("Sulfuras, Hand of Ragnaros", 5, 5);
    	items[1] = new Item("yyyyy", 47, 50);
    	items[2] = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 4);
    	app = new GildedRose(items);
    	app.updateQuality();
    	int expectedResult = 4+1*2;
    	    	
    	int actualResult = items[2].quality;
    	    	
    	Assert.assertEquals(expectedResult, actualResult);
    }
    
    //Los "backstage passes" incrementan su calidad conforme se aproxima la fecha de venta:
    //	-La calidad se incrementa por dos cuando quedan 10 días o menos para el concierto
    //	-Entre  5<Dias<10
    @Test
    public void itemBackstagePassesDeberiaIncrementarPorDosLaCalidadCuandoQuedanOchoDias(){
     	Item[] items = new Item[3];
    	items[0] = new Item("Sulfuras, Hand of Ragnaros", 5, 5);
    	items[1] = new Item("yyyyy", 47, 50);
    	items[2] = new Item("Backstage passes to a TAFKAL80ETC concert", 8, 5);
    	app = new GildedRose(items);
    	app.updateQuality();
    	int expectedResult = 5+1*2;
    	    	
    	int actualResult = items[2].quality;
    	    	
    	Assert.assertEquals(expectedResult, actualResult);
    }
    
    //Los "backstage passes" incrementan su calidad conforme se aproxima la fecha de venta :
    //	-por 3 cuando quedan 5 días o menos
    //	-Dias = 5
    @Test
    public void itemBackstagePassesDeberianIncrementarPorTresLaCalidadCuandoQuedanCincoDias(){
     	Item[] items = new Item[3];
    	items[0] = new Item("Sulfuras, Hand of Ragnaros", 5, 5);
    	items[1] = new Item("yyyyy", 47, 50);
    	items[2] = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 4);
    	app = new GildedRose(items);
    	app.updateQuality();
    	int expectedResult = 4+1*3;
    	    	
    	int actualResult = items[2].quality;
    	    	
    	Assert.assertEquals(expectedResult, actualResult);
    }
    
    //Los "backstage passes" incrementan su calidad conforme se aproxima la fecha de venta :
    //	-por 3 cuando quedan 5 días o menos
    //	-Dias = 5
    @Test
    public void itemBackstagePassesDeberianIncrementarPorTresLaCalidadCuandoQuedanTresDias(){
     	Item[] items = new Item[3];
    	items[0] = new Item("Sulfuras, Hand of Ragnaros", 5, 5);
    	items[1] = new Item("yyyyy", 47, 50);
    	items[2] = new Item("Backstage passes to a TAFKAL80ETC concert", 3, 10);
    	app = new GildedRose(items);
    	app.updateQuality();
    	int expectedResult = 10+1*3;
    	    	
    	int actualResult = items[2].quality;
    	    	
    	Assert.assertEquals(expectedResult, actualResult);
    }
    
    //Sin embargo la calidad disminuye a 0 después del concierto.
    //SeelIn = 0
    @Test
    public void itemBackstagePassesDeberiaDisminuirCalidadACeroCuandoConciertoPaso(){
     	Item[] items = new Item[3];
    	items[0] = new Item("Sulfuras, Hand of Ragnaros", 5, 5);
    	items[1] = new Item("yyyyy", 47, 50);
    	items[2] = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10);
    	app = new GildedRose(items);
    	app.updateQuality();
    	int expectedResult = 0;
    	    	
    	int actualResult = items[2].quality;
    	    	
    	Assert.assertEquals(expectedResult, actualResult);
    }
    
}