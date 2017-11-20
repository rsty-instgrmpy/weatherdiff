package weatherAppMvn;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherApiRunner {
	public Weather getWeather(String zipcode) { // returning Weather type, so need to convert from json to Weather type within function.
		Gson gson = new GsonBuilder()
	            .setLenient()
	            .create();
		
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://api.wunderground.com/api/c2d2e80944ae6bf9/")
				.addConverterFactory(GsonConverterFactory.create(gson)) // adding a converter factory for API data
	            .build();
		
		WeatherApi weatherAPI = retrofit.create(WeatherApi.class);   // WeatherApi.class as a parameter
		Call<WeatherResponse> call = weatherAPI.getConditions(zipcode); // create Call object, with WeatherApi interface class
	    
		WeatherResponse wr = null;
		
		try {
			Response<WeatherResponse> results = call.execute();
			
			wr = results.body();
			
		} catch (IOException e) {
			e.printStackTrace();
		} // synchronously call itself, store in Results object?
		
//		System.out.print("api returns ");
//		System.out.println(wr.current_observation.temp_c);
//		
//		System.out.print("in ");
//		System.out.println( wr.current_observation.observation_location.city );
		

	    // TODO: read Response class documentation; 
	    // TODO: read Gson class documentation;
	    // TODO: create & return Weather object from WeatherResponse (using Gson library)
		Weather w = new Weather();
//		System.out.println("Weather object created");
		
		w.setTemp( wr.current_observation.temp_c );
		w.setName( wr.current_observation.observation_location.city );
		w.setFeelsLike( wr.current_observation.feelslike_c );
		w.setRain ( wr.current_observation.precip_today_metric );
		w.setWind( wr.current_observation.wind_kph );
		
//		System.out.print("it is currently: ");
//		System.out.print(w.getTemp());
//		System.out.print(" celcius in ");
//		System.out.print(w.getName());
		return w;

		
		}
	
	
}
