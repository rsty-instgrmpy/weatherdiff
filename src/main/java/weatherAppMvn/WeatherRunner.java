package weatherAppMvn;

public class WeatherRunner {
	Weather wdiff = new Weather();
	public Weather diffCalc(Weather home, Weather away) {
		
		float tempdiff = away.getTemp() - home.getTemp();
		float winddiff = away.getWind() - home.getWind();
		float feelslikediff = away.getFeelsLike() - home.getFeelsLike();
		float raindiff = away.getRain() - home.getRain();
		
		wdiff.setTemp(tempdiff);
		wdiff.setWind(winddiff);
		wdiff.setFeelsLike(feelslikediff);
		wdiff.setRain(raindiff);
		
		return wdiff;
	}
	static final String DEGREE  = "\u00b0" + "C";
	
	public static void formatter( Weather wdiff, Weather home, Weather away ) {
		System.out.println( "Good morning! It is currently "+ home.getTemp() + DEGREE + " in " + home.getName() );
		System.out.println( "Today, in "+ away.getName() + " it's currently " + away.getTemp() + DEGREE + ", and feels like " + away.getFeelsLike() + DEGREE);
		System.out.println( "Expect "+ home.getRain() + " CM of rain in " + home.getName() + ", and " + away.getRain() + " CM of rain in " + away.getName() );
		System.out.print( "Your destination will feel ");
		System.out.printf("%.2f", wdiff.getFeelsLike()); 
		System.out.print( DEGREE + tempCompare( wdiff ) + ", and will have ");
		System.out.printf("%.1f", wdiff.getRain()); 
		System.out.print( rainCompare( wdiff ) );
		
	}
    
	public static String rainCompare(Weather wdiff) {
		String rainCompare = null;
		if ( wdiff.getRain() > 0 ) {
			rainCompare = " CM more rain";
		} else {
			rainCompare  = " CM less rain";
		}
		return rainCompare ;
	}
	
	public static String tempCompare(Weather wdiff) {
		String tempCompare = null;
		if ( wdiff.getTemp() > 0 ) {
			tempCompare = " warmer";
		} else {
			tempCompare = " colder";
		}
		return tempCompare;
	}
	
	public static void main(String[] args) {
		 
		Weather w1 = new Weather();
		Weather w2 = new Weather();
		
		WeatherApiRunner home = new WeatherApiRunner();
		w1 = home.getWeather("94118");
		
		WeatherApiRunner away = new WeatherApiRunner();
		w2 = away.getWeather("94107");
		
		WeatherRunner t = new WeatherRunner();
		t.diffCalc(w1, w2);
//		System.out.println( t.wdiff.getTemp() );
//		System.out.println( t.wdiff.getWind() );
		formatter(t.wdiff, w1, w2);
		
	}

}
