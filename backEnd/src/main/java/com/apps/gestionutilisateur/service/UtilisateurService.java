package com.apps.gestionutilisateur.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apps.gestionutilisateur.DAO.UtilisateurRespo;
import com.apps.gestionutilisateur.entities.Utilisateur;

@Service
public class UtilisateurService {
	
	@Autowired
	private UtilisateurRespo utilisateurRep; 
	
	public List<Utilisateur> getAllUtilisateur(){
		return utilisateurRep.findAll();
	}
	
	public Optional<Utilisateur> getUtilisateurById(Long id) {
		return utilisateurRep.findById(id);
	}
	
	public List<Utilisateur> recherchUtilisateursByValue(String value){
		return utilisateurRep.RechercheUtilisateurByValue(value);
	}
	
	
	public Utilisateur addUtilisateur(Utilisateur u) {
		return utilisateurRep.save(u);
	}
	
	
	public Utilisateur updateUtilisateur(Utilisateur u) {
		return utilisateurRep.save(u);
	}
	
	public void deleteUtilisateur(Long id) {
		utilisateurRep.deleteById(id);
	}
}
