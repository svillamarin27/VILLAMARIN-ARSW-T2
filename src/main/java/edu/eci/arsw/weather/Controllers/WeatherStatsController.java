package edu.eci.arsw.weather.Controllers;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.weather.model.City;
import edu.eci.arsw.weather.services.WeatherStatsService;
import edu.eci.arsw.weather.services.WeatherStatsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/informacion")
public class WeatherStatsController {
    @Autowired
    private WeatherStatsService weatherStatsService;
    @GetMapping("/weather/{nombre}")
    public ResponseEntity<?> getWeatherByCity(@PathVariable String nombre){
        Map<String,String> error= new HashMap<>();
        try{
            City datos = weatherStatsService.getStatsByCity(nombre);
            return new ResponseEntity<>(datos, HttpStatus.OK);
        }catch (UnirestException e){
            error.put("error", e.getMessage());
            return  new ResponseEntity<>(error,HttpStatus.FORBIDDEN);
        }
    }
} 