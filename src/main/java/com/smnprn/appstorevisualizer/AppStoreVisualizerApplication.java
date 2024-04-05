package com.smnprn.appstorevisualizer;

import com.smnprn.appstorevisualizer.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class AppStoreVisualizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppStoreVisualizerApplication.class, args);
	}

}
