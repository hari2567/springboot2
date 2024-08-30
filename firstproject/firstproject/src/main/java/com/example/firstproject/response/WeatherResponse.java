package com.example.firstproject.response;

public class WeatherResponse {
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }
  private String location;
public static  class Current{

}
  public Current getCurrent() {
    return current;
  }

  public void setCurrent(Current current) {
    this.current = current;
  }

  private  Current current;
 private double temperature;

  public double getTemperature() {
    return temperature;
  }

  public void setTemperature(double temperature) {
    this.temperature = temperature;
  }
  private  String description;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
  public  WeatherResponse(String location,Current current){
    this.location=location;
    this.current=current;
  }
}
