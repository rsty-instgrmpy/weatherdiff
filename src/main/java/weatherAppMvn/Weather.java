package weatherAppMvn;

public class Weather {
	private float temp;
	private float wind;
	private String name;
	private float rain;
	private float feelsLike_c;
	
	public Weather () {
//		System.out.println("new Weather created");
	}
	
	public void setTemp(float temp_c) {
		this.temp = temp_c;
//		System.out.println("temp set");
	}
	public void setWind(float wind_kph) {
		this.wind = wind_kph;
//		System.out.println("wind set");
	}
	
	public void setName(String name) {
		this.name= name;
//		System.out.println("name set");
	}
	
	public void setRain(float precip_today_metric ) {
		this.rain = precip_today_metric ;
	}
	
	public void setFeelsLike( float feelslike_c) {
		this.feelsLike_c = feelslike_c;
	}
	
	public float getTemp() {
		return this.temp;
	}
	public float getWind() {
		return this.wind;
	}

	public String getName() {
		return this.name;
	}
	
	public float getRain() {
		return this.rain;
	}
	
	public float getFeelsLike() {
		return this.feelsLike_c;
	}
}
