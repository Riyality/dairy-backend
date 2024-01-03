package com.dairy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan( "com.dairy" )
@SpringBootApplication
public class DairyApiStarter {

	public static void main( String[] args ) {
		SpringApplication.run( DairyApiStarter.class, args );
	}
}
