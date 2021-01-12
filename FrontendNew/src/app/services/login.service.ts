import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Login } from '../models/adminlogin';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  login(login: Login) : Observable<any> {
    let url = "http://localhost:8082/loginAdmin";
    return this.http.post(url,login);
  }
}
