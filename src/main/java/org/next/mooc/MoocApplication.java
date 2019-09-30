package org.next.mooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableCaching(proxyTargetClass = true)
@EnableAsync
public class MoocApplication {
	public static void main(String[] args) {
		SpringApplication.run(MoocApplication.class, args);
	}
}
