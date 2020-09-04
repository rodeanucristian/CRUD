package com.proiect.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proiect.model.Cladire;
import com.proiect.repository.CladireRepository;


@RestController
@RequestMapping("cladiri")
public class CladireController {
	
	@Autowired
	CladireRepository cladireRepository;
	
		// returneaza cladiri
	
		@GetMapping("all")
		public List<Cladire> getAllCladiri()
		{	
			List<Cladire> cladire=(List<Cladire>) cladireRepository.findAll(); 
			return cladire;
		}
		
		// insereaza cladire noua in baza
		@PostMapping("add")
		public Cladire addCladire(@RequestBody Cladire cladire)
		{
			return cladireRepository.save(cladire);
		}
		
		// returneaza gladire dupa id
		@GetMapping("cladire/{id}")
		public Optional<Cladire> getCladireId(@PathVariable int id)
		{
			return cladireRepository.findById(id);
		}
		
		// update 
		@PutMapping("update/{id}")
		public ResponseEntity<Object> updateCladire(@RequestBody Cladire cladire ,@PathVariable int id )
		{
			Optional<Cladire> cladOptional = cladireRepository.findById(id);

			if (!cladOptional.isPresent())
				return ResponseEntity.notFound().build();

			cladire.setId(id);
			
			cladireRepository.save(cladire);

			return ResponseEntity.noContent().build();
			
		}
		
		// sterge
		@DeleteMapping("delete/{id}")
		public void deleteCladire(@PathVariable int id)
		{
			
			
			cladireRepository.deleteById(id);
		}
	
	

}
