package com.example.firstproject.controller;

import com.example.firstproject.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class WeatherController {

  @Value("${api.key}")
  private  String apiKey;
 @GetMapping("/abc")
 public  String getIndex(){
   return "index";
 }
  @GetMapping("/weather")
  public  String getWeather(@RequestParam("city") String city, Model model){
   String url="http://api.openweathermap.org/data/?weather?q="+city+"&appId="+apiKey+"&units=metrics";
   RestTemplate restTemplate=new RestTemplate();
   WeatherResponse  weatherResponse=restTemplate.getForObject(url,WeatherResponse.class);
   if(weatherResponse!=null){
     model.addAttribute("location",weatherResponse.getLocation());
     model.addAttribute("current",weatherResponse.getCurrent());
     model.addAttribute("description",weatherResponse.getDescription());
     model.addAttribute("temperature",weatherResponse.getTemperature());
   }
   else{
     model.addAttribute("error","city not found");
   }
   return "weather";
  }
}
