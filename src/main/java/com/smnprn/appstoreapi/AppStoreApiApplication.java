package com.smnprn.appstoreapi;

import com.smnprn.appstoreapi.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class AppStoreApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppStoreApiApplication.class, args);
	}

}
