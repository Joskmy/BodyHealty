import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IServicio, Dato } from '../models/servicio.model';

@Injectable({
  providedIn: 'root'
})
export class ServicioHttpService {

  private baseUrl: string = 'http://localhost:8080/api/v1/servicios';

  constructor(private http: HttpClient) { }

  public getServicios(): Observable<IServicio> {
    return this.http.get<IServicio>(this.baseUrl);
  }

  public postServicios(servicio: Dato): Observable<IServicio> {
    return this.http.post<IServicio>(this.baseUrl, servicio);
  }
}
