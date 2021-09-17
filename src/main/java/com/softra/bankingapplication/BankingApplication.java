package com.softra.bankingapplication;

import java.util.Arrays;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.softra.bankingapplication.models.CreateUsers;

@SpringBootApplication
public class BankingApplication {
	
	public static String consumePostRestApis(RestTemplate template, Map<String, Object> beforeMap) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(beforeMap,headers);
		String url = "http://localhost:7777/users";
		template.exchange(url, HttpMethod.POST, entity, String.class).getBody();
		return null;
	}
	
	@Bean(name="resttemplate")
	public RestTemplate getRestTemplate() {
		
		return new RestTemplate();
	}

	public static void main(String[] args) {
//		SpringApplication.run(BankingApplication.class, args);
		
		ApplicationContext context = SpringApplication.run(BankingApplication.class, args);
		RestTemplate template = context.getBean("resttemplate", RestTemplate.class);
		
		CreateUsers cu = new CreateUsers();
		Map<String, Object> map1 = cu.create1();
		Map<String, Object> map2 = cu.create2();
		Map<String, Object> map3 = cu.create3();
		
		//PLEASE COMMENT LINES 48 TO 50 AFTER THE FIRST RUN!!!!!!!!!!!!!
		consumePostRestApis(template, map1);
		consumePostRestApis(template, map2);
		consumePostRestApis(template, map3);
	}

}
