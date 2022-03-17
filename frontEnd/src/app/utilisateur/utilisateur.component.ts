import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UtilisateurService } from '../service/utilisateur.service';
import { Utilisateur } from './utilisateur';

@Component({
  selector: 'app-utilisateur',
  templateUrl: './utilisateur.component.html',
  styleUrls: ['./utilisateur.component.css']
})
export class UtilisateurComponent implements OnInit {

  public listutilisateurs: Utilisateur[];
  public editUilisateur : Utilisateur;
  public deleteUtilisateur : Utilisateur;


  constructor(private utilisateurServ : UtilisateurService) { }

  ngOnInit(): void {
    this.OngetUtilisateurs();
  }

  public OngetUtilisateurs(): void{
    
    this.utilisateurServ.getUtilisateurs().subscribe(
      (utilisateurs) => {
        this.listutilisateurs = utilisateurs;
      },
      (error) => {
        console.log(error.message);
      }
    );
  }

  public OngetUtilisateurById(UtilisateurId: number): void{
    this.utilisateurServ.getUtilisateurById(UtilisateurId).subscribe(
      (utilisateur) => {
        this.editUilisateur = utilisateur;
      },
      (error) => {
        console.log(error.message);
      }
    );
  }

  public OnRechercherUtilisateurByValue(value : string): void{
    if(value.length > 0){
      this.utilisateurServ.RechercherUtilisateurByValue(value).subscribe(
        (utilisateurs) => {
          this.listutilisateurs = utilisateurs;
        },
        (error) => {
          console.log(error.message);
        }
      );
    }else{
      this.OngetUtilisateurs();
    }
    
  }

  public OnaddUtilisateur(addForm : NgForm): void{
    this.utilisateurServ.addUtilisateur(addForm.value).subscribe(
      (utilisateur) => {
        this.ResteForm(addForm);
        this.listutilisateurs.push(utilisateur);
      },
      (error) => {
        console.log(error.message);
      }
    );
  }

  public InitupdateUtilisateur(utilisateur: Utilisateur): void{
    this.utilisateurServ.getUtilisateurById(utilisateur.id).subscribe(
      (utilisateur) => {
        this.editUilisateur = utilisateur;
      },
      (error) => {
        console.log(error.message);
      }
    );
  }

  public OnupdateUtilisateur(updateForm : NgForm): void{
    this.utilisateurServ.updateUtilisateur(updateForm.value).subscribe(
      () => {
        this.OngetUtilisateurs();
      },
      (error) => {
        console.log(error.message);
      }

    );
  }

  public initDeleteUtilisateur(utilisateur: Utilisateur): void{
    this.utilisateurServ.getUtilisateurById(utilisateur.id).subscribe(
      (utilisateur) => {
        this.deleteUtilisateur = utilisateur;
      },
      (error) => {
        console.log(error.message);
      }
    );
  }
    public OndeleteUtilisateur(utilisateur : Utilisateur): void{
    this.utilisateurServ.deleteUtilisateur(utilisateur.id).subscribe(
      () => {
        this.OngetUtilisateurs();
      },
      (error) => {
        console.log(error.message);
      }
    );
  }

  public ResteForm(form : NgForm): void{
    form.reset();
  }
}
