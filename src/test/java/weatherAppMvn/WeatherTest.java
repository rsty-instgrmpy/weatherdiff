package weatherAppMvn;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeatherTest {

	@Test
	public void testWeather() {
		Weather w1 = new Weather();
		
		w1.setWind(22.2f);
		w1.setTemp(44.4f);
		
		float testwind = 22.2f;
		float testtemp = 44.4f;
		
		assertEquals(testwind, w1.getWind(), .001);
		assertEquals(testtemp, w1.getTemp(), .001);
	}

}
