package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@Configuration
public class YoutubeDataApp {
	
	public static void main(String[] args) {
		SpringApplication.run(YoutubeDataApp.class, args);
	}
	
	@GetMapping("/youtube-data-api")
	public Object youtube(
			@RequestParam String key, 
			@RequestParam String part, 
			@RequestParam String q, 
			@RequestParam String channelId,
			@RequestParam String type,
			@RequestParam String maxResults) {
		
		String url = "https://www.googleapis.com/youtube/v3/search?key={key}&part={part}&q={q}&channelId={channelId}&type={type}&maxResults={maxResults}";
		
		Map<String,String> params = new HashMap<>();		
		params.put("key", key);
		params.put("part", part);
		params.put("q", q);
		params.put("channelId", channelId);
		params.put("type", type);
		params.put("maxResults", maxResults);
		
		RestTemplate rest = new RestTemplate();
		return rest.getForObject(url, Object.class, params);
	}

}
