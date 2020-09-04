package com.proiect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.proiect.model.Camera;
import com.proiect.model.Cladire;


public interface CameraRepository extends JpaRepository<Camera, Integer>{

}
