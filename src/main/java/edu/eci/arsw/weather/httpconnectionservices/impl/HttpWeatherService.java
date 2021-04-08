package edu.eci.arsw.weather.httpconnectionservices.impl;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import edu.eci.arsw.weather.httpconnectionservices.*;

@Service
public class HttpWeatherService implements HttpWeatherServiceI {
    @Override
    public JSONObject getWeatherByCity(String place)  {
    	HttpResponse<String> response = null;
		try {
			response = Unirest.get("https://api.openweathermap.org/data/2.5/weather?q=" + place + "&appid=ca9309f63db926b8928aeb46c81f0a62")
			        .asString();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new JSONObject(response.getBody());
    }
}