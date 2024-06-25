package com.example.CrudProducts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@SpringBootApplication
@RestController
public class ProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsApplication.class, args);
	}
	/*
	//Prueba Conexión
	@GetMapping(path = "/")
	public List<String> getNames(){
		return List.of(
				"Ezequiel",
				"Alexis"
		);
	}
	*/
}
