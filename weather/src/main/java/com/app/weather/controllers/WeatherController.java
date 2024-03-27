package com.app.weather.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.app.weather.data.WeatherData;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class WeatherController {

	@Autowired
	private RestTemplate restTemplate;

    // Página inicial, exibe o formulário para inserir a cidade
	@GetMapping("/")
	public String showWeatherForm() {
		return "weather-form";
	}
 
    // Endpoint para obter dados meteorológicos com base na cidade fornecida
	@PostMapping("/weather")
	public String getWeatherData(@RequestParam String city, Model model) {
	    String apiKey = "fbb78cb67ba1708ffd134cfed4a1c877";
	    String apiUrl = "http://api.weatherstack.com/current?access_key=" + apiKey + "&query=" + city ;

	    try {
	        // Realiza a chamada à API
	        String weatherJson = restTemplate.getForObject(apiUrl, String.class);

	        // Desserializa os dados JSON para um objeto Java
	        WeatherData weatherData = parseWeatherJson(weatherJson);

	        // Adiciona os dados ao modelo
	        model.addAttribute("weatherData", weatherData);

	        return "weather-result";
	    } catch (Exception e) {
	        e.printStackTrace();
	        model.addAttribute("error", "Error retrieving weather data. Please try again.");
	        return "weather-result";
	    }
	}

    // Método para analisar a resposta JSON da API Weatherstack e converter em um objeto Java
	private WeatherData parseWeatherJson(String weatherJson) {
	    try {
	        ObjectMapper objectMapper = new ObjectMapper();
	        JsonNode rootNode = objectMapper.readTree(weatherJson);

	        // Verifica se os nós JSON necessários estão presentes
	        JsonNode locationNode = rootNode.path("location");
	        JsonNode currentWeatherNode = rootNode.path("current");
	        if (locationNode.isMissingNode() || currentWeatherNode.isMissingNode()) {
	            return null; // Retorna null se dados essenciais não estiverem presentes
	        }

	        // Extrai informações específicas do JSON
	        String cityName = locationNode.path("name").asText();
	        String temperature = currentWeatherNode.path("temperature").asText();
	        String weatherDescription = currentWeatherNode.path("weather_descriptions").get(0).asText();
	        String humidity = currentWeatherNode.path("humidity").asText();
	        String windSpeed = currentWeatherNode.path("wind_speed").asText();
	        String pressure = currentWeatherNode.path("pressure").asText();
	        String lastUpdated = currentWeatherNode.path("observation_time").asText();

	        return new WeatherData(cityName, temperature, weatherDescription, humidity, windSpeed, pressure, lastUpdated);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

}