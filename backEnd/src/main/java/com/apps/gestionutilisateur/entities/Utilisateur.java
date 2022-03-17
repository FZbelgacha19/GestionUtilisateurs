package com.apps.gestionutilisateur.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Utilisateur {
	@Id  @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 20)
	private String nom; 
	
	@Column(length = 20)
	private String prenom;
	
	@Column(length = 50)
	private String adresse;
	
	@Column(length = 20)
	private String tel;
	
	private String email;
	
	@Column(length = 20)
	private String login;
}
