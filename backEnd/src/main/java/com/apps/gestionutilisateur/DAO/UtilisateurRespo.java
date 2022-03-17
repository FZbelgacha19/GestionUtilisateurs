package com.apps.gestionutilisateur.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apps.gestionutilisateur.entities.Utilisateur;

public interface UtilisateurRespo extends JpaRepository<Utilisateur, Long>{
	
	@Query("SELECT new Utilisateur(u.id, u.nom, u.prenom, u.adresse, u.tel, u.email, u.login) "
			+ "FROM Utilisateur u "
			+ "WHERE u.nom LIKE %:value% OR u.prenom LIKE %:value% OR u.login LIKE %:value% OR u.email LIKE %:value% OR u.adresse LIKE %:value% OR u.tel LIKE %:value%")
	public List<Utilisateur> RechercheUtilisateurByValue(@Param("value") String value);
}
