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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.proiect.model.Camera;
import com.proiect.model.Cladire;
import com.proiect.model.Usa;
import com.proiect.repository.CameraRepository;
import com.proiect.repository.CladireRepository;



@RestController
@RequestMapping("camere")
public class CameraController {
	
	
	@Autowired
	CameraRepository cameraRepository;
	
	@Autowired
	CladireRepository cladireRepository;
	
	
	// Returneaza camerele din baza
	
	
		@GetMapping("all")
		public List<Camera> getAllCamere()
		{	
			List<Camera> camera=(List<Camera>) cameraRepository.findAll(); 
			return camera;
		}
		
	
		// Insereaza camera noua
		
		@PostMapping("add")
		public Camera addCamera(@RequestBody Camera camera)
		{
			
			
			if (camera.getCladire_id()!=null) {
				Cladire cladire ;
				cladire = cladireRepository.getOne(camera.getCladire_id());
				camera.setCladire(cladire);
				}
			
			return cameraRepository.save(camera);
			
			
		}
		
		// Returneaza camera dupa id
		
		
		@GetMapping("camera/{id}")
		public Optional<Camera> getCameraId(@PathVariable int id)
		{
			return cameraRepository.findById(id);
		}
		
	
		// Update camera 
		
		@PutMapping("update/{id}")
		public ResponseEntity<Object> updateCamera(@RequestBody Camera camera, @PathVariable int id)
		{
			Optional<Camera> cameraOptional = cameraRepository.findById(id);

			if (!cameraOptional.isPresent())
				return ResponseEntity.notFound().build();

				if (camera.getCladire_id()!=null) {
				
				Cladire cladire ;
				cladire = cladireRepository.getOne(camera.getCladire_id());
				camera.setCladire(cladire);
				
				}
			
			
			camera.setId(id);
			
			cameraRepository.save(camera);

			return ResponseEntity.noContent().build();
		}
		
		
		// sterge camera
		
		@DeleteMapping("delete/{id}")
		public void deleteCamera(@PathVariable int id)
		{
			cameraRepository.deleteById(id);
		}
	

}
