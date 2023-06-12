package com.example.aroundhub;

import com.example.aroundhub.config.ProfileManager;
import com.example.aroundhub.config.env.EnvConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@EnableJpaAuditing	// JAP에서 AUditing은 각 엔티티 별로 누가, 언제 접근했는지 기록하여 감시 체계를 꾸리는 것을 의미 // -> Configuration class 생성을 통해서도 가능하다.(JpaAuditingConfiguration)
public class AroundHubSpringBootApplication {

	private final Logger LOGGER = LoggerFactory.getLogger(AroundHubSpringBootApplication.class);

	@Autowired
	public AroundHubSpringBootApplication(EnvConfiguration envConfiguration, ProfileManager profileManager) {
		LOGGER.info(envConfiguration.getMessage());
		profileManager.printActiveProfiles();
	}

	public static void main(String[] args) {
		SpringApplication.run(AroundHubSpringBootApplication.class, args);
	}

}
