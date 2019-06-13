package org.tensorflow.lite.examples.classification.API.APIService;



import org.tensorflow.lite.examples.classification.models.CityWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherServices {
    @GET("forecast/daily")
    Call<CityWeather> getWeatherCity (@Query("q") String city, @Query("APPID")String key, @Query("units") String units , @Query("cnt") int days);
}
