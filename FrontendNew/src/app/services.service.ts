import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { UserDetails } from './models';

@Injectable({
  providedIn: 'root'
})
export class ServicesService {

  constructor(private http: HttpClient) { }

  register(user : UserDetails) : Observable<any>{
    let url = "http://localhost:8084/register";
    return this.http.post(url, user);
  }

  

}
