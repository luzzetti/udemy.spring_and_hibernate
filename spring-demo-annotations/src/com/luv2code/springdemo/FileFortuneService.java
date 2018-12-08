package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	private List<String> frasi;	
	
	private String filename;
	
	Random random;
	
	private FileFortuneService() {
		this.filename = "C:\\Users\\chris\\eclipse-workspace\\spring-demo-annotations\\src\\fortune.frasi";
	}
	
	@PostConstruct
	public void loadFortunesFromFile() {
		
		System.out.println(">> Allocamento Risorse");
		System.out.println(">> Caricamento frasi da file");
		
		frasi = new LinkedList<String>();
		random = new Random();
		
		File theFile = new File(filename);
		
		System.out.println("Reading fortunes from file: " + theFile);
		System.out.println("File exists: " + theFile.exists());
		
		//Apro il file
		try {
			BufferedReader bf = new BufferedReader(new FileReader(theFile));
			String stringaLetta;
			
			//Leggo riga per riga e la aggiungo alla Lista
			while ((stringaLetta = bf.readLine()) != null) {
				frasi.add(stringaLetta);
			}
			
			bf.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String getFortune() {
		// 
		int randIndex = random.nextInt(frasi.size());
		String fortune = frasi.get(randIndex);
		return fortune;
	}
	
	@PreDestroy
	public void cleanStuff() {
		System.out.println("Disallocamento Risorse");
		random = null;
		frasi = null;
	}

}
