package edu.eci.arsw.weather.services;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.weather.model.*;


public interface WeatherStatsService {City getStatsByCity(String name) throws UnirestException;}