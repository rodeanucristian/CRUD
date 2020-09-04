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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.proiect.model.Camera;
import com.proiect.model.Cladire;
import com.proiect.model.Usa;
import com.proiect.repository.CameraRepository;
import com.proiect.repository.CladireRepository;
import com.proiect.repository.UsaRepository;



@RestController
@RequestMapping("usi")
public class UsaController {
	
	
	@Autowired
	UsaRepository usaRepository;
	@Autowired
	CameraRepository cameraRepository;
	
	// returneaza usile
		@GetMapping("all")
		public List<Usa> getAllUsi()
		{	
			List<Usa> usa=(List<Usa>) usaRepository.findAll(); 
			return usa;
		}
		
		
		// adauga usa
		@PostMapping("add")
		public Usa addUsa(@RequestBody Usa usa)
		{
			
			
			
			
			if (usa.getCamera1_id() != null) {
		
			Camera camera1 ;
			camera1 = cameraRepository.getOne(usa.getCamera1_id());
			usa.setCamera1(camera1);
			
			}
			
			if (usa.getCamera2_id() != null) {
			
			Camera camera2 ;
			camera2 = cameraRepository.getOne(usa.getCamera2_id());
			usa.setCamera2(camera2);
			
			}
		

			
		if (usa.getExterior().equals("exterioara")) { 
			
			
			
			
			usa.setCamera2(null);
		
		
		} 
		
		if (usa.getExterior().equals("interioara")) {
			
			usa.setCamera2(null);
			usa.setCamera1(null); 
			
			
		}
			
		
			return usaRepository.save(usa);
		}
		
		// returneaza usa dupa id 
		@GetMapping("usa/{id}")
		public Optional<Usa> getUsaId(@PathVariable int id)
		{
			return usaRepository.findById(id);
		}
		
		// update usa
		@PutMapping("update/{id}")
		public ResponseEntity<Object> updateUsa(@RequestBody Usa usa ,@PathVariable int id)
		{
			
			
			
			Optional<Usa> usaOptional = usaRepository.findById(id);

			if (!usaOptional.isPresent())
				return ResponseEntity.notFound().build();

			if (usa.getCamera1_id() != null) {
				
				Camera camera1 ;
				camera1 = cameraRepository.getOne(usa.getCamera1_id());
				usa.setCamera1(camera1);
				
				}
			
			if (usa.getCamera2_id() != null) {
				
				Camera camera2 ;
				camera2 = cameraRepository.getOne(usa.getCamera2_id());
				usa.setCamera2(camera2);
				
				}
			
			usa.setId(id);
			
			usaRepository.save(usa);

			return ResponseEntity.noContent().build();
			
			
			
		}
		
		// sterge usa 
		@DeleteMapping("delete/{id}")
		public void deleteUsa(@PathVariable int id)
		{
			usaRepository.deleteById(id);
		}
	

}
