package com.johanlind.makeyouradventure;

import com.johanlind.makeyouradventure.Config.StorageProperties;
import com.johanlind.makeyouradventure.Interface.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class MakeyouradventuregameApplication {

	public static void main(String[] args) {
		SpringApplication.run(MakeyouradventuregameApplication.class, args);
	}

}
