
import org.junit.Assert;
import org.junit.Test;

import gildedrose.Item;

public class TestItem {

	@Test
	public void deberiaDevolverCacay45y5() {
		Item item = new Item("caca", 45, 5);
		String resultadoEsperado = "caca, 45, 5";
		
		String resultadoObtenido = item.toString();
		
		Assert.assertEquals(resultadoEsperado, resultadoObtenido);
	}

}
