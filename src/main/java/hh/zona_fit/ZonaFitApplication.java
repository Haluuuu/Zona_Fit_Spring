package hh.zona_fit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ZonaFitApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZonaFitApplication.class, args);
		var scan=new Scanner(System.in);
	}

}
