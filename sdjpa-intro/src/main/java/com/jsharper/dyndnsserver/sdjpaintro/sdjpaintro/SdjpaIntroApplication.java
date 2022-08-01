package com.jsharper.dyndnsserver.sdjpaintro.sdjpaintro;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
//@Profile({"local", "default", "remote-cloud"})
public class SdjpaIntroApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SdjpaIntroApplication.class, args);
		 new SpringApplicationBuilder(SdjpaIntroApplication.class)
         .profiles("local", "remote-cloud", "default", "remote-cloud-pg", "remote-cloud-mgdb")
         .run(args);
	}

}
