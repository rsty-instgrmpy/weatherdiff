package weatherAppMvn;

public class WeatherResponse {
	// top level:
	
	public WeatherObservation current_observation;
		
	public class WeatherObservation {
		
		public float temp_c;
		public float feelslike_c;
		public float wind_kph;
		public float precip_today_metric;
		public ObservationLocation observation_location;
		
		
		public class ObservationLocation {
			
			public String city;
		}
				
	}

}

