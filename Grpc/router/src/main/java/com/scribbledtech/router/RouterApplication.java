package com.scribbledtech.router;

import com.scribbledtech.router.service.OkHttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Configuration
public class RouterApplication {


	public static void main(String[] args) {
		SpringApplication.run(RouterApplication.class, args);
	}

}
