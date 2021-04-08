package edu.eci.arsw.weather.services.impl;

import com.google.gson.Gson;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.weather.model.*;
import edu.eci.arsw.weather.httpconnectionservices.HttpWeatherServiceI;
import edu.eci.arsw.weather.services.WeatherStatsService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherStatsServiceImpl implements WeatherStatsService {
    @Autowired
    private HttpWeatherServiceI weatherService;
    @Override
    public City getStatsByCity(String name) throws UnirestException {
        City cityWeather = new City();
        JSONObject object = weatherService.getWeatherByCity(name);
        Coord coord = formatObject("coord",object,Coord.class);
        Clouds clouds = formatObject("clouds",object,Clouds.class);
        MainStats mainStats = formatObject("main",object,MainStats.class);
        JSONObject objectWeather = object.getJSONArray("weather").getJSONObject(0);
        Weather weather = mapWeather(objectWeather);
        cityWeather.setCoord(coord);
        cityWeather.setWeather(weather);
        cityWeather.setClouds(clouds);
        cityWeather.setName(object.getString("name"));
        cityWeather.setTimezone(object.getInt("timezone"));
        cityWeather.setCod(object.getInt("cod"));
        cityWeather.setVisibility(object.getInt("visibility"));
        return null;
    }

    private Weather mapWeather(JSONObject objectWeater) {
        Gson gson = new Gson();
        return gson.fromJson(objectWeater.toString(),Weather.class);
    }
    private <T> T formatObject(String objectName, JSONObject object, Class objectClass){
        Gson gson = new Gson();
        String stringObject =  object.getJSONObject(objectName).toString();
        T formattedObject = (T) gson.fromJson(stringObject,objectClass);
        return formattedObject;
    }

}