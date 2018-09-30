package com.example.demo.beer;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BeerCommandLineRunner implements CommandLineRunner {

	private final BeerRepository repository;

	public BeerCommandLineRunner(BeerRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... args) throws Exception {
		Stream.of("Brahma", "Skol", "Bavaria", "Sol").forEach(name -> repository.save(new Beer(name)));
		repository.findAll().forEach(System.out::println);
	}

}
