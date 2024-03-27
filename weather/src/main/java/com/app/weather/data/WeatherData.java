package com.app.weather.data;

// WeatherData.java


public class WeatherData {

    private String cityName;
    private String temperature;
    private String weatherDescription;
    private String humidity;
    private String windSpeed;
    private String pressure;
    private String lastUpdated;

    // Construtor
    public WeatherData(String cityName, String temperature, String weatherDescription, String humidity, String windSpeed, String pressure, String lastUpdated) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.weatherDescription = weatherDescription;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.lastUpdated = lastUpdated;
    }
    // Getters e setters

	public String getCityName() {
		return cityName;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}

	public String getPressure() {
		return pressure;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getWeatherDescription() {
		return weatherDescription;
	}

	public void setWeatherDescription(String weatherDescription) {
		this.weatherDescription = weatherDescription;
	}

    
}