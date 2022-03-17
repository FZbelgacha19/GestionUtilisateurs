package com.apps.gestionutilisateur.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apps.gestionutilisateur.entities.Utilisateur;
import com.apps.gestionutilisateur.service.UtilisateurService;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/utilisateur")
public class UtilisateurResource {
	@Autowired
	private UtilisateurService utilisateurServ;
	
	@GetMapping("/all")
	public ResponseEntity<List<Utilisateur>> getAllUtilisateur(){
		List<Utilisateur> uts = utilisateurServ.getAllUtilisateur();
		return new ResponseEntity<>(uts, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Optional<Utilisateur>> getAllUtilisateurById(@PathVariable("id") Long id){
		Optional<Utilisateur> uts = utilisateurServ.getUtilisateurById(id);
		return new ResponseEntity<>(uts, HttpStatus.OK);
	}
	
	@GetMapping("/rechercher/{value}")
	public ResponseEntity<List<Utilisateur>> RechercheUtilisateurParValue(@PathVariable("value") String value){
		List<Utilisateur> uts = utilisateurServ.recherchUtilisateursByValue(value);
		return new ResponseEntity<>(uts, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Utilisateur> addUtilisateur(@RequestBody Utilisateur u){
		Utilisateur uts = utilisateurServ.addUtilisateur(u);
		return new ResponseEntity<>(uts, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Utilisateur> updateUtilisateur(@RequestBody Utilisateur u){
		Utilisateur uts = utilisateurServ.updateUtilisateur(u);
		return new ResponseEntity<>(uts, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUtilisateur(@PathVariable("id") Long id){
		utilisateurServ.deleteUtilisateur(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
