package com.spb.StrangersPlayBackend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spb.StrangersPlayBackend.dto.AccountDto;
import com.spb.StrangersPlayBackend.dto.AdvertisementDto;
import com.spb.StrangersPlayBackend.model.Category;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.spring.web.json.Json;
import springfox.documentation.spring.web.json.JsonSerializer;

import java.time.Instant;

@SpringBootApplication
public class StrangersPlayBackendApplication {

	public static void main(String[] args) {
		AdvertisementDto accountDto = new AdvertisementDto();
		accountDto.setCategory(Category.PILKA_NOZNA);
		accountDto.setLevel(1);
		accountDto.setPrice(10.0);
		accountDto.setCreationTime(Instant.now());
		accountDto.setUsername("janusz");
		accountDto.setEventTime("2019-11-11T15:52:50.065Z");
		accountDto.setTitle("granie w piłkę");
		accountDto.setDescription("granie w piłke za 3 DS PŁ");
		accountDto.setEventLocation("3 ds PŁ");
		ObjectMapper mapper = new ObjectMapper();
		try {
			System.out.println(mapper.writeValueAsString(accountDto));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		SpringApplication.run(StrangersPlayBackendApplication.class, args);
	}

}
