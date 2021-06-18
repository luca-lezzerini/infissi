import { InfissoDto } from './infisso-dto';
import { ListaInfissiDto } from './lista-infissi-dto';
import { Infisso } from './infisso';
import { Component } from '@angular/core';
import { stat } from 'fs';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  infissi: Infisso[] = [];
  infisso = new Infisso();
  infissoPrecedente = new Infisso();
  // stati possibili: Aggiungi, Modifica, Rimozione, Visualizza, Transitorio
  stato = "A";
  preloader = false;
  messaggio = "";
  readonly url = "http://localhost:8080/";

  editModello = false;
  editPrezzo = false;

  constructor(private http: HttpClient) {
    this.http.get<ListaInfissiDto>(this.url + "aggiorna")
      .subscribe(r => {
        this.infissi = r.listaInfissi;
        this.stato = "A";
        this.campiDisabilitati(false);
        this.preloader = false;
      });
  }
  conferma() {
    console.log("Siamo in conferma");
    this.resetPreloader();
    switch (this.stato) {
      case "A":
        this.salvaNuovo();
        break;
      case "M":
        this.salvaModifica();
        break;
      case "R":
        this.deleteInfisso();
        break;
      default:
        console.log("Transizione inattesa!");
    }

  }

  annulla() {
    console.log("Siamo in annulla");
    this.infisso = this.infissoPrecedente;
    this.stato = "V";
    this.campiDisabilitati(true);
  }

  modifica(i: Infisso) {
    this.stato = "M";
    this.campiDisabilitati(false);
    this.infisso = Object.assign({}, i);
    this.infissoPrecedente = i;
  }

  elimina(i: Infisso) {
    this.stato = "R";
    this.campiDisabilitati(true);
    this.infisso = i;
    this.infissoPrecedente = i;
  }

  aggiungi() {
    this.stato = "A";
    this.campiDisabilitati(false);
    this.infisso = new Infisso();
    this.infissoPrecedente = new Infisso();
  }

  salvaNuovo() {
    let dto = new InfissoDto();
    dto.infisso = this.infisso;
    this.http.post<ListaInfissiDto>(this.url + "salva-nuovo", dto)
      .subscribe(r => {
        if (r.errore) {
          this.messaggio = r.messaggioErrore;
        } else {
          this.infissi = r.listaInfissi;
          this.stato = "V";
          this.campiDisabilitati(true);
        }
        this.preloader = false;
      });
  }

  salvaModifica() {
    let dto = new InfissoDto();
    dto.infisso = this.infisso;
    this.http.post<ListaInfissiDto>(this.url + "salva-modifica", dto)
      .subscribe(r => {
        if (r.errore) {
          this.messaggio = r.messaggioErrore;
        } else {
          this.infissi = r.listaInfissi;
          this.stato = "V";
          this.campiDisabilitati(true);
        }
        this.preloader = false;
      });

  }

  deleteInfisso() {
    let dto = new InfissoDto();
    dto.infisso = this.infisso;
    this.http.post<ListaInfissiDto>(this.url + "salva-nuovo", dto)
      .subscribe(r => {
        this.infissi = r.listaInfissi;
        this.stato = "V";
        this.campiDisabilitati(true);
        this.preloader = false;
      });

  }

  resetPreloader() {
    this.preloader = true;
    this.messaggio = "";
  }

  campiDisabilitati(b: boolean) {
    this.editModello = b;
    this.editPrezzo = b;
  }

}
