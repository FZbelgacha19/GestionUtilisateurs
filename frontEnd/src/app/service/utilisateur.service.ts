import { Utilisateur } from './../utilisateur/utilisateur';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {
  private hostUrl = environment.hostUrl;

  constructor(private http: HttpClient) { }

  public getUtilisateurs(): Observable<Utilisateur[]> {
    return this.http.get<Utilisateur[]>(`${this.hostUrl}/utilisateur/all`);
  }

  public getUtilisateurById(UtilisateurId: number): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(`${this.hostUrl}/utilisateur/get/${UtilisateurId}`);
  }

  public RechercherUtilisateurByValue(value : string): Observable<Utilisateur[]> {
    return this.http.get<Utilisateur[]>(`${this.hostUrl}/utilisateur/rechercher/${value}`);
  }

  public addUtilisateur(Utilisateur: Utilisateur): Observable<Utilisateur> {
    return this.http.post<Utilisateur>(`${this.hostUrl}/utilisateur/add`, Utilisateur);
  }

  public updateUtilisateur(Utilisateur: Utilisateur): Observable<Utilisateur> {
    return this.http.put<Utilisateur>(`${this.hostUrl}/utilisateur/update`, Utilisateur);
  }

  public deleteUtilisateur(UtilisateurId: number): Observable<void> {
    return this.http.delete<void>(`${this.hostUrl}/utilisateur/delete/${UtilisateurId}`);
  }
}
