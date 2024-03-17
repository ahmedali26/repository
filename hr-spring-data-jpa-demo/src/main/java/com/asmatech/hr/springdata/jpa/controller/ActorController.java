package com.asmatech.hr.springdata.jpa.controller;

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

import com.asmatech.hr.springdata.jpa.entity.Actor;
import com.asmatech.hr.springdata.jpa.service.actor.ActorService;

@RestController
@RequestMapping("/actors")
public class ActorController {
	@Autowired
	private ActorService actorService;
	
	@GetMapping("/count")
	public Integer getActorsCount() {		
		return actorService.getCount();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getActorById(@PathVariable Integer id){
		return ResponseEntity.ok( actorService.findById(id));
	}
	
	@GetMapping("/all")
	public ResponseEntity<?>getAll() {
		return ResponseEntity.ok(actorService.findAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addActor(@RequestBody Actor actor) {
		return  ResponseEntity.ok(actorService.save(actor));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateActor(@RequestBody Actor actor) {
		return  ResponseEntity.ok(actorService.save(actor));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteActor(@PathVariable Integer id) {
		return ResponseEntity.ok(actorService.delete(id));
	}
	
	@GetMapping("/filterJpa")
	public ResponseEntity<?> filterJpa(@RequestParam String name , @RequestParam int pageNum, @RequestParam int pageSize, @RequestParam String colName, @RequestParam Boolean isAsc){
		return ResponseEntity.ok(actorService.filterJpa(name, pageNum, pageSize, colName, isAsc));
	}
	
	@GetMapping("/filter")
	public ResponseEntity<?> filter(@RequestParam String name){
		return ResponseEntity.ok(actorService.filter(name));
	}

}
