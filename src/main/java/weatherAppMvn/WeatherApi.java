package weatherAppMvn;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


//import retrofit2;

//example call:
//richmond 
//// http://api.wunderground.com/api/c2d2e80944ae6bf9/conditions/q/94110.json
////http://api.wunderground.com/api/c2d2e80944ae6bf9/conditions/q/94118.json
// API key

public interface WeatherApi	{
	@GET("conditions/q/{zipcode}.json")
	Call<WeatherResponse> getConditions(@Path("zipcode") String zipcode);
	
// if i want to add a different endpoint, say forecast...
//	@GET("forecast/q/{zipcode}.json")
//	Call<List<Weather>> getForecast(@Path("zipcode") String zipcode);
	
//	hourly! see: http://api.wunderground.com/api/c2d2e80944ae6bf9/hourly/q/94118.json
	
}
